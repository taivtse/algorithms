package data_structure;

public class LinkedList<T> {
    private Node<T> head;

    public static class Node<T> {
        private Node next;
        private T data;

        public Node(T data) {
            this.data = data;
        }
    }

    public void push(Node<T> newNode) {
        if (head == null){
            head = newNode;
            return;
        }

        Node<T> iterator = head;
        while (iterator.next != null){
            iterator = iterator.next;
        }
        iterator.next = newNode;
    }

    public Node<T> pop() {
        if (head == null)
            return null;

        Node<T> temp = head;
        head = head.next;

        return temp;
    }

    public Node<T> peek() {
        return head;
    }

    public void display(){
        Node<T> iterator = head;
        while (iterator != null){
            System.out.print(String.format("%5d", iterator.data));
            iterator = iterator.next;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.push(new Node<>(5));
        linkedList.push(new Node<>(1));
        linkedList.push(new Node<>(0));
        linkedList.push(new Node<>(9));

        linkedList.display();
    }
}
