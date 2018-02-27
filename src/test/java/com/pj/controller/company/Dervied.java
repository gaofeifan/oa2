package com.pj.controller.company;

/**
 * @author GFF
 * @date 2017年8月24日下午2:17:06
 * @version 1.0.0
 * @parameter
 * @since 1.8
 */
public class Dervied extends Base {
	private String name = "dervied";
	public Dervied() {
		System.out.println("执行子类");
		tellName();
		printName();
	}

	public void printName() {
		System.out.println("Dervied print 我被执行了");
		System.out.println("Dervied print name:"+name);
	}

	public void tellName() {
		System.out.println("Dervied tell 我被执行了");
		System.out.println("Dervied tell name:"+name);
	}
	public static void main(String[] args) {
		new Dervied();
	}

}
class Base {
	private String name = "base";

	public Base() {
		System.out.println("执行超类");
		tellName();
		printName();
	}

	public void printName() {
		System.out.println("Base print 我被执行了");
		System.out.println("Base print name:" + name);
	}

	public void tellName() {
		System.out.println("base tell 我被执行了");
		System.out.println("Base tell name:" + name);
	}

}
