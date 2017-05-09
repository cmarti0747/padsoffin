package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;

/**
 * Modulo de la clase PanelTemaAlumno
 * 
 * @author Javier Senit y Carlos Marti
 *
 */
public class PanelTemaAlumno extends JPanel {

	private static final long serialVersionUID = 1L;
	private JList<String> apuntes, ejercicios;
	private JLabel nombreTema, labelapuntes, labelejercicios;
	private DefaultListModel<String> lApuntes, lEjercicios;
	private DefaultListModel<String> lSubtemas;
	private JList<String> subtemas;
	private JLabel volver;

	/**
	 * Constructor de la clase PanelTemaAlumno
	 */
	public PanelTemaAlumno() {

		nombreTema = new JLabel();
		nombreTema.setFont(new Font("Arial", 0, 40));
		labelapuntes = new JLabel("Lista de apuntes");
		labelapuntes.setFont(new Font("Arial", 0, 35));
		labelejercicios = new JLabel("Lista de ejercicios");
		labelejercicios.setFont(new Font("Arial", 0, 35));

		volver = new JLabel("Volver");
		volver.setFont(new Font("Arial", 0, 20));

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

		layout.putConstraint("HorizontalCenter", nombreTema, -350, "HorizontalCenter", this);
		layout.putConstraint("VerticalCenter", nombreTema, -250, "VerticalCenter", this);

		layout.putConstraint(SpringLayout.NORTH, barraDesplazamiento, 70, SpringLayout.SOUTH, nombreTema);

		layout.putConstraint(SpringLayout.WEST, barraDesplazamiento, 0, SpringLayout.WEST, nombreTema);

		layout.putConstraint(SpringLayout.NORTH, labelapuntes, 25, SpringLayout.SOUTH, nombreTema);
		layout.putConstraint(SpringLayout.WEST, labelapuntes, 0, SpringLayout.WEST, nombreTema);

		layout.putConstraint(SpringLayout.NORTH, labelejercicios, 25, SpringLayout.SOUTH, nombreTema);
		layout.putConstraint(SpringLayout.WEST, labelejercicios, 450, SpringLayout.WEST, nombreTema);

		layout.putConstraint(SpringLayout.NORTH, barraDesplazamiento2, 70, SpringLayout.SOUTH, nombreTema);

		layout.putConstraint(SpringLayout.WEST, barraDesplazamiento2, 325, SpringLayout.WEST, nombreTema);

		layout.putConstraint(SpringLayout.NORTH, barraDesplazamiento3, 70, SpringLayout.SOUTH, nombreTema);

		layout.putConstraint(SpringLayout.WEST, barraDesplazamiento3, 650, SpringLayout.WEST, nombreTema);

		layout.putConstraint(SpringLayout.NORTH, volver, 30, SpringLayout.SOUTH, barraDesplazamiento3);
		layout.putConstraint(SpringLayout.EAST, volver, 0, SpringLayout.EAST, barraDesplazamiento3);

		add(barraDesplazamiento);
		add(barraDesplazamiento2);
		add(barraDesplazamiento3);
		add(volver);
		add(labelapuntes);
		add(labelejercicios);
		add(nombreTema);

		setBackground(new Color(0, 255, 255));
		setVisible(true);

	}

	/**
	 * Funcion que deveulve la lista de apuntes
	 * 
	 * @return lista de apuntes
	 */
	public JList<String> getApuntes() {
		return apuntes;
	}

	/**
	 * Funcion que modifica la lista de apuntes
	 * 
	 * @param apuntes
	 *            nueva lista
	 */
	public void setApuntes(JList<String> apuntes) {
		this.apuntes = apuntes;
	}

	/**
	 * Funcion que deveulve la lista de ejercicios
	 * 
	 * @return lista de ejercicios
	 */
	public JList<String> getEjercicios() {
		return ejercicios;
	}

	/**
	 * Funcion que modifica la lista de ejercicios
	 * 
	 * @param ejercicios
	 *            nueva lista
	 */
	public void setEjercicios(JList<String> ejercicios) {
		this.ejercicios = ejercicios;
	}

	/**
	 * Funcion que deveulve el label de nombreTema
	 * 
	 * @return label NombreTema
	 */
	public JLabel getNombreTema() {
		return nombreTema;
	}

	/**
	 * Funcion que modifica el nombre de un tema
	 * 
	 * @param nombreTema
	 *            nuevo nombre
	 */
	public void setNombreTema(String nombreTema) {
		this.nombreTema.setText(nombreTema);
	}

	/**
	 * Funcion que deveulve el label de apuntes
	 * 
	 * @return label apuntes
	 */
	public JLabel getLabelapuntes() {
		return labelapuntes;
	}

	/**
	 * Funcion que modifica la label de apuntes
	 * 
	 * @param labelapuntes
	 *            nueva label
	 */
	public void setLabelapuntes(JLabel labelapuntes) {
		this.labelapuntes = labelapuntes;
	}

	/**
	 * Funcion que deveulve el label de ejercicios
	 * 
	 * @return label ejercicios
	 */
	public JLabel getLabelejercicios() {
		return labelejercicios;
	}

	/**
	 * Funcion que modifica la label de ejercicios
	 * 
	 * @param labelejercicios
	 *            nueva label
	 */
	public void setLabelejercicios(JLabel labelejercicios) {
		this.labelejercicios = labelejercicios;
	}

	/**
	 * Funcion que obtiene la lista de apuntes
	 * 
	 * @return lista de apuntes
	 */
	public DefaultListModel<String> getlApuntes() {
		return lApuntes;
	}

	/**
	 * Funcion que obtiene la lista de ejercicios
	 * 
	 * @return lista de ejercicios
	 */
	public DefaultListModel<String> getlEjercicios() {
		return lEjercicios;
	}

	/**
	 * Funcion que obtiene la lista de subtemas
	 * 
	 * @return lista de subtemas
	 */
	public DefaultListModel<String> getlSubtemas() {
		return lSubtemas;
	}

	/**
	 * Funcion que devuelve la lista de subtemas
	 * 
	 * @return lista de subtemas
	 */
	public JList<String> getSubtemas() {
		return subtemas;
	}

	/**
	 * Funcion que deveulve el label de volver
	 * 
	 * @return label volver
	 */

	public JLabel getVolver() {
		return volver;
	}

}
