/**
vlad
Mar 20, 2018

*/

package model;

import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Coada implements Runnable{
	private LinkedList<Customer> customers = new LinkedList<Customer>();
	private LinkedList<Customer> arrivedCustomers = new LinkedList<Customer>();
	private int coadaId;
	private JTextArea text;
	private int simTime;
	private JLabel simWrite;
	private TurnCheck check;
	private int nrCozi;
	private float customersNr=0;
	private float waitTime=0;
	private int maxCustomers=0;
	private int peakTime;
	
	public Coada (int id, JTextArea textBox,int simTime, JLabel simLeft, TurnCheck check, int nrCozi) {
		this.coadaId = id;
		this.text = textBox;
		this.simWrite = simLeft;
		this.simTime = simTime;
		this.check = check;
		this.nrCozi = nrCozi;
	}
	
	public LinkedList<Customer> getCustomers() {
		return customers;
	}


	public void setCustomers(LinkedList<Customer> customers) {
		this.customers = customers;
	}


	public int getCoadaId() {
		return coadaId;
	}


	public void setCoadaId(int coadaId) {
		this.coadaId = coadaId;
	}
	
	public void enqueue(Customer c) {
		this.customers.add(c);
	}
	
	public void dequeue() {
		this.arrivedCustomers.removeFirst();
	}
	
	@Override
	public String toString() {
		return "Queue " + (this.coadaId+1) + ": ";
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 * the run method will implement the behavior of our 
	 * queue. I will always check if it is the current queue turn 
	 * and if it is it will execute the algorithm. 
	 * Checks if there are any customers left. If not it ends the queue and
	 * prints the results. Else continues it checks if any customers must arrive
	 * If yes, it enqueue them to the arrived list. Next it takes the arrived list
	 * and verifies the first customer, decrementing service time and incrementing
	 * waiting time of others. Then it increases the turn and it's next turns queue
	 * 
	 */
	public synchronized void run() {
		//while(exit == false) {
			try {
				synchronized(check){
					for(int time = 0 ; time <= simTime; time++) {
						while(check.getCheck()!=this.coadaId) {
							check.wait();
						}
						if(customers.isEmpty() && arrivedCustomers.isEmpty()) {
							float averageTime = waitTime/customersNr;
							text.append(Integer.toString(time) + ": " + this.toString() +
									"DONE. Total Customers = " + Float.toString(customersNr) +
									" Average Waiting Time = " + Float.toString(averageTime) + 
									" Peak Time = " + Integer.toString(peakTime) + "\n");
							check.setCheck(check.getCheck() + 1);
							check.notifyAll();
							if(check.getCheck() > nrCozi - 1) check.setCheck(0);
						} else {
						simWrite.setText(Integer.toString(time));
						Iterator<Customer> currCustomer = this.customers.iterator();
						while(currCustomer.hasNext()) {
							Customer cust = currCustomer.next();
							if(cust.getArrivalTime() == time) {
								arrivedCustomers.add(cust);
								currCustomer.remove();
								customersNr++;
							}
						}
						if(arrivedCustomers.size() == 0) {
							text.append(Integer.toString(time) + ": " + this.toString() + "empty\n");
						} else {
							text.append(Integer.toString(time) + ": " + this.toString());
							Iterator<Customer> arrivedIt = this.arrivedCustomers.iterator();
							while(arrivedIt.hasNext()) {
								if(arrivedCustomers.size() > maxCustomers) {
									maxCustomers = arrivedCustomers.size();
									peakTime = time;
								}
								Customer arrived = arrivedIt.next();
								if(arrived == arrivedCustomers.getFirst()) {
									text.append(arrived.toString());
									arrived.decServiceTime();
									if(arrived.getServiceTime()==0) {
										arrivedIt.remove();
										waitTime = waitTime + arrived.getWaitingTime();
									}									
								} else {
									text.append(arrived.toString());
									arrived.incWaitingTime();
								}
								
							}
							text.append("\n");
						}

						check.setCheck(check.getCheck() + 1);
						check.notifyAll();
						if(check.getCheck() > nrCozi - 1) {
							check.setCheck(0);
						}
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	//}
	
}
