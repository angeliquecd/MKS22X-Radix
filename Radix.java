public class Radix{
@SuppressWarnings({"unchecked","rawtypes"})
  public static void radixsort(int[]data){
    if (data.length<2) return ;//mine doesn't work with length 1
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
  for (int i= 0;i<20;i++){buckets[i]= new MyLinkedList<Integer>();}
    MyLinkedList<Integer> result = new MyLinkedList<Integer>();
    int largest =0;
    for (int a:data){
      result.add(a);//creates the result linkedlist to begin with
      if (Math.abs(a)>largest) largest=Math.abs(a);//simultaneously figures out where to stop
    }
  //  System.out.println("the linkedlist: "+result);
    int n = 1;//represents the place you're looking at
    while(largest>=n){//tells you where to start
  //    System.out.println(largest);
    //  System.out.println(result.hasNext()+" "+result.size());
      int passes=0;
    while(passes<data.length){//goes through each one
      int workingwith = result.removeFront();//picks off one by one
      int actual=workingwith;
      int add=0;
      if (workingwith<0){
        add=10;//puts negatives in their place
        workingwith=Math.abs(workingwith);//find mod of positive number
      }
      int place = n*10;
      int index = (workingwith%place)/(n)+add;
    //  System.out.println("working with: "+actual+" index:"+index);
      buckets[index].add(actual);//places stuff in buckets
    //  System.out.println("size: "+result.size());
    passes++;
    }
//    debug(buckets);
  //  System.out.println("ended first loop");
    result=new MyLinkedList<Integer>();
  //  System.out.println(result);
    //copies back into linkedlist for next pass
    for (int i =19;i>9;i--){
  //    System.out.println(i+": "+buckets[i]);
      if (buckets[i].hasNext()){//does negatives first
    //    System.out.println(true+""+i);
      result.extend(buckets[i]);}
  //  buckets[i].clear();}//reforms it into new linked list while also clearing buckets
  }
  //System.out.println(result);
    for (int i=0;i<10;i++){//next does positives
  //    System.out.println(i+": "+buckets[i]);
      if (buckets[i].hasNext()){
      result.extend(buckets[i]);}
  //  buckets[i].clear();}//reforms it into new linked list while also clearing buckets
    }
  //  System.out.println(result+"size: "+result.size());
  n=n*10;
}
//  System.out.println("final result: "+result);
  for (int i=0;i<data.length;i++){//copies final answer back into data
    data[i]=result.removeFront();
  }
  }

  public static void debug(MyLinkedList<Integer>[] buckets){
    int i =0;
  for (MyLinkedList<Integer> a: buckets){
    System.out.println("\n"+i+": ");
    System.out.print(a);
    i++;
  }
}
public static void debug(int[] data){
  for (int a: data){
    System.out.print(a+", ");
  }
  System.out.println();
}
public static void main (String[] args){
  int[] data = {1,2,3,10,5,6,3, -5, -8, -220,4300,-90000};
  radixsort(data);
  debug(data);
}
}
