package data_structure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree<T extends Comparable> {
    private Node<T> root;

    static class Node<T> {
        T data;
        Node<T> left, right;

        Node(T data) {
            this.data = data;
        }
    }

    public void add(T data) {
        if (root == null) {
            root = new Node<>(data);
            return;
        }

        this.insertNode(root, data);
    }

    private void insertNode(Node<T> parent, T data) {
        if (parent.data.compareTo(data) > 0) {
            if (parent.left != null) {
                this.insertNode(parent.left, data);
            } else {
                parent.left = new Node<>(data);
            }
        } else if (parent.data.compareTo(data) < 0) {
            if (parent.right != null) {
                this.insertNode(parent.right, data);
            } else {
                parent.right = new Node<>(data);
            }
        }
    }

    public void NLR() {
        if (root != null) {
            this.NLRRecursive(root);
        }
    }

    private void NLRRecursive(Node<T> node) {
        System.out.println(node.data);

        if (node.left != null) {
            this.NLRRecursive(node.left);
        }

        if (node.right != null) {
            this.NLRRecursive(node.right);
        }
    }

    public void LNR() {
        if (root != null) {
            this.LNRRecursive(root);
        }
    }

    private void LNRRecursive(Node<T> node) {
        if (node.left != null) {
            this.LNRRecursive(node.left);
        }

        System.out.println(node.data);

        if (node.right != null) {
            this.LNRRecursive(node.right);
        }
    }

    public void RNL() {
        if (root != null) {
            this.RNLRecursive(root);
        }
    }

    private void RNLRecursive(Node<T> node) {
        if (node.left != null) {
            this.RNLRecursive(node.left);
        }

        if (node.right != null) {
            this.RNLRecursive(node.right);
        }

        System.out.println(node.data);
    }

    public void delete(T data){

    }

    public void breadthFirstSearch(){
        if (this.root != null){
            Queue<Node<T>> queue = new LinkedList();
            queue.add(this.root);
            this.breadthFirstSearchRecursive(queue);
        }
    }

    private void breadthFirstSearchRecursive(Queue<Node<T>> queue){
        if (queue.isEmpty()){
            return;
        }

        Node<T> node = queue.poll();

        System.out.println(node.data);

        if (node.left != null){
            queue.add(node.left);
        }

        if (node.right != null){
            queue.add(node.right);
        }

        this.breadthFirstSearchRecursive(queue);
    }

    public void deepFirstSearch(){
        if (this.root != null){
            Stack stack = new Stack();
            stack.push(this.root);
            this.deepFirstSearchRecursive(stack);
        }
    }

    public void deepFirstSearchRecursive(Stack<Node<T>> stack){
        if (stack.isEmpty()){
            return;
        }

        Node<T> node = stack.pop();

        System.out.println(node.data);

        if (node.right != null){
            stack.push(node.right);
        }

        if (node.left != null){
            stack.push(node.left);
        }

        this.deepFirstSearchRecursive(stack);
    }

    public int getHeight(){
        if(root == null){
            return 0;
        }

        return this.getHeight(this.root);
    }

    private int getHeight(Node<T> root){
        if(root == null){
            return 0;
        }

        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(8);
        tree.add(3);
        tree.add(10);
        tree.add(1);
        tree.add(6);
        tree.add(14);
        tree.add(4);
        tree.add(7);
        tree.add(13);

//        tree.LNR();
        int treeHeight = tree.getHeight();
        System.out.println(treeHeight);
    }
}
