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
            Node<T> temp = this.first;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new Node<T>(value);
        }
        this.size++;
    }

    @Override
    public void addAt(T value, int index) {

        if (index > this.length()) {
            throw new IndexOutOfBoundsException();
        }
        else if (index == 0){
            this.addFirst(value);
        }
        else {
            Node<T> temp = this.first;
            int currentIndex = 0;

            while(currentIndex != index - 1){
                temp = temp.next;
                currentIndex++;
            }
            temp.next.next = temp.next;
            temp.next.setNext(new Node<T>(value));
            this.size++;
        }
    }

    @Override
    public void switchPositions(int index1, int index2) {

    }

    @Override
    public int getIndex(T value) {

        int nodeIndex = 0;
        Node<T> temp = this.first;

        if (temp.getValue() == value){
            return nodeIndex;
        }
        else{
            while(temp.getValue() != value){
                temp = temp.next;
                nodeIndex ++;
            }
            return nodeIndex;
        }
    }


    @Override
    public T getLastElement() {

        Node<T> temp = this.first;

        while (temp.next != null){
            temp = temp.next;
        }
        return temp.getValue();
    }

    @Override
    public void remove(int index) {

        Node<T> temp = this.first;

        while(temp.next != null && index > 0){
            temp = temp.next;
            index--;
        }
        temp.next = null;
        this.size--;
    }

    @Override
    public String printList() {
        return null;
    }

    @Override
    public int length(){
        return this.size;
    }

    @Override
    public Boolean isEmpty(){

        return this.first == null;
    }
}
