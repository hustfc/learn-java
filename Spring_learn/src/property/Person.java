package property;
import java.util.*;

public class Person {
    //使用p名称空间来进行属性注入
    private String name;

    public void setName(String name) {
        this.name = name;
    }
    public void test() {
        System.out.println(name);
    }

    private String[] arrs;
    private List<String> list;
    private Map<String, String> map;
    private Properties properties;

    public void setArrs(String[] arrs) {
        this.arrs = arrs;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void test1() {
        System.out.println("array" + arrs);
        System.out.println("list" + list);
        System.out.println("map" + map);
        System.out.println("pro" + properties);
    }
}
