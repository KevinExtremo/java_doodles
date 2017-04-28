package de.kevinsekin.view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import de.kevinsekin.control.ActionQueue;
import de.kevinsekin.model.Action;
import de.kevinsekin.model.ActionData;
import de.kevinsekin.model.ActionType;
import de.kevinsekin.model.Makrogruppe;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class NahrungsmittelCreation extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JComboBox<Makrogruppe> comboBox;
	private JTextArea textArea; 

	/**
	 * Create the panel.
	 */
	public NahrungsmittelCreation(ActionQueue ActionQueue) {
		setLayout(null);
		setBounds(0,0,784,561);
		
		textField = new JTextField();
		textField.setBounds(50, 150, 352, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblErstelleEinNahrungsmittel = new JLabel("Erstelle ein Nahrungsmittel");
		lblErstelleEinNahrungsmittel.setFont(new Font("Arial", Font.BOLD, 17));
		lblErstelleEinNahrungsmittel.setBounds(50, 50, 243, 29);
		add(lblErstelleEinNahrungsmittel);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Arial", Font.PLAIN, 12));
		lblName.setBounds(50, 125, 46, 14);
		add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(50, 210, 352, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblKcal = new JLabel("Kcal:");
		lblKcal.setFont(new Font("Arial", Font.PLAIN, 12));
		lblKcal.setBounds(50, 185, 46, 14);
		add(lblKcal);
		
		textField_2 = new JTextField();
		textField_2.setBounds(51, 270, 351, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblKohlenhydrateInGramm = new JLabel("Kohlenhydrate in Gramm:");
		lblKohlenhydrateInGramm.setFont(new Font("Arial", Font.PLAIN, 12));
		lblKohlenhydrateInGramm.setBounds(50, 245, 210, 14);
		add(lblKohlenhydrateInGramm);
		
		textField_3 = new JTextField();
		textField_3.setBounds(50, 330, 352, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblProteineInGramm = new JLabel("Proteine in Gramm:");
		lblProteineInGramm.setFont(new Font("Arial", Font.PLAIN, 12));
		lblProteineInGramm.setBounds(50, 305, 243, 14);
		add(lblProteineInGramm);
		
		textField_4 = new JTextField();
		textField_4.setBounds(50, 390, 352, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblFetteInGramm = new JLabel("Fette in Gramm:");
		lblFetteInGramm.setFont(new Font("Arial", Font.PLAIN, 12));
		lblFetteInGramm.setBounds(50, 365, 188, 14);
		add(lblFetteInGramm);
		
		comboBox = new JComboBox<Makrogruppe>();
		comboBox.setBounds(50, 450, 352, 20);
		add(comboBox);
		
		JLabel lblMakrogruppe = new JLabel("Makrogruppe:");
		lblMakrogruppe.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMakrogruppe.setBounds(50, 425, 229, 14);
		add(lblMakrogruppe);
		
		JButton btnNewButton = new JButton("Hinzuf\u00FCgen");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<ActionData> DataList = new ArrayList<ActionData>();
				DataList.add(new ActionData("Name", textField.getText()));
				DataList.add(new ActionData("Kcal", textField_1.getText()));
				DataList.add(new ActionData("Kohlenhydrate", textField_2.getText()));
				DataList.add(new ActionData("Proteine", textField_3.getText()));
				DataList.add(new ActionData("Fette", textField_4.getText()));
				DataList.add(new ActionData("Makrogruppe", comboBox.getSelectedItem()));
				ActionQueue.push(new Action("NahrungsmittelHinzufügenButtonAction",DataList,ActionType.CREATION_ACTION));
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(450, 150, 280, 50);
		add(btnNewButton);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(450, 210, 280, 200);
		add(textArea);
		
		JButton btnNewButton_1 = new JButton("Best\u00E4tigen");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<ActionData> DataList = new ArrayList<ActionData>();
				DataList.add(new ActionData("Name", textField.getText()));
				DataList.add(new ActionData("Kcal", textField_1.getText()));
				DataList.add(new ActionData("Kohlenhydrate", textField_2.getText()));
				DataList.add(new ActionData("Proteine", textField_3.getText()));
				DataList.add(new ActionData("Fette", textField_4.getText()));
				DataList.add(new ActionData("Makrogruppe", comboBox.getSelectedItem()));
				ActionQueue.push(new Action("NahrungsmittelBestätigenButtonAction",DataList,ActionType.CREATION_ACTION));
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_1.setBounds(450, 420, 280, 50);
		add(btnNewButton_1);
	}
	
	public JComboBox<Makrogruppe> getComboBox()
	{
		return comboBox;
	}
	public JTextArea getTextArea()
	{
		return textArea;
	}
}
