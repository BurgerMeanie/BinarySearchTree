public class Node <T>{
    Node<T> left;
    Node<T> right;
    Node<T> parent;
    T data;

    public Node(T data){
        this.left = null;
        this.right = null;
        this.parent = null;
        this.data = data;
    }
}