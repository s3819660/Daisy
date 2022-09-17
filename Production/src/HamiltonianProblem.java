import java.util.*;

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

}
class Restaurant extends Nodes {
    private double waitingTime;
    private double[] coordinates;

    double calculateM(double[] originCoordinates){
        double distance = calculateDistance(originCoordinates);
        return waitingTime - distance <= 0 ? distance : waitingTime - distance;
    }

    public double getWaitingTime() {
        return waitingTime;
    }

    @Override
    public double[] getCoordinates() {
        return coordinates;
    }
}
class Customer extends Nodes {
    private Restaurant orderedRestaurant;

    public Restaurant getOrderedRestaurant() {
        return orderedRestaurant;
    }

    public void setOrderedRestaurant(Restaurant orderedRestaurant) {
        this.orderedRestaurant = orderedRestaurant;
    }
}
class E {

}
class Shipper extends Nodes {
    ArrayList<Nodes> nodesCollection; // collection of restaurants and customer nodes ongoing for shipper
    Queue<Nodes> pathOrder = new PriorityQueue<>();
    ArrayList<Nodes> visited = new ArrayList<>();
    ArrayList<Nodes> unvisited = new ArrayList<>();


    // if the target node is a customer, only add if we've visited the customer.restaurant
    boolean acceptsOrders;

    boolean availableMoreOrders(Restaurant r) {
        double distance = calculateDistance(r.getCoordinates());
        this.acceptsOrders = (distance / r.getWaitingTime() > 1);
        return acceptsOrders;
    }
}

class HeapAlgo {
    // Prints the array
    void printArr(Nodes a[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
    static ArrayList<Nodes[]> pathLists = new ArrayList<>();
    static ArrayList<Nodes[]> filteredNodes = new ArrayList<>();

    public static void heapsAlgorithm(int n, Nodes[] list) {
        if (n == 1) {
            pathLists.add(Arrays.copyOf(list, list.length));
            System.out.println(Arrays.toString(list));
        }
        else {
            for(int i = 0; i < n; i++) {
                heapsAlgorithm(n - 1, list);
                if ( n % 2 == 0) {
                    Nodes swap = list[i];
                    list[i] = list[n-1];
                    list[n-1] = swap;
                }
                else {
                    Nodes swap = list[0];
                    list[0] = list[n-1];
                    list[n-1] = swap;
                }
            }
        }
    }
     public static ArrayList<Nodes[]> filterData() {
        int count = 0;
        int pages = 0;
         for (Nodes[] nodeChain:pathLists) {
             for (Nodes node : nodeChain) {
                 if (node instanceof Customer) {
                     int index = Arrays.asList(nodeChain).indexOf(node);
                     int jindex = Arrays.asList(nodeChain).indexOf(((Customer) node).getOrderedRestaurant());
                     if(index == 0) {
                         break;}
                     else {
                         count++;
                         System.out.println(count+" this statement khac 0");
                         if (index > jindex) {
                             pages++;
                             filteredNodes.add(nodeChain);
                             System.out.println(pages +" this statement satisfies both conditions");
                             break;
                         }
//                         pathLists.remove(nodeChain);
//                         System.out.println(count+" This string is error");
//                         System.out.println("Line "+ count);
//                         System.out.println("Customer"+index + " " + "Restaurant"+jindex);
                     }

//                     pages++;
//                     System.out.println("Line "+ pages);
//                     System.out.println("Customer"+index + " " + "Restaurant"+jindex);
//                    return Arrays.asList(nodeChain).contains(node);
//                    return Arrays.asList(nodeChain).contains(((Customer) node).getOrderedRestaurant());

                 }
             }
         }
         return filteredNodes;
     }



    // Driver code
    public static void main(String args[])
    {
        HeapAlgo obj = new HeapAlgo();
        Restaurant a = new Restaurant();
        Restaurant b = new Restaurant();
        Customer c = new Customer();
        Customer d = new Customer();
        Shipper z = new Shipper();


        Nodes test[] = {a,b,c,d};
        c.setOrderedRestaurant(a);
        d.setOrderedRestaurant(b);
        heapsAlgorithm(test.length,test);
        filterData();
        for(int i = 1; i <= filteredNodes.size(); i++) {
//            System.out.println("Filtered Data");
            System.out.println("List " + i + ": " + Arrays.toString(filteredNodes.get(i-1)));
        }
//        System.out.println(filterData());
    }
}



//    void addNodeToPath(Nodes targetNode) {
//        pathOrder.add(targetNode);
//        unvisited.remove(targetNode);
//        visited.remove(targetNode);
//    }
//    ArrayList<Nodes> listAllPaths() {
//        unvisited.addAll(nodesCollection); // add all nodes value to unvisited nodes list
//        boolean canAdd = false;
//        for (Nodes targetNode:unvisited) {
//            if (targetNode instanceof Customer && unvisited.contains(((Customer) targetNode))) {
//                continue;
//            }
//            else {
//                addNodeToPath(targetNode);
//            }
//        }
//    }
//    void listAllPaths(int n, ArrayList<Nodes> unvistedNodes, char delimiter) {
//        unvisited.addAll(nodesCollection); // add all nodes value to unvisited nodes list
//        if (n==1) {
//            listArray(unvistedNodes);
//        }
//        else {
//            for(int i = 0; i < n - 1; i++) {
//                listAllPaths(n-1, unvisited ,delimiter);
//                if (n%2 == 0) {
//                    swap(unvistedNodes,i,n-1);
//                }
//                else {
//                    swap(unvistedNodes,0,n-1);
//                }
//                listAllPaths(n-1,unvistedNodes,delimiter);
//            }
//        }
//    }
//    void listArray(ArrayList<Nodes> input) {
//        for (int i =0; i < input.size();i++) {
//            System.out.println(input.get(i));
//        }
//    }
//    private void swap(ArrayList<Nodes> input, int a, int b) {
//        Nodes tmp = input.get(a);
//        input.set(a, input.get(b));
//        input.set(b, tmp);
//private void swap(T[] input, int a, int b) {
//    T tmp = input[a];
//    input[a] = input[b];
//    input[b] = tmp;
//}
//
//    private static void printArray(T[] input) {
//        System.out.print('\n');
//        for(int i = 0; i < input.length; i++) {
//            System.out.print(input[i]);
//        }
//    }
//    public static <T> void printAllRecursive(
//            int n, T[] elements, char delimiter) {
//
//        if(n == 1) {
//            printArray((com.company.T[]) elements);
//        } else {
//            for(int i = 0; i < n-1; i++) {
//                printAllRecursive(n - 1, elements, delimiter);
//                if(n % 2 == 0) {
//                    swap(elements, i, n-1);
//                } else {
//                    swap(elements, 0, n-1);
//                }
//            }
//            printAllRecursive(n - 1, elements, delimiter);
//        }
//    }
//
//}

class T{

}
class Paths {
    ArrayList<Nodes> pathCollection = new ArrayList<>();


}

