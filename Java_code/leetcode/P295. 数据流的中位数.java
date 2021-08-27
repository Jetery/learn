/*
中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。

例如，

[2,3,4] 的中位数是 3

[2,3] 的中位数是 (2 + 3) / 2 = 2.5

设计一个支持以下两种操作的数据结构：

    void addNum(int num) - 从数据流中添加一个整数到数据结构中。
    double findMedian() - 返回目前所有元素的中位数。

示例：

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2

*/




class MedianFinder {
    //大根堆
    PriorityQueue<Integer> l = new PriorityQueue<>((a,b) -> b - a);
    //小根堆(默认)
    PriorityQueue<Integer> r = new PriorityQueue<>();
    
    public void addNum(int num) {
        // 大小相同
        if (l.size() == r.size()) {
            // r 为空,首个元素
            if (r.size() == 0) {
                l.offer(num);
            } else {
                //num 的插入位置不会在后半部分
                if (num <= r.peek()) {
                    l.offer(num);
                } else {
                    l.offer(r.poll());
                    r.offer(num);
                }
            }
        } else {
            if (num >= l.peek()) {
                r.offer(num);
            } else {
                r.offer(l.poll());
                l.offer(num);
            }
        }
    }
    
    public double findMedian() {
        if (r.size() == l.size()) {
            return (r.peek() + l.peek()) / 2.0;
        } else {
            return l.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */




//简洁版
class MedianFinder {
    PriorityQueue<Integer> l = new PriorityQueue<>((a,b)->b-a);
    PriorityQueue<Integer> r = new PriorityQueue<>((a,b)->a-b);
    
    public void addNum(int num) {
        int s1 = l.size(), s2 = r.size();
        if (s1 == s2) {
            if (r.isEmpty() || num <= r.peek()) {
                l.add(num);
            } else {
                l.add(r.poll());
                r.add(num);
            }
        } else {
            if (l.peek() <= num) {
                r.add(num);
            } else {
                r.add(l.poll());
                l.add(num);
            }
        }
    }
    
    public double findMedian() {
        int s1 = l.size(), s2 = r.size();
        if (s1 == s2) {
            return (l.peek() + r.peek()) / 2.0;
        } else {
            return l.peek();
        }
    }
}
