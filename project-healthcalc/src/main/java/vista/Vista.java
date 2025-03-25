package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
				    frame.setTitle("HealthCalc");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new BorderLayout(0, 0));
		
		JLabel lbTituloPrincipal = new JLabel("Health Calc");
		lbTituloPrincipal.setFont(new Font("Catallina", Font.PLAIN, 20));
		lbTituloPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		panelNorte.add(lbTituloPrincipal, BorderLayout.NORTH);
		
		JLabel lbInfo = new JLabel("Type your information");
		panelNorte.add(lbInfo, BorderLayout.SOUTH);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCentroNorte = new JPanel();
		panelCentro.add(panelCentroNorte, BorderLayout.NORTH);
		panelCentroNorte.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCentroNorteNorte = new JPanel();
		panelCentroNorte.add(panelCentroNorteNorte, BorderLayout.NORTH);
		panelCentroNorteNorte.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1_1 = new JLabel("Ideal Weight");
		panelCentroNorteNorte.add(lblNewLabel_1_1, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panelCentroNorte.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Height");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField(4);
		panel_1.add(textField);
		
		JPanel panelCentroCentro = new JPanel();
		panelCentro.add(panelCentroCentro, BorderLayout.CENTER);
		panelCentroCentro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelGender = new JPanel();
		panelCentroCentro.add(panelGender);
		panelGender.setLayout(new BorderLayout(0, 0));
		
		JLabel lbGender = new JLabel("Gender");
		panelGender.add(lbGender, BorderLayout.WEST);
		
		JPanel panelSelectGender = new JPanel();
		panelCentroCentro.add(panelSelectGender);
		panelSelectGender.setLayout(new GridLayout(2, 1, 0, 0));
		
		JRadioButton rbFemale = new JRadioButton("Female");
		rbFemale.setHorizontalAlignment(SwingConstants.CENTER);
		panelSelectGender.add(rbFemale);
		
		JRadioButton rbMale = new JRadioButton("Male");
		rbMale.setHorizontalAlignment(SwingConstants.CENTER);
		panelSelectGender.add(rbMale);
		
		JPanel panelCentroSur = new JPanel();
		panelCentro.add(panelCentroSur, BorderLayout.SOUTH);
		panelCentroSur.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton bCalcular = new JButton("Calcular");
		panelCentroSur.add(bCalcular);
		
		this.pack();

	}	
}
