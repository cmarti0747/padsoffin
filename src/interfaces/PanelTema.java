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

/**
 * Modulo de la clase PanelTema
 * @author Javier Senit Velasco
 *
 */
public class PanelTema extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JList<String> apuntes, ejercicios;
	private JLabel nombreTema, labelapuntes, labelejercicios,n, labelsub;
	private JButton crearA, eliminarA, crearE, eliminarE;
	private JButton crearSub;
	private JButton eliminarSub;
	private DefaultListModel<String> lApuntes, lEjercicios;
	private DefaultListModel<String> lSubtemas;
	private JList<String> subtemas;
	private JLabel volver;
	private String subtemaAnterior;
	private JButton cambiarvisA;
	private JButton cambiarvisSub;
	private JButton cambiarvisE;

	/**
	 * Constructor de la clase PanelTema
	 */
	public PanelTema() {

		nombreTema = new JLabel();
		nombreTema.setFont(new Font("Arial", 0, 40));
		labelapuntes = new JLabel("Apuntes");
		labelapuntes.setFont(new Font("Arial", 0, 25));
		n = new JLabel("");
		
		labelejercicios = new JLabel("Ejercicios");
		labelejercicios.setFont(new Font("Arial", 0, 25));
		
		labelsub = new JLabel("Subtemas");
		labelsub.setFont(new Font("Arial", 0, 25));

		volver = new JLabel("Volver");
		volver.setFont(new Font("Arial", 0, 20));
		volver.setForeground(Color.BLUE);

		crearA = new JButton("Crear Apunte");
		eliminarA = new JButton("Eliminar Apunte");
		cambiarvisA = new JButton("Cambiar visibilidad");

		crearE = new JButton("Crear Ejercicio");
		eliminarE = new JButton("Eliminar Ejercicio");
		cambiarvisE = new JButton("Cambiar visibilidad");

		crearSub = new JButton("Crear Subtema");
		eliminarSub = new JButton("Eliminar Subtema");
		cambiarvisSub = new JButton("Cambiar visibilidad");

		lApuntes = new DefaultListModel<String>();
		apuntes = new JList<String>(lApuntes);
		apuntes.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		JScrollPane barraDesplazamiento = new JScrollPane(apuntes);
		barraDesplazamiento.setPreferredSize(new Dimension(250, 250));
		barraDesplazamiento.getViewport().setBackground(Color.WHITE);
		apuntes.setFont(new Font("Arial", 0, 30));

		lEjercicios = new DefaultListModel<String>();
		ejercicios = new JList<String>(lEjercicios);
		ejercicios.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		JScrollPane barraDesplazamiento2 = new JScrollPane(ejercicios);
		barraDesplazamiento2.setPreferredSize(new Dimension(250, 250));
		barraDesplazamiento2.getViewport().setBackground(Color.WHITE);
		ejercicios.setFont(new Font("Arial", 0, 30));

		lSubtemas = new DefaultListModel<String>();
		subtemas = new JList<String>(lSubtemas);
		subtemas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		JScrollPane barraDesplazamiento3 = new JScrollPane(subtemas);
		barraDesplazamiento3.setPreferredSize(new Dimension(250, 250));
		barraDesplazamiento3.getViewport().setBackground(Color.WHITE);
		subtemas.setFont(new Font("Arial", 0, 30));
		SpringLayout layout = new SpringLayout();
		setLayout(layout);

		layout.putConstraint("HorizontalCenter", n, -465, "HorizontalCenter", this);
		layout.putConstraint("VerticalCenter", n, -250, "VerticalCenter", this);

		
		layout.putConstraint("HorizontalCenter", nombreTema, -350, "HorizontalCenter", this);
		layout.putConstraint("VerticalCenter", nombreTema, -250, "VerticalCenter", this);
		layout.putConstraint(SpringLayout.NORTH, barraDesplazamiento, 70, SpringLayout.SOUTH, n);

		layout.putConstraint(SpringLayout.WEST, barraDesplazamiento, 0, SpringLayout.WEST, n);

		

		

		layout.putConstraint(SpringLayout.NORTH, barraDesplazamiento2, 70, SpringLayout.SOUTH, n);

		layout.putConstraint(SpringLayout.WEST, barraDesplazamiento2, 325, SpringLayout.WEST, n);

		layout.putConstraint(SpringLayout.NORTH, barraDesplazamiento3, 70, SpringLayout.SOUTH, n);

		layout.putConstraint(SpringLayout.WEST, barraDesplazamiento3, 650, SpringLayout.WEST, n);
		
		layout.putConstraint(SpringLayout.SOUTH, labelapuntes, -20, SpringLayout.NORTH, barraDesplazamiento);
		layout.putConstraint(SpringLayout.WEST, labelapuntes, 0, SpringLayout.WEST, barraDesplazamiento);
		
		layout.putConstraint(SpringLayout.SOUTH, labelejercicios, -20, SpringLayout.NORTH, barraDesplazamiento2);
		layout.putConstraint(SpringLayout.WEST, labelejercicios, 0, SpringLayout.WEST, barraDesplazamiento2);


		layout.putConstraint(SpringLayout.SOUTH, labelsub, -20, SpringLayout.NORTH, barraDesplazamiento3);
		layout.putConstraint(SpringLayout.WEST, labelsub, 0, SpringLayout.WEST, barraDesplazamiento3);
		layout.putConstraint(SpringLayout.NORTH, crearA, 35, SpringLayout.SOUTH, barraDesplazamiento);

		layout.putConstraint(SpringLayout.WEST, crearA, -5, SpringLayout.WEST, barraDesplazamiento);

		layout.putConstraint(SpringLayout.NORTH, eliminarA, 0, SpringLayout.NORTH, crearA);

		layout.putConstraint(SpringLayout.WEST, eliminarA, 10, SpringLayout.EAST, crearA);

		layout.putConstraint(SpringLayout.NORTH, crearE, 35, SpringLayout.SOUTH, barraDesplazamiento2);

		layout.putConstraint(SpringLayout.WEST, crearE, -5, SpringLayout.WEST, barraDesplazamiento2);

		layout.putConstraint(SpringLayout.NORTH, eliminarE, 0, SpringLayout.NORTH, crearE);

		layout.putConstraint(SpringLayout.WEST, eliminarE, 10, SpringLayout.EAST, crearE);

		layout.putConstraint(SpringLayout.NORTH, crearSub, 35, SpringLayout.SOUTH, barraDesplazamiento3);

		layout.putConstraint(SpringLayout.WEST, crearSub, -5, SpringLayout.WEST, barraDesplazamiento3);

		layout.putConstraint(SpringLayout.NORTH, eliminarSub, 0, SpringLayout.NORTH, crearSub);

		layout.putConstraint(SpringLayout.WEST, eliminarSub, 10, SpringLayout.EAST, crearSub);
		
		layout.putConstraint(SpringLayout.NORTH, cambiarvisA,10 , SpringLayout.SOUTH, crearA);
		
		layout.putConstraint(SpringLayout.WEST, cambiarvisA,45 , SpringLayout.WEST, crearA);
		
layout.putConstraint(SpringLayout.NORTH, cambiarvisE,10 , SpringLayout.SOUTH, crearE);
		
		layout.putConstraint(SpringLayout.WEST, cambiarvisE,45 , SpringLayout.WEST, crearE);
		
layout.putConstraint(SpringLayout.NORTH, cambiarvisSub,10 , SpringLayout.SOUTH, crearSub);
		
		layout.putConstraint(SpringLayout.WEST, cambiarvisSub,45 , SpringLayout.WEST, crearSub);



		layout.putConstraint(SpringLayout.NORTH, volver, 50, SpringLayout.SOUTH, crearSub);
		
		layout.putConstraint(SpringLayout.EAST, volver, 0, SpringLayout.EAST, barraDesplazamiento3);

		add(barraDesplazamiento);
		add(barraDesplazamiento2);
		add(barraDesplazamiento3);
		add(crearA);
		add(eliminarA);

		add(crearE);
		add(eliminarE);
		add(crearSub);
		add(eliminarSub);
		add(volver);
		add(labelapuntes);
		add(labelejercicios);
		add(nombreTema);
		add(cambiarvisA);
		add(cambiarvisE);
		add(cambiarvisSub);
		add(labelsub);
		add(n);
		setBackground(new Color(0, 255, 255));
		setVisible(true);

	}
	
	

	/**
	 * Funcion que devuelve el subtemaanterior
	 * @return subtemaanterior
	 */
	public String getSubtemaAnterior() {
		return subtemaAnterior;
	}


	/**
	 * Funcion que modifica el subtemaanterior
	 * @param subtemaAnterior nuevo subtema
	 */
	public void setSubtemaAnterior(String subtemaAnterior) {
		this.subtemaAnterior = subtemaAnterior;
	}



	/**
	 * Funcion que devuelve la lista de apuntes
	 * @return lista de apuntes
	 */
	public JList<String> getApuntes() {
		return apuntes;
	}

	/**
	 * Funcion que modifica la lista de apuntes
	 * @param apuntes nueva lista
	 */
	public void setApuntes(JList<String> apuntes) {
		this.apuntes = apuntes;
	}

	/**
	 * Funcion que devuelve la lista de ejercicios
	 * @return lista de ejercicios
	 */
	public JList<String> getEjercicios() {
		return ejercicios;
	}

	/**
	 * Funcion que modifica la lista de ejercicios
	 * @param ejercicios nueva lista
	 */
	public void setEjercicios(JList<String> ejercicios) {
		this.ejercicios = ejercicios;
	}

	/**
	 * Funcion que devuelve el label de tema
	 * @return label de tema
	 */
	public JLabel getNombreTema() {
		return nombreTema;
	}

	/**
	 * Funcion que modifica el nombre de un tema
	 * @param nombreTema nuevo nombre
	 */
	public void setNombreTema(String nombreTema) {
		this.nombreTema.setText(nombreTema);
	}

	/**
	 * Funcion que devuelve el label de apuntes
	 * @return label de apuntes
	 */
	public JLabel getLabelapuntes() {
		return labelapuntes;
	}

	/**
	 * Funcion que modifica la label de apuntes
	 * @param labelapuntes nueva label
	 */
	public void setLabelapuntes(JLabel labelapuntes) {
		this.labelapuntes = labelapuntes;
	}

	/**
	 * Funcion que devuelve el label de ejercicios
	 * @return label de ejercicios
	 */
	public JLabel getLabelejercicios() {
		return labelejercicios;
	}

	/**
	 * Funcion que modifica la label de ejercicios
	 * @param labelejercicios nueva label
	 */
	public void setLabelejercicios(JLabel labelejercicios) {
		this.labelejercicios = labelejercicios;
	}

	
	/**
	 * Funcion que devuelve el boton de crear apuntes
	 * @return boton de crear apuntes
	 */
	public JButton getCrearA() {
		return crearA;
	}

	/**
	 * Funcion que modifica el boton de crear apuntes
	 * @param crearA nuevos boton
	 */
	public void setCrearA(JButton crearA) {
		this.crearA = crearA;
	}

	
	/**
	 * Funcion que devuelve el boton de eliminar apuntes
	 * @return boton de eliminar apuntes
	 */
	public JButton getEliminarA() {
		return eliminarA;
	}

	/**
	 * Funcion que modifica el boton de eliminar apuntes
	 * @param eliminarA nuevo boton
	 */
	public void setEliminarA(JButton eliminarA) {
		this.eliminarA = eliminarA;
	}

	/**
	 * Funcion que devuelve el boton de crear ejercicios
	 * @return boton de crear ejercicios
	 */
	public JButton getCrearE() {
		return crearE;
	}

	
	/**
	 * Funcion que modifica el boton de crear ejercicio
	 * @param crearE nuevo boton
	 */
	public void setCrearE(JButton crearE) {
		this.crearE = crearE;
	}

	/**
	 * Funcion que devuelve el boton de eliminar ejercicios
	 * @return boton de eliminar ejercicios
	 */
	public JButton getEliminarE() {
		return eliminarE;
	}

	/**
	 * Funcion que modifica el boton de eliminar ejercicio
	 * @param eliminarE nuevo boton
	 */
	public void setEliminarE(JButton eliminarE) {
		this.eliminarE = eliminarE;
	}

	/**
	 * Funcion que devuelve el boton de crear subtemas
	 * @return boton de crear subtemas
	 */
	public JButton getCrearSub() {
		return crearSub;
	}


	/**
	 * Funcion que devuelve el boton de eliminar subtemas
	 * @return boton de eliminar subtemas
	 */
	public JButton getEliminarSub() {
		return eliminarSub;
	}

	/**
	 * Funcion que devuelve el lista de apuntes
	 * @return lista de apuntes
	 */
	public DefaultListModel<String> getlApuntes() {
		return lApuntes;
	}

	/**
	 * Funcion que devuelve el lista de ejercicios
	 * @return lista de ejercicios
	 */
	public DefaultListModel<String> getlEjercicios() {
		return lEjercicios;
	}

	/**
	 * Funcion que devuelve el lista de subtemas
	 * @return lista de subtemas
	 */
	public DefaultListModel<String> getlSubtemas() {
		return lSubtemas;
	}

	/**
	 * Funcion que devuelve la lista de subtemas
	 * @return lista de subtemas
	 */
	public JList<String> getSubtemas() {
		return subtemas;
	}

	

	/**
	 * Funcion que devuelve la label de volver
	 * @return label volver
	 */
	public JLabel getVolver() {
		return volver;
	}



	/**
	 * Funcion que devuelve el boton de cambiar visibilidad de apuntes
	 * @return boton de visibilidad
	 */
	public JButton getCambiarvisA() {
		return cambiarvisA;
	}



	/**
	 * Funcion que devuelve el boton de cambiar visibilidad de subtema
	 * @return boton de visibilidad
	 */
	public JButton getCambiarvisSub() {
		return cambiarvisSub;
	}



	/**
	 * Funcion que devuelve el boton de cambiar visibilidad de ejercicio
	 * @return boton de visibilidad
	 */
	public JButton getCambiarvisE() {
		return cambiarvisE;
	}
	
	

}
