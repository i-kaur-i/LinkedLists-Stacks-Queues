
/**
 * This class extends the exception class and gives an
 * exception.
 *
 * @author Iakjot Kaur
 * @version May 19th, 2020
 */
public class LinkedListException extends Exception
{
   /**
     * This constructor returns a message.
     * 
     * It returns the super class and prints out the message 
     * needed.
     *
     *PRE: none
     *POST: exception message 
     * @param: none
     * *return: none
     */
   public LinkedListException(){
      super("Linked List Exception");
   }
   
   /**
     * This constructor takes in the message and returns it.
     * 
     * The message being passed in is returned.
     *
     *PRE: none
     *POST: exception message 
     * @param: none
     * *return: none
     */
   public LinkedListException(String m){
      super(m);
    }
}
