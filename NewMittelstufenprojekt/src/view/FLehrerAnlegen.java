package view;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
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
public class FLehrerAnlegen extends javax.swing.JFrame {
	private JLabel jTitel;
	private JLabel jVorname;
	private JTextField jTextVorname;
	private JButton jAnlegen;
	private JTextField jTextNachname;
	private JPasswordField jTextPassword;
	private JLabel jPasswort;
	private JLabel jNachname;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FLehrerAnlegen inst = new FLehrerAnlegen();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FLehrerAnlegen() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setFocusTraversalKeysEnabled(false);
			this.setPreferredSize(new java.awt.Dimension(253, 251));
			this.setMinimumSize(new java.awt.Dimension(253, 251));
			{
				jTitel = new JLabel();
				getContentPane().add(jTitel);
				jTitel.setText("Lehrer anlegen");
				jTitel.setBounds(62, 0, 124, 29);
				jTitel.setFont(new java.awt.Font("Tahoma",1,16));
			}
			{
				jVorname = new JLabel();
				getContentPane().add(jVorname);
				jVorname.setText("Vorname: ");
				jVorname.setBounds(12, 46, 96, 15);
			}
			{
				jNachname = new JLabel();
				getContentPane().add(jNachname);
				jNachname.setText("Nachname: ");
				jNachname.setBounds(12, 73, 96, 15);
			}
			{
				jPasswort = new JLabel();
				getContentPane().add(jPasswort);
				jPasswort.setText("Passwort: ");
				jPasswort.setBounds(12, 100, 96, 15);
			}
			{
				jTextVorname = new JTextField();
				getContentPane().add(jTextVorname);
				jTextVorname.setBounds(83, 43, 150, 22);
				jTextVorname.setPreferredSize(new java.awt.Dimension(150, 22));
			}
			{
				jTextPassword = new JPasswordField();
				getContentPane().add(jTextPassword);
				jTextPassword.setBounds(83, 97, 150, 22);
			}
			{
				jTextNachname = new JTextField();
				getContentPane().add(jTextNachname);
				jTextNachname.setBounds(83, 70, 150, 22);
			}
			{
				jAnlegen = new JButton();
				getContentPane().add(jAnlegen);
				jAnlegen.setText("Anlegen");
				jAnlegen.setBounds(-5, 188, 255, 22);
			}
			pack();
			this.setSize(253, 251);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
