package cn.itcast.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOC {
    @Test
    public void testUser(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Bean2 bean2 = (Bean2) context.getBean("bean2");
        System.out.println(bean2);
        bean2.add();
    }
}
