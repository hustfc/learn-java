package annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnno {
    @Test
    public void testUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserService service = (UserService) context.getBean("service");
        System.out.println(service);
        service.add();
    }
}
