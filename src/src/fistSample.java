public class fistSample {
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
