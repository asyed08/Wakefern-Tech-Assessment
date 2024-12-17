public class LinkedList {

    //Head of LinkedList
    Node head;

    //Single Node of LinkedList
    class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    //Inserting new node at beginning of LinkedList
    public void insert(int new_data){

        //Creating new node
        Node new_node = new Node(new_data);

        //Setting next node of new node as existing head.
        new_node.next=head;

        //Redefining head to point to new node.
        head = new_node;

    }

    //Inserting new node at specified position of LinkedList
    public void insertAfter(Node prevNode, int new_data){
        if(prevNode==null){
            System.out.println("The given prevNode cannot be null. Need an actual node to insert data after.");
            return;
        }

        //Creating new node
        Node new_node = new Node(new_data);

        //Pointing new node to same list as prev node
        new_node.next = prevNode.next;

        //Pointing existing node to new node, so that the new element can be inserted.
        prevNode.next=new_node;
    }

    //Inserting new node at end of LinkedList
    public void append(int new_data){

        //Creating new node
        Node new_node = new Node(new_data);

        //If linkedlist is empty, then only need to make new node as the head
        if(head==null){
            head = new Node(new_data);
            return;
        }

        //New node going to be last, so should point to null.
        new_node.next = null;

        //Find last node
        Node last_node = head;
        while(last_node.next != null){
            last_node = last_node.next;
        }

        //Point last node to new node
        last_node.next = new_node;
        return;
    }

    //Removing Node at beginning


    //Removing node at specified position

    //Removing Node at end of LinkedList

    //Traversal - printing all nodes of LinkedList
    public void printAll()
    {
        Node traversingNode = head;
        while(traversingNode!=null){
            System.out.print(traversingNode.data + " ");
            traversingNode = traversingNode.next;
        }
    }

    //Search - finding provided value in list

    //Reverse LinkedList

    //Tests
    public static void main(String[] args) {

        //Insertion
        LinkedList testlist = new LinkedList();
        testlist.insert(5);


        //Traversal
        testlist.printAll();

        //Deletion

        //Search

        //Reverse
    }

}
