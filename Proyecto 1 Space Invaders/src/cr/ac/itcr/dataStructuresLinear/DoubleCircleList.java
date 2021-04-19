package cr.ac.itcr.dataStructuresLinear;

public class DoubleCircleList<T> implements OurLists<T> {

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
        }
        newNode.setNext(this.last.getNext());
        newNode.setPrev(this.last);
        this.last.setNext(newNode);
        this.size++;
    }

    @Override
    public void addLast(T value) {

    }

    @Override
    public void addAt(T value, int index) {

    }

    @Override
    public int getIndex(T value) {
        return 0;
    }

    @Override
    public T getValueAtIndex(int index) {
        return null;
    }

    @Override
    public void switchPositions(int index1, int index2) {

    }

    @Override
    public void remove(T value) {

        Node<T> currentNode = this.last;

        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        if (size == 1 && value == this.last.getValue()) {
            this.last = null;
            this.size = 0;
        }
        while (currentNode.getNext().getValue() != value && currentNode.getNext() != this.last ) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(this.last.getNext().getNext());
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

        while (!isEmpty() && temp.getNext() != this.last){
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
        System.out.println(temp.getValue());
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
