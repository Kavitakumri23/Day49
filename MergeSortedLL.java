package Com.Kavita.SingleLinkedList.DoublyLinkedList;

    public class MergeSortedLL {
        private Node head;

        // Insert at end
        public void insertLast(int val) {
            Node node = new Node(val);
            if (head == null) {
                head = node;
                return;
            }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }

        // Display linked list
        public void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            }
            System.out.println("END");
        }

        // Merge two sorted lists
        public static MergeSortedLL merge(MergeSortedLL first, MergeSortedLL second) {
            Node f = first.head;
            Node s = second.head;

            MergeSortedLL ans = new MergeSortedLL();
            Node dummy = new Node(-1);  // dummy node
            Node tail = dummy;

            while (f != null && s != null) {
                if (f.value <= s.value) {
                    tail.next = f;
                    f = f.next;
                } else {
                    tail.next = s;
                    s = s.next;
                }
                tail = tail.next;
            }

            // Attach remaining nodes
            if (f != null) tail.next = f;
            if (s != null) tail.next = s;

            ans.head = dummy.next; // skip dummy node
            return ans;
        }

        // Node class
        private static class Node {
            int value;
            Node next;

            Node(int value) {
                this.value = value;
            }
        }

        // Main method
        public static void main(String[] args) {
            MergeSortedLL list1 = new MergeSortedLL();
            list1.insertLast(1);
            list1.insertLast(3);
            list1.insertLast(5);

            MergeSortedLL list2 = new MergeSortedLL();
            list2.insertLast(2);
            list2.insertLast(4);
            list2.insertLast(6);

            System.out.println("List 1:");
            list1.display();
            System.out.println("List 2:");
            list2.display();

            MergeSortedLL merged = MergeSortedLL.merge(list1, list2);

            System.out.println("Merged Sorted List:");
            merged.display();
        }
    }

