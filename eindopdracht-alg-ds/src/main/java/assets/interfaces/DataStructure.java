package assets.interfaces;

/**
 * Interface that is implemented on the Binarytree, doublylinkedlist and linkedlist
 * @param <S> generic searchterm
 */
public interface DataStructure<S> {
    void build();

    boolean search(S searchterm);

    void sort(String type);

}