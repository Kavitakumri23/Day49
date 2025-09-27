package Com.Kavita.SingleLinkedList.DoublyLinkedList;

class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public class LinkedListCycle {

        // Function to detect cycle
        public static boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) return false;

            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) return true;
            }
            return false;
        }

        public static void main(String[] args) {
            // Creating nodes
            ListNode head = new ListNode(3);
            ListNode node2 = new ListNode(2);
            ListNode node0 = new ListNode(0);
            ListNode nodeMinus4 = new ListNode(-4);

            // Linking nodes: 3 -> 2 -> 0 -> -4
            head.next = node2;
            node2.next = node0;
            node0.next = nodeMinus4;
            nodeMinus4.next = node2; // cycle here

            if (hasCycle(head)) {
                System.out.println("Cycle detected in the linked list!");
            } else {
                System.out.println("No cycle in the linked list.");
            }
        }
    }

