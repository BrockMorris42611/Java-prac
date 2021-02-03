public class Leaf<T extends Comparable<T>> {
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
