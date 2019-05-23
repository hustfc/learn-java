package property;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOC {
    @Test
//    public void TestUser() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
//
//        PropertyDemo1 demo1 = (PropertyDemo1) context.getBean("demo");
//        demo1.test1();
//    }
    public void testPerson() {
         ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
         Person person = (Person) context.getBean("person");
         person.test1();
    }
}
