package xmlanno;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BookService {
    //得到bookDao和OrdersDao对象
    @Resource("bookDao")
    private BookDao bookDao;

    @Resource("ordersDao")
    private OrdersDao ordersDao;

    @Test
    public void add() {
        System.out.println("service...");
    }
}
