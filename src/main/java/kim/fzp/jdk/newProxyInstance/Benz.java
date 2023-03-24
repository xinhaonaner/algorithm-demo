package kim.fzp.jdk.newProxyInstance;

/**
 * 目标类(即需要被增强的类)
 * author fzp
 * date 2023/3/24 18:19
 */
public class Benz implements Car {

    @Override
    public void run(String speed) {
        System.out.println("奔驰车正在以 " + speed + "km/h的速度行驶中...");
    }
}
