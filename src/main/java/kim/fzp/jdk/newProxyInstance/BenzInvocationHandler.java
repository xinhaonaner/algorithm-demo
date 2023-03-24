package kim.fzp.jdk.newProxyInstance;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 目标类的InvocationHandler
 * author fzp
 * date 2023/3/24 18:20
 */
public class BenzInvocationHandler implements InvocationHandler {

    Car target;

    public BenzInvocationHandler(Car target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("打火，开始行驶");
        Object invoke = method.invoke(target, args);
        System.out.println("熄火，停车");
        return invoke;
    }
}
