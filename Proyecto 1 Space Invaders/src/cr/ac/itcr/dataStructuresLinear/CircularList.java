package cr.ac.itcr.dataStructuresLinear;

public class CircularList<T> implements OurLists<T> {

    private Node<T> last = null;
    private int size = 0 ;

    @Override
    public void addFirst(T value) {

        Node<T> newNode = new Node<T>(value, null);
        Node<T> currentNode = this.last;

        if (isEmpty()) {
            newNode.setNext(newNode);
            this.last = newNode;
            this.size++;
            return;
        }
        while (currentNode != this.last.getNext()) {
            currentNode = currentNode.getNext();
        }
        newNode.setNext(currentNode);
        this.last.setNext(newNode);
        this.size++;
    }

    @Override
    public void addLast(T value) {

        Node<T> newNode = new Node<T>(value, null);
        Node<T> currentNode = this.last;

        if (isEmpty()) {
            newNode.setNext(newNode);
            this.last = newNode;
            this.size++;
            return;
        }
        while (currentNode != this.last) {
            currentNode = currentNode.getNext();
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

        if (isEmpty()) {
            newNode.setNext(newNode);
            this.last = newNode;
            size++;
            return;
        }
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("Index exceed the length");
        }
        if (index == 0) {
            newNode.setNext(this.last.getNext());
            this.last.setNext(newNode);
            size++;
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

        Node<T> currentNode = this.last.getNext();
        int nodeIndex = 0;

        if (isEmpty()){
            throw new RuntimeException("list is empty");
        }
        while (currentNode.getValue()!= value) {
            currentNode = currentNode.getNext();
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
        if (size == 1) {
            return this.last.getValue();
        }
        if (index == 0) {
            return this.last.getNext().getValue();
        }
        while (counter != index && currentNode.getNext() != this.last) {
            currentNode = currentNode.getNext();
            counter++;
        }
        return currentNode.getValue();
    }

    @Override
    public void remove(T value) {

        Node<T> currentNode = this.last;

        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        if (this.size == 1) {
            this.last = null;
            this.size--;
            return;
        }
        if (value == this.last.getNext()) {
            this.last.setNext(this.last.getNext().getNext());
            this.size--;
            return;
        }
        while (currentNode.getNext().getValue() != value && currentNode.getNext() != this.last) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(currentNode.getNext().getNext());
        this.last = currentNode;
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
