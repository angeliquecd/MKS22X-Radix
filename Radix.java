public class Radix{

  public static void radixsort(int[]data){
    MyLinkedList<Integer>[] buckets = new MyLinkedList<Integer>[20];
  for (int i= 0;i<20;i++){
    buckets[i]= new MyLinkedList<Integer>();
  }
  debug(buckets);
    MyLinkedList<Integer> result = new MyLinkedList<Integer>();
    int largest =0;
    for (int a:data){
      result.add(a);
      if (a>largest) largest=a;
    }
    int n = 10;
    while(largest%n!=largest){
    while(result.hasNext()){
      int workingwith = result.removeFront();
      buckets[(workingwith%n)/(n/10)].add(workingwith);
      n*=10;
    }
    result=buckets[0];
    for (int i =1;i<20;i++){
      result = result.extend(buckets[i]);//reforms it into new linked list
    }
  }
  }
  public static void debug(MyLinkedList<Integer>[] buckets){
  for (MyLinkedList<Integer> a: buckets){
    while(a.hasNext()){
    System.out.println(a.removeFront());}
  }
}
public static void main (String[] args){
  int[] data = {1,2,3};
  radixsort(data);
}
}
