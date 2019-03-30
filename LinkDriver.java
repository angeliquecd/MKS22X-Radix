public class LinkDriver{
  public static void main(String[] args){
    MyLinkedList<Integer> a = new MyLinkedList<Integer>();
    System.out.println(a);
    a.add(1);
    System.out.println(a);
    a.add(2);
    a.add(3);
    a.add(4);
    System.out.println(a);
    a.removeFront();
    System.out.println(a);
    MyLinkedList<Integer> b = new MyLinkedList<Integer>();
    b.add(5);
    b.add(6);
    b.add(7);
    b.add(9);
    a.extend(b);
    System.out.println(a);
    System.out.println(b);
    a.clear();
    System.out.println(a);
    //remove
    //add
    //clear
    //extend
  }
}
