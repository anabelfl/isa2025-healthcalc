package vista;

import healthcalc.HealthCalc;
import healthcalc.HealthCalcImp;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.HealthCtrl;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;

	private JTextField tfHeight1;
	private JRadioButton rbMale1;
	private JRadioButton rbFemale1;
	private ButtonGroup genderGroup1;
	private JLabel lbResultado1;
	private JButton bCalcularIW;
	
	private JTextField textFieldHeight2;
	private JTextField textField_Weight2;
	private JRadioButton rbMale2;
	private JRadioButton rbFemale2;
	private ButtonGroup genderGroup2;
	private JTextField textFieldEdad2;
	private JLabel lbResultado2;
	private JButton bCalcularBMR;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					frame.setTitle("HealthCalc");

					HealthCalc modelo = HealthCalcImp.getInstance(); 
					HealthCtrl controlador = new HealthCtrl(modelo, frame);

					frame.registrarControlador(controlador);
					frame.registrarControladorBMR(controlador);

					frame.pack();
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
		contentPane.setBackground(new Color(100, 150, 200)); // RGB
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelNorte = new JPanel();
		panelNorte.setOpaque(false); // Hace que el JPanel sea transparente
		contentPane.add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new BorderLayout(0, 0));

		JLabel lbTituloPrincipal = new JLabel("Health Calc");
		lbTituloPrincipal.setForeground(new Color(255, 255, 255));
		lbTituloPrincipal.setOpaque(false); 
		lbTituloPrincipal.setFont(new Font("Catallina", Font.BOLD, 20));
		lbTituloPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		panelNorte.add(lbTituloPrincipal, BorderLayout.NORTH);

		// Crear panel Centro
		JPanel panelCentro1 = new JPanel();
		panelCentro1.setLayout(new BorderLayout(0, 0));

		JPanel panelCentroNorte1 = new JPanel();
		panelCentro1.add(panelCentroNorte1, BorderLayout.NORTH);
		panelCentroNorte1.setLayout(new BorderLayout(0, 0));

		JPanel panelCentroNorteNorte1 = new JPanel();
		panelCentroNorte1.add(panelCentroNorteNorte1, BorderLayout.NORTH);
		panelCentroNorteNorte1.setLayout(new BorderLayout(0, 0));
		
		JTextArea textAreaIW = new JTextArea();
		textAreaIW.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		textAreaIW.setBackground(new Color(240, 240, 240)); // Cambiar el color de fondo
		textAreaIW.setPreferredSize(new Dimension(350, 70));
		textAreaIW.setMinimumSize(new Dimension(350, 60));
		textAreaIW.setMaximumSize(new Dimension(350, 100));
		textAreaIW.setWrapStyleWord(true);
		textAreaIW.setText("The ideal weight is computed by the Lorentz formula. This method estimates a person's ideal weight based on their height and gender. It provides an estimate of a healthy weight, but it does not consider factors such as body composition or muscle mass.");
		textAreaIW.setTabSize(5);
		textAreaIW.setLineWrap(true);
		textAreaIW.setForeground(Color.BLACK);
		textAreaIW.setEditable(false);
		panelCentroNorteNorte1.add(textAreaIW, BorderLayout.NORTH);
		


		JPanel panelHeight1 = new JPanel();
		panelCentroNorte1.add(panelHeight1);

		JLabel lbHeight1 = new JLabel("Height");
		lbHeight1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lbHeight1.setHorizontalAlignment(SwingConstants.CENTER);
		panelHeight1.add(lbHeight1);

		tfHeight1 = new JTextField(4);
		panelHeight1.add(tfHeight1);

		JLabel lbCM1 = new JLabel("cm");
		lbCM1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		panelHeight1.add(lbCM1);
				
		// JTabbedPane and tabs !!!!!!!!!!!!
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		tabbedPane.setForeground(new Color(100, 150, 200));
		tabbedPane.setBackground(new Color(240, 240, 240));

		// Panel for "Ideal Weight" and add PanelCentro inside
		JPanel panelIdealWeight = new JPanel(new BorderLayout());
		panelIdealWeight.add(panelCentro1, BorderLayout.CENTER); // Add PanelCentro
		
		JPanel panelCentroSur1 = new JPanel();
		panelCentro1.add(panelCentroSur1, BorderLayout.SOUTH);
		panelCentroSur1.setLayout(new GridLayout(0, 1, 0, 0));
		
		bCalcularIW = new JButton("Compute");
		bCalcularIW.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		bCalcularIW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelCentroSur1.add(bCalcularIW);
		
		lbResultado1 = new JLabel("");
		lbResultado1.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentroSur1.add(lbResultado1);
		
		JPanel panelCentroCentro1 = new JPanel();
		panelCentro1.add(panelCentroCentro1, BorderLayout.CENTER);
		panelCentroCentro1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelGender = new JPanel();
		panelCentroCentro1.add(panelGender);
		panelGender.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lbGender1 = new JLabel("Gender");
		lbGender1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		panelGender.add(lbGender1);
		
		JPanel panelSelectGender = new JPanel();
		panelCentroCentro1.add(panelSelectGender);
		panelSelectGender.setLayout(new GridLayout(2, 1, 0, 0));
		
		rbFemale1 = new JRadioButton("Female");
		rbFemale1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		rbFemale1.setHorizontalAlignment(SwingConstants.LEFT);
		panelSelectGender.add(rbFemale1);
		
		rbMale1 = new JRadioButton("Male");
		rbMale1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		rbMale1.setHorizontalAlignment(SwingConstants.LEFT);
		panelSelectGender.add(rbMale1);
		
		genderGroup1 = new ButtonGroup();
		genderGroup1.add(rbMale1);
		genderGroup1.add(rbFemale1);

		// Panel for "Basal Metabolic Rate"
		JPanel panelBMR = new JPanel();
		panelBMR.setLayout(new BorderLayout());

		// Add panels as tabs to JTabbedPane
		tabbedPane.addTab("Ideal Weight", panelIdealWeight);
		tabbedPane.addTab("Basal Metabolic Rate", panelBMR);

		JPanel panelNorte2 = new JPanel();
		panelBMR.add(panelNorte2, BorderLayout.NORTH);
		panelNorte2.setLayout(new BorderLayout(0, 0));

		JPanel panelCentroNorte2 = new JPanel();
		panelNorte2.add(panelCentroNorte2, BorderLayout.NORTH);
		panelCentroNorte2.setLayout(new BorderLayout(0, 0));

		JPanel panelParametros = new JPanel();
		panelCentroNorte2.add(panelParametros, BorderLayout.CENTER);
		panelParametros.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panelWeight2 = new JPanel();
		panelParametros.add(panelWeight2);
		FlowLayout fl_panelWeight2 = new FlowLayout(FlowLayout.CENTER, 5, 20);
		panelWeight2.setLayout(fl_panelWeight2);

		JLabel lbWeight2 = new JLabel("Weight");
		lbWeight2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lbWeight2.setHorizontalAlignment(SwingConstants.LEFT);
		panelWeight2.add(lbWeight2);

		textField_Weight2 = new JTextField(4);
		panelWeight2.add(textField_Weight2);

		JLabel lblKg = new JLabel("kg");
		lblKg.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		panelWeight2.add(lblKg);

		JPanel panelHeight2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelHeight2.getLayout();
		flowLayout.setVgap(20);
		panelParametros.add(panelHeight2);

		JLabel lbHeight2 = new JLabel("Height");
		lbHeight2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lbHeight2.setHorizontalAlignment(SwingConstants.LEFT);
		panelHeight2.add(lbHeight2);

		textFieldHeight2 = new JTextField(4);
		panelHeight2.add(textFieldHeight2);

		JLabel lbCM = new JLabel("cm");
		lbCM.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		panelHeight2.add(lbCM);

		JPanel panelEdad2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelEdad2.getLayout();
		flowLayout_1.setVgap(20);
		panelParametros.add(panelEdad2);

		JLabel lbAge2_1 = new JLabel("Age");
		lbAge2_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lbAge2_1.setHorizontalAlignment(SwingConstants.LEFT);
		panelEdad2.add(lbAge2_1);

		textFieldEdad2 = new JTextField();
		textFieldEdad2.setColumns(4);
		panelEdad2.add(textFieldEdad2);

		JLabel lbYears2 = new JLabel("y/o");
		lbYears2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		panelEdad2.add(lbYears2);

		JPanel panelGender2 = new JPanel();
		panelParametros.add(panelGender2);

		JLabel lbGender2 = new JLabel("Gender");
		lbGender2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		panelGender2.add(lbGender2);
		
		JPanel panelSelectGender2 = new JPanel();
		panelGender2.add(panelSelectGender2);
		panelSelectGender2.setLayout(new GridLayout(2, 1, 0, 0));

		rbFemale2 = new JRadioButton("Female");
		rbFemale2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		rbFemale2.setHorizontalAlignment(SwingConstants.LEFT);
		panelSelectGender2.add(rbFemale2);

		rbMale2 = new JRadioButton("Male");
		rbMale2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		rbMale2.setHorizontalAlignment(SwingConstants.LEFT);
		panelSelectGender2.add(rbMale2);
		
		genderGroup2 = new ButtonGroup();
		genderGroup2.add(rbMale2);
		genderGroup2.add(rbFemale2);
	

		
		JTextArea textAreaIBMR = new JTextArea();
		textAreaIBMR.setWrapStyleWord(true);
		textAreaIBMR.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		textAreaIBMR.setBackground(new Color(240, 240, 240)); // Cambiar el color de fondo
		textAreaIBMR.setPreferredSize(new Dimension(350, 60));

		textAreaIBMR.setText("The BMR is the number of calories your body needs to perform basic functions while at rest. It represents the minimum energy required to sustain life and is influenced by factors like age, gender, weight, height, and muscle mass.");
		textAreaIBMR.setTabSize(5);
		textAreaIBMR.setMinimumSize(new Dimension(350, 60));
		textAreaIBMR.setMaximumSize(new Dimension(350, 200));
		textAreaIBMR.setLineWrap(true);
		textAreaIBMR.setForeground(Color.BLACK);
		textAreaIBMR.setEditable(false);
		panelCentroNorte2.add(textAreaIBMR, BorderLayout.NORTH);

		JPanel panelCentroSur2 = new JPanel();
		panelNorte2.add(panelCentroSur2, BorderLayout.SOUTH);
		panelCentroSur2.setLayout(new GridLayout(0, 1, 0, 0));
		
		bCalcularBMR = new JButton("Compute");
		bCalcularBMR.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		bCalcularBMR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelCentroSur2.add(bCalcularBMR);
		
		lbResultado2 = new JLabel("");
		lbResultado2.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentroSur2.add(lbResultado2);

		// Add JTabbedPane to contentPane
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		pack();
		setVisible(true);
	}
	
	/*
	 * GESTION TabbedPane
	 */

	
    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }
	
	/*
	 * IDEAL WEIGHT
	 */

	public int getAltura() throws IllegalArgumentException {
	    String input = tfHeight1.getText().trim(); // Eliminar espacios en blanco

	    if (input.isEmpty()) {
	        throw new IllegalArgumentException("Height field cannot be empty.");
	    }

	    try {
	        int altura = Integer.parseInt(input);
	        if (altura <= 0 || altura > 250) { // Validar dentro del rango
	            throw new IllegalArgumentException("Height out of range (1-250 cm)");
	        }
	        return altura;
	        
	    } catch (NumberFormatException e) {
	        throw new IllegalArgumentException("Enter a valid height (numeric value).");
	    }
	}

	public char getGeneroSeleccionado()  {
		if (rbMale1.isSelected()) {
			return 'm';
		} 
		if (rbFemale1.isSelected()) {
			return 'w';
		}
		else {
			return 0;
		}
		
	}
	
	public void resetFieldsIW() {
	    tfHeight1.setText(""); 
	    genderGroup1.clearSelection(); 
	}
	
	public void registrarControlador(HealthCtrl c) {
		this.bCalcularIW.addActionListener(c);
		this.bCalcularIW.setActionCommand("Compute");
	}

	public void setResultado(float resultado) {
		lbResultado1.setText("Your ideal weight is " + resultado + " kg.");
	}

	public void error(String msg) {
		lbResultado1.setText(msg);
	}
	
	/*
	 * BASAL METABOLIC RATE
	 */
    
	public float getPesoBMR() {
		String input = textField_Weight2.getText().trim();
		
	    if (input.isEmpty()) {
	        throw new IllegalArgumentException("Weight field cannot be empty.");
	    }

	    try {
	        float peso = Float.parseFloat(input);
	        if (peso <= 0 || peso > 250) {
	            throw new IllegalArgumentException("Weight out of range (1-400 kg)");
	        }
	        return peso;
	        
	    } catch (NumberFormatException e) {
	        throw new IllegalArgumentException("Enter a valid weight (numeric value).");
	    }
	}
	
	public int getAlturaBMR() {
	    String input = textFieldHeight2.getText().trim();

	    if (input.isEmpty()) {
	        throw new IllegalArgumentException("Height field cannot be empty.");
	    }

	    try {
	        int altura = Integer.parseInt(input);
	        if (altura <= 0 || altura > 250) {
	            throw new IllegalArgumentException("Height out of range (1-250 cm)");
	        }
	        return altura;
	        
	    } catch (NumberFormatException e) {
	        throw new IllegalArgumentException("Enter a valid height (numeric value).");
	    }
	}
	
	public int getEdadBMR() {
		String input = textFieldEdad2.getText().trim();
		
	    if (input.isEmpty()) {
	        throw new IllegalArgumentException("Age field cannot be empty.");
	    }

	    try {
	        int edad = Integer.parseInt(input);
	        if (edad <= 0 || edad > 110) {
	            throw new IllegalArgumentException("Age out of range (1-110 years)");
	        }
	        return edad;
	        
	    } catch (NumberFormatException e) {
	        throw new IllegalArgumentException("Enter a valid age (numeric value).");
	    }
	}
	
	public char getGeneroSeleccionadoBMR() {
		if (rbMale2.isSelected()) {
			return 'm';
		} 
		if (rbFemale2.isSelected()) {
			return 'w';
		}
		else {
			return 0;
		}
	}
	
	public void resetFieldsBMR() {
		textFieldHeight2.setText(""); 
		textField_Weight2.setText(""); 
		textFieldEdad2.setText(""); 
	    genderGroup2.clearSelection(); 
	}

	public void registrarControladorBMR(HealthCtrl c) {
		this.bCalcularBMR.addActionListener(c);
		this.bCalcularBMR.setActionCommand("Compute");
	}

	public void setResultadoBMR(float resultado) {
		lbResultado2.setText("Your metabolic basal rate is " + resultado + ".");
	}

	public void errorBMR(String msg) {
		lbResultado2.setText(msg);
	}
}
