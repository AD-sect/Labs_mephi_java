package ru.mephi.laba2;

public class List {

    private class Node {
        private int data;
        private Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        private Node getNext() {
            return this.next;
        }

        private int getData() {
            return this.data;
        }

        private void setNext(Node next) {
            this.next = next;
        }

        private void setData(int data) {
            this.data = data;
        }

        private void set(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public java.lang.String toString() {
            return data + " " + next;
        }
    }

    private Node head;
    private int length;


    List() {
        head = null;
        length = 0;

    }

    List(int data) {
        head = new Node(data);
        length = 1;

    }

    List(int[] dataMas, int length) {
        for (int i = 0; i < length; i++) {
            head = new Node(dataMas[i], head);
        }
        this.length = length;
    }

    public Node getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    @Override
    public java.lang.String toString() {
        return "List{" +
                "head=" + head +
                ", length=" + length +
                '}';
    }

    public Node goTo(int index) {
        Node copyHead = head;
        for (int i = 0; i < index; i++) {
            copyHead = copyHead.getNext();
        }
        return copyHead;
    }

    public void add(int data) {

        if (head == null) {
            head = new Node(data);
            length = 1;
        } else {
            Node copyHead = head;
            Node cur = new Node(data, null);
            head = goTo(length - 1);

            head.set(head.getData(), cur);
            head = copyHead;
            length++;
        }
    }

    public void add(int data, int index) {
        if (index >= length) {
            add(data);
            length++;
        } else if (index <= 0) {
            head = new Node(data, head);
            length++;
        } else {
            Node copyHead = head;
            copyHead = goTo(index - 1);

            Node cur = new Node(data, copyHead.getNext());
            copyHead.setNext(cur);

            length++;
        }
    }

    public int remove(int index) {
        try{
            if ((index >= length) || (index < 0)){
                throw new IndexOutOfBoundsException("Index out of bound");
            }
            if (index == 0) {
                int data = head.getData();
                head = head.getNext();

                length--;
                return data;
            } else {
                Node copyHead = head;
                copyHead = goTo(index - 1);

                Node cur = copyHead;
                copyHead = copyHead.getNext();
                int data = copyHead.getData();
                cur.setNext(copyHead.getNext());
                cur = cur.getNext();

                length--;
                return data;
            }
        }
        catch(IndexOutOfBoundsException e){
            System.err.println(e.getMessage());
            return -1;

        }

    }

    public int get(int index) {
        try{
            if ((index >= length) || (index < 0)) {
                throw new IndexOutOfBoundsException("Index out of bound");
            }
            Node copyHead = head;
            copyHead = goTo(index);
            int data = copyHead.getData();
            return data;
        }
        catch(IndexOutOfBoundsException e){
            System.err.println(e.getMessage());
            return head.getData();
        }

    }

    public int size() {
        return length;
    }

    public int set(int data, int index) {

        try{
            if ((index >= length) || (index < 0)) {
                throw new IndexOutOfBoundsException();
            }
            Node copyHead = head;
            copyHead = goTo(index);
            copyHead.set(data, copyHead.getNext());
            return data;
        }
        catch(IndexOutOfBoundsException e){
            System.err.println(e.getMessage());
            return data;
        }

    }

    public boolean isEmpty() {
        if (length >= 0)
            return false;
        else
            return true;
    }

//    public int indexOf(int data) {
//        Node copyHead = head;
//        for (int i = 0; i < length; i++) {
//            if (copyHead.getData().equals(data)) {
//                return i;
//            }
//            copyHead = copyHead.getNext();
//        }
//        return -1;
//    }

//    public boolean contains(int data) {
//        if (indexOf(data) == -1)
//            return false;
//        else
//            return true;
//    }

    public static void main(String[] args) {

    }

}
