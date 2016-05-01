package yaml;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import com.cloudgarden.layout.AnchorLayout;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class MainGui extends javax.swing.JFrame {

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JMenuBar File;
	private JMenu jMenu1;
	private JTextPane Text;
	private JMenu OpenFile;
	private JMenu jMenu2;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainGui inst = new MainGui();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public MainGui() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				Text = new JTextPane();
				getContentPane().add(Text, BorderLayout.CENTER);
				Text.setText("Text");
				// Text.addMouseListener((MouseListener) this);
			}
			{
				File = new JMenuBar();
				setJMenuBar(getFile());
				{
					jMenu1 = new JMenu();
					File.add(jMenu1);
					jMenu1.setText("File");
					{
						OpenFile = new JMenu();
						jMenu1.add(OpenFile);
						OpenFile.setText("OpenFile");
						jMenu1.addActionListener(new ActionListener() {
							int i = 0;

							public void actionPerformed(ActionEvent e) {
								JFileChooser chooser = new JFileChooser();
								chooser.showOpenDialog(null);

							}

						});

					}
				}
				{
					jMenu2 = new JMenu();
					File.add(jMenu2);
					AnchorLayout OpenFileLayout = new AnchorLayout();
					OpenFile.setLayout(null);
					jMenu2.setText("Validate");
					jMenu2.setLayout(null);
				}
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	public JMenuBar getFile() {
		return File;
	}

}
