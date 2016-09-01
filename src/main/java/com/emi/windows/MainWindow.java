package com.emi.windows;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	public MainWindow() {
		setLayout(null);

		Button but45 = new Button("45");
		Button but60 = new Button("60");
		Button but90 = new Button("90");
		Button butCancel = new Button("Cancel");
		Button butExit = new Button("Exit");

		but45.setBounds(10, 10, 100, 40);
		but45.addActionListener(createTimerActionListener(but45.getLabel()));
		but60.setBounds(120, 10, 100, 40);
		but60.addActionListener(createTimerActionListener(but60.getLabel()));
		but90.setBounds(230, 10, 100, 40);
		but90.addActionListener(createTimerActionListener(but90.getLabel()));
		
		butCancel.setBounds(60, 60, 100, 40);
		butCancel.addActionListener(createCancelActionListener());
		butExit.setBounds(180, 60, 100, 40);
		butExit.addActionListener(createExitActionListener());
		
		

		add(but45);
		add(but60);
		add(but90);
		add(butCancel);
		add(butExit);
	}

	private ActionListener createTimerActionListener(String timeString){
		int time = Integer.parseInt(timeString);
		return new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				timer(time);
			}
		};
	}
	
	private ActionListener createCancelActionListener(){
		return new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				cancel();
			}
		};
	}
	
	private ActionListener createExitActionListener(){
		return new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				exit();
			}
		};
	}
	
	private void timer(int time) {
		final String command = new String("shutdown -s -t " + (time*60));
		executeCommand(command);
	}
	
	private void cancel() {
		final String command = new String("shutdown -a");
		executeCommand(command);
	}
	
	private void exit() {
		System.exit(0);
	}
	
	private void executeCommand(String command) {
		try {
			Runtime.getRuntime().exec(command);
		} catch (Exception e) {
			
		}
	}
}