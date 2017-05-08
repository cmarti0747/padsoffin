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
	private JLabel pregunta, texto,enunciado;
	private DefaultListModel<String> lPreguntas;
	private JLabel cancelar;
	private JTextArea textofield;
	private JButton terminarEjercicio;
	private JButton siguiente;

	
	public PanelPreguntaLibre() {
		
		pregunta = new JLabel("Preguntas");
		pregunta.setFont(new Font("Arial",0,40));
		texto = new JLabel("Escriba su respuesta:");
		texto.setFont(new Font("Arial",0,35));
		
		textofield = new JTextArea();
		textofield.setFont(new Font("Arial", 0, 20));
		textofield.setPreferredSize(new Dimension (500,250));
		textofield.setLineWrap(true);
		
		terminarEjercicio = new JButton("Terminar Ejercicio");
		 siguiente = new JButton("Siguiente");
		
		enunciado = new JLabel();
		enunciado.setFont(new Font("Arial", 0, 30));
		
		cancelar = new JLabel ("Volver");
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
		
		layout.putConstraint("HorizontalCenter", textofield, 50, "HorizontalCenter", this);
		layout.putConstraint("VerticalCenter", textofield, 50, "VerticalCenter", this);
		
layout.putConstraint(SpringLayout.NORTH, barraDesplazamiento, -70, SpringLayout.NORTH, textofield);
		
		layout.putConstraint(SpringLayout.EAST, barraDesplazamiento, -30, SpringLayout.WEST, textofield);
		
		
		
layout.putConstraint(SpringLayout.SOUTH, pregunta, -20, SpringLayout.NORTH, barraDesplazamiento);
layout.putConstraint(SpringLayout.WEST, pregunta, 0, SpringLayout.WEST, barraDesplazamiento);
		
		
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


			

		
		add(barraDesplazamiento);
		add(textofield);
		add(texto);
		add(pregunta);
		add(enunciado);
		add(terminarEjercicio);
		add(cancelar);
		add(siguiente);
		
		setBackground(new Color(0, 255, 255));
		setVisible(true); 
		
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public JLabel getVolver() {
		return cancelar;
	}


	public JList<String> getPreguntas() {
		return preguntas;
	}


	public void setPreguntas(JList<String> preguntas) {
		this.preguntas = preguntas;
	}


	public JLabel getPregunta() {
		return pregunta;
	}


	public void setPregunta(JLabel pregunta) {
		this.pregunta = pregunta;
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


	public JLabel getCancelar() {
		return cancelar;
	}


	public void setCancelar(JLabel cancelar) {
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
	
	
	
	
}
