package dijkstrasalgorithm;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sheehantoufiq
 */
public class Vertex {
    int v;
    HashMap<Integer, Integer> e = new HashMap<>();
    int keypair[] = new int[2];
    BinaryHeap heap;
    
    public Vertex(int v, HashMap<Integer, Integer> e) {
        this.v = v;
        this.e = e;
        System.out.println(e);
    }
    
    public void runHeap() {
        int size = e.size();
        heap = new BinaryHeap(size);  
        for (Map.Entry<Integer, Integer> entry : e.entrySet()) {
            int key = entry.getKey();
            heap.insert(key);
        }
        
        e.clear();
    }
    
    public int[] getMinimum() {
        keypair[1] = heap.getMinimum();
        keypair[0] = e.get(keypair[1]);
        
        heap.removeMin();
        
        return keypair;
    }
    
    @Override
    public String toString() {
        String output = "Vertex: " + v + "\n";
        for (Map.Entry<Integer, Integer> entry : e.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            output += "connected to: " + value + " weight: " + key + "\n";
        }
        return output;
    }
    
}
