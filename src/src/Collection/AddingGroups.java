package Collection;

import java.util.*;

public class AddingGroups {
    public static void main(String[] args){
        Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = {6, 7, 8, 9};
        collection.addAll(Arrays.asList(moreInts));
        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection, moreInts);
        for(Integer i : collection)
            System.out.print(i + " ");
        List<Integer> list = Arrays.asList(16, 17, 18, 19);   //底层是数组，不能调整尺寸
        list.set(0, 20);
        System.out.println("\n" + list.toString());
    }
}
