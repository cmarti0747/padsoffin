package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

/**
 * Modulo de la clase PanelApuntes
 * @author Javier Senit y Carlos Marti
 *
 */
public class PanelApuntes extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel titulo, texto, volver;
	private JTextArea titulofield;
	private JTextArea textofield;
	private JButton modificar;
	private JCheckBox check1;
	
	/**
	 * Constructor de la clase PanelApuntes
	 */
	public PanelApuntes(){
		
		modificar = new JButton("Modificar apunte");
		
		
		titulo = new JLabel("TITULO DEL APUNTE");
		titulo.setFont(new Font("Arial",0,35));
		
		volver = new JLabel ("Volver");
		volver.setFont(new Font("Arial",0,25));
		volver.setBackground(Color.BLUE);
		
		texto = new JLabel("TEXTO DEL APUNTE");
		texto.setFont(new Font("Arial",0,35));
		
		check1=new JCheckBox("Visbilidad");
        check1.setBounds(10,10,150,30);
        check1.setBackground(new Color(0,255,255));
		
		
		titulofield = new JTextArea();
		titulofield.setPreferredSize(new Dimension ( 750, 100));
		titulofield.setFont(new Font("Arial", 0, 20));
		textofield = new JTextArea();
		textofield.setFont(new Font("Arial", 0, 20));
		textofield.setPreferredSize(new Dimension (750,250));
		textofield.setLineWrap(true);
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		
		layout.putConstraint("HorizontalCenter", titulo, 0, "HorizontalCenter", this);
		layout.putConstraint("VerticalCenter", titulo, -300, "VerticalCenter", this);
		
		layout.putConstraint(SpringLayout.NORTH, titulofield, 50, SpringLayout.SOUTH, titulo);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, titulofield, 0, SpringLayout.HORIZONTAL_CENTER, titulo);
		
		layout.putConstraint(SpringLayout.NORTH, texto, 20, SpringLayout.SOUTH, titulofield);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, texto, 0, SpringLayout.HORIZONTAL_CENTER, titulo);
		
		layout.putConstraint(SpringLayout.NORTH, textofield, 20, SpringLayout.SOUTH, texto);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, textofield, 0, SpringLayout.HORIZONTAL_CENTER, titulo);
		
		layout.putConstraint(SpringLayout.NORTH, modificar, 15, SpringLayout.SOUTH, textofield);
		layout.putConstraint(SpringLayout.EAST, modificar, 0, SpringLayout.EAST, textofield);
		
		layout.putConstraint(SpringLayout.NORTH, volver, 50, SpringLayout.SOUTH, modificar);
		layout.putConstraint(SpringLayout.WEST, volver, 40, SpringLayout.EAST, modificar);
		
layout.putConstraint(SpringLayout.WEST, check1, 0, SpringLayout.WEST, textofield);
		
		layout.putConstraint(SpringLayout.NORTH, check1, 20, SpringLayout.SOUTH,textofield);
		
		
		add(titulo);
		add(texto);
		add(textofield);
		add(titulofield);
		add(modificar);
		add(volver);
		add(check1);
		
		setBackground(new Color(0, 255, 255));
		setVisible(true); 
		
	}

	/**
	 * Funcion que deveulve el label de titulo
	 * @return label de titulo
	 */
	public JLabel getTitulo() {
		return titulo;
	}

	/**
	 * Funcion que modifica el titulo del apunte
	 * @param titulo nuevo titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo.setText(titulo);
	}

	/**
	 * Funcion que deveulve el label de texto
	 * @return label de texto
	 */
	public JLabel getTexto() {
		return texto;
	}

	/**
	 * Funcion que modifica el texto del apunte
	 * @param texto nuevo texto
	 */
	public void setTexto(JLabel texto) {
		this.texto = texto;
	}

	/**
	 * Funcion que deveulve el label de volver
	 * @return label de volver
	 */
	public JLabel getVolver() {
		return volver;
	}

	/**
	 * Funcion que modifica la label de volver
	 * @param volver nueva label
	 */
	public void setVolver(JLabel volver) {
		this.volver = volver;
	}

	/**
	 * Funcion que deveulve el titulo de un apunte
	 * @return titulo
	 */
	public JTextArea getTitulofield() {
		return titulofield;
	}

	/**
	 * Funcion que modifica el titulo de un apunte
	 * @param titulofield nuevo titulo
	 */
	public void setTitulofield(JTextArea titulofield) {
		this.titulofield = titulofield;
	}

	/**
	 * Funcion que deveulve el texto de un apunte
	 * @return texto
	 */
	public JTextArea getTextofield() {
		return textofield;
	}

	/**
	 * Funcion que modifica el texto de un apunte
	 * @param textofield nuevo texto
	 */
	public void setTextofield(JTextArea textofield) {
		this.textofield = textofield;
	}

	/**
	 * Funcion que obtiene el boton de modificar apunte
	 * @return boton de modifica
	 */
	public JButton getModificar() {
		return modificar;
	}

	/**
	 * Funcion que modifica el boton de modificar
	 * @param modificar nuevo boton
	 */
	public void setModificar(JButton modificar) {
		this.modificar = modificar;
	}

	/**
	 * Funcion que devulve el checkbox de visibilidad
	 * @return checkbox de visibilidad
	 */
	public JCheckBox getCheck1() {
		return check1;
	}
	
	
	
	
}
