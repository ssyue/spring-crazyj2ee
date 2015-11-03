package ch07.se09.service.impl;

import ch07.se09.service.Axe;

public class SteelAxe implements Axe {

	@Override
	public String chop() {
		return "钢斧砍柴很快！";
	}
	public SteelAxe(){
		System.out.println("spring实例化bean,SteelAxe实例");
	}
}
