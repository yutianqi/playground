/**
 * 功能描述
 *
 * @author y00290641
 * @version V300R005C10, 2019/12/4
 * @since V300R005C10
 */
public abstract class Beverage {

    String description = "Unknown Beverage";

    public String getDescription() {                // getDescription()已经在抽象类中实现
        return description;
    }

    public abstract double cost();                  // cost()方法必须在子类中实现
}
