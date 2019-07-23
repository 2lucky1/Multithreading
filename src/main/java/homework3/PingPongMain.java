package main.java.homework3;

public class PingPongMain {
	private static Player vasya;
	private static Player petya;
	
	private static Thread vasyaThread;
	private static Thread petyaThread;
	
	private static final Ball _ball = new Ball();
	private static final int GAME_DURATION_MILLIS = 2;
	
	public static void main(String[] args) {
		createPlayers(_ball);
		createThreads();
		startThreads();
		
		setGameDuration(GAME_DURATION_MILLIS);
		
		_ball.setGame(false);
		
		printResults();
	}

	private static void printResults() {
		System.out.println("The ball was hited " + _ball.getTouchNumber() + " times");
		System.out.println(vasyaThread.getName() + " made " + vasya.getHitsNumber() + " hits");
		System.out.println(petyaThread.getName() + " made " + petya.getHitsNumber() + " hits");
	}
	
	private static void setGameDuration(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static void startThreads() {
		vasyaThread.start();
		petyaThread.start();
	}
	
	private static void createThreads() {
		vasyaThread = new Thread(vasya, "Vasya");
		petyaThread = new Thread(petya, "Petya");
	}
	
	private static void createPlayers(Ball _ball) {
		vasya = new Player(_ball);
		petya = new Player(_ball);
	}
}

