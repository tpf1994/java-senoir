package com.atguigu.designPatterns.proxy1;

/**
 * 静态代理编写步骤：
 * 	1.一个委托类，一个代理类，实现同一个接口，重写同样的方法
 * 	2.代理类需要通过构造器把委托类信息加载过来
 * 	3.代理类在重写的方法里面编写增强代码。例如前后通知，中间调用委托类的目标方法。
 * 		这样便实现的静态的代理增强
 * 	4.使用代理的本质：new代理类生成对象，调用这个对象与委托类同样重写过的方法
 * 		，但此时，创建对象需要传参，这个参数就是委托类对象。
 * 		也就是说，此时把委托类对象信息传递过去。
 */
public class StaticProxyTest {

	public static void main(String[] args) {
		Car car = new Benz();
		CarStaticProxy carStaticProxy = new CarStaticProxy(car);
		carStaticProxy.drive();
	}
}
