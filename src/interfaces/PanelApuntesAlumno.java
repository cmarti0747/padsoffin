package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

/**
 * Modulo de la clase PanelApuntesAlumno
 * @author Javier Senit y Carlos Marti
 *
 */
public class PanelApuntesAlumno extends JPanel{

	
	
	private static final long serialVersionUID = 1L;
	private JLabel titulo, volver;
	private JTextArea textofield;
	
	/**
	 * Constructor de la clase PanelApuntesAlumno
	 */
	public PanelApuntesAlumno(){
		
		
		
		
		titulo = new JLabel();
		titulo.setFont(new Font("Arial",0,35));
		
		volver = new JLabel ("Volver");
		volver.setFont(new Font("Arial",0,20));
		volver.setForeground(Color.BLUE);

		textofield = new JTextArea();
		textofield.setFont(new Font("Arial", 0, 20));
		textofield.setPreferredSize(new Dimension (750,250));
		textofield.setBackground(Color.WHITE);
		textofield.setLineWrap(true);
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		
		layout.putConstraint("HorizontalCenter", titulo, 0, "HorizontalCenter", this);
		layout.putConstraint("VerticalCenter", titulo, -300, "VerticalCenter", this);
	
		layout.putConstraint(SpringLayout.NORTH, textofield, 70, SpringLayout.SOUTH, titulo);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, textofield, 0, SpringLayout.HORIZONTAL_CENTER, titulo);
		
		
		
		layout.putConstraint(SpringLayout.NORTH, volver, 80, SpringLayout.SOUTH, textofield);
		layout.putConstraint(SpringLayout.WEST, volver, 85, SpringLayout.EAST, textofield);
		
		
		add(titulo);
		add(textofield);
		add(volver);
		
		
		setBackground(new Color(0, 255, 255));
		setVisible(true); 
		
	}


	/**
	 * Funcion que deveulve la label de titulo
	 * @return label de titulo
	 */
	public JLabel getTitulo() {
		return titulo;
	}


	/**
	 * Funcion que modifica la label de titulo
	 * @param titulo nuevo titulo
	 */
	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}

	/**
	 * Funcion que deveulve la label de volver
	 * @return label de volver
	 */
	public JLabel getVolver() {
		return volver;
	}


	/**
	 * Funcion que modifica la label volver
	 * @param volver nueva label de volver
	 */
	public void setVolver(JLabel volver) {
		this.volver = volver;
	}


	/**
	 * Funcion que obtiene el teexto del apunte
	 * @return texto
	 */
	public JTextArea getTextofield() {
		return textofield;
	}


	/**
	 * Funcion que modifica el texto del apunte
	 * @param textofield nuevo texto
	 */
	public void setTextofield(JTextArea textofield) {
		this.textofield = textofield;
	}


	
	
	
	
	
	
}
