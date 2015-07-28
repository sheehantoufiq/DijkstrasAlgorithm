package dijkstrasalgorithm;

/**
 *
 * @author sheehantoufiq
 */
public class Node {
    
    public int u;    
    public int v;
    public int w;
    
    public Node(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public String toString() {
        return "(u: " + u + ", v: " + v + ", w: " + w + ")";
    }
}
