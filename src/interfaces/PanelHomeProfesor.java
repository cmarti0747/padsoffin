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
 * Módulo de la clase PanelHomeProfesor
 * 
 * @author Javier Senit y Carlos Marti
 *
 */
public class PanelHomeProfesor extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultListModel<String> model,modelo;
	private JComboBox<String> alumnos;
	private JButton n , aceptar, denegar, crearAsignatura;
	private JList<String> listaMatriculas,listaAsignaturas;
	private JScrollPane matriculas,asignaturas;
	private JButton cambiarvis;
	private JLabel labelalumnos, labelasignaturas, labelmatriculas;
	
	/**
	 * Contructor de la clase PanelHomeProfesor
	 */
	public PanelHomeProfesor() {

		n= new JButton("");
		aceptar= new JButton("Aceptar matricula");
		denegar= new JButton("Denegar matricula");
		
		crearAsignatura = new JButton("Crear Asignatura");
		
		setBackground(new Color(0,255,255));
		
		alumnos= new JComboBox<String>();
		
		labelalumnos = new JLabel("Alumnos");
		labelalumnos.setFont(new Font( "Arial",0,30));
		

		labelasignaturas = new JLabel("Asignaturas");
		labelasignaturas.setFont(new Font( "Arial",0,30));
		
		labelmatriculas = new JLabel("Matriculas pendientes");
		labelmatriculas.setFont(new Font( "Arial",0,30));
		
		
		
		
		 model = new DefaultListModel<String>();
		 listaMatriculas = new JList<String>(model); 
		 modelo = new DefaultListModel<String>();
		 listaAsignaturas = new JList<String>(modelo); 
			
		 alumnos.setPreferredSize(new Dimension(200,50));
		 alumnos.setFont(new Font("Arial",0,25));
		 listaMatriculas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 
		 matriculas = new JScrollPane(listaMatriculas); 
		 matriculas.setPreferredSize(new Dimension(300,200));
		 matriculas.getViewport().setBackground(Color.WHITE);
		 
		
		  asignaturas = new JScrollPane(listaAsignaturas); 
		  asignaturas.setPreferredSize(new Dimension(300,200));
		  asignaturas.getViewport().setBackground(Color.WHITE);
			 
		  
		  cambiarvis = new JButton("Cambiar visivilidad");
		  
		 SpringLayout layout = new SpringLayout();
		 setLayout(layout);
		 
		 
		 
		 layout.putConstraint("HorizontalCenter", alumnos, -350, "HorizontalCenter", this);
			layout.putConstraint("VerticalCenter", alumnos, -150, "VerticalCenter", this);
			
			layout.putConstraint(SpringLayout.NORTH, n, 30, SpringLayout.SOUTH, alumnos);
			// El norte de field estará a 5 pixels desde el norte del contenedor
			layout.putConstraint(SpringLayout.EAST, n, 40, SpringLayout.EAST, alumnos);	
		 
			layout.putConstraint(SpringLayout.NORTH, matriculas, -80, SpringLayout.NORTH, n);
			
			layout.putConstraint(SpringLayout.WEST, matriculas, 360, SpringLayout.EAST, n);
			
			
			layout.putConstraint(SpringLayout.NORTH, asignaturas, 0, SpringLayout.NORTH, matriculas);
			
			layout.putConstraint(SpringLayout.EAST, asignaturas, -60, SpringLayout.WEST, matriculas);
		 
layout.putConstraint(SpringLayout.NORTH, crearAsignatura, 3, SpringLayout.SOUTH, asignaturas);
			
			layout.putConstraint(SpringLayout.WEST, crearAsignatura, 0, SpringLayout.WEST, asignaturas);
			
layout.putConstraint(SpringLayout.NORTH, cambiarvis, 0, SpringLayout.NORTH, crearAsignatura);
			
			layout.putConstraint(SpringLayout.WEST, cambiarvis, 4, SpringLayout.EAST, crearAsignatura);
			
layout.putConstraint(SpringLayout.NORTH, aceptar, 3, SpringLayout.SOUTH, matriculas);
			
			layout.putConstraint(SpringLayout.WEST, aceptar, 0, SpringLayout.WEST, matriculas);
			
layout.putConstraint(SpringLayout.NORTH, denegar, 0, SpringLayout.NORTH, aceptar);
			
			layout.putConstraint(SpringLayout.WEST, denegar, 4, SpringLayout.EAST, aceptar);
			
layout.putConstraint(SpringLayout.SOUTH, labelalumnos, -15, SpringLayout.NORTH, alumnos);
			
			layout.putConstraint(SpringLayout.WEST, labelalumnos, 0, SpringLayout.WEST, alumnos);
			
			
layout.putConstraint(SpringLayout.SOUTH, labelasignaturas, -15, SpringLayout.NORTH, asignaturas);
			
			layout.putConstraint(SpringLayout.WEST, labelasignaturas, 0, SpringLayout.WEST, asignaturas);
			
layout.putConstraint(SpringLayout.SOUTH, labelmatriculas, -15, SpringLayout.NORTH, matriculas);
			
			layout.putConstraint(SpringLayout.WEST, labelmatriculas, 0, SpringLayout.WEST, matriculas);
			
			
		 add(crearAsignatura);
		 add(aceptar);
		 add(denegar);
		 add(alumnos); 
      add(matriculas); 
      add(asignaturas);
      add(cambiarvis);
      add(labelalumnos);
      add(labelasignaturas);
      add(labelmatriculas);
  }

	/**
	 * Funcion que devuelve el string del combobox
	 * @return string del combobox
	 */
	public JComboBox<String> getCombobox() {
		return alumnos;
	}

	/**
	 * Funcion que devuelve el boton de crear asignatura 
	 * @return botont de crear asignatura
	 */
	public JButton getCrearAsignatura() {
		return crearAsignatura;
	}

	/**
	 * Funcion que devuelve el boton de aceptar asignatura 
	 * @return botont de aceptar asignatura
	 */
	public JButton getAceptar() {
		return aceptar;
	}

	/**
	 * Funcion que devuelve el boton de denegar 
	 * @return boton de denegar asignatura
	 */
	public JButton getDenegar() {
		return denegar;
	}


	/**
	 * Funcion que devuelve la lista de matriculas
	 * @return lista de matriculas
	 */
	public JList<String> getListaMatriculas() {
		return listaMatriculas;
	}


	/**
	 * Funcion que devuelve la lista de asignaturas
	 * @return lista de asignaturas
	 */
	public JList<String> getListaAsignaturas() {
		return listaAsignaturas;
	}

	
	/**
	 * Funcion que devuelve la lista scroll de matriculas
	 * @return lista scroll de matriculas
	 */
	public JScrollPane getBarraDesplazamiento() {
		return matriculas;
	}



	/**
	 * Funcion que devuelve la lista scroll de asignaturas
	 * @return lista scroll de asignaturas
	 */
	public JScrollPane getBarraDesplazamiento2() {
		return asignaturas;
	}



	/**
	 * Funcion que devuelve el modelo de una lista
	 * @return modelo de una lista
	 */
	public DefaultListModel<String> getModel() {
		return model;
	}

	/**
	 * Funcion que devuelve el modelo de una lista
	 * @return modelo de una lista
	 */
	public DefaultListModel<String> getModelo() {
		return modelo;
	}



	/**
	 * Funcion que devuelve el los strings del combobox de alumno
	 * @return strings del combobox de alumno
	 */
	public JComboBox<String> getAlumnos() {
		return alumnos;
	}


	/**
	 * Funcion que devuelve el scrollpane de matriculas
	 * @return scrollpane de matriculas
	 */
	public JScrollPane getMatriculas() {
		return matriculas;
	}


	/**
	 * Funcion que devuelve el scrollpane de asignaturas
	 * @return scrollpane de asignaturas
	 */
	public JScrollPane getAsignaturas() {
		return asignaturas;
	}


	/**
	 * Funcion que devuelve la visibilidad de una asignatura
	 * @return visibilidad de la asignatura
	 */
	public JButton getCambiarvis() {
		return cambiarvis;
	}
	
	
	
	
	
}
	
	
	
	
	
	


