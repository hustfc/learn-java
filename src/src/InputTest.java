import java.util.*;   //Scanner的库
public class InputTest {
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
