
public class BST<T extends Comparable<T>> {

    int depth; // gotta know how many levels we working with
    Leaf<T> root; // aka the first circle or "node"

    public BST(){
        root = null;
        depth = 0; //we dont count root as a level
    }
    public boolean isEmpty(){
        return this.root == null;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void insert(T data){
        this.root = insert(data, this.root);
    }
    public Leaf<T> insert(T data, Leaf<T> node) {

        if(node == null){
             return new Leaf<>(data); // this is a recursive traversal of the tree. we check each lvl and she if it is greater than the right node then go right and vice with left
        }
        if(data.compareTo(node.data) > 0){
            node.rightNode = insert(data, node.rightNode); // go right
        }else if(data.compareTo(node.data) < 0){
            node.leftNode = insert(data, node.leftNode); // go left
        }else if(data.compareTo(node.data) == 0){
            node.multiples++; // here we dont want to add to the tree as that would mess up the flow to have the same number so we simply keep track of how mant there are
        }
        return node; // set that node
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void inOrderTrav(){
        inOrderTrav(root);
    }  //this is a more slim way of doiing it so that we dont need to put in our root bc it is called in the next method of the same name
    public void inOrderTrav(Leaf<T> node){
        if(node != null){
            inOrderTrav(node.rightNode);
            System.out.println(node.data);
            inOrderTrav(node.leftNode);
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Leaf<T> find(T data) {
        return find(data, root);
    }
    public Leaf<T> find(T data, Leaf<T> leaf) {

        if(leaf == null)
            return null;
        else if(data.compareTo(leaf.data) > 0) //checck left and right like insert and make sure we are going the right way to find the number
            return find(data, leaf.rightNode);
        else if(data.compareTo(leaf.data) < 0)
            return find(data, leaf.leftNode);
        else
            return leaf; //if it isnt smaller or larger...
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public T delete(T data){                 //UNFINISHED BC I WAS LAZY BUT REALLY INTERESTING DOCUMENTATION ONLINE( the left most node on the right side of the tree)
        Leaf<T> target = this.find(data);
        T retval = target.data;
        //System.out.println(retval);
//        target.data = target.rightNode.data;
//        target.rightNode = target.rightNode.rightNode;
       if(target.leftNode == null && target.rightNode == null) {
           System.out.println("HI");
       }else if(target.leftNode == null){
           target = target.rightNode;
           target.rightNode = null;
       }else if(target.rightNode == null){
           target = target.leftNode;
           target.leftNode = null;
       }else{
           target.data = min(target).data;
       }

        return retval;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Leaf<T> min(){
        return min(root);
    }
    public Leaf<T> min(Leaf<T> node){ //GO ALL THE WAY LEFT
        if(this.isEmpty())
            return null;

        Leaf <T> temp = node;

        while(temp != null){
            if(temp.leftNode.leftNode == null)
                return temp.leftNode;
            temp = temp.leftNode;
        }
        return null;
    }
        public T delMin(){
        if(this.isEmpty())
            return null;


        Leaf <T> temp = root;
        T hold = null;
        while(temp != null){
            if(temp.leftNode.leftNode == null){
                hold = temp.leftNode.data;
                temp.leftNode = null;
                return hold;
            }
            temp = temp.leftNode;
        }
        return null;
    }
    public Leaf<T> max(){ // GO ALL THE WAY RIGHT

        if(this.isEmpty())
            return null;

        Leaf <T> temp = root;

        while(temp != null){
            if(temp.rightNode == null)
                return temp;
            temp = temp.rightNode;
        }
        return null;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String args[]){

        BST<Integer> tree = new BST<>();

        tree.insert(50);tree.insert(20);tree.insert(30);tree.insert(10);tree.insert(80);tree.insert(60);tree.insert(70);tree.insert(61);tree.insert(71);
        tree.inOrderTrav();
        //tree.delete(71);
        System.out.println();
        tree.inOrderTrav();


    }
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

class Leaf<T extends Comparable<T>> {
    public T data;
    public Leaf<T> rightNode;
    public Leaf<T> leftNode;
    public int multiples;

    public Leaf(T data, Leaf<T> leftNode, Leaf<T> rightNode){
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        multiples = 1;
    }
    public Leaf(T data){
        this(data, null, null);
    }
    public Leaf(){
        this(null,null, null);
    }
}