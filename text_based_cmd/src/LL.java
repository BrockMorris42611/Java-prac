public class LL<T> extends ListElement<T>
{
    private ListElement<T> head;
    private ListElement<T> tail;

    public LL()
    {
        this.head = new ListElement<T>(); // add dummy "first" element
        this.tail = this.head;
    }

    public void insertAtHead(T value)
    {
        this.head.link = new ListElement<T>(value, this.head.link);
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

    public void insertAtTail(T value)
    {
        this.tail.link = new ListElement<T>(value);
        this.tail = this.tail.link;
    }

    public String toString()
    {

        String retval = "";
        retval +=  toString(head.link, retval);
        return retval;
    }

    public String toString(ListElement<T> h, String first)
    {
        if(h == null)
            return first + "\n";
        else
        {
            return first + h.value + "\n" + toString(h.link, first);
        }
    }
/*
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
*/

    public static void main(String args[])
    {
        LL<Integer> myLL = new LL<Integer>();

        System.out.println(myLL);
        for (int i = 0; i < 10; i++)
        {
            myLL.insertAtTail(i);
        }
        //for(int i = 0; i < myLL.size(); i++)
            //System.out.println(myLL.getAtInd(i).toString());
        ListElement a = new ListElement("HI");
        ListElement b = new ListElement("BYE");
        ListElement c = new ListElement("GUY", a);
        System.out.println("a>" + a.toString());
        System.out.println("c>" + c.toString());
    }

    public boolean isEmpty()
    {
        return this.head.link == null;
    }
}

class ListElement<R>
{
    public R value;
    public ListElement<R> link;

    public ListElement(R v, ListElement<R> link)
    {
        this.value = v;
        this.link = link;
    }

    public ListElement(R v)
    {
        this(v, null);
    }

    public ListElement()
    {
        this(null, null);
    }

    public void setValue(R v)
    {
        this.value = v;
    }

    public void setLink(ListElement<R> link)
    {
        this.link = link;
    }

    public R getValue()
    {
        return this.value;
    }

    public ListElement<R> getLink()
    {
        return this.link;
    }

    public String toString()
    {
        return "Value = " + this.getValue() + "\nLink = " + this.getLink();
    }
}

