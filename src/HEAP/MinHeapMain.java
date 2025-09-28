package HEAP;

class MinHeap{

    int capacity;
    int[] heap;
    int size;

    MinHeap(int capacity){
        this.capacity = capacity;
        size=0;
        heap = new int[capacity];
    }

    int parent(int i){
        return (i-1)/2;
    }
    int left(int i){
        return (2*i+1);
    }
    int right(int i){
        return (2*i+2);
    }

    void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    void insert(int val){
        if(size == capacity) throw new RuntimeException("Heap full");
        heap[size] = val;
        int current = size;
        size++;
        while(current > 0 && heap[current] < heap[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }
    }

    int extractMin(){
        int min = heap[0];
        heap[0] = heap[size-1];
        size--;
        System.out.println(min);
        return min;
    }

    void heapify(int i){
        int smallest = i;
        int l = parent(i);
        int r = parent(i);

        if(l < size && heap[l] < heap[smallest]) smallest =l;
        if(r < size && heap[r] < heap[smallest]) smallest =r;

        if(smallest != i){
            swap(i, smallest);
            heapify(smallest);
        }


    }

    // Level Order (just print array)
    public void levelOrder() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " : ");
            //System.out.println(heap[parent(i)] + " : " + heap[i]);
        }
    }

}

public class MinHeapMain {

        public static void main(String[] args) {
            System.out.println("START DSA");

            MinHeap heap = new MinHeap(10);
            heap.insert(5);
            heap.insert(3);
            heap.insert(17);
            heap.insert(10);
            heap.insert(84);
            heap.insert(19);
            heap.insert(6);
            heap.insert(22);
            heap.insert(9);

            heap.levelOrder();

            heap.extractMin();
            heap.extractMin();
            heap.extractMin();

        }
}
