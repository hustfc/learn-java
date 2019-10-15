package annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "user")    //等价于<bean id="user" class="User"></bean>
@Scope(value = "prototype")    //默认单实例，创建多实例
public class User {
    public void add() {
        System.out.println("add........");
    }
}
