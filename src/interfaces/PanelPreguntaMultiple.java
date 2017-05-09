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
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;

public class PanelPreguntaMultiple extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList<String> preguntas;
	private JLabel texto,enunciado;
	private DefaultListModel<String> lPreguntas;
	private JButton cancelar;
	private JButton terminarEjercicio;
	
	private JList<String> opciones;
	private DefaultListModel<String> lOpciones;
	private JButton anterior, siguiente, anteriorbien;

	
	public PanelPreguntaMultiple() {
		
		texto = new JLabel("Escriba su respuesta:");
		texto.setFont(new Font("Arial",0,35));
		
		
		terminarEjercicio = new JButton("Terminar Ejercicio");
	
		
		enunciado = new JLabel();
		enunciado.setFont(new Font("Arial", 0, 30));
	
	
		 siguiente = new JButton("Siguiente");
		 anterior = new JButton("Anterior");
		
		cancelar = new JButton ("Cancelar");
		cancelar.setFont(new Font("Arial",0,20));
				
		lPreguntas = new DefaultListModel<String>();
		preguntas = new JList<String>(lPreguntas);
		preguntas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		preguntas.setSelectionInterval(-1, -1);
		JScrollPane barraDesplazamiento = new JScrollPane(preguntas); 
		barraDesplazamiento.setPreferredSize(new Dimension(250,250));
		barraDesplazamiento.getViewport().setBackground(Color.WHITE);
		preguntas.setFont(new Font("Arial",0,30));
		
		lOpciones = new DefaultListModel<String>();
		opciones = new JList<String>(lOpciones);
		opciones.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane barraDesplazamiento2 = new JScrollPane(opciones); 
		barraDesplazamiento2.setPreferredSize(new Dimension(400,200));
		barraDesplazamiento2.getViewport().setBackground(Color.WHITE);
		opciones.setFont(new Font("Arial",0,30));
		
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		
		layout.putConstraint("HorizontalCenter", barraDesplazamiento2, 0, "HorizontalCenter", this);
		layout.putConstraint("VerticalCenter", barraDesplazamiento2, 50, "VerticalCenter", this);
		
			
layout.putConstraint(SpringLayout.SOUTH, texto, -20, SpringLayout.NORTH, barraDesplazamiento2);
layout.putConstraint(SpringLayout.WEST, texto, 0, SpringLayout.WEST,barraDesplazamiento2);

layout.putConstraint(SpringLayout.NORTH, cancelar, 80, SpringLayout.SOUTH, barraDesplazamiento2);
layout.putConstraint(SpringLayout.WEST, cancelar, 50, SpringLayout.EAST, barraDesplazamiento2);

layout.putConstraint(SpringLayout.SOUTH, enunciado, -15, SpringLayout.NORTH, texto);
layout.putConstraint(SpringLayout.WEST, enunciado, 0, SpringLayout.WEST, texto);



layout.putConstraint(SpringLayout.NORTH, terminarEjercicio, 10, SpringLayout.SOUTH, barraDesplazamiento2);
layout.putConstraint(SpringLayout.EAST, terminarEjercicio, 0, SpringLayout.EAST, barraDesplazamiento2);





layout.putConstraint(SpringLayout.NORTH, anterior, 0, SpringLayout.NORTH, siguiente);
layout.putConstraint(SpringLayout.EAST, anterior, -10, SpringLayout.WEST, siguiente);

layout.putConstraint(SpringLayout.NORTH, siguiente, 0, SpringLayout.NORTH, terminarEjercicio);
layout.putConstraint(SpringLayout.EAST, siguiente, -10, SpringLayout.WEST, terminarEjercicio);



			

		


		add(texto);	
		add(enunciado);
		add(terminarEjercicio);
		add(cancelar);
	
		add(barraDesplazamiento2);
	
		add(anterior);
		add(siguiente);
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


	public JButton getTerminarEjercicio() {
		return terminarEjercicio;
	}


	public JButton getSiguiente() {
		return siguiente;
	}


	public JList<String> getOpciones() {
		return opciones;
	}


	public DefaultListModel<String> getlOpciones() {
		return lOpciones;
	}


	public JButton getAnterior() {
		return anterior;
	}

	
	
	
	
}
