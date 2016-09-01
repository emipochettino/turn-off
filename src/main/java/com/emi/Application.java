package com.emi;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

import com.emi.windows.MainWindow;

public class Application {

	public static void main(String[] args) {
		MainWindow mw = new MainWindow();
		mw.setTitle("Power Off");
		mw.setVisible(true);
		mw.setSize(350, 145);
		mw.setLocationRelativeTo(createDummyComponent(getBiggestDisplayConfig()));
		mw.setVisible(true);
		mw.setResizable(false);
	}

	private static GraphicsConfiguration getBiggestDisplayConfig() {
		final GraphicsDevice[] gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
		GraphicsConfiguration displayConfig = null;
		if (gd.length > 1) {
			if (gd[0].getDisplayMode().getWidth() >= gd[1].getDisplayMode().getWidth()) {
				displayConfig = gd[0].getDefaultConfiguration();
			} else {
				displayConfig = gd[1].getDefaultConfiguration();
			}
		} else {
			displayConfig = gd[0].getDefaultConfiguration();
		}
		
		return displayConfig;
	}
	
	private static JFrame createDummyComponent(GraphicsConfiguration gc){
		return new JFrame(gc);
	}

}
