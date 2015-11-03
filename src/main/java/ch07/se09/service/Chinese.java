/**
 * 
 */
package ch07.se09.service;

/**
 * @author yuess
 *
 */
public abstract class Chinese implements Person {

	Chinese(){
		System.out.println("spring实例化bean,Chinese实例");
	}
	/* (non-Javadoc)
	 * @see ch07.se09.service.Person#useAxe()
	 */
	@Override
	public void useAxe() {
		System.out.println("正载使用"+getAxe());
		System.out.println(getAxe().chop());
	}
	public  abstract Axe getAxe();//通过spring,每次都将生成一个新的SteelAxe,
}
