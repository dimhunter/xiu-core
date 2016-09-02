package com.shen.basic;

/**
 * 枚举用法详解，枚举是不能new一个对象的，只能通过“枚举名.值”取得枚举中的值，枚举是一种类型，用于定义变量，以限制变量的赋值；
 * 枚举值都是public static final的（重要），也就是我们经常所定义的常量方式，因此枚举类中的枚举值最好全部大写。 
 * @author shen
 *
 */
public class TestEnum {
    
	/**
     * 1.普通枚举
     * @author shen
     */
    public enum ColorEnum {
    	//如果是普通枚举，即只有值，最后一个分号可以省略。
        red, green, yellow, blue;
    }
    
    /**
     * 2.枚举像普通的类一样可以添加属性和方法，可以为它添加静态和非静态的属性或方法
     * @author shen
     */
    public enum SeasonEnum {
        //注：枚举写在最前面，且最后一个分号一定不可以省略。否则编译出错，这是和普通枚举不同的。
        spring, summer, autumn, winter;
        private final static String position = "com/shen/test";
        //静态方法，可对外直接调用。SeasonEnum.getSeason()
        //普通方法调用是不同的，必须指定枚举的一个值，如本例中的 Gender.MAN.getValue()，调用普通方法getValue()。
        public static SeasonEnum getSeason() {
            if ("com/shen/test".equals(position))
                return spring;
            else
                return winter;
        }
    }
    
    /**
     * 3.实现带有构造器的枚举，先通过括号赋值，可以有多个值，对应也就是多个参数。
     * @author shen
     */
    public enum Gender{
        //通过括号赋值,而且必须带有一个参构造器和一个属性跟方法，否则编译出错
        //赋值必须都赋值或都不赋值，不能一部分赋值一部分不赋值；如果不赋值则不能写构造器，赋值编译也出错
        MAN("MAN"), WOMEN("WOMEN");
        
        private final String value;

        //构造器默认也只能是private, 从而保证构造函数只能在内部使用
        Gender(String value) {
            this.value = value;
        }
        
        public String getValue() {
            return value;
        }
    }
    
   /**
    * 4.实现带有抽象方法的枚举
    * @author shen
    */
    public enum OrderState {
        /** 已取消 */
        CANCEL {public String getName(){return "已取消";}},
        /** 待审核 */
        WAITCONFIRM {public String getName(){return "待审核";}},
        /** 等待付款 */
        WAITPAYMENT {public String getName(){return "等待付款";}},
        /** 正在配货 */
        ADMEASUREPRODUCT {public String getName(){return "正在配货";}},
        /** 等待发货 */
        WAITDELIVER {public String getName(){return "等待发货";}},
        /** 已发货 */
        DELIVERED {public String getName(){return "已发货";}},
        /** 已收货 */
        RECEIVED {public String getName(){return "已收货";}};
        
        public abstract String getName();
    }
    
    
    public static void main(String[] args) {
        //枚举是一种类型，用于定义变量，以限制变量的赋值；赋值时通过“枚举名.值”取得枚举中的值
        ColorEnum colorEnum = ColorEnum.blue;
        switch (colorEnum) {
        case red:
            System.out.println("color is red");
            break;
        case green:
            System.out.println("color is green");
            break;
        case yellow:
            System.out.println("color is yellow");
            break;
        case blue:
            System.out.println("color is blue");
            break;
        }
        
        //遍历枚举，通过Enum.values()静态方法，可遍历枚举。
        System.out.println("遍历ColorEnum枚举中的值");
        for(ColorEnum color : ColorEnum.values()){
            System.out.println(color);
        }
        
        //获取枚举的个数
        System.out.println("ColorEnum枚举中的值有"+ColorEnum.values().length+"个");
        
        //获取枚举的索引位置，默认从0开始
        System.out.println(ColorEnum.red.ordinal());//0
        System.out.println(ColorEnum.green.ordinal());//1
        System.out.println(ColorEnum.yellow.ordinal());//2
        System.out.println(ColorEnum.blue.ordinal());//3
        
        //枚举默认实现了java.lang.Comparable接口
        System.out.println(ColorEnum.red.compareTo(ColorEnum.green));//-1
        
        //--------------------------
        System.out.println("===========");
        System.err.println("季节为" + SeasonEnum.getSeason());
        
        
        //--------------
        System.out.println("===========");
        for(Gender gender : Gender.values()){
            System.out.println(gender.value);
        }
        System.out.println("枚举普通方法调用="+Gender.MAN.getValue());
       
        //--------------
        System.out.println("===========");
        for(OrderState order : OrderState.values()){
            System.out.println(order.getName());
        }
    }
    
}
