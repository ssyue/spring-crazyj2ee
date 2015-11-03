package ch07.se09.service.impl;

import ch07.se09.service.Axe;
import ch07.se09.service.Person;

public class Chinese implements Person {
	private Axe axe;

	@Override
	public void useAxe() {
		System.out.println(axe.chop());
	}

	// 定义设值注入的setter方法
	public void setAxe(Axe axe) {
		this.axe = axe;
	}

}
