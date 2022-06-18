
public class Node implements Comparable<Node>{
    String id;
    String first_name;
    String last_name;
    String ticket_type;
    Node next;
    Node prev;
    int value;

    public Node(String[] person) {
        this.id = person[0];
        this.first_name = person[1];
        this.last_name = person[2];
        this.ticket_type = person[3];
        this.prev = null;
        this.next = null;
        if (this.ticket_type == "VIP") this.value = 4;  //Defining "VIP" as number 4
        if (this.ticket_type == "GOLDEN_RING") this.value = 3; //Defining "GOLDEN_RING" as number 3
        if (this.ticket_type == "INNER_RING") this.value = 2;  //Defining "INNER_RING" as number 2
        if (this.ticket_type == "OUTER_RING") this.value = 1;  //Defining "OUTER_RING" as number 1


    }

    public Node getNext() {
        return this.next;
    }

    /*
    the function returns a list with the person data:
     */
    public String[] getData() {
        String[] person = new String[]{this.id, this.first_name, this.last_name, this.ticket_type};
        return person;
    }

    /*
    the function compars between Nodes accoreding to the seats value:
     */
    public int compareTo(Node other) {
        if (this.value == other.value) {
            return 0;  // equals
        }
        if (this.value > other.value) {
            return 1; //
        } else return -1;

    }
}



