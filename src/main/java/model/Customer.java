/**
vlad
Mar 20, 2018

*/

package model;

public class Customer {
	private int id;
	private int arrivalTime;
	private int serviceTime;
	private int waitingTime;
	
	public Customer(int id, int arrivalTime, int serviceTime) {
		this.id = id;
		this.arrivalTime = arrivalTime;
		this.serviceTime = serviceTime;
		this.waitingTime = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}
	
	public void decArrivalTime() {
		this.arrivalTime--;
	}
	
	public void decServiceTime() {
		this.serviceTime--;
	}
	
	public void incWaitingTime() {
		this.waitingTime++;
	}
	
	public int getWaitingTime() {
		return this.waitingTime;
	}
	
	@Override
	public String toString() {
		return " C #" + this.id + " [A: " + this.arrivalTime + 
				" S: " + this.serviceTime + 
				" W: " + this.waitingTime + "] ";
	}
}
