package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;

/**
 * Modulo de la clase PanelAsignatura
 * 
 * @author e336706
 *
 */
public class PanelAsignatura extends JPanel {

	private static final long serialVersionUID = 1L;
	private DefaultListModel<String> model;
	private JLabel nombreAsignatura;
	private JLabel labeltemas, matriculados;
	private JList<String> lista;
	private JButton crearTema, eliminarTema;
	private JComboBox<String> combobox;
	private JLabel volver;
	private JButton cambiarvis;

	/**
	 * Constructor de la clase PanelAsignatura
	 */
	public PanelAsignatura() {

		volver = new JLabel("Volver");
		volver.setFont(new Font("Arial", 0, 25));
		volver.setForeground(Color.BLUE);

		labeltemas = new JLabel("Temas");
		labeltemas.setFont(new Font("Arial", 0, 35));

		matriculados = new JLabel("Alumnos");
		matriculados.setFont(new Font("Arial", 0, 25));
		nombreAsignatura = new JLabel();
		nombreAsignatura.setFont(new Font("Arial", 0, 50));

		combobox = new JComboBox<String>();
		combobox.setPreferredSize(new Dimension(200, 50));
		combobox.setFont(new Font("Arial", 0, 25));

		crearTema = new JButton("Crear Tema");
		eliminarTema = new JButton("Eliminar Tema");
		cambiarvis = new JButton("Cambiar visivilidad");

		model = new DefaultListModel<String>();
		lista = new JList<String>(model);

		lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

		JScrollPane barraDesplazamiento = new JScrollPane(lista);
		barraDesplazamiento.setPreferredSize(new Dimension(500, 250));
		barraDesplazamiento.getViewport().setBackground(Color.WHITE);

		SpringLayout layout = new SpringLayout();
		setLayout(layout);

		layout.putConstraint("HorizontalCenter", lista, -350, "HorizontalCenter", this);
		layout.putConstraint("VerticalCenter", lista, -100, "VerticalCenter", this);

		layout.putConstraint(SpringLayout.NORTH, barraDesplazamiento, 50, SpringLayout.NORTH, labeltemas);

		layout.putConstraint(SpringLayout.WEST, barraDesplazamiento, 0, SpringLayout.WEST, labeltemas);

		layout.putConstraint(SpringLayout.SOUTH, nombreAsignatura, -75, SpringLayout.NORTH, lista);

		layout.putConstraint(SpringLayout.WEST, nombreAsignatura, 0, SpringLayout.WEST, lista);

		layout.putConstraint(SpringLayout.NORTH, labeltemas, 40, SpringLayout.SOUTH, nombreAsignatura);

		layout.putConstraint(SpringLayout.WEST, labeltemas, 0, SpringLayout.WEST, nombreAsignatura);

		layout.putConstraint(SpringLayout.SOUTH, crearTema, 0, SpringLayout.SOUTH, labeltemas);

		layout.putConstraint(SpringLayout.WEST, crearTema, 30, SpringLayout.EAST, labeltemas);

		layout.putConstraint(SpringLayout.WEST, eliminarTema, 10, SpringLayout.EAST, crearTema);

		layout.putConstraint(SpringLayout.NORTH, eliminarTema, 0, SpringLayout.NORTH, crearTema);

		layout.putConstraint(SpringLayout.WEST, cambiarvis, 10, SpringLayout.EAST, eliminarTema);

		layout.putConstraint(SpringLayout.NORTH, cambiarvis, 0, SpringLayout.NORTH, eliminarTema);

		layout.putConstraint(SpringLayout.WEST, combobox, 100, SpringLayout.EAST, barraDesplazamiento);

		layout.putConstraint(SpringLayout.NORTH, combobox, 0, SpringLayout.NORTH, barraDesplazamiento);

		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, matriculados, 0, SpringLayout.HORIZONTAL_CENTER, combobox);

		layout.putConstraint(SpringLayout.SOUTH, matriculados, -22, SpringLayout.NORTH, combobox);

		layout.putConstraint(SpringLayout.EAST, volver, 0, SpringLayout.EAST, combobox);

		layout.putConstraint(SpringLayout.NORTH, volver, 200, SpringLayout.SOUTH, combobox);

		lista.setFont(new Font("Arial", 0, 30));

		add(crearTema);
		add(combobox);
		add(matriculados);
		add(labeltemas);
		add(nombreAsignatura);
		add(barraDesplazamiento);
		add(volver);
		add(eliminarTema);
		add(cambiarvis);

		setBackground(new Color(0, 255, 255));
		setVisible(true);

	}

	/**
	 * Funcion que devuelve el modelo de una lista
	 * @return modelo de una lista
	 */
	public DefaultListModel<String> getModel() {
		return model;
	}

	/**
	 * Funcion que devuelve la label matriculados
	 * @return label matriculados
	 */
	public JLabel getMatriculados() {
		return matriculados;
	}

	/**
	 * Funcion que devuelve una lista de temas
	 * @return lista de temas
	 */
	public JList<String> getLista() {
		return lista;
	}

	/**
	 * Funcion que devuelve el combobox de alumnos matriculados
	 * @return combobox de alumnos matriculados
	 */
	public JComboBox<String> getCombobox() {
		return combobox;
	}

	/**
	 * Funcion que devuelve la label volver
	 * @return label volver
	 */
	public JLabel getVolver() {
		return volver;
	}

	/**
	 * Funcion que devuelve la label nombreAsignatura
	 * @return label nombreAsignatura
	 */
	public JLabel getNombreAsignatura() {
		return nombreAsignatura;
	}

	/**
	 * Funcioj que devuelve el boton de crear un tema
	 * @return boton de crear
	 */
	public JButton getCrearTema() {
		return crearTema;
	}

	/**
	 * Funcioj que devuelve el boton de eliminar un tema
	 * @return boton de eliminar
	 */
	public JButton getEliminarTema() {
		return eliminarTema;
	}

	/**
	 * Funcion que modifica el nombre de una asignatura
	 * @param nombreAsignatura nuevo nombre
	 */
	public void setNombreAsignatura(String nombreAsignatura) {

		this.nombreAsignatura.setText(nombreAsignatura);
		
	}

	

	/**
	 * Funcion que devuelve la label temas
	 * @return label temas
	 */
	public JLabel getLabeltemas() {
		return labeltemas;
	}

	/**
	 * Funcion que deveulve el boton de cambiar visibilidad
	 * @return boton de cambiar visibilidad
	 */
	public JButton getCambiarvis() {
		return cambiarvis;
	}

}
