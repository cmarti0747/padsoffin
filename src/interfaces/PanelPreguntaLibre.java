package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;

public class PanelPreguntaLibre extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList<String> preguntas;
	private JLabel texto,enunciado;
	private DefaultListModel<String> lPreguntas;
	private JButton cancelar;
	private JTextArea textofield;
	private JButton terminarEjercicio;
	private JButton siguiente;
	private JButton anterior;

	
	public PanelPreguntaLibre() {
		
		texto = new JLabel("Escriba su respuesta:");
		texto.setFont(new Font("Arial",0,35));
		
		textofield = new JTextArea();
		textofield.setFont(new Font("Arial", 0, 20));
		textofield.setPreferredSize(new Dimension (500,250));
		textofield.setLineWrap(true);
		
		terminarEjercicio = new JButton("Terminar Ejercicio");
		 siguiente = new JButton("Siguiente");
		 anterior = new JButton("Anterior");
		
		enunciado = new JLabel();
		enunciado.setFont(new Font("Arial", 0, 30));
		
		cancelar = new JButton ("Volver");
		cancelar.setFont(new Font("Arial",0,20));
		
		lPreguntas = new DefaultListModel<String>();
		preguntas = new JList<String>(lPreguntas);
		preguntas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		preguntas.setSelectionInterval(-1, -1);
		JScrollPane barraDesplazamiento = new JScrollPane(preguntas); 
		barraDesplazamiento.setPreferredSize(new Dimension(250,250));
		barraDesplazamiento.getViewport().setBackground(Color.WHITE);
		preguntas.setFont(new Font("Arial",0,30));
		
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		
		layout.putConstraint("HorizontalCenter", textofield, 0, "HorizontalCenter", this);
		layout.putConstraint("VerticalCenter", textofield, 50, "VerticalCenter", this);
		
layout.putConstraint(SpringLayout.NORTH, barraDesplazamiento, -70, SpringLayout.NORTH, textofield);
		
		layout.putConstraint(SpringLayout.EAST, barraDesplazamiento, -30, SpringLayout.WEST, textofield);
		
			
layout.putConstraint(SpringLayout.SOUTH, texto, -20, SpringLayout.NORTH, textofield);
layout.putConstraint(SpringLayout.WEST, texto, 0, SpringLayout.WEST,textofield);
		
layout.putConstraint(SpringLayout.SOUTH, texto, -20, SpringLayout.NORTH, textofield);
layout.putConstraint(SpringLayout.WEST, texto, 0, SpringLayout.WEST,textofield);
		
layout.putConstraint(SpringLayout.SOUTH, texto, -20, SpringLayout.NORTH, textofield);
layout.putConstraint(SpringLayout.WEST, texto, 0, SpringLayout.WEST,textofield);

layout.putConstraint(SpringLayout.NORTH, cancelar, 20, SpringLayout.SOUTH, textofield);
layout.putConstraint(SpringLayout.EAST, cancelar, 0, SpringLayout.EAST, textofield);

layout.putConstraint(SpringLayout.SOUTH, enunciado, -15, SpringLayout.NORTH, texto);
layout.putConstraint(SpringLayout.WEST, enunciado, 0, SpringLayout.WEST, texto);



layout.putConstraint(SpringLayout.NORTH, terminarEjercicio, 0, SpringLayout.NORTH, cancelar);
layout.putConstraint(SpringLayout.EAST, terminarEjercicio, -10, SpringLayout.WEST, cancelar);


layout.putConstraint(SpringLayout.NORTH, siguiente, 0, SpringLayout.NORTH, cancelar);
layout.putConstraint(SpringLayout.EAST, siguiente, -10, SpringLayout.WEST, terminarEjercicio);


layout.putConstraint(SpringLayout.NORTH, anterior, 0, SpringLayout.NORTH, siguiente);
layout.putConstraint(SpringLayout.EAST, anterior, -10, SpringLayout.WEST, siguiente);

			

		

		add(textofield);
		add(texto);

		add(enunciado);
		add(terminarEjercicio);
		add(cancelar);
		add(siguiente);
		add(anterior);
		
		setBackground(new Color(0, 255, 255));
		setVisible(true); 
		
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public JButton getVolver() {
		return cancelar;
	}


	public JList<String> getPreguntas() {
		return preguntas;
	}


	public void setPreguntas(JList<String> preguntas) {
		this.preguntas = preguntas;
	}


	public JLabel getTexto() {
		return texto;
	}


	public void setTexto(JLabel texto) {
		this.texto = texto;
	}


	public JLabel getEnunciado() {
		return enunciado;
	}


	public void setEnunciado(String enunciado) {
		this.enunciado.setText(enunciado);
	}


	public DefaultListModel<String> getlPreguntas() {
		return lPreguntas;
	}


	public void setlPreguntas(DefaultListModel<String> lPreguntas) {
		this.lPreguntas = lPreguntas;
	}


	public JButton getCancelar() {
		return cancelar;
	}


	public void setCancelar(JButton cancelar) {
		this.cancelar = cancelar;
	}


	public JTextArea getTextofield() {
		return textofield;
	}


	public void setTextofield(JTextArea textofield) {
		this.textofield = textofield;
	}


	public JButton getTerminarEjercicio() {
		return terminarEjercicio;
	}


	public JButton getSiguiente() {
		return siguiente;
	}


	public JButton getAnterior() {
		return anterior;
	}
	
	
	
	
}
