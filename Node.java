import java.util.List;
import java.util.Optional;

public class Node<T> {
    private T value;
    private List<Node<T>> children;

    public  Node(T value, List<Node<T>> children) {
        this.value = value;
        this.children = children;
    }

    public T getValue() {
        return value;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public void addChild(Node<T> child) {
        children.add(child);
    }

    public void removeChild(Node<T> child) {
        children.remove(child);
    }

    public boolean isEquals(Node<T> node) {
        return this.equals(node);
    }

    public String toString() {
        return " ";
    }
}
