package com.company;

import org.w3c.dom.Node;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class HamiltonianProblem {
    public static void main(String args[]) {
        ArrayList<Nodes> nodes = new ArrayList<>();
        Restaurant a = new Restaurant();
        Restaurant b = new Restaurant();
        Customer c = new Customer();
        Customer d = new Customer();
        Shipper z = new Shipper();
        nodes.add(a);
        nodes.add(b);
        nodes.add(c);
        nodes.add(d);
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
    void printArr(int a[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    // Generating permutation using Heap Algorithm
    void heapPermutation(int a[], int size, int n)
    {
        // if size becomes 1 then prints the obtained
        // permutation
        if (size == 1)
            printArr(a, n);

        for (int i = 0; i < size; i++) {
            heapPermutation(a, size - 1, n);

            // if size is odd, swap 0th i.e (first) and
            // (size-1)th i.e (last) element
            if (size % 2 == 1) {
                int temp = a[0];
                a[0] = a[size - 1];
                a[size - 1] = temp;
            }

            // If size is even, swap ith
            // and (size-1)th i.e last element
            else {
                int temp = a[i];
                a[i] = a[size - 1];
                a[size - 1] = temp;
            }
        }
    }

    // Driver code
    public static void main(String args[])
    {
        HeapAlgo obj = new HeapAlgo();
        int a[] = { 1, 2, 3 };
        obj.heapPermutation(a, a.length, a.length);
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

