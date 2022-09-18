import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import org.apache.commons.httpclient.util.URIUtil;

import org.json.*;
public class HamiltonianProblem {
    public static void main(String args[]) {
        ArrayList<Nodes> nodes = new ArrayList<>();


        /*z.listAllPaths(4,nodes,':');*/

    }
}

abstract class Nodes {
    private double distance;
    private String address;
    private double[] coordinates; // (coordinates x,y) of the location used for calculating distance
    private String name;
    private double M;
    private double waitingTime;
    private double travelTime;
    public double getDistance() {
        return distance;
    }

    public String getAddress() {
        return address;
    }

    public double[] getCoordinates() {
        return coordinates;
    }
    double calculateDistance(double[] array2) {
        double x1 = getCoordinates()[1];
        double y1 = getCoordinates()[2];
        double x2 = array2[0];
        double y2 = array2[0];
        return Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
    }
    abstract void calculateM(Nodes previousNode);
    public double getM() {
        return M;
    }
    int calculateTravelTime(String nextAddress) {
        try{
            // write your code here
            URL url = new URL(
                    "https://maps.googleapis.com/maps/api/distancematrix/json?destinations=" +
                            URIUtil.encodeQuery(this.address) + "&origins=" +
                            URIUtil.encodeQuery(nextAddress) + "&key=AIzaSyCr5QPYztOCLdfbJizK0-v6S49PLsZwl24");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output = "", full = "";
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                full += output;
                String jsonString = output;
                JSONObject obj = new JSONObject(jsonString);
                JSONArray arr = obj.getJSONArray("rows");
                for (int i = 0; i < arr.length(); i++) {
                    JSONArray newObj = obj.getJSONArray("elements");
                    for (int j = 0; j<newObj.length(); j++) {
                        JSONObject distanceObj = obj.getJSONObject("duration");
                        for (int x = 0; x < distanceObj.length();x++) {
                            JSONObject duration = distanceObj.getJSONObject("text");
                            String durationString = duration.toString();
                            String[] splited = durationString.split(" ");
                            int timeTravel = Integer.parseInt(splited[0]);
                            this.travelTime = timeTravel;
                            return timeTravel;
                        }
                    }
                }
            }

            conn.disconnect();
        }
        catch (NullPointerException e) {
            System.out.println("Address, latitude on longitude is null");
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public String getName() {
        return name;
    }

}
class Restaurant extends Nodes {
    private double waitingTime;
    private double[] coordinates;
    private double M;
    private double travelTime;

    private String name;

    public Restaurant(String name) {
        this.name = name;
    }

    public double getWaitingTime() {
        return waitingTime;
    }

    @Override
    public double[] getCoordinates() {
        return coordinates;
    }


    @Override
    void calculateM(Nodes previousNode) {
        double travelTime = calculateTravelTime(previousNode.getAddress());

        this.M = waitingTime - travelTime <= 0 ? travelTime : waitingTime - travelTime;
    }

    public String getName() {
        return name;
    }

    static class Customer extends Nodes {
        private Restaurant orderedRestaurant;
        private String name;
        private double waitingTime = 0;
        private double M;

        public Customer(Restaurant orderedRestaurant, String name) {
            this.orderedRestaurant = orderedRestaurant;
            this.name = name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        void calculateM(Nodes previousNode) {
            double travelTime = calculateTravelTime(previousNode.getAddress());
            this.M = waitingTime - travelTime <= 0 ? travelTime : waitingTime - travelTime;
        }

        public String getName() {
            return name;
        }

        public Restaurant getOrderedRestaurant() {
            return orderedRestaurant;
        }

        public void setOrderedRestaurant(Restaurant orderedRestaurant) {
            this.orderedRestaurant = orderedRestaurant;
        }
    }

    static class Shipper extends Nodes {
        boolean acceptsOrders;

        boolean availableMoreOrders(Restaurant r, double travelTime) {
            // adding second order
            double distance = calculateDistance(r.getCoordinates());
            this.acceptsOrders = (travelTime / r.getWaitingTime() < 1);
            // adding third order

            return acceptsOrders;
        }

        @Override
        void calculateM(Nodes previousNode) {

        }
    }

    static class HeapAlgo {
        // Prints the array
        void printArr(Nodes a[], int n) {
            for (int i = 0; i < n; i++)
                System.out.print(a[i] + " ");
            System.out.println();
        }

        static ArrayList<Nodes[]> pathLists = new ArrayList<>();
        static ArrayList<Nodes[]> filteredNodes = new ArrayList<>();
        static HashMap<Nodes[], Double> pathWeight = new HashMap<Nodes[], Double>();

        public static void heapsAlgorithm(int n, Nodes[] list) {
            if (n == 1) {
                pathLists.add(Arrays.copyOf(list, list.length));
                System.out.println(Arrays.toString(list));
            } else {
                for (int i = 0; i < n; i++) {
                    heapsAlgorithm(n - 1, list);
                    if (n % 2 == 0) {
                        Nodes swap = list[i];
                        list[i] = list[n - 1];
                        list[n - 1] = swap;
                    } else {
                        Nodes swap = list[0];
                        list[0] = list[n - 1];
                        list[n - 1] = swap;
                    }
                }
            }
        }

        public static ArrayList<Nodes[]> filterData() {
            int count = 0;
            int pages = 0;
            for (Nodes[] nodeChain : pathLists) {
                boolean canAdd = true;
                for (Nodes node : nodeChain) {
                    if (node instanceof Customer) {
                        int index = Arrays.asList(nodeChain).indexOf(node);
                        int jindex = Arrays.asList(nodeChain).indexOf(((Customer) node).getOrderedRestaurant());
                        if (index == 0) {
                            canAdd = false;
                            break;
                        } else {
                            if (index < jindex) {
                                canAdd = false;
                                break;
                            }
                        }
                    }
                }
                if (canAdd) {
                    filteredNodes.add(nodeChain);
                }
            }
            return filteredNodes;
        }

        public static void main(String args[]) {
            HeapAlgo obj = new HeapAlgo();
            Restaurant a = new Restaurant("Restaurant A");
            Restaurant b = new Restaurant("Restaurant B");
            Customer c = new Customer(a, "My");
            Customer d = new Customer(b, "Linh");
            Shipper z = new Shipper();
            int count = 0;
            Nodes test[] = {a, b, c, d};
            c.setOrderedRestaurant(a);
            d.setOrderedRestaurant(b);
            heapsAlgorithm(test.length, test);
            filterData();
            for (Nodes[] n : filteredNodes) {
                count++;

                System.out.println(count + " Line: ");
                for (Nodes m : n) {
                    System.out.println(m.getName());
                }
                System.out.println("-----");

            }
        }

        double calculateMEachPath(Nodes[] path) {
            Double totalMValue = 0.0;
            for (Nodes n : path) {
//            totalMValue += n.calculateM();
            }
            pathWeight.put(path, totalMValue);
            return totalMValue;
        }

        double calculateCustomerWaitTime(Nodes current, Nodes destination, Nodes[] path) {
            int startingIndex = Arrays.asList(path).indexOf(current);
            int endingIndex = Arrays.asList(path).indexOf(destination);

            Nodes[] slice = Arrays.copyOfRange(path, startingIndex, endingIndex);
            return calculateMEachPath(slice);
        }

        Nodes[] mostOptimizedPath() {
            double minimumMValue = Collections.min(pathWeight.values());

            for (Nodes[] nodeChain : pathWeight.keySet()) {
                if (pathWeight.get(nodeChain) == minimumMValue) {
                    return nodeChain;
                }
            }
            return null;
        }

    }
}


