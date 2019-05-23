package ioc;

public class UserService {
    private UserDao userDao;
    //set一定要小写
    public void setUserDao(UserDao dao) {
        userDao = dao;
    }
     public void add() {
         System.out.println("Service........");
         //new的过程交给spring
//         UserDao dao = new UserDao();
//         dao.add();
         //具体实现过程：
         //1. Service定义UserDao属性
         //2. 生成Set方法
         //3. 使用Set方法注入
        userDao.add();
     }
}
