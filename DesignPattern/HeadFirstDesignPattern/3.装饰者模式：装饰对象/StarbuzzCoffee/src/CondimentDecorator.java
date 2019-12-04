/**
 * 功能描述
 *
 * @author y00290641
 * @version V300R005C10, 2019/12/4
 * @since V300R005C10
 */
public abstract class CondimentDecorator extends Beverage {


    @Override
    public abstract String getDescription();                // getDescription()方法被重新定义为抽象方法
                                                            // 所有的调料装饰者都必须重新实现getDescription()方法


}
