public class Heap {

    private int[] data;
        
    private int capacity;
    
    private int count;

    
    public Heap(int n) {
        data = new int[n+1];
        capacity = n;
        count = 0;
    }
    
       
    public void buildHeap(int[] a, int n) {
        for (int i = n/2; i >= 1; i--) {
            heapify(a, n, i);            
        }
    }
    
    private void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) {
                maxPos = i * 2;
            }

            if ((i * 2 + 1) <= n && a[maxPos] < a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }

            if (maxPos == i) {
                break;
            }
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    private void swap(int a[], int i1, int i2) {
        int temp = a[i1];
        a[i1] = a[i2];
        a[i2] = temp;
    }
    
}