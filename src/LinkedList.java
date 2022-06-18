public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;

    }

    public void add(String[] person){
        Node temp = new Node(person);
        this.size ++;
        if (this.tail == null){
            this.head = temp;
            this.tail = temp;
        }
        else {
            temp.prev = this.tail;
            this.tail.next = temp;
            this.tail = temp;
        }
    }

    public int getSize(){
        return this.size;
    }

    public Node getHead(){
        return this.head;
    }

    public Node getTail(){
        return this.tail;
    }


}
