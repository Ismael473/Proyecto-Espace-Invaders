package cr.ac.itcr.dataStructuresLinear;

public class DoubleLinkedList<T> implements OurLists<T> {

    private Node<T> first = null;
    private Node<T> prev = null;
    private int size = 0;

    @Override
    public void addFirst(T value) {

        Node<T> newNode = new Node(value, null, null);

        if (isEmpty()){
            this.first = newNode;
        }
        else{
            newNode.setNext(this.first);
            this.first.setPrev(newNode);
            this.first = newNode;
        }
        this.size++;
    }

    @Override
    public void addLast(T value) {

        Node<T> newNode = new Node<T>(value, null, null);

        if(this.first == null) {
            this.first = newNode;
            this.size++;
            return;
        }
        Node<T> currentNode = this.first;
        while(currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        newNode.setPrev(currentNode);
        currentNode.setNext(newNode);
        this.size++;
    }

    @Override
    public void addAt(T value, int index) {

        if (index > this.length()) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            this.addFirst(value);
        }
        if ( index < 0){
            throw new IndexOutOfBoundsException("index must be positive");
        }

        Node<T> currentNode = this.first;
        while(currentNode != null && index > 0) {
            prev = currentNode;
            currentNode = currentNode.getNext();
            index--;
        }
        Node<T> nodeAdded = new Node<T>(value);
        nodeAdded.setNext(currentNode);
        prev.setNext(nodeAdded);
        this.size++;
    }

    @Override
    public T getValueAtIndex(int index) {

        Node<T> currentNode = this.first;
        int indexCount = 0;

        if (isEmpty()){
            throw new RuntimeException("list is empty");
        }
        while (indexCount != index && currentNode.getNext() != null){
            currentNode = currentNode.getNext();
        }
        return currentNode.getValue();
    }

    @Override
    public int getIndex(T value) {

        int nodeIndex = 0;
        Node<T> currentNode = this.first;

        if (isEmpty()){
            throw new IllegalArgumentException("List is empty");
        }
        while(currentNode.getValue() != value){
            currentNode = currentNode.getNext();
            nodeIndex ++;
        }
        return nodeIndex;
    }

    private Node<T> getNodeAtIndex(int index){

        Node<T> currentNode = this.first;
        int indexCounter = 0;

        while (indexCounter < index && currentNode.getNext() != null){
            currentNode = currentNode.getNext();
            indexCounter++;
        }
        return currentNode;
    }

    @Override
    public void switchPositions(int index1, int index2) {

        T valueReference = getValueAtIndex(index1);

        if (index1 > this.size || index2 > this.size){
            throw new RuntimeException("Some index exceed the length");
        }
        if (index1 == index2) {
            throw new IllegalArgumentException("Indexes must be different");
        }
        getNodeAtIndex(index1).setValue(getValueAtIndex(index2));
        getNodeAtIndex(index2).setValue(valueReference);
    }

    @Override
    public void remove(T value) {

        Node<T> currentNode = this.first;
        int valueIndex = getIndex(value);
        int indexCounter = 0;

        if (isEmpty()){
            throw new RuntimeException("List is empty");
        }
        if (valueIndex == 0 && valueIndex < this.size){
            this.first = currentNode.getNext();
            this.size--;
            return;
        }
        while (indexCounter < valueIndex - 1){
            currentNode = currentNode.getNext();
            indexCounter++;
        }
        if (indexCounter == this.size - 2){
            currentNode.setNext(null);
            this.size--;
            return;
        }
        else{
            currentNode.getNext().getNext().setPrev(currentNode);
            currentNode.setNext(currentNode.getNext().getNext());
            this.size--;
            return;
        }

    }

    @Override
    public void clear() {

        this.first = null;
        this.size = 0 ;
    }

    @Override
    public int length() {
        return this.size;
    }

    @Override
    public void printList() {
        Node<T> temp = this.first;
        System.out.println("Elements: ");

        while(temp != null){
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }

    @Override
    public Boolean isEmpty() {

        return this.first == null;
    }
}
