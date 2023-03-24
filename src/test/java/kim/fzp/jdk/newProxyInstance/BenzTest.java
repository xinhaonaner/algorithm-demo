package kim.fzp.jdk.newProxyInstance;


import java.lang.reflect.Proxy;

/**
 * 主要用来做方法的增强，让你可以在不修改源代码的情况下，增强一些方法，在方法执行前后做任何你想做的事情（甚至根本不去执行这个方法），因为在InvocationHandler的invoke方法中，你可以直接获取正在调用方法对应的Method对象，具体应用的话，比如可以添加调用日志，做事务控制等。动态代理是设计模式当中代理模式的一种。动态，指的是代理类是在程序运行时创建的，而不是在程序运行前手动编码来定义代理类的。这些动态代理类是在运行时候根据我们在JAVA代码中的“指示”动态生成的。相比于静态代理，动态代理的优势在于
 *
 * 可以很方便的对代理类的方法进行统一处理。
 * 不用为每一个目标类(需要增强的类)单独编写代理类。
 * ————————————————
 * 版权声明：本文为CSDN博主「Evan Wang」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/qq_41378597/article/details/102593732
 */
class BenzTest {

    public static void main(String[] args) {
        Benz benz = new Benz();
        //生成目标类的代理类proxyBenz，对目标类做强的类
        Car proxyBenz = (Car) Proxy.newProxyInstance(benz.getClass().getClassLoader(), benz.getClass().getInterfaces(), new BenzInvocationHandler(benz));
        proxyBenz.run("80");
    }
}