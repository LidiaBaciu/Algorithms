package linkedList;

public class LinkedList {

    private Node head;

    public static void runTests(){
        LinkedList linkedList = new LinkedList();
        Node head = new Node(5);
        linkedList.addToTheLast(head);
        linkedList.addToTheLast(new Node(6));
        linkedList.addToTheLast(new Node(7));
        linkedList.addToTheLast(new Node(1));
        linkedList.addToTheLast(new Node(2));

        linkedList.printList(head);

        Node reverseHead = reverseLinkedList(head);
        System.out.println("After reversing");
        linkedList.printList(reverseHead);
    }

    public void addToTheLast(Node node){
        if(head == null){
            head = node;
        } else {
            Node currentNode = head;
            while(currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = node;
        }
    }

    public static void printList(Node head){
        Node current = head;
        while(current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static Node reverseLinkedList(Node currentNode){
        if (currentNode == null || currentNode.next == null) {
            return currentNode;
        }

        Node remaining = reverseLinkedList(currentNode.next);
        currentNode.next.next = currentNode;
        currentNode.next = null;
        return remaining;
    }

}
