import algorithms.*;
import java.util.*;
public class Exercise1_BFS {

	    public static void main(String[] args) {
	        // Uncomment this line if you want to read from a file
	        In.open("public/test1.in");
	        Out.compareTo("public/test1.out");

	        int t = In.readInt();
	        for (int i = 0; i < t; i++) {
	            testCase();
	        }
	        
	        //Uncomment this line if you want to read from a file
	        In.close();
	    }

	    public static void testCase() {
	        // Input using In.java class
	        int n = In.readInt();
	        int m = In.readInt();
	        int v = In.readInt();
	        
	        int[] edge1 = new int[m];
	        int[] edge2 = new int[m];
	        boolean[] discovered = new boolean[n];
	        for (int i = 0; i<m; i++) {
	          edge1[i] = In.readInt();
	          edge2[i] = In.readInt();
	        }
	        int[] distance = new int[n];
	        for (int i = 0; i<n; i++) {
	          distance[i] = -1;
	        }
	        LinkedList<Integer> queue = new LinkedList<Integer>();
	        queue.add(v);
	        distance[v] = 0;
	        while(!queue.isEmpty()) {
	          int first = queue.poll();
	          
	          for (int i = 0; i<m; i++) {
	            if (edge1[i] == first) {
	            	
	                if (discovered[edge2[i]] == false) {
	                  discovered[edge2[i]] = true;
	                  distance[edge2[i]] = distance[edge1[i]] + 1;
	                  queue.add(edge2[i]);
	                }
	           
	              edge1[i] = -1;
	              edge2[i] = -1;
	            }
	          }
	          for (int i = 0; i<m; i++) {
	            if (edge2[i] == first) {
	           
	                if (discovered[edge1[i]] == false) {
	                  discovered[edge1[i]] = true;
	                  distance[edge1[i]] = distance[edge2[i]] + 1;
	                  queue.add(edge1[i]);
	                }
	              
	              edge1[i] = -1;
	              edge2[i] = -1;
	            }
	          }
	        }
	        String output = "";
	        for (int i = 0; i<n; i++) {
	          output = output + Integer.toString(distance[i]) + " ";
	        }
	        Out.println(output);
	    }
	}

