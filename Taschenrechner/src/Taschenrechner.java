import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
public class Taschenrechner extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JButton Eins;
	private JButton Zwei;
	private JButton Drei;
	private JButton Multiplizieren;
	private JButton Dividieren;
	private JButton Minus;
	private JButton Plus;
	private JTextField Ausgabe;
	private JButton Gleich;
	private JButton Punkt;
	private JButton Null;
	private JButton Neun;
	private JButton Acht;
	private JButton Sieben;
	private JButton Sechs;
	private JButton Fuenf;
	private JButton Vier;
	private double Zwischenwert = 0;
	private int lastaction = 0;
	private boolean Nochmal = false;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Taschenrechner inst = new Taschenrechner();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Taschenrechner() {
		super("Taschenrechner made by Extremo");
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(265, 272));
			this.setMaximumSize(new java.awt.Dimension(265, 272));
			{
				Eins = new JButton();
				getContentPane().add(Eins);
				Eins.setText("1");
				Eins.setBounds(15, 93, 46, 26);
				Eins.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						EinsActionPerformed(evt);
					}
				});
			}
			{
				Zwei = new JButton();
				getContentPane().add(Zwei);
				Zwei.setText("2");
				Zwei.setBounds(70, 93, 46, 26);
				Zwei.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						ZweiActionPerformed(evt);
					}
				});
			}
			{
				Drei = new JButton();
				getContentPane().add(Drei);
				Drei.setText("3");
				Drei.setBounds(121, 93, 46, 26);
				Drei.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						DreiActionPerformed(evt);
					}
				});
			}
			{
				Vier = new JButton();
				getContentPane().add(Vier);
				Vier.setText("4");
				Vier.setBounds(15, 130, 46, 26);
				Vier.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						VierActionPerformed(evt);
					}
				});
			}
			{
				Fuenf = new JButton();
				getContentPane().add(Fuenf);
				Fuenf.setText("5");
				Fuenf.setBounds(70, 130, 46, 26);
				Fuenf.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						FuenfActionPerformed(evt);
					}
				});
			}
			{
				Sechs = new JButton();
				getContentPane().add(Sechs);
				Sechs.setText("6");
				Sechs.setBounds(121, 130, 46, 26);
				Sechs.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						SechsActionPerformed(evt);
					}
				});
			}
			{
				Sieben = new JButton();
				getContentPane().add(Sieben);
				Sieben.setText("7");
				Sieben.setBounds(15, 167, 46, 26);
				Sieben.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						SiebenActionPerformed(evt);
					}
				});
			}
			{
				Acht = new JButton();
				getContentPane().add(Acht);
				Acht.setText("8");
				Acht.setBounds(70, 167, 46, 26);
				Acht.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						AchtActionPerformed(evt);
					}
				});
			}
			{
				Neun = new JButton();
				getContentPane().add(Neun);
				Neun.setText("9");
				Neun.setBounds(121, 167, 46, 26);
				Neun.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						NeunActionPerformed(evt);
					}
				});
			}
			{
				Null = new JButton();
				getContentPane().add(Null);
				Null.setText("0");
				Null.setBounds(70, 207, 46, 26);
				Null.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						NullActionPerformed(evt);
					}
				});
			}
			{
				Punkt = new JButton();
				getContentPane().add(Punkt);
				Punkt.setText(".");
				Punkt.setBounds(121, 207, 46, 26);
				Punkt.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						PunktActionPerformed(evt);
					}
				});
			}
			{
				Gleich = new JButton();
				getContentPane().add(Gleich);
				Gleich.setText("=");
				Gleich.setBounds(15, 207, 46, 26);
				Gleich.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						GleichActionPerformed(evt);
					}
				});
			}
			{
				Ausgabe = new JTextField();
				getContentPane().add(Ausgabe);
				Ausgabe.setText("");
				Ausgabe.setBounds(21, 30, 211, 37);
				Ausgabe.setHorizontalAlignment(SwingConstants.RIGHT);
				Ausgabe.setEditable(false);
			}
			{
				Plus = new JButton();
				getContentPane().add(Plus);
				Plus.setText("+");
				Plus.setBounds(172, 95, 65, 22);
				Plus.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						PlusActionPerformed(evt);
					}
				});
			}
			{
				Minus = new JButton();
				getContentPane().add(Minus);
				Minus.setText("-");
				Minus.setBounds(172, 132, 65, 22);
				Minus.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						MinusActionPerformed(evt);
					}
				});
			}
			{
				Dividieren = new JButton();
				getContentPane().add(Dividieren);
				Dividieren.setText("/");
				Dividieren.setBounds(172, 169, 65, 22);
				Dividieren.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						DividierenActionPerformed(evt);
					}
				});
			}
			{
				Multiplizieren = new JButton();
				getContentPane().add(Multiplizieren);
				Multiplizieren.setText("*");
				Multiplizieren.setBounds(172, 209, 65, 22);
				Multiplizieren.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						MultiplizierenActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(265, 272);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void EinsActionPerformed(ActionEvent evt) {
		String s = Ausgabe.getText();
		s = s+"1";
		Ausgabe.setText(s);
	}
	private void ZweiActionPerformed(ActionEvent evt) {
		String s = Ausgabe.getText();
		s = s+"2";
		Ausgabe.setText(s);
	}
	private void DreiActionPerformed(ActionEvent evt) {
		String s = Ausgabe.getText();
		s = s+"3";
		Ausgabe.setText(s);
	}
	private void VierActionPerformed(ActionEvent evt) {
		String s = Ausgabe.getText();
		s = s+"4";
		Ausgabe.setText(s);
	}
	private void FuenfActionPerformed(ActionEvent evt) {
		String s = Ausgabe.getText();
		s = s+"5";
		Ausgabe.setText(s);
	}
	private void SechsActionPerformed(ActionEvent evt) {
		String s = Ausgabe.getText();
		s = s+"6";
		Ausgabe.setText(s);
	}
	private void SiebenActionPerformed(ActionEvent evt) {
		String s = Ausgabe.getText();
		s = s+"7";
		Ausgabe.setText(s);
	}
	private void AchtActionPerformed(ActionEvent evt) {
		String s = Ausgabe.getText();
		s = s+"8";
		Ausgabe.setText(s);
	}
	private void NeunActionPerformed(ActionEvent evt) {
		String s = Ausgabe.getText();
		s = s+"9";
		Ausgabe.setText(s);
	}
	private void NullActionPerformed(ActionEvent evt) {
		String s = Ausgabe.getText();
		s = s+"0";
		Ausgabe.setText(s);
	}
	private void PunktActionPerformed(ActionEvent evt) {
		String s = Ausgabe.getText();
		s = s+".";
		Ausgabe.setText(s);
	}
	private void GleichActionPerformed(ActionEvent evt) {
		double Wert = Double.parseDouble(Ausgabe.getText());
		if(lastaction == 1)
		{
			Zwischenwert = Zwischenwert+Wert;
		}
		if(lastaction == 2)
		{
			Zwischenwert = Zwischenwert-Wert;
		}
		if(lastaction == 3)
		{
			Zwischenwert = Zwischenwert/Wert;
		}
		if(lastaction == 4)
		{
			Zwischenwert = Zwischenwert*Wert;
		}
		String s = Double.toString(Zwischenwert);
		Ausgabe.setText(s);
		if(lastaction == 0 && Nochmal)
		{
			Ausgabe.setText(" ");
			Zwischenwert = 0;
		}
		Nochmal = true;
		lastaction = 0;
	}
	private void PlusActionPerformed(ActionEvent evt) {
		double Wert = Double.parseDouble(Ausgabe.getText());
		Zwischenwert = Zwischenwert+Wert;
		Ausgabe.setText("");
		lastaction = 1;
	}
	private void MinusActionPerformed(ActionEvent evt) {
		double Wert = Double.parseDouble(Ausgabe.getText());
		Zwischenwert = Zwischenwert-Wert;
		Ausgabe.setText("");
		lastaction = 2;
	}
	private void DividierenActionPerformed(ActionEvent evt) {
		double Wert = Double.parseDouble(Ausgabe.getText());
		Zwischenwert = Zwischenwert/Wert;
		Ausgabe.setText("");
		lastaction = 3;
	}
	private void MultiplizierenActionPerformed(ActionEvent evt) {
		double Wert = Double.parseDouble(Ausgabe.getText());
		Zwischenwert = Zwischenwert*Wert;
		Ausgabe.setText("");
		lastaction = 4;
	}
	

}
