import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class Waehrungsrechner extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JLabel Name;
	private JButton Pounds;
	private JButton Yen;
	private JButton Dollar;
	private JTextField Ausgabe;
	private JTextField Eingabe;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Waehrungsrechner inst = new Waehrungsrechner();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Waehrungsrechner() {
		super("Waehrungsrechner made by Extremo");
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setMinimumSize(new java.awt.Dimension(387, 262));
			{
				Name = new JLabel();
				getContentPane().add(Name);
				Name.setText("Waehrungsrechner");
				Name.setBounds(49, 12, 371, 38);
				Name.setFont(new java.awt.Font("Monotype Corsiva",3,36));
			}
			{
				Eingabe = new JTextField();
				getContentPane().add(Eingabe);
				Eingabe.setBounds(12, 136, 89, 28);
			}
			{
				Ausgabe = new JTextField();
				getContentPane().add(Ausgabe);
				Ausgabe.setBounds(281, 136, 89, 28);
			}
			{
				Dollar = new JButton();
				getContentPane().add(Dollar);
				Dollar.setText("Dollar");
				Dollar.setBounds(148, 94, 72, 34);
				Dollar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						DollarActionPerformed(evt);
					}
				});
			}
			{
				Yen = new JButton();
				getContentPane().add(Yen);
				Yen.setText("Yen");
				Yen.setBounds(148, 139, 72, 34);
				Yen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						YenActionPerformed(evt);
					}
				});
			}
			{
				Pounds = new JButton();
				getContentPane().add(Pounds);
				Pounds.setText("Pounds");
				Pounds.setBounds(148, 184, 72, 34);
				Pounds.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						PoundsActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(387, 262);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private double runden(double var)
	{
		var = Math.floor(var*10000)/10000.0; 
		return var;
	}
	private void DollarActionPerformed(ActionEvent evt) {
		String s = Eingabe.getText();
		double Wert = Double.parseDouble(s);
		Wert = Wert * 1.5814;
		Ausgabe.setText(Double.toString(runden(Wert)));
	}
	
	private void YenActionPerformed(ActionEvent evt) {
		String s = Eingabe.getText();
		double Wert = Double.parseDouble(s);
		Wert = Wert * 157.3839;
		Ausgabe.setText(Double.toString(runden(Wert)));
	}
	
	private void PoundsActionPerformed(ActionEvent evt) {
		String s = Eingabe.getText();
		double Wert = Double.parseDouble(s);
		Wert = Wert * 0.7954;
		Ausgabe.setText(Double.toString(runden(Wert)));
	}

}
