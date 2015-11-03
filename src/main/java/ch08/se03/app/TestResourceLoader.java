/**
 * 
 */
package ch08.se03.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ResourceLoader;

/**
 * @author yuess
 *
 */
public class TestResourceLoader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beanse08.xml");
		MyResourceLoader my=ctx.getBean(MyResourceLoader.class);
		ResourceLoader r=my.getRd();
		// 判断Spring是否是将自身注入到TestBean中了
		// 输出为true，表面Spring确实将自身作为参数调用了setResourceLoader方法
		System.out.println(ctx==r);
	}

}
