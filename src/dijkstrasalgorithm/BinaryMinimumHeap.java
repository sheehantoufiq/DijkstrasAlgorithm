/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstrasalgorithm;

/**
 *
 * @author sheehantoufiq
 */
public class BinaryMinimumHeap implements PriorityQueue
{
	private static final int DEFAULT_CAPACITY = 100;
    
    private int currentSize;      // Number of elements in heap
    private Comparable[] array; // The heap array
    
    /**
     * Construct the binary heap.
     */
    public BinaryMinimumHeap()
    {
        currentSize = 0;
        array = new Comparable[DEFAULT_CAPACITY+1];
    }
    
    public BinaryMinimumHeap(Comparable[] items) {
        currentSize = items.length;
        array = new Comparable[items.length+1];
        
        for (int i = 0; i < items.length; i++) {
            array[ i + 1 ] = items[ i ];
        }
        buildHeap();
    }
    
    public PriorityQueue.Position insert(Comparable x)
    {
        if (currentSize + 1 == array.length) {
            doubleArray( );
        }
        
        // Percolate up
        int hole = ++currentSize;
        array[0] = x;
        
        for (; x.compareTo(array[hole/2]) < 0; hole /= 2) {
            array[hole] = array[hole/2];
        }
        array[hole] = x;
        
        return null;
    }
    
    public void decreaseKey(PriorityQueue.Position p, Comparable newVal)
    {
    	throw new UnsupportedOperationException( "Cannot use decreaseKey for binary heap" );
    }
    

    public Comparable findMin()
    {
        if (isEmpty()) {
            System.out.println("Underflow Exception");
        }
        return array[1];
    }

    public Comparable deleteMin()
    {
        Comparable minItem = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);
        
        return minItem;
    }

    private void buildHeap()
    {
        for( int i = currentSize/2; i > 0; i--) {
            percolateDown(i);
        }
    }
 
    public boolean isEmpty()
    {
        return currentSize == 0;
    }
    
    public int size()
    {
        return currentSize;
    }
    
    public void makeEmpty()
    {
        currentSize = 0;
    }

    private void percolateDown(int hole)
    {
        int child;
        Comparable tmp = array[ hole ];
        
        for( ; hole * 2 <= currentSize; hole = child ) {
            child = hole * 2;
            if (child != currentSize && array[child+1].compareTo(array[child])  < 0) {
                child++;
            }
            if (array[child].compareTo(tmp) < 0) {
                array[hole] = array[child];
            } else {
                break;
            }
        }
        array[hole] = tmp;
    }
    

    private void doubleArray()
    {
        Comparable [ ] newArray;
        
        newArray = new Comparable[ array.length * 2 ];
        for( int i = 0; i < array.length; i++ )
            newArray[ i ] = array[ i ];
        array = newArray;
    }
 
}