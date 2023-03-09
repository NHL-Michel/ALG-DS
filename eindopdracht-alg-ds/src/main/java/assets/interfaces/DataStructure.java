package assets.interfaces;

public interface DataStructure <S> {
    void build();
    boolean search(S searchterm);
    void sort(String type);

}

