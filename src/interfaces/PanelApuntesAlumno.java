package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class PanelApuntesAlumno extends JPanel{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel titulo, volver;
	private JTextArea textofield;
	
	
	public PanelApuntesAlumno(){
		
		
		
		
		titulo = new JLabel();
		titulo.setFont(new Font("Arial",0,35));
		
		volver = new JLabel ("Volver");
		titulo.setFont(new Font("Arial",0,20));

		textofield = new JTextArea();
		textofield.setFont(new Font("Arial", 0, 20));
		textofield.setPreferredSize(new Dimension (750,250));
		textofield.setBackground(Color.WHITE);
		textofield.setEditable(false);
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


	public JLabel getTitulo() {
		return titulo;
	}


	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}


	public JLabel getVolver() {
		return volver;
	}


	public void setVolver(JLabel volver) {
		this.volver = volver;
	}


	public JTextArea getTextofield() {
		return textofield;
	}


	public void setTextofield(JTextArea textofield) {
		this.textofield = textofield;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
}
