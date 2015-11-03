package ch08.se01.service.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyProfessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
		System.out.println("程序现在使用postProcessAfterInitializations对"+arg1+"进行增强处理…");
		if(arg0 instanceof Chinese){
			Chinese c=(Chinese)arg0;
			c.setName("yueshunshun");
		}
		return arg0;
	}

	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1) throws BeansException {
		// TODO Auto-generated method stub	System.out.println("程序现在使用BeanFactoryPostProcessor对Spring容器进行增强处理…");
		System.out.println("程序现在使用postProcessBeforeInitialization对"+arg1+"进行增强处理…");
		return arg0;
	}

}
