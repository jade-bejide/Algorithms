import java.util.List;

public class BinaryTree<T> extends KaryTrees<T> {
    
    public BinaryTree(Node<T> root) {
        super(root);
    }

    public void addChild(Node<T> parent, Node<T> child) {
        if (!nodeInTree(parent)) throw new IllegalArgumentException("Node not in tree!");

        if (parent.getChildren().size() < 2) parent.addChild(child);
        else throw new IllegalArgumentException("Max node capacity reached!");
    }

    public boolean nodeInTree(Node<T> node) {
        //use tree traversal algorithm to find tree
        return true;
    }
}
