class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq =
            new PriorityQueue<>((a, b) -> a.val - b.val);

        // Put first node of every list into heap
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {

            // Smallest node
            ListNode current = pq.poll();

            // Add it to answer
            tail.next = current;
            tail = tail.next;

            // Add next node of same list
            if (current.next != null) {
                pq.add(current.next);
            }
        }

        return dummy.next;
    }
}