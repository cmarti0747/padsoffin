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
 * Modulo de la clase PanelAsignaturaAlumno
 * @author Javier Senit y Carlos Marti
 *
 */
public class PanelAsignaturaAlumno extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private DefaultListModel<String> model;
	private JList<String> listatemas;
	private JLabel labeltemas, volver,nombreAsignatura;
	private JScrollPane barraDesplazamiento;
	
	/**
	 * Constructor de la clase PanelAsignaturaAlumno
	 */
	public PanelAsignaturaAlumno(){
		
		model = new DefaultListModel<String>();
		listatemas = new JList<String>(model);
		
		listatemas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); 
		listatemas.setFont(new Font("Arial", 0, 25));
		barraDesplazamiento = new JScrollPane(listatemas); 
		barraDesplazamiento.setPreferredSize(new Dimension(500,400));
		barraDesplazamiento.getViewport().setBackground(Color.WHITE);
		
		labeltemas = new JLabel("Temas disponibles");
		labeltemas.setFont(new Font("Arial", 0, 25));
		
		nombreAsignatura = new JLabel();
		nombreAsignatura.setFont(new Font("Arial", 0, 25));
		
		volver = new JLabel("Volver");
		volver.setFont(new Font("Arial", 0, 25));
		volver.setForeground(Color.BLUE);
		
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		
		layout.putConstraint("HorizontalCenter", barraDesplazamiento, -130, "HorizontalCenter", this);
		layout.putConstraint("VerticalCenter", barraDesplazamiento, -3, "VerticalCenter", this);
		
		
		
		
		layout.putConstraint(SpringLayout.SOUTH, labeltemas, -15, SpringLayout.NORTH, barraDesplazamiento);
		layout.putConstraint(SpringLayout.WEST, labeltemas, 0, SpringLayout.WEST, barraDesplazamiento);
		
		layout.putConstraint(SpringLayout.SOUTH, nombreAsignatura, -15, SpringLayout.NORTH, labeltemas);
		layout.putConstraint(SpringLayout.WEST, nombreAsignatura, 0, SpringLayout.WEST, labeltemas);
		
		
		
		layout.putConstraint(SpringLayout.NORTH, volver, 25, SpringLayout.SOUTH, barraDesplazamiento);
		layout.putConstraint(SpringLayout.WEST, volver, 200, SpringLayout.EAST, barraDesplazamiento);
		
		setBackground(new Color(0,255,255));
		
		add(barraDesplazamiento);
		add(volver);
		add(labeltemas);
		add(nombreAsignatura);
	}


	


	/**
	 * Funcion que devuelve el modelo de una lista
	 * @return modelo de una lista
	 */
	public DefaultListModel<String> getModel() {
		return model;
	}


	/**
	 * Funcion que devuelve la lista de temas de la asignatura
	 * @return lista de temas
	 */
	public JList<String> getListatemas() {
		return listatemas;
	}


	/**
	 * Funcion que devuelve el label de temas
	 * @return label de temas
	 */
	public JLabel getLabeltemas() {
		return labeltemas;
	}

	/**
	 * Funcion que devuelve el label de volver
	 * @return label de volver
	 */
	public JLabel getVolver() {
		return volver;
	}

	/**
	 * Funcion que devuelve el label de nombre de asignatura
	 * @return label de nombre de asignatura
	 */
	public JLabel getNombreAsignatura() {
		return nombreAsignatura;
	}

/**
 * Funcion que modifica el nombre de una asignatura
 * @param nombreAsignatura nuevo nombre
 */
	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura.setText(nombreAsignatura);
	}
	
	

}
