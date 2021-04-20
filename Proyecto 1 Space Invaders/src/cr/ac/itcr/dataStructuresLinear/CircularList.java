package cr.ac.itcr.dataStructuresLinear;
/**
 *
 * @param <T> Data type
 *
 * @author kleader gutierrez pineda
 */
public class CircularList<T> implements OurLists<T> {

    private Node<T> last = null;
    private int size = 0 ;

    @Override
    public void addFirst(T value) {

        Node<T> newNode = new Node<T>(value, null);
        Node<T> temp = this.last;

        if (isEmpty()) {
            newNode.setNext(newNode);
            this.last = newNode;
            this.size++;
            return;
        }
        while (temp != this.last.getNext()) {
            temp = temp.getNext();
        }
        newNode.setNext(temp);
        this.last.setNext(newNode);
        this.size++;
    }

    @Override
    public void addLast(T value) {

        Node<T> newNode = new Node<T>(value, null);
        Node<T> temp = this.last;

        if (isEmpty()) {
            newNode.setNext(newNode);
            this.last = newNode;
            this.size++;
            return;
        }
        while (temp != this.last) {
            temp = temp.getNext();
        }
        newNode.setNext(this.last.getNext());
        this.last.setNext(newNode);
        this.last = newNode;
        this.size++;
    }

    @Override
    public void addAt(T value, int index) {

        Node<T> newNode = new Node<T>(value, null);
        Node<T> currentNode = this.last;

        if (index > size - 1) {
            throw new IndexOutOfBoundsException("Index exceed the length");
        }
        if (isEmpty() && index == 0) {
            addFirst(value);
            return;
        }
        while (index > 0){
            currentNode = currentNode.getNext();
            index--;
        }
        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);
        this.size++;
    }

    @Override
    public int getIndex(T value) {

        Node<T> temp = this.last.getNext();
        int nodeIndex = 0;

        if (isEmpty()){
            throw new RuntimeException("list is empty");
        }
        while (temp.getValue()!= value) {
            temp = temp.getNext();
            nodeIndex++;
        }
        return nodeIndex;
    }

    @Override
    public T getValueAtIndex(int index) {

        Node<T> temp = this.last;
        int counter = 0;

        if (isEmpty()){
            throw new RuntimeException("list is empty");
        }
        if (size == 1) {
            return this.last.getValue();
        }
        if (index == 0) {
            return this.last.getNext().getValue();
        }
        while (counter != index && temp.getNext() != this.last) {
            temp = temp.getNext();
            counter++;
        }
        return temp.getValue();
    }

    @Override
    public void remove(T value) {

        Node<T> temp = this.last;

        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        if (this.size == 1) {
            this.last = null;
            this.size--;
            return;
        }
        if (value == this.last.getNext().getValue()) {
            this.last.setNext(this.last.getNext().getNext());
            this.size--;
            return;
        }
        while (temp.getNext().getValue() != value && temp.getNext() != this.last) {
            temp = temp.getNext();
        }
        temp.setNext(temp.getNext().getNext());
        this.last = temp;
        this.size--;
    }

    @Override
    public void clear() {

        this.last = null;
        this.size = 0;
    }

    @Override
    public void printList() {

        Node<T> temp = this.last;
        System.out.println("Elements, increasing order:");
        while (!isEmpty() && temp.getNext() != this.last){
            System.out.println(temp.getNext().getValue());
            temp = temp.getNext();
        }
        System.out.println(temp.getNext().getValue());
        /*
        Node<T> temp = this.last;
        int counter = 0;
        System.out.println("Elements: ");

        if (isEmpty()){
            System.out.println("Empty");
        }
        if (size == 1) {
            System.out.println(temp.getValue());
        }
        else {
            while (counter < size) {
                System.out.println(temp.getNext().getValue());
                temp = temp.getNext();
                counter++;
                }
        }

         */
        System.out.println("---------");
    }

    @Override
    public Boolean isEmpty() {
        return this.last == null;
    }

    @Override
    public int length() {
        return this.size;
    }

    @Override
    public void switchPositions(int index1, int index2) {}
}
