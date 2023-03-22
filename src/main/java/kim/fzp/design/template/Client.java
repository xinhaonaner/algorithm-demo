package kim.fzp.design.template;

/**
 * description
 * author fzp
 * date 2023/3/22 17:31
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("=======制作红豆豆浆=======");
        ReadBeanSoyMilk readBeanSoyMilk = new ReadBeanSoyMilk();
        readBeanSoyMilk.make();

        System.out.println("=======制作花生豆浆=======");
        PeanutSoyMilk peanutSoyMilk = new PeanutSoyMilk();
        peanutSoyMilk.make();

        System.out.println("=制作纯豆浆=");
        PureSoyMilk pureSoyMilk = new PureSoyMilk();
        pureSoyMilk.make();
    }
}
