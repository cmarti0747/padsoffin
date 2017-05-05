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

public class PanelTema extends JPanel{
	private JList apuntes, ejercicios;
	private JLabel nombreTema, labelapuntes, labelejercicios;
	private JButton crearA, eliminarA, crearE, eliminarE;
	private JButton crearSub;
	private JButton eliminarSub;
	private DefaultListModel<String> lApuntes,lEjercicios;
	private DefaultListModel<String> lSubtemas;
	private JList subtemas;
	
	public PanelTema(){
		
		nombreTema = new JLabel();
		nombreTema.setFont(new Font("Arial",0,40));
		labelapuntes = new JLabel("Lista de apuntes");
		labelapuntes.setFont(new Font("Arial",0,35));
		labelejercicios = new JLabel("Lista de ejercicios");
		labelejercicios.setFont(new Font("Arial",0,35));
		
		
		crearA = new JButton("Crear Apunte");
		eliminarA = new JButton("Eliminar Apunte");
		
		crearE = new JButton("Crear Ejercicio");
		eliminarE = new JButton("Eliminar Ejercicio");
		
		crearSub = new JButton("Crear Subtema");
		eliminarSub = new JButton("Eliminar Subtema");
		
		lApuntes = new DefaultListModel<String>();
		apuntes = new JList(lApuntes);
		apuntes.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); 
		JScrollPane barraDesplazamiento = new JScrollPane(apuntes); 
		barraDesplazamiento.setPreferredSize(new Dimension(250,250));
		barraDesplazamiento.getViewport().setBackground(Color.WHITE);
		apuntes.setFont(new Font("Arial",0,30));
		
		lEjercicios = new DefaultListModel<String>();
		ejercicios = new JList(lEjercicios);
		ejercicios.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); 
		JScrollPane barraDesplazamiento2 = new JScrollPane(ejercicios); 
		barraDesplazamiento2.setPreferredSize(new Dimension(250,250));
		barraDesplazamiento2.getViewport().setBackground(Color.WHITE);
		ejercicios.setFont(new Font("Arial",0,30));
		
		
		lSubtemas = new DefaultListModel<String>();
		subtemas = new JList(lSubtemas);
		subtemas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); 
		JScrollPane barraDesplazamiento3 = new JScrollPane(subtemas); 
		barraDesplazamiento3.setPreferredSize(new Dimension(250,250));
		barraDesplazamiento3.getViewport().setBackground(Color.WHITE);
		subtemas.setFont(new Font("Arial",0,30));
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
		
			
		
		
layout.putConstraint(SpringLayout.NORTH, crearA, 35, SpringLayout.SOUTH, barraDesplazamiento);
		
		layout.putConstraint(SpringLayout.WEST, crearA, -5, SpringLayout.WEST, barraDesplazamiento);
		
layout.putConstraint(SpringLayout.NORTH, eliminarA, 0, SpringLayout.NORTH, crearA);
		
		layout.putConstraint(SpringLayout.WEST, eliminarA, 10, SpringLayout.EAST, crearA);
		
		
		
		
		
layout.putConstraint(SpringLayout.NORTH, crearE, 35, SpringLayout.SOUTH, barraDesplazamiento2);
		
		layout.putConstraint(SpringLayout.WEST, crearE, -5, SpringLayout.WEST, barraDesplazamiento2);
		
layout.putConstraint(SpringLayout.NORTH, eliminarE, 0, SpringLayout.NORTH, crearE);
		
		layout.putConstraint(SpringLayout.WEST, eliminarE, 10, SpringLayout.EAST, crearE);
		
		
layout.putConstraint(SpringLayout.NORTH, crearSub, 35, SpringLayout.SOUTH, barraDesplazamiento3);
		
		layout.putConstraint(SpringLayout.WEST, crearSub,-5, SpringLayout.WEST, barraDesplazamiento3);
		
layout.putConstraint(SpringLayout.NORTH, eliminarSub, 0, SpringLayout.NORTH, crearSub);
		
		layout.putConstraint(SpringLayout.WEST, eliminarSub, 10, SpringLayout.EAST, crearSub);
		
		


		
		add(barraDesplazamiento);
		add(barraDesplazamiento2);
		add(barraDesplazamiento3);
		add(crearA);
		add(eliminarA);
		
		add(crearE);
		add(eliminarE);
		add(crearSub);
		add(eliminarSub);
		
add(labelapuntes);
add(labelejercicios);
		add(nombreTema);
		
		setBackground(new Color(0, 255, 255));
		setVisible(true); 
		
	}


	public JList getApuntes() {
		return apuntes;
	}


	public void setApuntes(JList apuntes) {
		this.apuntes = apuntes;
	}


	public JList getEjercicios() {
		return ejercicios;
	}


	public void setEjercicios(JList ejercicios) {
		this.ejercicios = ejercicios;
	}


	public JLabel getNombreTema() {
		return nombreTema;
	}


	public void setNombreTema(String nombreTema) {
		this.nombreTema.setText(nombreTema);
	}


	public JLabel getLabelapuntes() {
		return labelapuntes;
	}


	public void setLabelapuntes(JLabel labelapuntes) {
		this.labelapuntes = labelapuntes;
	}


	public JLabel getLabelejercicios() {
		return labelejercicios;
	}


	public void setLabelejercicios(JLabel labelejercicios) {
		this.labelejercicios = labelejercicios;
	}


	public JButton getCrearA() {
		return crearA;
	}


	public void setCrearA(JButton crearA) {
		this.crearA = crearA;
	}


	public JButton getEliminarA() {
		return eliminarA;
	}


	public void setEliminarA(JButton eliminarA) {
		this.eliminarA = eliminarA;
	}


	public JButton getCrearE() {
		return crearE;
	}


	public void setCrearE(JButton crearE) {
		this.crearE = crearE;
	}


	public JButton getEliminarE() {
		return eliminarE;
	}


	public void setEliminarE(JButton eliminarE) {
		this.eliminarE = eliminarE;
	}
	
	
	
	
}
