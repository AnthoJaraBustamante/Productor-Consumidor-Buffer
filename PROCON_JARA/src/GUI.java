import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLabel;

public class GUI {


	private JFrame frame;

	boolean p1bool = false;
	boolean p2bool = false;
	boolean c1bool = false;
	boolean c2bool = false; 
	
	public static int TAM;
	
	public static boolean Prod1 = false;
	public static boolean Prod2 = false;
	public static boolean Cons1 = false;
	public static boolean Cons2 = false;

	public static JTextArea Productor1;
	public static JTextArea Productor2;
	public static JTextArea Consumido1;
	public static JTextArea Consumido2;

	///////////////////////////
	//Botones//
	public JButton btnIniciarP1;
	public JButton btnPararP1;
	public JButton btnIniciarP2;
	public JButton btnPararP2;
	public JButton btnIniciarC1;
	public JButton btnPararC1;
	public JButton btnIniciarC2;
	public JButton btnPararC2;
	private JLabel lblConsumidor;
	private JLabel lblConsumidor_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;


	////////////////////////////

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public GUI() {
		initialize();
	}


	private void initialize() {
		//

		
		TAM = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del Buffer: ") );
		TAM -= 1;

		//Formulario//
		frame = new JFrame();
		frame.setBounds(100, 100, 763, 392);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//Productores//
		//Productor 1//
		Productor1 = new JTextArea();
		Productor1.setBounds(45, 43, 57, 63);
		Productor1.setLineWrap(true);
		Productor1.setWrapStyleWord(true);
		Productor1.setEditable(true);
		frame.getContentPane().add(Productor1);
		//Productor 2//
		Productor2 = new JTextArea();
		Productor2.setBounds(187, 114, 120, 346);
		Productor2.setLineWrap(true);
		Productor2.setWrapStyleWord(true);
		Productor2.setEditable(true);
		frame.getContentPane().add(Productor2);
		//Consumidores//
		//Consumidor 1//
		Consumido1 = new JTextArea();
		Consumido1.setBounds(428, 114, 120, 346);
		Consumido1.setLineWrap(true);
		Consumido1.setWrapStyleWord(true);
		Consumido1.setEditable(true);
		frame.getContentPane().add(Consumido1);
		//Consumidor 2//
		Consumido2 = new JTextArea();
		Consumido2.setBounds(558, 114, 120, 346);
		Consumido2.setLineWrap(true);
		Consumido2.setWrapStyleWord(true);
		Consumido2.setEditable(true);
		frame.getContentPane().add(Consumido2);


		//Variables//
		Buffer b  =  new Buffer (TAM);
		Productor p = new Productor (b,32767);
		Productor p2 = new Productor (b,32767);
		Consumidor c= new Consumidor (b,32767);
		Consumidor c2= new Consumidor (b,32767);

		/////////////////////////////////////////////////////
		//JScrollPanelS//
		JScrollPane panel1 = new JScrollPane(Productor1);
		panel1.setPreferredSize(new Dimension(380, 100));
		panel1.setViewportView(Productor1);
		panel1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel1.setBounds(57, 114, 120, 107);
		frame.getContentPane().add(panel1);

		JScrollPane panel2 = new JScrollPane(Productor2);
		panel2.setPreferredSize(new Dimension(380, 100));
		panel2.setViewportView(Productor2);
		panel2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel2.setBounds(187, 114, 120, 107);
		frame.getContentPane().add(panel2);

		JScrollPane panel3 = new JScrollPane(Consumido1);
		panel3.setPreferredSize(new Dimension(380, 100));
		panel3.setViewportView(Consumido1);
		panel3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel3.setBounds(428, 114, 120, 107);
		frame.getContentPane().add(panel3);

		JScrollPane panel4 = new JScrollPane(Consumido2);
		panel4.setPreferredSize(new Dimension(380, 100));
		panel4.setViewportView(Consumido2);
		panel4.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel4.setBounds(558, 114, 120, 107);				
		frame.getContentPane().add(panel4);
		//Botones Productor 1//
		//Iniciar//
		btnIniciarP1 = new JButton("Iniciar");
		btnIniciarP1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				btnIniciarP1.setEnabled(false);
				btnIniciarP2.setEnabled(false);
				btnPararP1.setEnabled(true);
				btnIniciarC1.setEnabled(true);
				btnIniciarC2.setEnabled(false);
				Prod1 = true;

				if(!p1bool) {
					p1bool = true;
					p.start();
					btnIniciarC1.setEnabled(true);
				}
				else {
					p.resume();
				}
			}
		});

		btnIniciarP1.setBounds(57, 243, 120, 23);
		frame.getContentPane().add(btnIniciarP1);
		//Parar//
		btnPararP1 = new JButton ("Parar");
		btnPararP1.setEnabled(false);
		btnPararP1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				btnIniciarP1.setEnabled(true);
				btnIniciarP2.setEnabled(true);
				btnPararP1.setEnabled(false);
				Prod1 = false;
				p.suspend();

			}
		});
		btnPararP1.setBounds(57, 277, 120, 23);
		frame.getContentPane().add(btnPararP1);
		/////////////////////////////////////////////////////
		//Botones Productor 2//
		//Iniciar//
		btnIniciarP2 = new JButton("Iniciar");
		btnIniciarP2.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				btnIniciarP2.setEnabled(false);
				btnPararP2.setEnabled(true);
				btnIniciarP1.setEnabled(false);
				btnIniciarC1.setEnabled(false);
				btnIniciarC2.setEnabled(true);

				Prod2 = true;

				if(!p2bool) {
					p2bool = true;
					p2.start();
					btnIniciarC2.setEnabled(true);
				}
				else {
					p2.resume();
				}


			}
		});
		btnIniciarP2.setBounds(187, 243, 120, 23);
		frame.getContentPane().add(btnIniciarP2);
		//Parar//
		btnPararP2 = new JButton ("Parar");
		btnPararP2.setEnabled(false);
		btnPararP2.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				btnIniciarP2.setEnabled(true);
				btnPararP2.setEnabled(false);
				btnIniciarP1.setEnabled(true);
				Prod2 = false;
				p2.suspend();
			}
		});
		btnPararP2.setBounds(187, 277, 120, 23);
		frame.getContentPane().add(btnPararP2);
		/////////////////////////////////////////////////////
		//Botones Consumidor 1//
		//Iniciar//
		btnIniciarC1 = new JButton("Iniciar");
		btnIniciarC1.setEnabled(false);
		btnIniciarC1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				btnIniciarC1.setEnabled(false);
				btnPararC1.setEnabled(true);
				Cons1 = true;

				if(!c1bool) {
					c1bool = true;
					c.start();
				}
				else {
					c.resume();

				}
			}
		});
		btnIniciarC1.setBounds(428, 243, 120, 23);
		frame.getContentPane().add(btnIniciarC1);
		//Parar//
		btnPararC1 = new JButton ("Parar");
		btnPararC1.setEnabled(false);
		btnPararC1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				btnIniciarC1.setEnabled(true);
				btnPararC1.setEnabled(false);
				c.suspend();
				Cons1 = false;
			}
		});
		btnPararC1.setBounds(428, 277, 120, 23);
		frame.getContentPane().add(btnPararC1);
		/////////////////////////////////////////////////////
		//Botones Consumidor 2//
		//Iniciar//
		btnIniciarC2 = new JButton("Iniciar");
		btnIniciarC2.setEnabled(false);
		btnIniciarC2.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				btnIniciarC2.setEnabled(false);
				btnPararC2.setEnabled(true);
				Cons2 = true;

				if(!c2bool) {
					c2bool = true;
					c2.start();
				}
				else {
					c2.resume();
				}

			}
		});
		btnIniciarC2.setBounds(558, 243, 120, 23);
		frame.getContentPane().add(btnIniciarC2);
		//Parar//
		btnPararC2 = new JButton ("Parar");
		btnPararC2.setEnabled(false);
		btnPararC2.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				btnIniciarC2.setEnabled(true);
				btnPararC2.setEnabled(false);
				c2.suspend();
				Cons2 = false;
			}
		});
		btnPararC2.setBounds(558, 277, 120, 23);
		frame.getContentPane().add(btnPararC2);
		
		JLabel lblProductor = new JLabel("PRODUCTOR 1");
		lblProductor.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductor.setBounds(57, 66, 120, 37);
		frame.getContentPane().add(lblProductor);
		
		JLabel lblProductor_1 = new JLabel("PRODUCTOR 2");
		lblProductor_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductor_1.setBounds(187, 66, 120, 37);
		frame.getContentPane().add(lblProductor_1);
		
		lblConsumidor = new JLabel("CONSUMIDOR 1");
		lblConsumidor.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsumidor.setBounds(428, 66, 120, 37);
		frame.getContentPane().add(lblConsumidor);
		
		lblConsumidor_1 = new JLabel("CONSUMIDOR 2");
		lblConsumidor_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsumidor_1.setBounds(558, 66, 120, 37);
		frame.getContentPane().add(lblConsumidor_1);
		
		lblNewLabel = new JLabel("Anthony Jara - V Semestre - Ing. de Sistemas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(411, 332, 326, 14);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Examen de Sistemas Operativos");
		lblNewLabel_1.setFont(new Font("Ubuntu", Font.BOLD, 18));
		lblNewLabel_1.setBounds(209, 25, 370, 44);
		frame.getContentPane().add(lblNewLabel_1);
		/////////////////////////////////////////////////////
	}
}