package dijkstrasalgorithm;

/**
 *
 * @author sheehantoufiq
 */
public class BinaryHeap {
    private int[] data;
    private int heapSize;
 
    public BinaryHeap(int size) {
        data = new int[size];
        heapSize = 0;
    }
 
    public int getMinimum() {
        if (isEmpty()) {
            throw new HeapException("Heap is empty");
        } else {
            return data[0];
        }
    }
 
    public boolean isEmpty() {
        return (heapSize == 0);
    }
 
    public void insert(int value) {
        if (heapSize == data.length) {
            throw new HeapException("Heap's underlying storage is overflow");
        } else {
            heapSize++;
            data[heapSize - 1] = value;
            bubbleUp(heapSize - 1);
        }
    }
    public void removeMin() {
        if (isEmpty()) {
            throw new HeapException("Heap is empty");
        } else {
            data[0] = data[heapSize - 1];
            heapSize--;
            if (heapSize > 0) {
                bubbleDown(0);
            }
        }
    }
    
    private void bubbleUp(int nodeIndex) {
        int parentIndex, tmp;
        if (nodeIndex != 0) {
            parentIndex = getParentIndex(nodeIndex);
            if (data[parentIndex] > data[nodeIndex]) {
                tmp = data[parentIndex];
                data[parentIndex] = data[nodeIndex];
                data[nodeIndex] = tmp;
                bubbleUp(parentIndex);
            }
        }
    }
    
    private void bubbleDown(int nodeIndex) {
        int leftChildIndex, rightChildIndex, minIndex, tmp;
        leftChildIndex = getLeftChildIndex(nodeIndex);
        rightChildIndex = getRightChildIndex(nodeIndex);
        if (rightChildIndex >= heapSize) {
            if (leftChildIndex >= heapSize) {
                return;
            } else {
                minIndex = leftChildIndex;
            }
        } else {
            if (data[leftChildIndex] <= data[rightChildIndex]) {
                minIndex = leftChildIndex;
            } else {
                minIndex = rightChildIndex;
            }
        }
        if (data[nodeIndex] > data[minIndex]) {
            tmp = data[minIndex];
            data[minIndex] = data[nodeIndex];
            data[nodeIndex] = tmp;
            bubbleDown(minIndex);
        }
    }
 
    private int getLeftChildIndex(int nodeIndex) {
        return 2 * nodeIndex + 1;
    }
 
    private int getRightChildIndex(int nodeIndex) {
        return 2 * nodeIndex + 2;
    }
 
    private int getParentIndex(int nodeIndex) {
        return (nodeIndex - 1) / 2;
    }
 
    public class HeapException extends RuntimeException {
        public HeapException(String message) {
            super(message);
        }
    }
}
