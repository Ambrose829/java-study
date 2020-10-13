package com.pika.designPattern.factory.simpleFactory;

/**
 * 简单工厂，既能生产宝马也能生产奔驰
 * 根据简单工厂的定义，用户只要产品而不在乎产品如何生产，看起来好像很完美的样子。但大家想想，这个世界存在什么都生产的工厂吗？
 *
 * 显然是不存在的，每一个汽车品牌都有自己的生产工厂，都有自己生产技术。映射到spring框架中，我们有很多很多种的bean需要生产，如果只依靠一个简单工厂来实现，那么我们得在工厂类中嵌套多少个if..else if啊？
 *
 * 而且我们在代码中生产一辆汽车只是new一下就出来了，但实际操作中却不知道需要进行多少操作，加载、注册等操作都将体现在工厂类中，那么这个类就会变得紊乱，管理起来也很不方便，所以说每个品牌应该有自己的生产类。
 *
 * 因为专一，所以专业嘛，这个时候工厂方法就出现了。
 */
public class SimpleFactory {
    public Car getCar(String name) {
        if ("BMW".equals(name)) {
            return new BMW();
        } else if ("BenZ".equals(name)) {
            return new BenZ();
        }else {
            System.out.println("目前暂不支持生产"+name);
            return null;
        }
    }
}
