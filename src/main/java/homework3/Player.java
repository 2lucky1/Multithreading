package homework3;

public class Player implements Runnable {
	private int hitsNumber = 0;
	private Ball _ball;

	public Player(Ball ball) {
		_ball = ball;
	}

	public int getHitsNumber() {
		return hitsNumber;
	}

	public void run() {
		while (true) {
			synchronized (_ball) {
				if (_ball.isGame()) {
					_ball.notifyAll();
					_ball.incrementTouchNumber();
					incrementHits();
					try {
						_ball.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else{
					_ball.notifyAll();
					break;
				}
			}
		}
	}

	public void incrementHits() {
		hitsNumber++;
	}
}
