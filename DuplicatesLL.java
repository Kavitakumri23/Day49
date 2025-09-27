package Com.Kavita.SingleLinkedList;

public class DuplicatesLL {
        private Node head;
        private Node tail;
        private int size;

        public DuplicatesLL() {
            this.size = 0;
        }

    // Insert at beginning
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size++;
    }

    // Insert at end
        public void insertLast(int val) {
            if (tail == null) {
                insertFirst(val);
                return;
            }
            Node node = new Node(val);
            tail.next = node;
            tail = node;
            size++;
        }


        public void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            }
            System.out.println("END");
        }

        // Node class (inner class)
        private class Node {
            int value;
            Node next;

            Node(int value) {
                this.value = value;
            }

            Node(int value, Node next) {
                this.value = value;
                this.next = next;
            }
        }

        public void duplicates(){
            Node node= head;
            while(node.next !=null){
                if(node.value == node.next.value){
                    node.next = node.next.next;
                    size--;
                } else{
                    node = node.next;
                }
            }
            tail = node;
            tail.next = null;
        }

        public static void main(String[] args){
            DuplicatesLL dd = new DuplicatesLL();
            dd.insertLast(1);
            dd.insertLast(2);
            dd.insertLast(3);
            dd.insertLast(3);
            dd.insertLast(4);

            dd.display();
            dd.duplicates();
            dd.display();
        }
}
