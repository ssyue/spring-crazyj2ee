package jvm.unit2;


//-Xss2M 不要运行
public class JavaVMStackOOM {
	private void dontstop(){
		while(true){
		}
	}
	public void stackLeakByThread(){
		while(true){
			Thread thread=new Thread(new Runnable(){
				@Override
				public void run() {
					dontstop();
				}
			});
			thread.start();
		}
	}
	
	public static void main(String[] args) {
		JavaVMStackOOM oom=new JavaVMStackOOM();
		oom.stackLeakByThread();
	}

}
