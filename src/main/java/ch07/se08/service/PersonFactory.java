package ch07.se08.service;

import org.springframework.beans.factory.FactoryBean;

import ch07.se08.service.impl.Chinese;

public class PersonFactory implements FactoryBean<Chinese> {
	Chinese p=null;
	@Override
	public Chinese getObject() throws Exception {
		if(p==null){
			p=new Chinese();
		}
		return p;
	}

	@Override
	public Class<Chinese> getObjectType() {
		return Chinese.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
