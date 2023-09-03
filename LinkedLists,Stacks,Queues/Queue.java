
/**
 * This is the linked list queue class, inherited from List.
 * This class extends the list parent class and it 
 * overrides the insert and remove methods.
 *
 * @author Iakjot Kaur
 * @version May 19th, 2020
 */
public class Queue extends List
{
  /**
     * This method is to add the object to the list.
     * 
     * I made sure the object isn't null and then if it wasn't
     * I added it to the node and stored it as a head.
     *
     *PRE: have an object
     *POST: adds object
     * @param: object
     * *return: none
     */
  public void enqueue(Object n) throws LinkedListException{
     if(n == null){
        throw new LinkedListException("error");
     }
     head = new Node(n, head);
  }
  
  /**
     * This method is to remove from the list.
     * 
     * I made sure the invarients were followed and then
     * removed the node from the end of the list.
     *
     *PRE: have an object
     *POST: removes object
     * @param: none
     * *return: object
     */
  public Object dequeue() throws LinkedListException{
     if(isEmpty()){
        throw new LinkedListException("error");
     }
     Node current = head;
     Node backNode = null;
     while(current.getLink() != null){
        backNode = current;
        current = current.getLink();
     }
     Object curr = null;
     if(backNode == null){
        curr = head.getOb();
        head = head.getLink();
     }
     else{
        curr = current.getOb();
        backNode.setLink(current.getLink());
     }
     return current;
  }
  
  /**
     * This method is to test all of the methods.
     * 
     * Made a new queue and added and printed to make sure they were all working.
     *
     *PRE: none
     *POST: testing the methods 
     * @param: none
     * *return: none
     */
    public static void main(String[] args) throws LinkedListException
   {
       Queue queue = new Queue();
       queue.enqueue(50);
       queue.enqueue(60);
       queue.enqueue(70);
       queue.enqueue(80);

       System.out.println("Queue: " + queue);

       while (!queue.isEmpty())
       {
           System.out.println("Dequeued item: " + queue.dequeue());
       }
      
       System.out.println("Queue: " + queue);
   }
}
