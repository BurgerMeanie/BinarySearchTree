public class Node <T>{
    Node<T> left;
    Node<T> right;
    T data;

    public Node(T data){
        this.left = null;
        this.right = null;
        this.data = data;
    }
}