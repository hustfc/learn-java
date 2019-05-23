package cn.itcast.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestIOC {
    @Test
    public void testUser(){
        //1 加载spring配置文件，根据配置创建对象
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");

        //2 得到配置文件对象
        User user1 = (User) context.getBean("user");
        User user2 = (User) context.getBean("user");
        System.out.println(user1);
        System.out.println(user2);
    }
}
