package Seguimiento5;

import java.util.ArrayList;

public class BST {

    private Node root;



    public Node getRoot() {
        return root;
    }
    public void add(Node node){
        if(root == null){
            root = node;
        }else{
            add(root, node);
        }
    }
    private void add(Node current, Node node){
        if(node.getKey().compareTo(current.getKey()) < 0){
          //Meter a la izquierda
            if(current.getLeft() == null){
                current.setLeft(node);
            }else{
                add(current.getLeft(), node);
            }
        }else if(node.getKey().compareTo(current.getKey()) > 0){
            //Meter a la derecha
            if(current.getRight() == null){
                current.setRight(node);
            }else{
                add(current.getRight(), node);
            }

        }else{
            //No hacer nada
        }
    }

    public Node getMin(){
        return getMin(root);
    }

    private Node getMin(Node current){
        if(current.getLeft() == null){
            return current;
        }
        return getMin(current.getLeft());
    }

    public Node getMax(){
        return getMax(root);
    }

    private Node getMax(Node current){
        if(current.getRight() == null){
            return current;
        }
        return getMax(current.getRight());
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node current){
        if(current == null){
            return;
        }
        inOrder(current.getLeft());
        System.out.println(current.getKey());
        inOrder(current.getRight());
    }

    public void inOrderReverse(){
        inOrderReverse(root);
    }

    private void inOrderReverse(Node current){
        if(current == null){
            return;
        }
        inOrderReverse(current.getRight());
        System.out.print(current.getKey() + " ");
        inOrderReverse(current.getLeft());
    }

    public Node search(String goal){
        return search(root, goal);
    }

    private Node search(Node current, String goal){
        if(current == null){
            System.out.println("No encontrado");
            return null;
        }
        if(current.getKey().equals(goal)){
            return current;
        }

        if(goal.compareTo(current.getKey()) < 0){
            return search(current.getLeft(), goal);
        }else{
            return search(current.getRight(), goal);
        }

    }

    public void splitArray(ArrayList<String> arr) {
        int size = arr.size();
        ArrayList<String> leftHalf = new ArrayList<String>();
        ArrayList<String> rightHalf = new ArrayList<String>();
        if (size == 1) {
            add(new Node(arr.get(0)));
            return;
        }
        else if (size == 2) {
            add(new Node(arr.get(0)));
            add(new Node(arr.get(1)));
            return;
        }
        else if (size % 2 == 0) {
            Node tempNode = new Node(arr.get(((size/2)-1)));
            add(tempNode);
            leftHalf = subList(arr, 0, ((size/2)-2));
            rightHalf = subList(arr, ((size/2)), (size-1) );
        } else {
            Node tempNode = new Node(arr.get((int)(size/2)));
            add(tempNode);
            leftHalf = subList(arr, 0, (((int)(size/2))-1));
            rightHalf = subList(arr, (((int)(size/2))+1), (size-1) );
        }
        splitArray(leftHalf);
        splitArray(rightHalf);
    }
    public ArrayList<String> subList(ArrayList<String> arr, int initPos, int endPos) {
        ArrayList<String> newArr = new ArrayList<String>();
        for (int i = initPos; i <= endPos; i++) {
            newArr.add(arr.get(i));
        }
        return newArr;
    }

    public int depth() {
        if (root == null) {
            return 0;
        }
        return depth(root, 1);
    }

    private int depth(Node current, int n) {
        if (current == null) {
            return n-1;
        }
        if (depth(current.getRight(), n+1) >= depth(current.getLeft(), n+1)) {
            return depth(current.getRight(), n+1);
        } else {
            return depth(current.getLeft(), n+1);
        }
    }
}
