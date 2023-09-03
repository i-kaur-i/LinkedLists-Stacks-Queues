
/**
 * This is the linked list stack class that is inherited from list.
 * This class extends the list parent class while it overrides the
 * insert and remove method.
 *
 * @author Iakjot Kaur
 * @version May 19th, 2020
 */
public class Stack extends List
{
    /**
     * This method is to add to the top of the stack.
     * 
     * I made sure the object being passed in isn't null and then
     * added the new object into the node.
     *
     *PRE: have an object
     *POST: adds in the head
     * @param: none
     * *return: int
     */
    public void push(Object ob)throws LinkedListException{
        if(ob == null){
            throw new LinkedListException("Error");
        }
        head = new Node(ob, head);
    }
    
    /**
     * This method is to remove the object.
     * 
     * I checked if it's empty and then if it wasn't
     * I removed the current object.
     *
     *PRE: object to pop
     *POST: pops the object
     * @param: none
     * *return: Object
     */
    public Object pop() throws LinkedListException{
        if(isEmpty()){
            throw new LinkedListException("Error");
        }
        Object current = head.getOb();
        head = head.getLink();
        return current;
    }
    
    /**
     * This method is to test all of the methods.
     * 
     * Made a new stack and added and printed to make sure they were all working.
     *
     *PRE: none
     *POST: testing the methods
     * @param: none
     * *return: none
     */
    public static void main(String[] args) throws LinkedListException
    {
        Stack stack = new Stack();
        stack.push(40);
        stack.push(30);
        stack.push(30);
        stack.push(10);

        System.out.println("Stack: " + stack);

        while(!stack.isEmpty())
        {
            System.out.println("Popped item: " + stack.pop());
        }

        System.out.println("Stack: " + stack);
    }

}
