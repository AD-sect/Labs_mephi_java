package ru.mephi.laba2;

/* Class realised a structure of lincked list with the sort of elements while adding.

    Method mergeJoin solve the task for 2nd laba:
    Input: Sorted list
    Output: List of joining current object of class and list from input

 */

public class SortedList<T extends Comparable<T>> {

    public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
        private T value;
        private Node<T> next;
        private Node<T> previous;

        Node(T value) {
            this.value = value;
            this.next = null;
            this.previous = null;
        }

        Node(T value, Node<T> next, Node<T> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public T getValue() {
            return this.value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        @Override
        public int compareTo(Node<T> o) {
            return this.getValue().compareTo(o.getValue());
        }

        @Override
        public String toString() {
            return value + " -> " + next;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    SortedList() {
        head = null;
        tail = null;
        size = 0;
    }

    SortedList(T value) {
        head = new Node<T>(value);
        tail = head;
        size++;
    }

    public void add(T value) {
        if (head == null) {
            head = new Node<T>(value);
            tail = head;
            size++;
            return;
        } else {
            if (head.getValue().compareTo(value) > 0) { // for the adding to the start
                Node<T> newHead = new Node<T>(value, head, null);
                head.setPrevious(newHead);
                head = newHead;
                size++;
                return;
            } else {
                if (tail.getValue().compareTo(value) < 0) { // for the adding to the end
                    Node<T> newTail = new Node<T>(value, null, tail);
                    tail.setNext(newTail);
                    tail = newTail;
                    size++;
                    return;
                }
                Node<T> cur = head.getNext();

                while (cur.getValue().compareTo(value) < 0) { // for the adding in middle
                    cur = cur.getNext();
                }
                Node<T> curPrev = cur.getPrevious();
                Node<T> newNode = new Node(value, cur, cur.getPrevious());
                cur.setPrevious(newNode);
                curPrev.setNext(newNode);
                size++;
                return;

            }
        }
    }

    public T getTail() {
        return tail.getValue();
    }

    public T remove(int index) {
        if (index >= size) {
            return tail.getValue();
        }
        if (index < 0) {
            return head.getValue();
        } else {
            if (index == 0) {// for removing the first element
                T value = head.getValue();
                head = head.getNext();
                size--;
                return value;
            } else {
                if (index == size - 1) { // for removing the last element
                    T value = tail.getValue();
                    tail = tail.getPrevious();
                    tail.setNext(null);
                    size--;
                    return value;
                } else {
                    Node<T> cur = getNode(index); //for removing element from the center
                    T value = cur.getValue();

                    Node<T> curPrev = cur.getPrevious();
                    Node<T> curNext = cur.getNext();
                    curPrev.setNext(curNext);
                    curNext.setPrevious(curPrev);
                    size--;
                    return value;
                }
            }
        }
    }

    @Override
    public String toString() {
        return head + " ";
    }

    public T get(int index) {
        if (index >= size) {
            return tail.getValue();
        }
        if (index < 0) {
            return head.getValue();
        }
        Node<T> cur = getNode(index);
        return cur.getValue();
    }

    public Node<T> getNode(int index) { //helper method for finding node
        Node<T> cur;
        if (index <= size / 2) {
            cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
        } else {
            cur = tail;
            for (int i = size - 1; i > index; i--) {
                cur = cur.getPrevious();
            }
        }
        return cur;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public int indexOf(Object data) {
        Node cur = head;

        for (int i = 0; i < size; i++) {
            if (cur.getValue().equals(data)) {
                return i;
            }
            cur = cur.getNext();
        }
        return -1;
    }


    public boolean contains(Object data) {
        return indexOf(data) != -1;
    }

    public Node<T> getHead() {
        return this.head;
    }

    public int size() {
        return this.size;
    }

    public SortedList<T> mergeJoin(SortedList<T> list2) {

        SortedList<T> joinList = new SortedList<>();// make the result list
        if (list2 == null) {// check if list is empty
            return joinList = this;
        } else {
            Node<T> cur1 = head;//make pointers for the first list
            Node<T> cur2 = list2.getHead();//make pointers for the second list
            while (cur1 != null && cur2 != null) {// check if lists are ended
                if (cur1.compareTo(cur2) >= 0) {// check which one is smaller
                    joinList.add(cur1.getValue());//join to the result list
                    cur1 = cur1.getNext();//go on in the list, where element is smaller
                } else {
                    joinList.add(cur2.getValue());//join to the result list
                    cur2 = cur2.getNext();//go on in the list, where element is smaller
                }
            }//when ane of list is ended
            while (cur1 != null) {//check if we can add remainig element
                joinList.add(cur1.getValue());
                cur1 = cur1.getNext();
            }
            while (cur2 != null) {//check if we can add remainig element
                joinList.add(cur2.getValue());
                cur2 = cur2.getNext();
            }
        }
        return joinList;
    }

}
