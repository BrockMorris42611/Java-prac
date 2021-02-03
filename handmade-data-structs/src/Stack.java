public class Stack<T extends Comparable<T>> extends LinkedList {

    //I AM IMPLEMENTING THE QUEUE AND STACK AS LINKED LISTS SO IT DOESNT NEED TO BE THAT HARD
    // FUCK STACK POINTERS AND SIZE TRACKING LMFAO

    LinkedList<T> stack;
    public Stack(){
        stack = new Stack<>();
    }
    public boolean isEmpty(){
        return this.stack.isEmpty();
    }
    public void push(T newitem){
        this.stack.insertHead(newitem);
    }
    public T pop(){
        return this.stack.removeFromHead().data;
    }
    public T peek() { // gets front value
        T temp = pop();
        this.push(temp);
        return temp;
    }
}
