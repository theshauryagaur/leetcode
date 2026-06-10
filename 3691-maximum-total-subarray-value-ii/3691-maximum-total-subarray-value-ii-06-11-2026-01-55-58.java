import java.util.*;

class Solution {
    class Node {
        int min, max;
        Node(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    public class SegmentTree {
        Node[] tree;
        int[] arr;
        int n;

        SegmentTree(int[] nums) {
            arr = nums;
            n = arr.length;
            tree = new Node[4 * n];
            build(0, 0, n - 1);
        }

        public void build(int node, int st, int end) {
            if (st == end) {
                tree[node] = new Node(arr[st], arr[st]);
                return;
            }
            int mid = st + (end - st) / 2;
            build(2 * node + 1, st, mid);
            build(2 * node + 2, mid + 1, end);
            tree[node] = new Node(
                Math.min(tree[2*node+1].min, tree[2*node+2].min),
                Math.max(tree[2*node+1].max, tree[2*node+2].max)
            );
        }

        public Node query(int l, int r) {
            return query(0, 0, n - 1, l, r);
        }

        public Node query(int node, int st, int end, int l, int r) {
            if (end < l || r < st) return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE);
            if (l <= st && end <= r) return tree[node];
            int mid = st + (end - st) / 2;
            Node left  = query(2 * node + 1, st, mid, l, r);
            Node right = query(2 * node + 2, mid + 1, end, l, r);
            return new Node(
                Math.min(left.min, right.min),
                Math.max(left.max, right.max)
            );
        }
    }

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        SegmentTree tree = new SegmentTree(nums);

        // max-heap: {value, l, r}
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        Set<Long> visited = new HashSet<>();

        Node temp = tree.query(0, n - 1);
        maxHeap.offer(new int[]{temp.max - temp.min, 0, n - 1});
        visited.add((long) 0 * n + (n - 1));

        while (k-- > 0) {
            int[] cur = maxHeap.poll();
            int val = cur[0], l = cur[1], r = cur[2];
            ans += val;

            // shrink from right
            if (r - 1 >= l) {
                long key = (long) l * n + (r - 1);
                if (visited.add(key)) {
                    Node t = tree.query(l, r - 1);
                    maxHeap.offer(new int[]{t.max - t.min, l, r - 1});
                }
            }
            // shrink from left
            if (l + 1 <= r) {
                long key = (long) (l + 1) * n + r;
                if (visited.add(key)) {
                    Node t = tree.query(l + 1, r);
                    maxHeap.offer(new int[]{t.max - t.min, l + 1, r});
                }
            }
        }

        return ans;
    }
}