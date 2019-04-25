package quickstart;

import java.util.Arrays;
import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

    public static class array {
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

    public static class arrayCopy {
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

    public static class fistSample {
        public static void main(String[] arg){
            System.out.println("We will not use hello world");
            double x = 4;
            double y = Math.sqrt(x);
            System.out.println(y);
            double z = Math.pow(x, y);
            System.out.println(z);
            String str = "";
            if(str.equals("")){
                System.out.println("空串");
            }
            if(str.length() == 0){
                System.out.println("空串");
            }
            if(str != null && str.length() != 0){
                System.out.println("不是空串也不是null值");
            }
        }
    }

    public static class InputTest {
        public static void main(String[] args){
            Scanner in = new Scanner(System.in);

            System.out.println("What is your name");
            String name = in.nextLine();
            //String firstName = in.next();

            System.out.println("How old are you?");
            int age = in.nextInt();

            System.out.println("Hello, " + name + ". Next year, you'll be " + (age + 1));
            //可以直接在后面加上int类型的数据
        }
    }

    public static class stringBuilder {
        public static void main(String[] arg) {
            StringBuilder builder = new StringBuilder();
            builder.append('c');
            builder.append("cdef");
            System.out.println(builder.length());   //builder的长度
            String str = builder.toString();
            System.out.println(str);
            System.out.println(str.length());
        }
    }
}
