package cr.ac.itcr.dataStructuresLinear;

public class SimpleLinkedList<T> implements OurLists<T> {

    private Node<T> first = null;
    private int size = 0;

    @Override
    public void addFirst(T value) {

        if(isEmpty()){
            this.first = new Node<T>(value);
        }
        else{
            this.first = new Node<T>(value, this.first);
        }
        this.size++;
    }

    @Override
    public void addLast(T value) {

        if (isEmpty()){
            this.first = new Node<T>(value);
        }
        else{
            Node<T> currentNode = this.first;
            while(currentNode.getNext() != null){
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(new Node<T>(value));
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
        if ( index < 0){
            throw new IndexOutOfBoundsException("index must be positive");
        }
        Node<T> prev = null;
        Node<T> currentNode = this.first;
        while(currentNode != null && index > 0){
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

    @Override
    public void remove(T value) {

        Node<T> currentNode = this.first;

        if (isEmpty()) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        while (currentNode.getNext().getValue() != value && currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(currentNode.getNext().getNext());
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

        while(temp != null){
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }

    @Override
    public T getValueAtIndex(int index) {

        Node<T> currentNode = this.first;
        int indexCount = 0;

        while (indexCount != index){
            currentNode = currentNode.getNext();
        }
        return currentNode.getValue();
    }

    @Override
    public int length(){

        return this.size;
    }

    @Override
    public Boolean isEmpty(){

        return this.first == null;
    }

    @Override
    public void switchPositions(int index1, int index2) {}

}
