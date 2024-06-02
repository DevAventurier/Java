package pack.fr;
import java.util.Arrays;

public class MaxHeap {
    private int[] heap;
    public int size;
    
    public MaxHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }
    
    private int parent(int index) {
        return (index - 1) / 2;
    }
    
    private int leftChild(int index) {
        return 2 * index + 1;
    }
    
    private int rightChild(int index) {
        return 2 * index + 2;
    }
    
    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }
    
    private void siftUp(int index) {
        while (index > 0 && heap[parent(index)] < heap[index]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }
    
    private void siftDown(int index) {
        int maxIndex = index;
        int left = leftChild(index);
        if (left <= size && heap[left] > heap[maxIndex]) {
            maxIndex = left;
        }
        int right = rightChild(index);
        if (right <= size && heap[right] > heap[maxIndex]) {
            maxIndex = right;
        }
        if (index != maxIndex) {
            swap(index, maxIndex);
            siftDown(maxIndex);
        }
    }
    
    public void insert(int value) {
        if (size == heap.length) {
            throw new RuntimeException("Heap is full");
        }
        heap[size] = value;
        size++;
        siftUp(size - 1);
    }
    
    public int extractMax() {
        int result = heap[0];
        heap[0] = heap[size - 1];
        size--;
        siftDown(0);
        return result;
    }

}
