/**
 * This Binary Search Tree can be used to quickly find data in a large list of related data, as
 * well as delete data or insert more data into the list.
 *
 * @param <T> Any data the user wishes to populate the search tree with.
 */

public class BinarySearchTree<T extends Comparable<T>> {
    /**
     * The root node represents the center value of the tree. It may become unbalanced over time,
     * at which point the tree needs rebalanced which will change which node represents the root
     * of the tree.
     */
    protected Node<T> root;

    /**
     * Constructor for the Binary Search Tree. The root node is initialized as null,
     * as there is no initial data when the tree is created.
     */
    public BinarySearchTree(){
        this.root = null;
    }

    /**
     * Kick-off method for more in depth insert. The root should only change if the data is inserted
     * as a branch of the root, or if there was no root to begin with.
     *
     * @param data Data to be inserted into the Binary Search Tree.
     * @return The root Node.
     */
    public Node<T> insert(T data){
        this.root = this.insert(this.root, data);
        return this.root;
    }

    /**
     * The insert method will insert specified data into the list. First checking to ensure that the
     * current node is not null, and in the case that it is, fulling the null spot with a node filled
     * with the specified data. If the current node is not null, the method will compare the data with
     * the data in the current node. If it is smaller, the current node's left pointer will be assigned
     * to the outcome of a recursive insert method, with it's left node and the inserted data as the
     * inputs of the method. This is just to find where the data should be inserted, as once the method
     * returns a node, it will either be the node that was already in that location, or the node that
     * should be inserted in that location anyway. The same process applies to the right node if the data
     * is larger than the data in the current node.
     *
     * @param current Initially the root Node, but on recursion, this becomes the next node while
     *                searching for where the inserted data should be placed.
     * @param data Data to be inserted into the Binary Search Tree.
     * @return The current Node, or a New node if current is null.
     */
    private Node<T> insert(Node<T> current, T data){
        /*
        Check if the current node is null. If it is, return a new node with the data to be inserted.
         */
        if(current == null){
            return new Node(data);
        }

        /*
        Compare the current node's data with the data to be inserted. Move left if it is smaller, and
        right if it is larger.
         */
        if(data.compareTo(current.data) < 0){
            current.left = this.insert(current.left, data);
        }else if(data.compareTo(current.data) > 0){
            current.right = this.insert(current.right, data);
        }

        /*
        If the data is equal to the found node, return the existing node, as the data does not need
        to be inserted.
         */
        return current;
    }

    /**
     * Kick-off method for more in depth delete.
     *
     * @param data The data to be deleted from the Binary Search Tree.
     * @return The deleted Node, or null if the data does not exist.
     */
    public Node<T> delete(T data){
        Node<T> deletedNode = delete(this.root, data);
        return deletedNode;
    }

    /**
     * The delete method will delete the specified data from the Binary Search Tree, assuming it exists.
     * First, the data will be compared to the root (or current on recursion) node.
     * If it is equal to the root data, it will need to be replaced similar to any node below, but
     * keeping in mind that if it is being replaced, the replacement will be root.
     * Assuming it is not in the root (current) node, it will be redirected either left or right,
     * depending on if it is smaller or larger, respectively. Before changing the current node to the
     * left or right, it will first be compared to that data to make sure it doesn't match that data.
     * If it does, it will be checked for children. There are three possible cases from there.
     * 1. If it has no children, the pointer to this node can just be set to null.
     * 2. If it has a single child, then the pointer can be set to the deleted node's child.
     * 3. If the node has two children, the deleted node will be replaced by the node that is the
     * furthest left in the right tree. This means that it will be the smallest value in the larger
     * subtree.
     *
     * @param current Initially the root Node, but on recursion, this becomes the next node while
     *                searching for where the data to be deleted is located.
     * @param data The data to be deleted from the Binary Search Tree.
     * @return The parent Node of the Node with the data to be deleted.
     */
    private Node<T> delete(Node<T> current, T data){
        /*
        First, we check to make sure there is data in the list. This is the
         */
        if(current == null){
            return null;
        }

        if(data.compareTo(current.data) < 0){
            current.left = delete(current.left, data);
        } else if (data.compareTo(current.data) > 0){
            current.right = delete(current.right, data);
        } else {
            if(current.left == null || current.right == null){
                Node<T> temp;
                temp = current.left == null ? current.right : current.left;
                return temp;
            } else {
                Node<T> successor = getSuccessor(current);
                current.data = successor.data;
                current.right = delete(current.right, successor.data);
                return current;
            }
        }

        return current;
    }

    public Node<T> getSuccessor(Node<T> current){
        if(current == null){
            return null;
        }
        Node<T> temp = current.right;

        while(temp.left != null){
            temp = temp.left;
        }

        return temp;
    }

    public boolean contains(T data){
        //find the node, if you don't find it, then it doesn't exist

        //return true if you find it

        //return false if you hit a null
        return false;
    }

    public String inOrderTraversal(){
        return this.inOrderTraversal(this.root);
    }

    public String inOrderTraversal(Node<T> current){
        StringBuilder stringBuilder = new StringBuilder();

        //check if we have anything to add to the string (if the current is null)
        if(current != null){
            //go left first because this is inorder
            stringBuilder.append(this.inOrderTraversal(current.left));

            //now print the current node
            stringBuilder.append(current.data);
            stringBuilder.append(" ");

            //go right last because inorder
            stringBuilder.append(this.inOrderTraversal(current.right));
        }

        //return the toString of the builder
        return stringBuilder.toString();
    }
}