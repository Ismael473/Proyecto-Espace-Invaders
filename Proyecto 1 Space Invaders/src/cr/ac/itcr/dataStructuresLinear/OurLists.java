package cr.ac.itcr.dataStructuresLinear;
/*
    - kleader gutierrez

    T - tipo de dato con el que se implementaran los metodos
 */
public interface OurLists<T> {

    void addFirst(T value);
    void addLast(T value);
    void addAt(T value, int index);
    void switchPositions(int index1, int index2);
    void remove(int index);
    int length();
    int getIndex(T value);
    String printList();
    Boolean isEmpty();
    T getLastElement();

}
