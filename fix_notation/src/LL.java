public class LL<T>
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

  public String toString(ListElement h, String first)
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
  public R getValue()
  {
    return this.value;
  }

  public String toString()
  {
    return "Value = " + this.getValue();
  }
}

/*

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


public static void main(String args[])
  {
    LL<Integer> myLL = new LL<Integer>();

    System.out.println(myLL); 
    for (int i = 0; i < 10; i++)
    {
      myLL.insertAtTail(i);
    }

    System.out.println(myLL);
  }
  
  public boolean isEmpty()
  {
    return this.head.link == null;
  }
*/