package jvm.unit2;

import java.util.ArrayList;
/*//堆溢出
-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+HeapDumpOnOutOfMemoryError -XX:+PrintGCDetails*/
public class HeapOOM {
	static class OOMObject{}
	public static void main(String[] args) {
		ArrayList<OOMObject> list=new ArrayList<OOMObject>();
		while(true){
			list.add(new OOMObject());
		}
	}
}
