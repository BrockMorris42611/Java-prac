public class Queue<T extends Comparable<T>> extends LinkedList{



    //I AM IMPLEMENTING THE QUEUE AND STACK AS LINKED LISTS SO IT DOESNT NEED TO BE THAT HARD
    // FUCK STACK POINTERS AND SIZE TRACKING LMFAO


    public LinkedList<T> Q;
    public Queue(){
        Q = new LinkedList<>();
    }
    public boolean isEmpty(){
        return this.Q.isEmpty();
    }
    public void enqueue(T newItem) {
        if(this.isEmpty())
            this.Q.insertHead(newItem);
        else
            this.Q.insertTail(newItem);
    }
    public T dequeue() { return this.Q.removeFromHead().data; }

    public T peek() { // gets front value
        T temp = dequeue();
        this.Q.insertHead(temp);
        return temp;
    }
    public void printQ(){
        Node<T> temp = this.Q.head.node;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.node;
        }
    }
    public static void main(String args[]){
        Queue<String> playlist = new Queue<>();

        System.out.println(playlist.isEmpty());
        playlist.enqueue("Hello");
        System.out.println(playlist.isEmpty());
        playlist.dequeue();
        System.out.println(playlist.isEmpty());

        playlist.enqueue("Hello");
        playlist.printQ();

        playlist.enqueue("Bye");
        playlist.printQ();

    }
}
