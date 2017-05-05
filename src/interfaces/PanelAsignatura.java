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

public class PanelAsignatura extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultListModel<String> model;
	private JLabel nombreAsignatura;
	private JLabel labeltemas, matriculados;
	private JList<String> lista;
	private JButton crearTema, eliminarTema;
	private JComboBox<String> combobox;
	private JLabel volver;
	
	public PanelAsignatura(){
		
		
volver = new JLabel("Volver");
volver.setFont(new Font("Arial",0,15));
		
	labeltemas = new JLabel ("Lista de temas");
	labeltemas.setFont(new Font("Arial",0,35));
	
	matriculados = new JLabel ("Lista de alumnos matriculados");
	matriculados.setFont(new Font("Arial",0,25));
		nombreAsignatura = new JLabel();
		nombreAsignatura.setFont(new Font("Arial",0,50));
		
		combobox= new JComboBox<String>();
		 combobox.setPreferredSize(new Dimension(200,50));
		 combobox.setFont(new Font("Arial",0,25));
		 combobox.addItem("hola");
		crearTema = new JButton("Crear Tema");
		eliminarTema = new JButton ("Eliminar Tema");
		
		model = new DefaultListModel<String>();
		lista = new JList<String>(model); 

		lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); 
		
		
		JScrollPane barraDesplazamiento = new JScrollPane(lista); 
		barraDesplazamiento.setPreferredSize(new Dimension(500,500));
		barraDesplazamiento.getViewport().setBackground(Color.WHITE);
		
		
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		
		
		layout.putConstraint("HorizontalCenter", lista, -350, "HorizontalCenter", this);
		layout.putConstraint("VerticalCenter", lista, -100, "VerticalCenter", this);
		
		
		layout.putConstraint(SpringLayout.NORTH, barraDesplazamiento, 50, SpringLayout.NORTH, labeltemas);
		
		layout.putConstraint(SpringLayout.WEST, barraDesplazamiento, 0, SpringLayout.WEST, labeltemas);
		
		
		layout.putConstraint(SpringLayout.SOUTH, nombreAsignatura, -100, SpringLayout.NORTH, lista);
		
		layout.putConstraint(SpringLayout.WEST, nombreAsignatura, 0, SpringLayout.WEST, lista);
		
layout.putConstraint(SpringLayout.NORTH, labeltemas, 40, SpringLayout.SOUTH, nombreAsignatura);
		
		layout.putConstraint(SpringLayout.WEST, labeltemas, 0, SpringLayout.WEST, nombreAsignatura);
		
layout.putConstraint(SpringLayout.SOUTH, crearTema, 0, SpringLayout.SOUTH, labeltemas);
		
		layout.putConstraint(SpringLayout.WEST, crearTema, 30, SpringLayout.EAST, labeltemas);
		
layout.putConstraint(SpringLayout.WEST, eliminarTema, 10, SpringLayout.EAST, crearTema);
		
		layout.putConstraint(SpringLayout.NORTH, eliminarTema, 0, SpringLayout.NORTH, crearTema);
		
layout.putConstraint(SpringLayout.WEST, combobox, 575, SpringLayout.EAST, lista);
		
		layout.putConstraint(SpringLayout.NORTH, combobox, 0, SpringLayout.NORTH, lista);
		
layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, matriculados, 0, SpringLayout.HORIZONTAL_CENTER, combobox);
		
		layout.putConstraint(SpringLayout.SOUTH, matriculados, -22, SpringLayout.NORTH, combobox);
		
layout.putConstraint(SpringLayout.WEST,volver, 60, SpringLayout.EAST, combobox);
		
		layout.putConstraint(SpringLayout.NORTH, volver, 500, SpringLayout.SOUTH, combobox);
		
		lista.setFont(new Font("Arial",0,30));
		 
		
		
		add(crearTema);
		add(combobox);
		add(matriculados);
		add(labeltemas);
		add(nombreAsignatura);
		add(barraDesplazamiento); 
		add(volver);
		add(eliminarTema);
		
		
		setBackground(new Color(0, 255, 255));
		setVisible(true); 
		
		
	}


	public DefaultListModel<String> getModel() {
		return model;
	}


	public JLabel getMatriculados() {
		return matriculados;
	}


	public JList<String> getLista() {
		return lista;
	}


	public JComboBox<String> getCombobox() {
		return combobox;
	}


	public JLabel getVolver() {
		return volver;
	}


	public JLabel getNombreAsignatura() {
		return nombreAsignatura;
	}


	public JButton getCrearTema() {
		return crearTema;
	}


	public JButton getEliminarTema() {
		return eliminarTema;
	}


	public void setNombreAsignatura(String nombreAsignatura) {
		
		this.nombreAsignatura.setText(nombreAsignatura);;
	}
	
	
	
	
}
