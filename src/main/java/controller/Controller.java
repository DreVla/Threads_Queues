/**
vlad
Mar 26, 2018

*/

package controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import model.Coada;
import model.Customer;
import model.Simulare;
import model.TurnCheck;
import view.SimulationGui;

public class Controller {
	private SimulationGui simGui;
	LinkedList<Customer> myCustomers = new LinkedList<Customer>();
	ArrayList<Coada> myQueues = new ArrayList<Coada>();
	private Simulare sim;
	private TurnCheck check = new TurnCheck();
	public Controller() {
		simGui = new SimulationGui();
		simGui.startPressed(e->{
			int nrClienti = Integer.parseInt(simGui.getValNrClienti());
			int nrCozi = Integer.parseInt(simGui.getValNrCozi());
			int minArrival = Integer.parseInt(simGui.getValMinArrival());
			int maxArrival = Integer.parseInt(simGui.getValMaxArrival());
			int minService = Integer.parseInt(simGui.getValMinService());
			int maxService = Integer.parseInt(simGui.getValMaxService());
			int simTime = Integer.parseInt(simGui.getValSimTime());
			Random rand = new Random();
			for(int i = 0; i < nrClienti; i++) {
				myCustomers.add(new Customer(i, rand.nextInt(maxArrival) + 
						minArrival, rand.nextInt(maxService) + minService));
			}
			for(int i = 0; i < nrCozi; i++) {
				myQueues.add(new Coada(i, simGui.getStatusText(), simTime, simGui.getSimulationTime(), check, nrCozi));
			}
			for(Customer c: myCustomers) {
				myQueues.get(rand.nextInt(nrCozi) + 0).enqueue(c);
			}
			sim = new Simulare(myQueues, simTime);
			Thread simulare = new Thread(sim);
			simulare.start();
		});
	}
}
