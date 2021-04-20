package cr.ac.itcr.dataStructuresLinear;
/**
 *
 * @param <T> Data type
 *
 * @author kleader gutierrez pineda
 */
public class DoubleCircularList<T> implements OurLists<T> {

    private Node<T> last = null;
    private int size = 0;

    @Override
    public void addFirst(T value) {

        Node<T> newNode = new Node<T>(value, null, null);

        if (isEmpty()) {
            newNode.setNext(newNode);
            newNode.setPrev(newNode);
            this.last = newNode;

            this.size++;
            return;
        }
        else {
            newNode.setNext(this.last.getNext());
            newNode.setPrev(this.last);
            this.last.setNext(newNode);
            this.size++;
        }
    }

    @Override
    public void addLast(T value) {

        Node<T> newNode = new Node<T>(value, null, null);

        if (isEmpty()) {
            newNode.setNext(newNode);
            newNode.setPrev(newNode);
            this.last = newNode;
            this.size++;
            return;
        }
        newNode.setNext(this.last.getNext());
        newNode.setPrev(this.last);
        this.last.getNext().setPrev(newNode);
        this.last.setNext(newNode);
        this.last = newNode;
        this.size++;
    }

    @Override
    public void addAt(T value, int index) {

        Node<T> newNode = new Node<T>(value, null, null);
        Node<T> currentNode = this.last;

        if (index > size ) {
            throw new IndexOutOfBoundsException("Index exceed the length");
        }
        if (isEmpty() && index == 0) {
            addFirst(value);
            return;
        }
        if (index == size) {
            addLast(value);
            return;
        }
        else{
            while (index > 0 ) {
                currentNode = currentNode.getNext();
                index--;
            }
            newNode.setNext(currentNode);
            newNode.setPrev(currentNode.getPrev());
            currentNode.getPrev().setNext(newNode);
            this.size++;
            return;
        }
    }

    @Override
    public int getIndex(T value) {

        Node<T> temp = this.last;
        int nodeIndex = 0;

        if (isEmpty()){
            throw new RuntimeException("list is empty");
        }
        while (temp.getNext().getValue() != value && temp.getNext() != this.last) {
            temp = temp.getNext();
            nodeIndex++;
        }
        return nodeIndex;
    }

    @Override
    public T getValueAtIndex(int index) {

        Node<T> currentNode = this.last;
        int counter = 0;

        if (isEmpty()){
            throw new RuntimeException("list is empty");
        }
        if (size == 1 && index == size - 1) {
            return this.last.getValue();
        }
        if (index == 0) {
            return this.last.getNext().getValue();
        }
        if (index == this.size - 1) {
            return this.last.getValue();
        }
        while (counter != index && currentNode.getNext() != this.last) {
            currentNode = currentNode.getNext();
            counter++;
        }
        return currentNode.getValue();
    }

    @Override
    public void switchPositions(int index1, int index2) {

    }

    @Override
    public void remove(T value) {

        Node<T> temp = this.last;

        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        if (value == this.last.getValue()) {
            this.last.getPrev().setNext(this.last.getNext());
            this.last.getNext().setPrev(this.last.getPrev());
            this.last = this.last.getPrev();
            this.size--;
            return;
        }
        if (value == this.last.getNext().getValue()) {
            this.last.getNext().getNext().setPrev(this.last);
            this.last.setNext(this.last.getNext().getNext());
            this.size--;
            return;
        }
        while (temp.getNext().getValue() != value && temp.getNext() != this.last) {
            temp =temp.getNext();
        }
        temp.getNext().getNext().setPrev(temp);
        temp.setNext(temp.getNext().getNext());
        this.size--;
    }

    @Override
    public void clear() {

        this.last = null;
        this.size = 0;
    }

    @Override
    public void printList() {

        if (!isEmpty()) {
            Node<T> temp = this.last;
            System.out.println("Elements, increasing order:");
            while (temp.getNext() != this.last) {
                System.out.println(temp.getNext().getValue());
                temp = temp.getNext();
            }
            System.out.println(temp.getNext().getValue());
        }
        else {
            System.out.println("Empty list");
            System.out.println("--------");
        }
    }

    @Override
    public Boolean isEmpty() {
        return this.last == null;
    }

    @Override
    public int length() {
        return this.size;
    }
}
