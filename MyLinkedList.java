public class MyLinkedList<E>{
  private int size;
  private Node start,end;
  public MyLinkedList(){
    size=0;
    start=new Node();
    end=start;
  }
  public String toString(){
  Node current=start;
  String value="[";
  if (size>0){//for empty lists, don't print zero
  while(current.next()!=null){
    value+=current.toString()+", ";
    current=current.next();
  }
  return value+current.toString()+"]";}
  return value+"]";
}
    //not REQUIRED, but it would be crazy of you not to have this
public void clear(){
  start=new Node();
  end=start;
  size=0;
}
    //reset the list to an empty state. Very similar to the constructor.
public void add(E value){
  if (size==0){//special case
    start=new Node(value, null, null);
    end=start;
    size++;
    }
  else{//for all the rest
    Node last = end;//saves penultimate value
    end=new Node(value, null, last);//sets up last element
    last.setNext(end);//bridges penultimate and last
    size++;
    }
}
    //add an element to the end of the list (the boolean would be true all the time if you want to conform to list standards)
public void extend(MyLinkedList<E> other){
  end.setNext(other.start);
  other.start.setPrev(end);//links them
  end=other.end;//creates new end
  size+=other.size;//resets size
  other.size=0;//honestly not sure why it does this
}
    /* in O(1) time, connect the other list to the end of this list.
    The other list is then reset to size 0 (do not wipe out the nodes, just disconnect them.)
    This is how you will merge lists together for your radix sort.*/
public E removeFront() {
  Node next = start.next();
  start=next;
  start.setPrev(null);
  size--;
  return next.getData();
}
  //  remove the 1st element of the list, and return that value.
  private class Node{
      private E data;
      private Node next, prev;
      public Node (E data1, Node next1, Node prev1){
        data=data1;
        next=next1;
        prev=prev1;
      }
      public Node(){
        data=null;
        next=null;
        prev=null;
      }
      public E getData(){
        return data;
      }
      private Node next(){
        return next;
      }
      private Node prev(){
        return prev;
      }
      public void setData(E data1){
        data=data1;
      }
      private void setNext (Node other){
        next=other;
      }
      public void setPrev(Node other){
        prev=other;
      }
      //public String toStringdebug(){
      //}
      public String toString(){
        String value=""+data;
        return value;
      }
    }
}
