package cr.ac.itcr.dataStructuresLinear;
/**
 *
 * @param <T> Data type
 *
 * @author kleader gutierrez pineda
 */
public class SimpleLinkedList<T> implements OurLists<T> {

    private Node<T> first = null;
    private int size = 0;

    @Override
    public void addFirst(T value) {

        if (isEmpty()) {
            this.first = new Node<T>(value);
        } else {
            this.first = new Node<T>(value, this.first);
        }
        this.size++;
    }

    @Override
    public void addLast(T value) {

        if (isEmpty()) {
            this.first = new Node<T>(value);
        } else {
            Node<T> temp = this.first;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node<T>(value));
        }
        this.size++;
    }

    @Override
    public void addAt(T value, int index) {

        if (index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            this.addFirst(value);
        }
        if (index < 0) {
            throw new IndexOutOfBoundsException("index must be positive");
        }
        if (index == 0 && isEmpty()) {
            addFirst(value);
        }
        Node<T> prev = null;
        Node<T> temp = this.first;
        while (temp != null && index > 0) {
            prev = temp;
            temp = temp.getNext();
            index--;
        }
        Node<T> nodeAdded = new Node<T>(value);
        nodeAdded.setNext(temp);
        prev.setNext(nodeAdded);
        this.size++;
    }

    @Override
    public int getIndex(T value) {

        int nodeIndex = 0;
        Node<T> temp = this.first;

        if (isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }

        while (temp.getValue() != value) {
            temp = temp.getNext();
            nodeIndex++;
        }
        return nodeIndex;
    }

    @Override
    public void remove(T value) {

        Node<T> temp = this.first;

        if (isEmpty()) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        if (value == this.first.getValue()) {
            this.first = this.first.getNext();
        }
        while (temp.getNext().getValue() != value && temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(temp.getNext().getNext());
        this.size--;
    }

    @Override
    public void clear() {
        this.first = null;
        this.size = 0;
    }

    @Override
    public void printList() {

        Node<T> temp = this.first;
        System.out.println("Elements: ");

        while (temp != null) {
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }

    @Override
    public T getValueAtIndex(int index) {

        Node<T> temp = this.first;
        int indexCount = 0;

        while (indexCount != index && temp.getNext() != null) {
            temp = temp.getNext();
        }
        return temp.getValue();
    }

    @Override
    public int length() {

        return this.size;
    }

    @Override
    public Boolean isEmpty() {

        return this.first == null;
    }

    @Override
    public void switchPositions(int index1, int index2) {
    }
}


