
/**
 * This is the list class that extends the LinkedListException
 * this class also has a node class. The list class has operations
 * to remove, append, insert, delete and to find if it is empty.
 *
 * @author Iakjot Kaur 
 * @version May 19th, 2020
 */
public class List extends LinkedListException
{   
    protected Node head;
    public class Node{
        // instance variables
        private Node link;
        private Object ob;

        /**
         * This constructor initalizes the object.
         * 
         * the link is null and the object passed in is initalized.
         *
         *PRE: object
         *POST: initalization
         * @param: object
         * *return: none
         */
        public Node(Object obNew){
            this.link = null;
            this.ob = obNew;
        }

        /**
         * This constructor is to initalize the object and node.
         * 
         * the instance variables are intialized to the new parameters.
         *
         *PRE: object and node
         *POST: initialies
         * @param: object, node
         * *return: node
         */
        public Node(Object theNew, Node theNext){
            this.ob = theNew;
            this.link = theNext;
        }

        /**
         * This method is to get the object.
         * 
         * I returned the instance variable of the object.
         *
         *PRE: have an object
         *POST: returns the object
         * @param: none
         * *return: object
         */
        public Object getOb(){
            return this.ob;
        }

        /**
         * This method is to get the link.
         * 
         * I returned the instance variable of the node.
         *
         *PRE: have a node
         *POST: returns the link
         * @param: none
         * *return: node
         */
        public Node getLink(){
            return this.link;
        }

        /**
         * This method is to set the link of the node.
         * 
         * I initialzed the instance variable to the parameter passed in.
         *
         *PRE: node
         *POST: sets the link 
         * @param: node
         * *return: none
         */
        public void setLink(Node nextItem){
            this.link = nextItem;
        }
    }

    Node h = null;
    /**
     * This method is to insert the object with a certain index.
     * 
     * I made sure the invarients were followed and made a new node
     * and stored the passed in one and used it to make a new node.
     *
     *PRE: have an object and index
     *POST: inserts the object at a certain index
     * @param: object, int
     * *return: none
     */
    public void insert(Object next, int index) throws LinkedListException{
         if(next == null){
            throw new LinkedListException("Error, can't be null");
        }
        Node node = new Node(next);
        if(index < 0 || index > size()){
            throw new LinkedListException("Error, index out of bounds");
        }
        if(isEmpty()){
            head = new Node(next);
        }
        if(index == 0){
            head = new Node(next,head);
        }
        if(size() ==1 ){
            head = new Node(next, head);
        }
        Node temp = head;
        Node previous = null;
        while(index >0){
            previous = temp;
            temp = temp.link; 
            index--;
        }
        previous.link = node;
        node.link = temp;
        

    }

    /**
     * This method is to add the object to the end.
     * 
     * I made sure the invarients are followed and then made a 
     * temp node and then added it to the end of the list, if it was available.
     *
     *PRE: object to add
     *POST: adds the the object
     * @param: object
     * *return: none
     */
    public void append(Object next)throws LinkedListException{
        if(isEmpty()){
            head = new Node(next);
        }
        if(next == null){
            throw new LinkedListException("Error");
        }
        else{
            Node current = head;
            while(current.link !=null){
                current = current.link;
            }
            current.link = new Node(next);
        }
    }

    /**
     * This method is to remove the object according to the index.
     * 
     * I made the current object null and used it to store it to the 
     * next one, and I made sure all the invarients are followed,
     * if yes, then I i removed the object according to the index
     * being passed and then returned it.
     *
     *PRE: index of what you want to remove
     *POST: removes object based on the index
     * @param: index
     * *return: Object
     */
    public Object remove(int index)throws LinkedListException{
        Object current = null;
        if(isEmpty()){
            throw new LinkedListException("empty list cannot be deleted");
        }
        else if(index ==0 || size() ==1){
            current = head.ob;
            head = head.link;
        }
        else{
            if(index > size()){
                throw new LinkedListException("index can't be larger than size");
            }
            if(index < 0){
                throw new LinkedListException("index can't be less than zero");
            }

            Node currentNode = head;
            for(int i=0; i < index-1; i++){
                currentNode = currentNode.link;
            }
            current = currentNode.link.ob;
            currentNode.link = currentNode.link.link;
        }
        return current;
    }

    /**
     * This method is to get the size of the list.
     * 
     * I started with the head and then went through it while it's not null
     * and counted it with a counter.
     *
     *PRE: list
     *POST: returns the size of the list
     * @param: none
     * *return: int
     */
    public int size(){
        int counter = 0;
        Node current = head;
        while(current!= null){
            current = current.link;
            counter++;
        }
        return counter;
    }

    /**
     * This method is to get the index of the object you want.
     * 
     * I started with the head and then if the head was the target, i returned
     * that and if not, I made sure if it's not the right number I kept going
     * and returned the right number.
     *
     *PRE: object you want to remove
     *POST: removes the object you want to remove
     * @param: object
     * *return: int
     */
    public int indexOf(Object target) throws LinkedListException{
        Node curr = head;
        int count = 0;
        if(curr == target){
            return count;
        }
        else{
            while(curr != target){
                count++;
                curr = curr.link; 
                if(curr.link == null){
                    throw new LinkedListException("Error");
                }
            }
            return count;
        }
    }

    /**
     * This method is to delete the object that you want based off of the index
     * 
     * I made sure the invairents were followed and then redirected the 
     * node to the next one.
     *
     *PRE: index
     *POST: deletes the object
     * @param: int
     * *return: none
     */
    public void delete(int index)throws LinkedListException{
        if(index > size()){
            throw new LinkedListException("Error");
        }
        if( index < 0){
            throw new LinkedListException("Error");
        }
        if(isEmpty()){
            head = null;
        }
        else if(size() ==1 || index ==0){
            head = head.link;
        }
        else{
            Node current = head;
            for(int i =0; i<index -1; i++){
                current = current.link;
                i++;
            }
            current.link = current.link.link;
        }
    }

    /**
     * This method is to print out the list.
     * 
     * I enumerated through my list and returned the list.
     *
     *PRE: none
     *POST: returns the list
     * @param: none
     * *return: String
     */
    public String toString(){
        String string = "";
        Node current = head;
        while(current!= null){
            string += current.ob + "\n";
            current = current.link;
        }
        return string;
    }

    /**
     * This method is to check if the list is empty.
     * 
     * if the head is empty then the entire list is, if not then 
     * it is not empty.
     *
     *PRE: none
     *POST: returns true or false based on if its empty or not
     * @param: none
     * *return: boolean
     */
    public boolean isEmpty(){
        if(head != null){
            return false;
        }
        else{
            return true;
        }
    }
    
      /**
     * This method is to test the methods in this class.
     * 
     *
     *PRE: none
     *POST: tests the methods
     * @param: none
     * *return: none
     */
    public static void main(String[] args) throws LinkedListException{
        List list = new List();

        list.append(20);
        list.append(5);
        list.append(60);
        System.out.println("the list: " + list);

        list.insert(22, 2);
        list.insert(50, 0);
        list.insert(11, 3);

        list.remove(2);
        System.out.println("removed at index 2: " + list);

        list.remove(0);
        System.out.println("removed at index 0: " + list);

        list.delete(3);
        System.out.println("deleted at index 3: " + list);

        System.out.println("Index of object 20: " + list.indexOf(20));
        System.out.println("the size of the list: " + list.size());

    }
    
}
