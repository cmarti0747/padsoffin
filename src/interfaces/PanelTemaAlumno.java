package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;

public class PanelTemaAlumno extends JPanel{
	private JList apuntes, ejercicios;
	private JLabel nombreTema, labelapuntes, labelejercicios, volver;
	
	
	
	public PanelTemaAlumno(){
		

		String[] nombres = {"Ana","Margarita","Daniela","Divian", 
		"Leslie","Paz","Andrea","Macarena"}; 
		
		nombreTema = new JLabel("JAVA SWING");
		nombreTema.setFont(new Font("Arial",0,40));
		labelapuntes = new JLabel("Lista de apuntes");
		labelapuntes.setFont(new Font("Arial",0,35));
		labelejercicios = new JLabel("Lista de ejercicios");
		labelejercicios.setFont(new Font("Arial",0,35));
		
		
		volver = new JLabel("Volver");
		volver.setFont(new Font("Arial",0,17));
		
		
		
		
		apuntes = new JList(nombres);
		apuntes.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); 
		JScrollPane barraDesplazamiento = new JScrollPane(apuntes); 
		barraDesplazamiento.setPreferredSize(new Dimension(250,250));
		barraDesplazamiento.getViewport().setBackground(Color.WHITE);
		apuntes.setFont(new Font("Arial",0,30));
		
		ejercicios = new JList(nombres);
		ejercicios.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); 
		JScrollPane barraDesplazamiento2 = new JScrollPane(ejercicios); 
		barraDesplazamiento2.setPreferredSize(new Dimension(250,250));
		barraDesplazamiento2.getViewport().setBackground(Color.WHITE);
		ejercicios.setFont(new Font("Arial",0,30));
		
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
		
		
layout.putConstraint(SpringLayout.NORTH, barraDesplazamiento2, 67, SpringLayout.SOUTH, nombreTema);
		
		layout.putConstraint(SpringLayout.WEST, barraDesplazamiento2, 450, SpringLayout.WEST, nombreTema);
		
		
		layout.putConstraint(SpringLayout.NORTH, volver, 100, SpringLayout.SOUTH, barraDesplazamiento2);
		layout.putConstraint(SpringLayout.WEST, volver, 95, SpringLayout.EAST, barraDesplazamiento2);
				
		

		
		
		
		

		
		

		
		add(barraDesplazamiento);
		add(barraDesplazamiento2);
		
		
		
add(labelapuntes);
add(labelejercicios);
		add(nombreTema);
		add(volver);
		
		setBackground(new Color(0, 255, 255));
		setVisible(true); 
		
	}
	
	
}