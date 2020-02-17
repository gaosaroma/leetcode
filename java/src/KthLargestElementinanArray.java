import java.util.PriorityQueue;

public class KthLargestElementinanArray {
//    堆
//    不需要排序，只是要部分排序，（比v小|v|比v大），堆和quick-select都是很好的选择
//    第k大，即在前k个数里是最小的；

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k + 1);
        for (int i : nums) {
            minHeap.offer(i);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        KthLargestElementinanArray t = new KthLargestElementinanArray();
        int[] n = { 3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(t.findKthLargest(n, k));
    }
}
