package ch08.se01.service.impl;

import org.springframework.beans.factory.InitializingBean;

import ch08.se01.service.Axe;
import ch08.se01.service.Person;

public class Chinese implements Person, InitializingBean {
	private String name;
	
	private Axe axe;
	
	public Chinese() {
		System.out.println("Spring实例化主调bean：Chinese实例…");
	}

	@Override
	public void useAxe() {
		System.out.println(name + " use " + axe.chop());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("Spring调用setName()为bean设置name属性…");
		this.name = name;
	}
	
	public Axe getAxe() {
		return axe;
	}

	public void setAxe(Axe axe) {
		System.out.println("Spring调用setAxe()为bean设置axe属性…");
		this.axe = axe;
	}
	
	public void init() {
		System.out.println("正在执行初始化方法init()…");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("正在执行初始化方法afterPropertiesSet()…");
	}

}
