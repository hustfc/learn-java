package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

public class MyTest {
    @Test
    public void testAop() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean3.xml");
        Book book = (Book) context.getBean("book");
        System.out.println(book);
        book.add();
    }

}
