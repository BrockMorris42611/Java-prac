public class LinkedList<T extends Comparable<T>> {
    public Node<T> head;
    public Node<T> tail;
    public LinkedList(){
        this.head = new Node<T>();
        this.tail = this.head;
    }
    public void printList(){
        Node<T> temp = head.node;//dont want to print the first dummy node.
        while(temp != null){ // go till we find a null and then end
            System.out.println(temp.data);
            temp = temp.node;
        }
    }
    public void insertTail(T data){
        this.tail.node = new Node<T>(data);// since wea re given a tail go to it and add to it hen make the addition the new tail
        this.tail = this.tail.node;
    }
    public Node<T> removeFromTail(){

        if(this.isEmpty())
            return null;

        Node<T> temp = this.head; int i = 1;
        Node<T> ret = null;

        while(temp.node != null){
            if(i == this.size()){
                ret = temp.node;
                temp.node = null;
                return ret;
            }
            temp = temp.node;
            i++;
        }
        return null;
    }
    public void insertHead(T data){
        this.head.node = new Node<T>(data, this.head.node);
    }
    public Node<T> removeFromHead(){
        if(this.isEmpty())
            return null;
        Node<T> ret = head.node;
        head.node = head.node.node;
        return ret;
    }
    public void insertInOrder(T data){
        head.node = insertInOrder(data, head.node);
    }
    public Node<T> insertInOrder(T data, Node<T> elem){
        Node<T> temp = null;

        if(elem == null || elem.data.compareTo(data) > 0){
            elem = new Node<T>(data, elem);
            temp = elem;
        }else{
            elem.node = insertInOrder(data, elem.node);
            temp = elem;
        }
        return temp;
    }
    public int loc(T toRem){
        Node<T> temp = this.head.node;
        for(int i = 0; i < this.size(); i++){
            if(temp.data.compareTo(toRem) == 0) {
                return i;
            }else{
                temp = temp.node;
            }
        }
        return 0;
    }
    public Node<T> remove(T toRem){
        Node<T> temp = head.node, ret = null;
        int i = 0, loc = this.loc(toRem);

        if(this.loc(toRem) == this.size()-1)
            return this.removeFromTail();

        while(i < this.loc(toRem)){
            if(i == loc-1 && temp.node.node != null ){
                ret = temp.node;
                temp.node = temp.node.node;
                return ret;
            }else{
                temp = temp.node;
            }
        }
        return null;
    }
    public int size(){
        if(this.isEmpty())
            return 0;
        int counter = 1;
        Node<T> temp = head.node;
        while(temp.node != null){
            counter++;
            temp = temp.node;
        }
        return counter;
    }
    boolean isEmpty(){
        return this.head.node == null;
    }

    public static void main(String[] args) throws Exception{

        LinkedList<Integer> list = new LinkedList<>();

        System.out.println("SIZE " + list.size());
        list.insertInOrder(3);
        list.insertInOrder(57);
        list.insertInOrder(107);
        list.insertInOrder(2);
        list.printList();
        System.out.println("SIZE " + list.size());
        Node<Integer> takenOut = list.removeFromHead();
        list.printList();
        System.out.println("SIZE " + list.size());
        System.out.println("loc: " + list.loc(57));
        list.remove(107);
        list.printList();
    }
}
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
