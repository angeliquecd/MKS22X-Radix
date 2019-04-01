public class Radix{
@SuppressWarnings({"unchecked","rawtypes"})
  public static void radixsort(int[]data){
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
  for (int i= 0;i<20;i++){
    buckets[i]= new MyLinkedList<Integer>();
  }
    MyLinkedList<Integer> result = new MyLinkedList<Integer>();
    int largest =0;
    for (int a:data){
      result.add(a);
      if (a>largest) largest=a;
    }
    System.out.println("the linkedlist: "+result);
    int n = 10;
    while(largest%n!=largest){
    while(result.hasNext()){
      int workingwith = result.removeFront();
      int index = (workingwith%n)/(n/10);
      System.out.println("working with: "+workingwith+" index:"+index);
      buckets[index].add(workingwith);
    //  System.out.println("size: "+result.size());
    }
    result=buckets[0];
    for (int i =1;i<20;i++){
      if (buckets[i].hasNext()){
      result.extend(buckets[i]);}//reforms it into new linked list
    }
    System.out.println("final result: "+result);
  n*=10;}
  for (int i=0;i<data.length;i++){//copies final answer back into data
    data[i]=result.removeFront();
  }
  }
  public static void debug(MyLinkedList<Integer>[] buckets){
  for (MyLinkedList<Integer> a: buckets){
    while(a.hasNext()){
    System.out.println(a.removeFront());}
  }
}
public static void debug(int[] data){
  for (int a: data){
    System.out.print(a);
  }
}
public static void main (String[] args){
  int[] data = {1,2,3,10,5,6,3};
  radixsort(data);
  debug(data);
}
}
