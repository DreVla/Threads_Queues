/**
vlad
Mar 31, 2018

*/

package model;

public class TurnCheck {
	private volatile int check = 0;

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}
}
