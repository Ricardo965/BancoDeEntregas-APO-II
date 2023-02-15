package CircularLists;

public class Node {

    private String value;
    private Node next;
    private Node previous;

    public Node(String value) {
        this.value = value;
    }
    
    public void alfa(){
        //alfaMethod
    }
    
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public Node getPrevious() {
        return previous;
    }
    public void setPrevious(Node previous) {
        this.previous = previous;
    }
    
}
