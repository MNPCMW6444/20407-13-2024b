package michael;




    // Example of usage
    public class Main {
        public static void main(String[] args) {
            MergeableHeap heap1 = MergeableHeap.heapMake();
            MergeableHeap heap2 = MergeableHeap.heapMake();

            heap1.insert(5);
            heap1.insert(3);
            heap1.insert(8);

            heap2.insert(1);
            heap2.insert(4);
            heap2.insert(2);

            System.out.println("Minimum in heap1: " + heap1.findMinimum());
            System.out.println("Extracted min from heap1: " + heap1.extractMin());
            System.out.println("New min in heap1 after extraction: " + heap1.findMinimum());

            heap1.union(heap2);
            System.out.println("Min in merged heap: " + heap1.findMinimum());
        }
    }


