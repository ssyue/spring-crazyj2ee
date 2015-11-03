package ch08.se01.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("程序现在使用BeanFactoryPostProcessor对Spring容器进行增强处理…");
		System.out.println("Spring容器是：" + beanFactory);
	}
	
}
