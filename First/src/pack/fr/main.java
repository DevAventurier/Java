package pack.fr;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5, 2, 9, 12, 20, 1, 5, 6};
        MaxHeap maxHeap = new MaxHeap(arr.length);
        for (int i = 0; i < arr.length; i++) {
            maxHeap.insert(arr[i]);
        }
        while (maxHeap.size > 0) {
            System.out.print(maxHeap.extractMax() + " ");
        }

	}

}
