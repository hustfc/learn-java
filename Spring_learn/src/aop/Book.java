package aop;

public class Book {
    //切入点：实际需要增强的方法
    public void add() {
        System.out.println("add......");
    }
}
