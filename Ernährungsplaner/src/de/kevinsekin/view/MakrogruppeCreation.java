package de.kevinsekin.view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import de.kevinsekin.control.ActionQueue;
import de.kevinsekin.model.Action;
import de.kevinsekin.model.ActionData;
import de.kevinsekin.model.ActionType;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class MakrogruppeCreation extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextArea textArea;

	/**
	 * Create the panel.
	 */
	public MakrogruppeCreation(ActionQueue ActionQueue) {
		setLayout(null);
		setBounds(0,0,784,561);
		
		textField = new JTextField();
		textField.setBounds(50, 150, 352, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Arial", Font.PLAIN, 12));
		lblName.setBounds(50, 125, 46, 14);
		add(lblName);
		
		JLabel lblErstelleEineMakrogruppe = new JLabel("Erstelle eine Makrogruppe");
		lblErstelleEineMakrogruppe.setFont(new Font("Arial", Font.BOLD, 17));
		lblErstelleEineMakrogruppe.setBounds(50, 50, 243, 29);
		add(lblErstelleEineMakrogruppe);
		
		JButton btnHinzufgen = new JButton("Hinzuf\u00FCgen");
		btnHinzufgen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<ActionData> DataList = new ArrayList<ActionData>();
				DataList.add(new ActionData("Name", textField.getText()));
				ActionQueue.push(new Action("MakrogruppeHinzufügenButtonAction",DataList,ActionType.CREATION_ACTION));
			}
		});
		btnHinzufgen.setFont(new Font("Arial", Font.BOLD, 14));
		btnHinzufgen.setBounds(450, 150, 280, 50);
		add(btnHinzufgen);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(450, 210, 280, 200);
		add(textArea);
		
		JButton btnBesttigen = new JButton("Best\u00E4tigen");
		btnBesttigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<ActionData> DataList = new ArrayList<ActionData>();
				DataList.add(new ActionData("Name", textField.getText()));
				ActionQueue.push(new Action("MakrogruppeBestätigenButtonAction",DataList,ActionType.CREATION_ACTION));
			}
		});
		btnBesttigen.setFont(new Font("Arial", Font.BOLD, 14));
		btnBesttigen.setBounds(450, 420, 280, 50);
		add(btnBesttigen);
	}
	public JTextArea getTextArea()
	{
		return textArea;
	}
}
