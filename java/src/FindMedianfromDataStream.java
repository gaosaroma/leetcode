import java.util.PriorityQueue;

public class FindMedianfromDataStream {
    /**
     * initialize your data structure here.
     */
//    堆
//    当只要求max或者min，不需要内部排序时，最大堆与最小堆是很好的选择。
//    这里求平均数，构造两个堆（maxHeap与minHeap），取peek的平均就可以了。
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

    public FindMedianfromDataStream() {

    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }

        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == 0) return 0;

        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }

    }

    public static void main(String[] args) {
        FindMedianfromDataStream t = new FindMedianfromDataStream();
        t.addNum(1);
        t.addNum(2);
        System.out.println(t.findMedian());
        t.addNum(3);
        System.out.println(t.findMedian());
    }
}
