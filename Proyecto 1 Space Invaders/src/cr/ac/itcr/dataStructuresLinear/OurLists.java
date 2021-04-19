package cr.ac.itcr.dataStructuresLinear;

public interface OurLists<T> {

    void addFirst(T value);
    void addLast(T value);
    void addAt(T value, int index);
    int getIndex(T value);
    T getValueAtIndex(int index);
    void switchPositions(int index1, int index2);
    void remove(T value);
    void clear();
    void printList();
    Boolean isEmpty();
    int length();



}
