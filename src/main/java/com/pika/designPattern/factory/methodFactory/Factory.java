package com.pika.designPattern.factory.methodFactory;

import com.pika.factory.simpleFactory.Car;

/**
 * 每一个汽车生产商都应该有一个工厂
 *
 * 根据上述代码可以看出，不同品牌的汽车是由不同的工厂生产的，
 * 貌似又是很完美的。但大家看一下测试类，当一个人想要去买一辆宝马汽车的时候（假设没有销售商），
 * 那么他就要去找宝马工厂给他生产一辆，过几天又想要买一辆奔驰汽车的时候，又得跑到奔驰工厂请人生产，
 * 这无疑就增加了用户的操作复杂性。所以有没有一种方便用户操作的方法呢？这个时候抽象工厂模式就出现了。
 */
public interface Factory {
    public Car getCar();
}
