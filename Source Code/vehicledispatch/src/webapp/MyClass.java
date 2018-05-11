package webapp;

import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.lang.*;
import java.lang.reflect.Array;
import java.io.*;
import java.util.Random;
import java.lang.*;

@WebServlet(name = "MyClass")
public class MyClass extends HttpServlet {
    static ArrayList<int[]> Vehicleavailable;
    int unsorteddist[] =new int[10];
    String zipcode;
    String vehicletype;
    int zipcode1,vehicletype1;
    public String value3;
    static final int V = 10;
    int type;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        zipcode = request.getParameter("zipcode");
        System.out.println(zipcode);
        vehicletype = request.getParameter("featured");

        zipcode1 = Integer.parseInt(zipcode);
        switch(vehicletype)
        {
            case "fire":
                type = 0;
                break;
            case "police":
                type = 1;
                break;
            case "ambulance":
                type = 2;
                break;

            default:
                type = 900000000;
                break;
        }
        System.out.println(type);
        int src, typ, src1;

        Vehicleavailable = new ArrayList<int[]>();
        int i1[] = {0, 0, 1};
        Vehicleavailable.add(0, i1);
        int i2[] = {1, 0, 0};
        Vehicleavailable.add(1, i2);
        int i3[] = {1, 1, 1};
        Vehicleavailable.add(2, i3);
        int i4[] = {2, 0, 1};
        Vehicleavailable.add(3, i4);
        int i5[] = {1, 0, 0};
        Vehicleavailable.add(4, i5);
        int i6[] = {0, 2, 0};
        Vehicleavailable.add(5, i6);
        int i7[] = {0, 1, 0};
        Vehicleavailable.add(6, i7);
        int i8[] = {3, 0, 0};
        Vehicleavailable.add(7, i8);
        int i9[] = {0, 1, 1};
        Vehicleavailable.add(8, i9);
        int i10[] = {1, 0, 0};
        Vehicleavailable.add(9, i10);
        int i11[] = {1, 0, 1};
        Vehicleavailable.add(10, i11);
        int i12[] = {0, 0, 0};
        Vehicleavailable.add(11, i12);
        int i13[] = {0, 0, 4};
        Vehicleavailable.add(12, i13);


        //The graph the zipcode nodes converted into multi dimentional array
        int graph[][] = new int[][]{
                {0, 0, 0, 0, 6, 0, 0, 10, 8, 0, 0, 0, 0},
                {0, 0, 7, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 7, 0, 0, 0, 9, 0, 0, 0, 6, 0, 0, 0},
                {0, 11, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0},
                {6, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 9, 2, 6, 0, 7, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 7, 0, 0, 5, 0, 0, 0, 3},
                {10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {8, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0},
                {0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 2, 4, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 9, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 4, 9, 0, 0},
                {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
        };

        src1 = zipConversion(zipcode1);
        String value;
        value= Shortestdiszipcode(graph, src1, type);


        out.println(value3);

    }


    int Shortestdist ( int dist[], Boolean Set[]){
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (Set[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    // function to print the nearest node
    String printVehicleDispatched ( int dist[], int unsorteddist[], int n, int src, int typ){


        List<Integer> list2 = new ArrayList<Integer>();
        List<Integer> list3 = new ArrayList<Integer>();
        for (int l = 0; l < unsorteddist.length; l++) {
            int k1 = dist[l];
            list2.add(k1);
        }

        for (int b = 0; b < dist.length; b++) {
            int item = dist[b];
            for (int x = 0; x < unsorteddist.length; x++) {
                if (item == unsorteddist[x]) {
                    list3.add(x);
                } else {
                    continue;
                }

            }
        }

        Label1:
        for (int i = 0; i < n; i++) {
            int item1 = list3.get(i);
            int type1[];
            type1 = Vehicleavailable.get(item1);
            inner:
            if (type1[typ] > 0) {
                value3= "vehicle dispatched from destination node within this time frame"
                        +"\t" + dist[i] + "mins" + "\t"+ "and from node" + item1;
                type1[typ]--;
                break  Label1;

            } else {
                continue Label1;
            }
        }
        return value3;
    }


    //Shortestdiszipcode's algorithm
    String Shortestdiszipcode ( int graph[][], int src, int typ){

        int dist[] = new int[V];
        Boolean Set[] = new Boolean[V];

        // ISetting all othernodes except source to infinite
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            Set[i] = false;
        }
        dist[src] = 0;//the distance to source node is always 0

        // Find shortest path for all vertices
        for (int count = 0; count < V - 1; count++) {
            int u = Shortestdist(dist, Set);
            Set[u] = true;
            for (int v = 0; v < V; v++)
                if (!Set[v] && graph[u][v] != 0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }
         System.out.println("The shortest distance from the source to other nodes");
        for (int j = 0; j < 10; j++) {
            System.out.println(dist[j]);
            unsorteddist[j] = dist[j];
        }

        QuickSort h = new QuickSort();
        h.sort(dist, 0, 9);
        h.printArray(dist);
        String value1= printVehicleDispatched(dist, unsorteddist, V, src, type);
        return value1;
    }

    //switch case for input of zipcodes.
    int zipConversion ( int src){
        int zipp = -1;

        switch (src) {
            case 64110:
                zipp = 0;
                break;
            case 64130:
                zipp = 1;
                break;
            case 64127:
                zipp = 2;
                break;
            case 64134:
                zipp = 3;
                break;
            case 64030:
                zipp = 4;
                break;
            case 64149:
                zipp = 5;
                break;
            case 64155:
                zipp = 6;
                break;
            case 64064:
                zipp = 7;
                break;
            case 64143:
                zipp = 8;
                break;
            case 64210:
                zipp = 9;
                break;
            case 65311:
                zipp = 10;
                break;
            case 61255:
                zipp = 11;
                break;
            case 61232:
                zipp = 12;
                break;
            default:
                zipp = 900000000;
                break;
        }
        return zipp;
    }




}

class QuickSort {
    int partition(int dist[], int low, int high) {
        int pivot = dist[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (dist[j] <= pivot)
            {
                i++;
                // swap arr[i] and arr[j]
                int temp = dist[i];
                dist[i] = dist[j];
                dist[j] = temp;
            }
        }
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = dist[i + 1];
        dist[i + 1] = dist[high];
        dist[high] = temp;
        return i + 1;
    }
    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,low  --> Starting index,high  --> Ending index */
    void sort(int dist[], int low, int high) {
        if (low < high) {
        /* pi is partitioning index, arr[pi] is
          now at right place */
            int pi = partition(dist, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(dist, low, pi - 1);
            sort(dist, pi + 1, high);
        }




    }

    void printArray(int dist[]) {
        System.out.println("The sorted distances value as follows");
        for (int i = 0; i < 10; ++i)
            System.out.println(dist[i] + " ");
        System.out.println();
    }
}



