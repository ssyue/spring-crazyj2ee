package ch08.se03.app;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

public class MyResourceLoader implements ResourceLoaderAware {
	
	private ResourceLoader rd;
	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.rd=resourceLoader;
		System.out.println("context inject  setResourceLoader() ");
	}
	public ResourceLoader getRd(){
		return rd;
	}
	public void setRd(ResourceLoader resourceLoader){
		this.rd=resourceLoader;
		System.out.println("setRd()");
	}
}
