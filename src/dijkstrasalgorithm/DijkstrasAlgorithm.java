package dijkstrasalgorithm;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author sheehantoufiq
 * 
 * IDE: Netbeans + Mac OSX
 * 
 * Program is not correct, however I got close. I tried for days to figure out what was wrong with no luck.
 * Program must have an input file exactly like outlined to work.
 * 
 * References
 * - Java Documentation: 
 *      - https://docs.oracle.com/javase/8/
 * 
 * - Stanford Online Course on Algorithms:
 *      - https://class.coursera.org/algo-007
 * 
 * - Dijkstra's Algorithm Youtube Explanation
 *      - https://www.youtube.com/watch?v=8Ls1RqHCOPw
 * 
 * - Pseudocode on Dijkstra's Binary Heap Algorithm 
 *      - http://www.cs.gsu.edu/~rpersaud2/2010/04/23/dijkstra-binary-heap/
 * 
 * - Array based Binary Heap:
 *      - http://www.algolist.net/Data_structures/Binary_heap/Array-based_int_repr
 * 
 * - Dijkstra's Algorithm explained:
 *      - https://compprog.wordpress.com/2007/12/01/one-source-shortest-path-dijkstras-algorithm/
 * 
 */
public class DijkstrasAlgorithm {
    
    public class Graph {
        public Node s[];
        public Node q[];
        public int n;
        public int m;
    }  
    
    Graph g = new Graph();
    public int total = 0;
    //BinaryMinimumHeap heapQ;
    
    public void runAlgorithm() {
        g.s = new Node[g.q.length];
        int size = g.s.length;
        for (int i = 0; i < size; i++) {
            Node infinite = new Node(0, 0, 26000*26000);
            g.s[i] = infinite;
        }
        
        BinaryHeap heap = new BinaryHeap(size);
        
        int j = 0;
        while (j < size && g.q[j] != null) {
            Node node = g.q[j];
            heap.insert(node.w);
            int min = heap.getMinimum();
            if (min < node.w) {
                int vertex = node.u;
                g.s[vertex] = node;
            }
            j++;
        }
        for (int i = 0; i < size; i++) {
            if (g.q[i] != null) {
                Node comparison = g.q[i];
                if (comparison.w < 25500*25500) {
                    total += comparison.w;
                }
            }
        }
    }
    
    public void readFile(String filePath) {
        
        String[] tokens;
        
        int u = 0;
        int v = 0;
        int w = 0; 
        
        try {
            Scanner file = new Scanner(new FileReader(filePath)).useDelimiter("\\s*\\w+=");
            String line = file.nextLine();
            tokens = line.trim().split("[\\s]+");
            g.n = Integer.parseInt(tokens[0].substring(2));
            g.m = Integer.parseInt(tokens[1].substring(2));
            
            g.q = new Node[g.n-1];
            
            while (file.hasNextLine()) {
                
                line = file.nextLine();
                tokens = line.trim().split("[\\s]+");

                if (tokens.length == 1) {
                    if (!tokens[0].equals("")) {
                        u = Integer.parseInt(tokens[0]);
                    } else {
                        Node node = new Node(u, v, w);
                        g.q[u] = node;
                        System.out.println(g.q[u]);
                    }
                } else if (tokens.length == 2) {
                    v = Integer.parseInt(tokens[0]);
                    w = Integer.parseInt(tokens[1]);
                }
                
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error: File not found.");
        }
    }

        
    public void userPrompt() {
        boolean run = true;
        while (run) {
            Scanner in = new Scanner(System.in);
            System.out.println("Please enter a path to an input file: ");
            String filePath = in.nextLine();
            readFile(filePath);
            
            runAlgorithm();
            System.out.println(total*2.57);
            while (true) {
                System.out.println("Would you like to run again? (y/n)");
                String prompt = in.nextLine();
                switch (prompt) {
                    case "y":   break;
                    case "n":   System.out.println("Goodbye.");
                                run = false;
                                break;
                    default:    System.out.println("Please enter y or n.");
                                continue;
                }
                break;
            }
        }
    }
    public static void main(String[] args) {
        DijkstrasAlgorithm run = new DijkstrasAlgorithm();
        run.userPrompt();
    }
}

