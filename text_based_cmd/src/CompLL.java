
public class CompLL<T extends Comparable<T>>
{
    private ListElement<T> head;
    private ListElement<T> tail;

    public CompLL()
    {
        this.head = new ListElement<T>(); // add dummy "first" element
        this.tail = this.head;
    }

    public void insertAtHead(T value)
    {
        this.head.link = new ListElement<T>(value, this.head.link);
    }

    public T removeFromHead()
    {
        T retval = null;

        if (this.isEmpty())
        {
            return null;
        }
        retval = this.head.link.value;
        this.head.link = this.head.link.link;
        return retval;
    }

    public void remove(T ind){
        ListElement<T> where = this.head.link;
        while (where != null)
        {
            if(where.value == ind) {
                where.value = where.link.value;
                where.link = where.link.link;
            }
            where = where.link.link;
        }
    }

    public void insertAtTail(T value)
    {
        this.tail.link = new ListElement<T>(value);
        this.tail = this.tail.link;
    }

    public String toString()
    {
        String retval = "";
        ListElement<T> where = this.head.link;
        if (where == null)
        {
            retval += "Empty\n";
        }
        else
        {
            while (where != null)
            {
                retval += where.value + "\n";
                where = where.link;
            }
        }
        return retval;
    }

    public T getAtInd(int index) {
        if (index < 0 && index > this.size()) {
            return null;
        }

        ListElement<T> where = this.head.link;
        int i = 0;
        while (i != index) {
            where = where.link;
            i++;
        }
        T toReturn = where.value;

        return toReturn;
    }
    public int size() {
        ListElement<T> where = this.head.link;
        int size = 0;
        while(where != null) {
            size++;
            where = where.link;
        }
        return size;
    }
    /*public T find(T ln)
    {
        ListElement<T> where = this.head.link;
        while (where != null)
        {
            if(where.value == ln) {
                return where.value;
            }
            where = where.link;
        }
        return null;
    }*/

    public void insertInOrder(T value)
    {
        head.link = insertInOrder(value, head.link);
    }

    public ListElement<T> insertInOrder(T value, ListElement<T> h)
    {
        ListElement<T> retval = null;
        if (h == null || value.compareTo(h.value) < 0)
        {
            h = new ListElement<T>(value, h);
            retval = h;
        }
        else
        {
            h.link =  insertInOrder(value, h.link);
            retval =  h;
        }
        //System.out.println(this.toString());
        return retval;
    }
    public boolean isEmpty()
    {
        return this.head.link == null;
    }
    public static void main(String args[])
    {
        CompLL<Integer> cll = new CompLL<Integer>();
        CompLL<TextLine> tl = new CompLL<TextLine>();

        tl.insertInOrder(new TextLine("12 Fucker"));
        cll.insertInOrder(21);
        cll.insertInOrder(2);
        cll.insertInOrder(1);
        cll.insertInOrder(13);
        cll.insertInOrder(-7);
        cll.insertInOrder(33);
        cll.insertInOrder(4);
        cll.insertInOrder(15);
        cll.insertInOrder(12);
        System.out.println("SIZE: " + cll.size());
        System.out.println(cll.toString());
        System.out.println(tl.toString());
        System.out.println(">>>> " + cll.getAtInd(2).toString());
        cll.remove(2);
        System.out.println(cll.toString());
        System.out.println("NEW SIZE: " + cll.size());
    }
}