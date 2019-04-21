package treeSet;

import java.util.*;

public class TreeSetTest {
    public static void main(String[] args){
        SortedSet<Item> parts = new TreeSet<>();

        parts.add(new Item("Toaster", 1234));
        parts.add(new Item("Widget", 4562));
        parts.add(new Item("Modem", 9912));
        System.out.println(parts);  //按照number排序，因为Item campareTo方法实现的是对partNumber排序

        //按照description排序
        NavigableSet<Item> sortByDescription = new TreeSet<>(Comparator.comparing(Item::getDescription));
        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }
}
