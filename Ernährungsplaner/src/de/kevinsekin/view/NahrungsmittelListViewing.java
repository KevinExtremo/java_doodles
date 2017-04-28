package de.kevinsekin.view;

import javax.swing.JPanel;

import de.kevinsekin.control.ActionQueue;
import de.kevinsekin.model.Action;
import de.kevinsekin.model.ActionData;
import de.kevinsekin.model.ActionType;
import de.kevinsekin.model.Makrogruppe;
import de.kevinsekin.model.Nahrungsmittel;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class NahrungsmittelListViewing extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList<Nahrungsmittel> list = null;
	private JComboBox<Makrogruppe> comboBox;
	/**
	 * Create the panel.
	 */
	public NahrungsmittelListViewing(ActionQueue ActionQueue) 
	{
		setLayout(null);
		setBounds(0,0,784,561);
		
		JLabel lblListeDerNahrungsmittel = new JLabel("Liste der Nahrungsmittel");
		lblListeDerNahrungsmittel.setFont(new Font("Arial", Font.BOLD, 17));
		lblListeDerNahrungsmittel.setBounds(50, 50, 243, 29);
		add(lblListeDerNahrungsmittel);
		
		comboBox = new JComboBox<Makrogruppe>();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) 
			{
				if(arg0.getStateChange() == ItemEvent.SELECTED)
				{
					Object selectedItem = arg0.getItem();
					ArrayList<ActionData> DataList = new ArrayList<ActionData>();
					DataList.add(new ActionData("SelectedItem", selectedItem));
					ActionQueue.push(new Action("LoadNahrungsmittelViewing", DataList, ActionType.VIEWING_ACTION));
				}
			}
		});
		comboBox.setBounds(534, 90, 200, 20);
		add(comboBox);
		

	}
	/**
	 * Create list with data
	 */
	public void CreateAndFillList(ArrayList<Nahrungsmittel> nList)
	{
		if(list!=null) list.removeAll();
		DefaultListModel<Nahrungsmittel> listModel = new DefaultListModel<Nahrungsmittel>();
		for(Nahrungsmittel n : nList)
		{
			listModel.addElement(n);
		}
		list = new JList<Nahrungsmittel>(listModel);
		list.setBounds(50, 110, 684, 380);
		add(list);
	}
	
	public JComboBox<Makrogruppe> getComboBox()
	{
		return comboBox;
	}
}
