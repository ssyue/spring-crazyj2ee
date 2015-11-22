package jvm.unit2;
//单个线程下，栈帧太大或者虚拟机栈容量太小都将抛出stackoverflow
//-Xss128k
public class JavaVMStackSOF {
	private int stackLength=1;
	public void stackLeak(){
		stackLength++;
		stackLeak();
	}
	public static void main(String[] args) {
		JavaVMStackSOF oom=new JavaVMStackSOF();
		try{	
		oom.stackLeak();
		}catch(Throwable e){
			System.out.println("stack length ="+oom.stackLength);
			throw e;
		}
	}
}
