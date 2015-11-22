package jvm.unit4;

import java.util.ArrayList;
import java.util.List;
//-Xms100M -Xmx100M -XX:+UserSerialGC
public class Jconsole {
	public static void main(String[] args){
		fillHeap(1000);
	}
	static class OOMObject{
		public byte[] placeholder=new byte[64*1024];
	}
	public static void fillHeap(int num) {
		List<OOMObject> list=new ArrayList<OOMObject>();
		for(int i=0;i<num;i++){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list.add(new OOMObject());
		}
		System.gc();
	}
	
}
