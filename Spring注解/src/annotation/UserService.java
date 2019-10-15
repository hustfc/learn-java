package annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("service")
public class UserService {

    //@Autowired自动注入
//    @Autowired
//    UserDao userDao;
    @Resource(name="dao")
    UserDao userDao;
    public void add() {
        userDao.add();
        System.out.println("UserService......");
    }
}
