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
    public void insertAt(int position, int new_data){

        Node temp = head;
        Node prev = null;

        //Creating new node
        Node new_node = new Node(new_data);

        for(int i=1; i<position; i++){
            prev = temp;
            temp = temp.next;
        }

        if(temp!=null){
            //Pointing new node to same list as prev node
            new_node.next = prev.next;

            //Pointing existing node to new node, so that the new element can be inserted.
            prev.next = new_node;
        }
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
    public void deleteHead(){

        //If head is already null, then no need to delete anything.
        if(head==null){
            return;
        }

        Node temp = head;
        head = head.next;

    }

    //Removing node at specified position
    public void deleteAt(int position){

        Node temp = head;

        Node prev = null;

        if(head==null){
            return;
        }

        //Base case if first position
        if(position==1){
            head = temp.next;
            return;
        }

        //Find node at given position
        for(int i=1; temp!=null && i<position; i++){
            prev = temp;
            temp = temp.next;
        }

        //If position is found, deleting node.
        if(temp!=null){
            prev.next = temp.next;
        }else{
            //If position does not exist, cannot delete
            System.out.println("This position does not exist. Cannot delete anything.");
        }

    }

    //Removing Node at end of LinkedList
    public void deleteEnd(){
        // If the list is empty, return null
        if (head == null) {
            return;
        }

        // If the list has only one node, delete it and return null
        if (head.next == null) {
            return;
        }

        //Find secondlast node
        Node secondLast = head;
        while (secondLast.next.next != null) {
            secondLast = secondLast.next;
        }

        //Delete last node
        secondLast.next= null;

    }

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
    public void search(int value){
        Node traversingNode = head;
        int position = 1;
        while(traversingNode!=null){
            if(traversingNode.data == value){
                System.out.println("Value found in position " + position);
                return;
            }
            position++;
            traversingNode = traversingNode.next;
        }
        System.out.println("Value not present in linked list.");
    }

    //Reverse LinkedList


    //Tests
    public static void main(String[] args) {

        //Insertion
        LinkedList testlist = new LinkedList();
        testlist.insert(5);
        testlist.insert(3);
        testlist.append(7);
        testlist.append(9);
        testlist.insertAt(3,20);
        testlist.insertAt(2,15);
        testlist.insertAt(5,30);

        //Traversal
        testlist.printAll();

        //Deletion
        testlist.deleteHead();
        System.out.println();
        testlist.printAll();

        testlist.deleteEnd();
        System.out.println();
        testlist.printAll();

        testlist.deleteAt(4);
        System.out.println();
        testlist.printAll();

        //Search
        System.out.println();

        //Search case when element not in list
        testlist.search(3);
        System.out.println();

        //Search case when element in list
        testlist.search(20);

        //Reverse
    }

}
