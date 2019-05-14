package co.inventorsoft.academy.collections.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class Main {
    public static void main(String args[]){
      Range<Integer> test =new Range<Integer>();
      test.add(4);
      test.add(6);
      test.add(3);
//   System.out.println(test.contains(4));
//   System.out.println(test.contains(6));
//   System.out.println(test.contains(3));



      Iterator it=test.iterator();
      while(it.hasNext()){
          System.out.println( it.next());
      }



//      System.out.println(test.size());
//      System.out.println(test.contains(1));
//
//        System.out.println("--------------------------------");
//      test.add(4);
//      test.add(5);
//      test.add(6);
//      test.add(7);
//      test.add(8);
//      test.add(9);
//      test.add(10);
//      test.add(11);
//      test.add(12);
//      test.add(13);
//      test.add(14);

//         int i=0;
//         Iterator it=test.iterator();
//      while(it.hasNext()){
//          System.out.println(it.next());
//      }
//
//        for(Number count:test){
//            System.out.println(count.intValue());
//        }
//        ArrayList<Integer> arrayList=new ArrayList<>();
//        arrayList.add(2);
//        arrayList.add(3);
//        Iterator iterator=arrayList.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

//        test.retainAll(arrayList);

//        System.out.println(test.size());

//        System.out.println(test.toArray());

//        Range<Integer> integerRange=Range.of(1,10);
//        System.out.println(integerRange.contains(10));

//        Range<Character> test =new Range<Character>();
//        Iterator iterator=test.iterator();
//        test.add('a');
//        test.add('b');
//        test.add('c');
//        test.add('d');
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

    }
}
