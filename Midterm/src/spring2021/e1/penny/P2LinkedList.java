package spring2021.e1.penny;


public class P2LinkedList {

	  private IntegerNode head = null;               
	  private IntegerNode tail = null;               
	  private int size = 0;                      
	  
	  public IntegerNode getHead() { return head; }
	  public IntegerNode getTail() { return tail; }
	  public int getSize() { return size; }
	  
	  public void setHead(IntegerNode h) { head = h; }
	  public void setTail(IntegerNode t) { tail = t; }
	  public void setSize(int s) { size = s; }
	  
	  public P2LinkedList() { }              
	  public int size() { return size; }
	  public boolean isEmpty() { return size == 0; }

	  public void addLast(Integer e) {                 
		    IntegerNode newest = new IntegerNode(e);    
		    newest.setNext(null);
		    if (isEmpty())
		      head = newest;                         
		    else
		      tail.setNext(newest);                  
		    tail = newest;                           
		    size++;
	  }
	  
	  public void printList() {
		  IntegerNode current = head;
		  while (current != null) {
			  System.out.print(current.getElement() + "  ");
			  current = current.getNext();
		  }
		  System.out.println();
	  }
	  
	  // assume the linked list is not empty
	  public void methodP2(Integer e) {
		  IntegerNode prev = head;
		  //System.out.println(prev.toString());
		  boolean flag=false;
		  if (prev.getElement()!=e) {
			  while (prev != null || prev.getNext() != null) {
				  System.out.println(prev.getElement());
				  System.out.println(prev.getNext().getElement());
				 	
				  if (prev.getNext().getElement()==e) {
					  prev.setNext(prev.getNext().getNext());
					  prev.getNext().setNext(head);
					  head=prev.getNext();
					  flag=true;
			
				  }else {
					  if(prev.getNext() != null) {
						  prev=prev.getNext().getNext();
					  }
					  
				  }
				  
				  
			  }
			  if(flag==false) {
				  System.out.println("No node with given integer");		  
			  }
		  }
		  
		  // implement this method
		  
	  }
	  
	  
}
