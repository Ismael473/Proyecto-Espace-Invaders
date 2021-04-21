package cr.ac.itcr.dataStructuresLinear;
/**
 * Este metodo de implementar las lista es por subtipos
 * es decir, los ucuatro tipos de clases son un tipo de
 * ourList por tanto satisfacen las mismas necesidades
 * que Ourlist tiene definidas
 * @param <T> data type
 */
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
