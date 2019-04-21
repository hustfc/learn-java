package linkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListTest {
    public static void main(String[] args){
        List<String> a = new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        List<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");

        //merge the words from b into a
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while(bIter.hasNext()){
            if(aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }

        System.out.println("a: " + a);

        //remove every second word from b
        bIter =  b.iterator();
        while(bIter.hasNext()){
            String oldValue = bIter.next();//skip one element
            System.out.println("oldValue: " + oldValue);
            if(bIter.hasNext()) {
                oldValue = bIter.next();
                System.out.println("removeValue: " + oldValue);
                bIter.remove();//删除访问的对象，必须紧跟在访问一个元素之后执行，iterator的remove返回void
            }
        }

        System.out.println("b: " + b);

        //remove all words in b from a
        a.removeAll(b);
        System.out.println(a);
    }
}