package random;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import random.util.MyBrowser;


public class ThatsRndm extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton one;
	private JButton two;
	private JButton randNum;
	private JButton ops;
	private JButton via;
	private JTextField console;
	private JTextArea up;
	private JTextArea test;
	private JPanel panel;
	private JPanel linePanel;
	private JPanel hidden;
	private String x;
	private String viaUrl;
	private int counter;
	int b=1;
	private JLabel label;

	public ThatsRndm(String lol) {
		panel=new JPanel();
		hidden=new JPanel();
		linePanel=new JPanel();
		up=new JTextArea("",10, 60);
		console=new JTextField("");
		test=new JTextArea("\n\n\n\n\n\nint i = (byte) + (char) - (int) + (long) - 1;\nSystem.out.println(i);\n\n\tCosa restituisce?", 10, 22);
		test.setBackground(this.getForeground());
		one=new JButton();
		two=new JButton();
		ops=new JButton(":)");
		randNum=new JButton("Numero casuale"); randNum.addActionListener(this);
		via=new JButton();
		label= new JLabel("  Completa il codice con un n. casuale o con una delle 'combinazioni speciali'");
		setCode();
		counter=0;

		up.setEditable(false);
		up.setFocusable(false);
		up.setBackground(this.getForeground());
		test.setLineWrap(true); test.setFocusable(false);
		up.setLineWrap(true);
		console.setEditable(false);
		hidden.add(test);
		one.setFocusable(false);two.setFocusable(false);randNum.setFocusable(false);
		one.setText("441287210"); one.addActionListener(this);
		two.setText("-6732303926L"); two.addActionListener(this);
		via.setText("[via]"); via.addActionListener(this);
		Neutralize(via);
		Neutralize(ops);

		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout());
		panel.add(up, BorderLayout.PAGE_START);
		panel.add(console, BorderLayout.PAGE_END);
		add(label);
		linePanel.add(randNum); linePanel.add(one); linePanel.add(two); linePanel.add(via); linePanel.add(ops);
		add(linePanel, BorderLayout.SOUTH);
		ops.addActionListener(this); 

		setSize(500, 320);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Random??");
		setResizable(false);
		setVisible(true);
		setAlwaysOnTop(true);
	}

	private void Neutralize(AbstractButton button) {
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setFocusable(false);
	}

	private void setCode() {
		Font font = new Font("Monaco", Font.ROMAN_BASELINE, 12);
		up.setFont(font);
		up.append("\n  Ecco del semplice codice per generare 'ipoteticamente' dei numeri     casuali di dieci cifre sempre diversi e stamparli a video. Provalo!");
		up.setForeground(Color.blue);
		up.append("\n\n\tRandom ");
		up.setForeground(Color.black);
		up.append("rdm= new Random("+x+");\n");
		up.setForeground(Color.magenta);
		up.append("\t\tfor");
		up.setForeground(Color.black);
		up.append("(");
		up.setForeground(Color.magenta);
		up.append("int ");
		up.setForeground(Color.black);
		up.append("k= 0;k<10;k++)\n\t\t   System.out.print(rdm.nextInt(10)+' ');\n\n\n\nconsole:");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source= e.getSource();
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		int raid=dateFormat.format(cal.getTime()).hashCode();
		int m=0;
		raid=(Math.abs(raid))%10000;
		System.out.println(raid);
		if(source==one){
			x="441287210";
		}
		if(source==two)
			x="-6732303926L";
		if(source==randNum){
			Random rdm= new Random((b*42)+(raid*13));
			x=rdm.nextInt(1000000000)+"";b++;
			m=rdm.nextInt(1000000000);
			counter++;
		}
		up.setText("");
		console.setText("...");
		console.setText(calcResolult(source, m));
		viaUrl="http://programmazione.it/index.php?entity=eitem&idItem=47907";
		if(counter>=18 && counter<=20){
			console.setText("PORN TIME! CHECK THE SOURCE");
			viaUrl="http://youporn.com/watch/660007/orgasms-little-caprice-cums/?from=country_hybrid_noscore";
		}	
		setCode();
		if (source==via){
			via.setVisible(false);
			try {
				openVia();
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(source==ops)
			curiosity();
	}

	private void curiosity() {
		panel.setVisible(false);
		linePanel.setVisible(false);
		label.setVisible(false);
		add(hidden, BorderLayout.CENTER);
	}

	private void openVia() throws URISyntaxException, IOException {
		@SuppressWarnings("unused")
		MyBrowser via= new MyBrowser("via", viaUrl);	
	}

//Si potrebbe fare un solo metodo senza source e usando x...ma non mi va. 
	private String calcResolult(Object source, int m) {
		String res="";
		Random rdm = null;
		if (source==one){
			rdm= new Random(441287210);
			for(int k=0;k<10;k++)
				res=res+(rdm.nextInt(10)+" ");
		}
		if(source==two){
			rdm= new Random(-6732303926L);
			for(int k=0;k<10;k++)
				res=res+(rdm.nextInt(10)+" ");
		}
		if(source==randNum){
			rdm= new Random(m);
			for(int k=0;k<10;k++)
				res=res+(rdm.nextInt(10)+" ");
		}
		return res;
	}


}
