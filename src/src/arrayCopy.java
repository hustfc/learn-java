import java.util.Arrays;

public class arrayCopy {
    public static void main(String[] args){
        int[] a = {17, 19, 23, 29, 31, 37};
        int[] small = a;   //浅拷贝
        small[1] = 33;
        System.out.println(Arrays.toString(a));
        int[] copy = Arrays.copyOf(a, a.length); //深拷贝
        copy[0] = 12;
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(copy));
    }
}
