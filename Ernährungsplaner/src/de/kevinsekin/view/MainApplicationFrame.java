package de.kevinsekin.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import de.kevinsekin.control.ActionQueue;

import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainApplicationFrame extends JFrame {

	private JPanel contentPane;
	private JTabbedPane creationTabs;
	private JTabbedPane viewingTabs;
	
	/**
	 * Launch & close creation UI
	 */
	public void CreationUIStart()
	{
		creationTabs.setVisible(true);
	}
	public void CreationUIStop()
	{
		creationTabs.setVisible(false);
	}
	
	/**
	 * Launch & close viewing UI
	 */
	public void ViewingUIStart()
	{
		viewingTabs.setVisible(true);
	}
	public void ViewingUIStop()
	{
		viewingTabs.setVisible(false);
	}
	
	/**
	 * Getters for Tabs for Logic
	 */
	
	public JTabbedPane getCreationTabs()
	{
		return creationTabs;
	}
	
	public JTabbedPane getViewingTabs()
	{
		return viewingTabs;
	}

	/**
	 * Create the frame.
	 */
	public MainApplicationFrame(ActionQueue ActionQueue) {
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setName("Ernährungsplaner");
		setTitle("Ernährungsplaner");
		setBounds(100,100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}
		
		creationTabs = new JTabbedPane(JTabbedPane.TOP);
		creationTabs.setBounds(0, 0, 784, 561);
		contentPane.add(creationTabs);
		creationTabs.add("Nahrungsmittel",new NahrungsmittelCreation(ActionQueue));
		creationTabs.add("Makrogruppe", new MakrogruppeCreation(ActionQueue));
		creationTabs.setVisible(false);
		
		viewingTabs = new JTabbedPane(JTabbedPane.TOP);
		viewingTabs.setBounds(0, 0, 784, 561);
		contentPane.add(viewingTabs);
		viewingTabs.add("Nahrungsmittel Liste",new NahrungsmittelListViewing(ActionQueue));
		viewingTabs.setVisible(false);
		
		setVisible(true);
		setLocationRelativeTo(null); // fix for multi monitor setup
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-400, dim.height/2-300);
	}
}
