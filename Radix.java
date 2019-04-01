public class Radix{
  MyLinkedList<Integer> buckets[] = new MyLinkedList<Integer>()[10];
  public void radixsort(int[]data){
    MyLinkedList<Integer> result = new MyLinkedList<Integer>();
    int largest =0;
    for (int a:data){
      result.add(a);
      if (a>largest) largest=a;
    }
    int n = 10;
    while(largest%n!=largest){
      
    }
  }
}
