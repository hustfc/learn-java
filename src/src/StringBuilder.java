public class stringBuilder {
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
