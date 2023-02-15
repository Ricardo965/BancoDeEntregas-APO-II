package CircularLists;

public class CircularList {
    public static void main(String[] args) {
        CircularList cir = new CircularList();
        for (int i = 0; i < 4; i++) {
            Node newNode = new Node(String.valueOf(i));
            cir.addNode(newNode);
        }
        cir.print();
        System.out.println(cir.searchNode("0").toString());
        System.out.println(cir.searchNode("1").toString());
        System.out.println(cir.searchNode("2").toString());
        System.out.println(cir.searchNode("3").toString());

        cir.print();
        cir.delete("null");
        System.out.println("Eliminación del 0");
        cir.delete("0");
        cir.print();
        System.out.println("Eliminación del 2");
        cir.delete("2");
        cir.print();
        System.out.println("Eliminación del 3");
        cir.delete("3");
        cir.print();
        System.out.println("Eliminación del 1");
        cir.delete("1");
        System.out.println("???????????");
        cir.print();
        cir.delete("null");
        cir.print();
    }

    private Node head;

    public CircularList() {
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void addNode(Node nodeToAdd) {
        if (head == null) {
            head = nodeToAdd;
            nodeToAdd.setNext(nodeToAdd);
            nodeToAdd.setPrevious(nodeToAdd);
        } else {

            Node tail = head.getPrevious();
            nodeToAdd.setNext(head);
            head.setPrevious(nodeToAdd);
            tail.setNext(nodeToAdd);
            nodeToAdd.setPrevious(tail);
        }
    }

 
    public void print() {
        if (head == null) {
            return;
        }
        print2(head);
    }

    private void print1(Node node) {
        if (node == head.getPrevious()){
            System.out.println(node.getValue());
            return;
        } else {
            System.out.println(node.getValue());
            print1(node.getNext());
        }


    }

    private void print2(Node node) {
        System.out.println(node.getValue());
        if (node.getNext() == head) {
            return;
        }
        print2(node.getNext());
    }

    public void delete(String goal) {
        delete(head, goal);
    }

    private void delete(Node current, String goal) {
        if (current != null) {
            if (current.getValue().equals(goal)) {
                if (head == head.getNext()) {
                    head = null;
                    return;
                }
                current.getPrevious().setNext(current.getNext());
                current.getNext().setPrevious(current.getPrevious());
                if (current == head) {
                    head = current.getNext();
                }
                return;
            }
            if (current.getNext() == head)return;
            delete(current.getNext(), goal);
        } 
        return;
    }

    public Node searchNode(String goal) {
        return searchNode(head, goal);
    }

    private Node searchNode(Node current, String goal) {

        if (current != null) {
            if (current.getValue().equals(goal)) {
                return current;
            }
            if (current.getNext() == head) return null;
            return searchNode(current.getNext(), goal);
        } 
        return null;
    }


    
}
