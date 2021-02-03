public class Node<T> {

    public T data;
    public Node<T> node;

    public Node(T data, Node<T> node){
        this.data = data;
        this.node = node;
    }
    public Node(T data){
        this(data, null);
    }
    public Node(){
        this( null, null);
    }
    public void setData(T data) {
        this.data = data;
    }
    public void setNode(Node<T> node) {
        this.node = node;
    }
    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", node=" + node +
                '}';
    }
    public static void main(String[] args){
        Node<Integer> test_node = new Node(1);
        System.out.println(test_node.toString());
    }
}
