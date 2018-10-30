package com.asidun;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Node implements Comparable<Node>{
    private final String word;

    private int count;

    private Node parent;

    private Node leftChild;

    private Node rightChild;

    public Node(String word){
        this.word = word;
        count = 1;
    }

    public Node(){
        count = 0;
        this.word = "";
    }

    public String getWord() {
        return new String(word);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void incrementCount(){
        count++;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString(){
        return word + "-" + count;
    }

    @Override
    public int compareTo(@NotNull Node n) {
        return count - n.getCount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return count == node.count &&
                Objects.equals(word, node.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, count);
    }
}
