package kim.fzp.design.template;

/**
 * 纯豆浆
 * author fzp
 * date 2023/3/22 18:12
 */
public class PureSoyMilk extends SoyMilk {

    @Override
    void addCondiment() {
        // 添加配料的方法 空实现 即可
    }

    @Override
    boolean customerWantCondiment() {
        return false;
    }
}
