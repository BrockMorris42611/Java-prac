//import java.util.Iterator;
//import java.util.NoSuchElementException;

public class Queue<T>{
	
	LL<T> theQueue;
	ListElement<T> first;
	ListElement<T> last;
	
	
	private int numItems;         	// number of elements on queue
    
    public Queue() {
        theQueue = new LL<T>();
        first = null;
        last = null;
    }
    
    public boolean isEmpty() {
        return this.theQueue.isEmpty();// returns true if empty
    }

    public void enqueue(T newItem) {
    	
    	if(isEmpty()) {
    		theQueue.insertAtHead(newItem);
    	} else {
    		theQueue.insertAtTail(newItem);
    	}
    	numItems++;
    	
    }
    
    public T dequeue() {
    	
    	numItems--;
    	return this.theQueue.removeFromHead();
    	
    }
    
    public T peek() { // gets front value
    	T temp = this.dequeue();
    	this.theQueue.insertAtHead(temp);
    	return temp;
    	
    }
    
}
    