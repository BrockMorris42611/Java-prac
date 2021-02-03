import java.security.KeyException;


/*Create a class that implements a dictionary, associating text strings
with doubles.  It should use a hash table with the hash function
described in class. (Break the string into groups of two 8 bit characters.
Shift one of them 8 bits to the left and OR in the other.  Add all of these
together, throwing away the carry from the 16th bit.  Divide by a convenient
number which should be the table size and take the remainder.)
The class should have at least a constructor and methods to insert and retrieve.
More methods can be added as you need them later.*/

public class Dictionary
{
  private LL<Variable> theTable[];
  private int size;

  public Dictionary(int size)
  {
	this.size = size;
    theTable = new LL[size];
    for (int i = 0; i < size; i++)
    {
      theTable[i] = new LL<Variable>();
    }
  }

  public Dictionary()
  {
    this(100);
    this.size = 100;
  }

  public void insert(String s, double val)
  {
    int where = hash(s);

    for (int i = 0; i < size; i++) {
          for (int j = 0; j < theTable[i].size(); j++) {
              if(theTable[i].getAtInd(j).getName() == s){
                theTable[i].getAtInd(j).setValue(where);
              }
          }
      }
      theTable[where].insertAtHead(new Variable(s, val));
      //lookup first and change if it already exists, otherwise insert as above


      //int where = hash(s); theTable[where].insertAtHead(new Variable(s, val));
  }

  /*public double find(String s) throws KeyException {
    int where = hash(s);
    Variable value = theTable[where].find(s);
    if(value != null)
    {
      return value.getValue();
    }
    else
    {
      throw new KeyException("Key not found:" + s);
    }
  }*/

  private int hash(String s)
  {
    int sum = 0;
    for (int i = 0; i < s.length(); i++)
    {
      char c = s.charAt(i);
      sum = sum + (int)c & 0xff;
    }
    return sum % this.size;
  }
  public void main(String args[]){
    Dictionary dict = new Dictionary();

  }
}