package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;

public class PanelHomeProfesor extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultListModel<String> model,modelo;
	private JComboBox<String> alumnos;
	private JButton crearAsignatura , aceptar, denegar;
	private JList<String> listaMatriculas,listaAsignaturas;
	private JScrollPane matriculas,asignaturas;
	private JButton cambiarvis;
	public PanelHomeProfesor() {

		crearAsignatura= new JButton("Crear Asignatura");
		aceptar= new JButton("Aceptar matricula");
		denegar= new JButton("Denegar matricula");
		
		setBackground(new Color(0,255,255));
		
		alumnos= new JComboBox<String>();

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
		 
		 
		 
		 layout.putConstraint("HorizontalCenter", alumnos, -100, "HorizontalCenter", this);
			layout.putConstraint("VerticalCenter", alumnos, 0, "VerticalCenter", this);
			
			layout.putConstraint(SpringLayout.NORTH, crearAsignatura, 30, SpringLayout.SOUTH, alumnos);
			// El norte de field estará a 5 pixels desde el norte del contenedor
			layout.putConstraint(SpringLayout.EAST, crearAsignatura, 0, SpringLayout.EAST, alumnos);	
		 
			layout.putConstraint(SpringLayout.NORTH, matriculas, 0, SpringLayout.NORTH, crearAsignatura);
			
			layout.putConstraint(SpringLayout.WEST, matriculas, 200, SpringLayout.EAST, crearAsignatura);
			
			
			layout.putConstraint(SpringLayout.NORTH, asignaturas, 0, SpringLayout.NORTH, matriculas);
			
			layout.putConstraint(SpringLayout.EAST, asignaturas, -100, SpringLayout.WEST, matriculas);
		 
layout.putConstraint(SpringLayout.NORTH, cambiarvis, 3, SpringLayout.SOUTH, asignaturas);
			
			layout.putConstraint(SpringLayout.WEST, cambiarvis, 0, SpringLayout.WEST, asignaturas);
			
			
		 add(crearAsignatura);
		 add(aceptar);
		 add(denegar);
		 add(alumnos); 
      add(matriculas); 
      add(asignaturas);
      add(cambiarvis);
  }


	public JComboBox<String> getCombobox() {
		return alumnos;
	}

	public JButton getCrearAsignatura() {
		return crearAsignatura;
	}


	public JButton getAceptar() {
		return aceptar;
	}


	public JButton getDenegar() {
		return denegar;
	}


	public JList<String> getListaMatriculas() {
		return listaMatriculas;
	}


	public JList<String> getListaAsignaturas() {
		return listaAsignaturas;
	}


	public JScrollPane getBarraDesplazamiento() {
		return matriculas;
	}


	public JScrollPane getBarraDesplazamiento2() {
		return asignaturas;
	}


	public DefaultListModel<String> getModel() {
		return model;
	}


	public DefaultListModel<String> getModelo() {
		return modelo;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public JComboBox<String> getAlumnos() {
		return alumnos;
	}


	public JScrollPane getMatriculas() {
		return matriculas;
	}


	public JScrollPane getAsignaturas() {
		return asignaturas;
	}


	public JButton getCambiarvis() {
		return cambiarvis;
	}
	
	
	
	
	
}
	
	
	
	
	
	


