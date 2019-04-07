import java.util.Arrays;

public class array {
    public static void main(String[] args){
        //int[] a;
        int[] a = new int[100];   //创建可以存储100个数字的数组
        for(int i = 0; i < 100; i ++){
            a[i] = i;
        }
        for(int i = 0; i < 100; i ++){
            System.out.println(a[i]);
        }
        //同样是可以打印的
        for(int element : a)
            System.out.println(element);

        System.out.println(Arrays.toString(a));
    }
}
