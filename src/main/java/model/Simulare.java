/**
vlad
Mar 25, 2018

*/

package model;

import java.util.ArrayList;

public class Simulare implements Runnable{
	private ArrayList<Coada> queues = new ArrayList<Coada>();
	
	public Simulare(ArrayList<Coada> queues, int simTime) {
		this.queues = queues;
	}
	
	public void run() {
		for(Coada q: queues) {
			Thread myQueue = new Thread(q);
			myQueue.start();
		}
	}
}
