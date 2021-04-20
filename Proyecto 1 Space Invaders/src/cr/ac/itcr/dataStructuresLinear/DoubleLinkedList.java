package cr.ac.itcr.dataStructuresLinear;
/**
 *
 * @param <T> Data type
 *
 * @author kleader gutierrez pineda
 */
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
        Node<T> temp = this.first;
        while(temp.getNext() != null) {
            temp = temp.getNext();
        }
        newNode.setPrev(temp);
        temp.setNext(newNode);
        this.size++;
    }

    @Override
    public void addAt(T value, int index) {

        if (index > this.size) {
            throw new IndexOutOfBoundsException("Index exceed the last index");
        }
        if (isEmpty() ) {
            this.addFirst(value);
        }
        if ( index < 0){
            throw new IndexOutOfBoundsException("index must be positive");
        }

        Node<T> temp = this.first;
        while(temp != null && index > 0) {
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
    public T getValueAtIndex(int index) {

        Node<T> temp = this.first;
        int indexCount = 0;

        if (isEmpty()){
            throw new RuntimeException("list is empty");
        }
        while (indexCount != index && temp.getNext() != null){
            temp = temp.getNext();
        }
        return temp.getValue();
    }

    @Override
    public int getIndex(T value) {

        int nodeIndex = 0;
        Node<T> temp = this.first;

        if (isEmpty()){
            throw new IllegalArgumentException("List is empty");
        }
        while(temp.getValue() != value){
            temp = temp.getNext();
            nodeIndex ++;
        }
        return nodeIndex;
    }

    private Node<T> getNodeAtIndex(int index){

        Node<T> temp = this.first;
        int indexCounter = 0;

        while (indexCounter < index && temp.getNext() != null){
            temp = temp.getNext();
            indexCounter++;
        }
        return temp;
    }

    @Override
    public void switchPositions(int index1, int index2) {

        T valueReference = getValueAtIndex(index1);
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
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

        Node<T> temp = this.first;
        int valueIndex = getIndex(value);
        int indexCounter = 0;

        if (isEmpty()){
            throw new RuntimeException("List is empty");
        }
        if (valueIndex == 0 && valueIndex < this.size){
            this.first = temp.getNext();
            this.size--;
            return;
        }
        while (indexCounter < valueIndex - 1){
            temp = temp.getNext();
            indexCounter++;
        }
        if (indexCounter == this.size - 2){
            temp.setNext(null);
            this.size--;
            return;
        }
        else{
            temp.getNext().getNext().setPrev(temp);
            temp.setNext(temp.getNext().getNext());
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
