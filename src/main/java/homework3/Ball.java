package homework3;

public class Ball {
	private int _touchNumber = 0;
	private boolean _game = true;

	public int getTouchNumber() {
		return _touchNumber;
	}

	public void setTouch(int touch) {
		this._touchNumber = touch;
	}

	public boolean isGame() {
		return _game;
	}

	public void setGame(boolean _game) {
		this._game = _game;
	}

	public void incrementTouchNumber() {
		System.out.println(Thread.currentThread().getName() + " hit");
		_touchNumber++;
		System.out.println("touch " + _touchNumber);
	}
}
