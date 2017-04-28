package GUI;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import action.CInteractions;

import DAO.LehrerDAO;
import Model.CLehrer;
import Model.CLernbuero;
import Model.CLernbuerogruppe;
import Model.CSchueler;


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
public class NewJFrame extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JLabel jLabelBenutzer;
	private JLabel jLabelFehler;
	private JButton jButtonLogin;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JLabel jLabelPasswort;
	private JPasswordField jPasswordFieldLogin;
	private JTextField jTextFieldBenutzer;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				NewJFrame inst = new NewJFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public NewJFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(352, 201));
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Willkommen beim Anwesenheitssystem der ");
				jLabel1.setBounds(50, 12, 279, 29);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Gesamtschule Bremen Mitte ");
				jLabel2.setBounds(92, 47, 185, 16);
			}
			{
				jLabelBenutzer = new JLabel();
				getContentPane().add(jLabelBenutzer);
				jLabelBenutzer.setText("Benutzer:");
				jLabelBenutzer.setBounds(12, 108, 73, 16);
			}
			{
				jLabelPasswort = new JLabel();
				getContentPane().add(jLabelPasswort);
				jLabelPasswort.setText("Passwort:");
				jLabelPasswort.setBounds(12, 134, 80, 16);
			}
			{
				jTextFieldBenutzer = new JTextField();
				getContentPane().add(jTextFieldBenutzer);
				jTextFieldBenutzer.setBounds(85, 106, 122, 20);
			}
			{
				jPasswordFieldLogin = new JPasswordField();
				getContentPane().add(jPasswordFieldLogin);
				jPasswordFieldLogin.setBounds(85, 132, 122, 20);
			}
			{
				jButtonLogin = new JButton();
				getContentPane().add(jButtonLogin);
				jButtonLogin.setText("Login ");
				jButtonLogin.setBounds(219, 100, 102, 52);
				jButtonLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButtonLoginActionPerformed(evt);
					}
				});
			}
			{
				jLabelFehler = new JLabel();
				getContentPane().add(jLabelFehler);
				jLabelFehler.setText("Der Benutzer oder das Passwort ist inkorrekt!");
				jLabelFehler.setBounds(12, 74, 260, 16);
				jLabelFehler.setForeground(Color.red);
				jLabelFehler.setVisible(false);
			}
			pack();
			this.setSize(352, 201);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void jButtonLoginActionPerformed(ActionEvent evt) 
	{
		CLehrer l = new CLehrer();
		l.setLname("Sekin");
		l.setLvorname("Kevin");
		l.setPasswort("12345");
		CLernbuero lerb = new CLernbuero();
		CLernbuerogruppe lerbg = new CLernbuerogruppe();
		lerbg.setLernbgbez("lol");
		lerb.setLbgruppeID(lerbg);
		lerb.setLernbbez("lol");
		l.setIstSuperUser(false);
		l.setLbid(lerb);
		LehrerDAO ld = new LehrerDAO();
		ld.anlegen(l);
		CInteractions inter = new CInteractions();
		String names[] = jTextFieldBenutzer.getText().split(" ");
		if(names.length==2&&jPasswordFieldLogin.getPassword().toString().isEmpty()==false)
		{
			LehrerDAO ldao = new LehrerDAO();
			CLehrer lehrer = ldao.find(names);
			System.out.println(lehrer);
			if(lehrer!=null)
			{
				if(inter.LehrerLogin(lehrer, jPasswordFieldLogin.toString()))
				{
					System.out.println("Lehrer angelegt");
					jLabelFehler.setVisible(false);
					return;
				}
				jLabelFehler.setVisible(true);
				return;
			}
			jLabelFehler.setVisible(true);
		}
		jLabelFehler.setVisible(true);
	}

}
