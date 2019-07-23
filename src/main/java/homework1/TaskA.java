package homework1;

public class TaskA implements Runnable {

	public static Thread threadA;
	public static TaskA taskA;
	private static final String STATE_OF = "State of ";
	
	public static void main(String[] args){
		taskA = new TaskA();
		threadA = new Thread(taskA, "ThreadA");
		
		//NEW
		System.out.println(STATE_OF + threadA.getName() + " = " + threadA.getState());

		Thread threadC = new Thread(taskA, "ThreadC");
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		threadA.start();
		threadC.start();
		
		//RUNNABLE
		System.out.println(STATE_OF + threadA.getName() + " = " + threadA.getState());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//TIMED_WAITING
		System.out.println(STATE_OF + threadA.getName() + " = " + threadA.getState());

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		//TERMINATED
		System.out.println(STATE_OF + threadA.getName() + " = " + threadA.getState());
	}
	
	@Override
	public void run() {
		
		synchronized(threadA){
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		TaskB taskB = new TaskB();
		Thread threadB = new Thread(taskB, "ThreadB");
		
		threadB.start();

		try{
			threadB.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
	}

}

class TaskB implements Runnable{

	@Override
	public void run() {
		synchronized (TaskA.threadA) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//WAITING/BLOCKED
			System.out.println("State of " + TaskA.threadA.getName() + " = "  + TaskA.threadA.getState());
		}
		
	}
	
}

