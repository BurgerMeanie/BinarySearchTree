public class BinarySearchTree<T extends Comparable<T>> {
    protected Node<T> root;

    public BinarySearchTree(){
        this.root = null;
    }

    /**
     * Inserts into the BST
     * @param data the thing to insert
     * @return the inserted node
     */
    public Node<T> insert(T data){
        this.root = this.insert(this.root, data);
        return this.root;
    }

    /**
     * Inserts into the BST
     * @param current the current node that the recursion is operating on
     * @param data the thing to insert
     * @return the inserted node
     */
    private Node<T> insert(Node<T> current, T data){
        //if the current is null, just set the current to the new node
        if(current == null){
            return new Node(data);
        }

        //compare the data to the current node to see which way to traverse
        if(data.compareTo(current.data) < 0){
            current.left = this.insert(current.left, data);
        }else if(data.compareTo(current.data) > 0){
            current.right = this.insert(current.right, data);
        }

        //if the data is already there, just return the existing node
        return current;
    }


    public Node<T> delete(Integer data){
        //kick off method

        //within the recursive method

        //find the location of the node that contains the data

        //is it the root(then you have to remember to reset the root)

        //is it a leaf node, then just delete it

        //does it only have one child, then reassign the parent pointer to the child

        /*
        does it have two children, then go left and then all the way right (this is the smallest
        value in the larger subtree)
         */

        //then replace the deleted node with that node you just found
        return null;
    }

    public Node<T> contains(T data){
        //find the node, if you don't find it, then it doesn't exist

        //return true if you find it

        //return false if you hit a null
        return null;
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
