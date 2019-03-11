/**
vlad
Mar 26, 2018

*/

package view;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SimulationGui extends JFrame{
	
	private JPanel panel;
	private JLabel labelNrClienti, labelNrCozi;
	private JTextField valNrClienti, valNrCozi;
	private JLabel labelArrivalTime, labelMinArrival, labelMaxArrival;
	private JTextField valMinArrival, valMaxArrival;
	private JLabel labelServiceTime, labelMinService, labelMaxService;
	private JTextField valMinService, valMaxService;
	private JButton startSimulation;
	private JTextArea statusText;
	private JScrollPane scroll;
	private JLabel labelSimTime;
	private JTextField valSimTime;
	private JLabel simulationTimeText;
	private JLabel simulationTime;
	
	public SimulationGui() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setBounds(100,100,1000,550); 
		panel = new JPanel(); 
		panel.setLayout(null); 
		Font arialFont = new Font("Arial", Font.BOLD, 15);
		this.setTitle("Queue Simulations");
		labelNrClienti = new JLabel("Insert number of customers:");
		labelNrClienti.setBounds(10,10,200,20);
		labelNrClienti.setFont(arialFont);
		panel.add(labelNrClienti);
		valNrClienti = new JTextField();
		valNrClienti.setBounds(10,40,100,30);
		valNrClienti.setFont(arialFont);
		panel.add(valNrClienti);
		labelNrCozi = new JLabel("Insert number of queues:");
		labelNrCozi.setBounds(10,70,200,20);
		labelNrCozi.setFont(arialFont);
		panel.add(labelNrCozi);
		valNrCozi = new JTextField();
		valNrCozi.setBounds(10,100,100,30);
		valNrCozi.setFont(arialFont);
		panel.add(valNrCozi);
		labelArrivalTime = new JLabel("Insert min and max arrival times:");
		labelArrivalTime.setBounds(10,150,300,30);
		labelArrivalTime.setFont(arialFont);
		panel.add(labelArrivalTime);
		labelMinArrival = new JLabel("Min:");
		labelMinArrival.setBounds(10,190,50,30);
		labelMinArrival.setFont(arialFont);
		panel.add(labelMinArrival);
		valMinArrival = new JTextField();
		valMinArrival.setBounds(45,190,50,30);
		valMinArrival.setFont(arialFont);
		panel.add(valMinArrival);
		labelMaxArrival = new JLabel("Max:");
		labelMaxArrival.setBounds(100,190,50,30);
		labelMaxArrival.setFont(arialFont);
		panel.add(labelMaxArrival);
		valMaxArrival = new JTextField();
		valMaxArrival.setBounds(135,190,50,30);
		valMaxArrival.setFont(arialFont);
		panel.add(valMaxArrival);
		labelServiceTime = new JLabel("Insert min and max service times:");
		labelServiceTime.setBounds(10,230,300,30);
		labelServiceTime.setFont(arialFont);
		panel.add(labelServiceTime);
		labelMinService = new JLabel("Min:");
		labelMinService.setBounds(10,270,50,30);
		labelMinService.setFont(arialFont);
		panel.add(labelMinService);
		valMinService = new JTextField();
		valMinService.setBounds(45,270,50,30);
		valMinService.setFont(arialFont);
		panel.add(valMinService);
		labelMaxService = new JLabel("Max:");
		labelMaxService.setBounds(100,270,50,30);
		labelMaxService.setFont(arialFont);
		panel.add(labelMaxService);
		valMaxService = new JTextField();
		valMaxService.setBounds(135,270,50,30);
		valMaxService.setFont(arialFont);
		panel.add(valMaxService);
		labelSimTime = new JLabel("Enter the simulation time: ");
		labelSimTime.setBounds(10,310,200,30);
		labelSimTime.setFont(arialFont);
		panel.add(labelSimTime);
		valSimTime = new JTextField();
		valSimTime.setBounds(10,350,50,30);
		valSimTime.setFont(arialFont);
		panel.add(valSimTime);
		startSimulation = new JButton("Start Simulation");
		startSimulation.setBounds(10,390,200,30);
		panel.add(startSimulation);
		simulationTimeText = new JLabel("Simulation Time:");
		simulationTimeText.setFont(new Font("Arial", Font.BOLD, 25));
		simulationTimeText.setBounds(300,440,200,30);
		panel.add(simulationTimeText);
		simulationTime = new JLabel("");
		simulationTime.setFont(new Font("Arial", Font.BOLD, 25));
		simulationTime.setBounds(520,440,200,30);
		panel.add(simulationTime);
		statusText = new JTextArea("Here is the log of events: \n");
		statusText.setBounds(270,10,500,400);
		statusText.setEditable(false);
		scroll = new JScrollPane(statusText);
		scroll.setBounds(270,10,700,400);
		panel.add(scroll);
		this.add(panel);
		this.setVisible(true);
	}

	public JTextArea getStatusText() {
		return statusText;
	}

	public String getValNrClienti() {
		return valNrClienti.getText();
	}

	public String getValNrCozi() {
		return valNrCozi.getText();
	}

	public String getValMinArrival() {
		return valMinArrival.getText();
	}

	public String getValMaxArrival() {
		return valMaxArrival.getText();
	}

	public String getValMinService() {
		return valMinService.getText();
	}

	public String getValMaxService() {
		return valMaxService.getText();
	}
	
	public String getValSimTime() {
		return valSimTime.getText();
	}
	
	public void writeStatus(String s) {
		statusText.append(s);
	}
	
	public void writeSimTime(String s) {
		simulationTime.setText(s);
	}
	
	public JLabel getSimulationTime() {
		return simulationTime;
	}

	public void startPressed(ActionListener e) {
		startSimulation.addActionListener(e);
	}
	
	
}
