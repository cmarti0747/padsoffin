package interfaces;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;


public class PanelCrearEjercicio extends JPanel{
	
	private JList listapreguntas;
	private JLabel labeltitulo, labellistapreguntas, seleccion;
	private JTextField titulofield;
	private JRadioButton preguntatest, preguntamultiple, preguntalibre;
	private ButtonGroup group;
	
	
	public PanelCrearEjercicio(){
		String[] nombres = {"Ana","Margarita","Daniela","Divian", 
				"Leslie","Paz","Andrea","Macarena"}; 
		
		
		
		
		listapreguntas = new JList(nombres);
		listapreguntas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); 
		JScrollPane barraDesplazamiento = new JScrollPane(listapreguntas); 
		barraDesplazamiento.setPreferredSize(new Dimension(400,400));
		barraDesplazamiento.getViewport().setBackground(Color.WHITE);
		listapreguntas.setFont(new Font("Arial",0,17));
		
		
		
		
		labeltitulo = new JLabel("TITULO DEL EJERCICIO");
		labeltitulo.setFont(new Font("Arial",0,40));
		
		seleccion = new JLabel("SELECCIONE TIPO DE PREGUNTA");
		seleccion.setFont(new Font("Arial",0,20));
		
		
		labellistapreguntas = new JLabel("PREGUNTAS DEL EJERCICIO");
		labeltitulo.setFont(new Font("Arial",0,40));
		
		titulofield = new JTextField(30);
		titulofield.setPreferredSize(new Dimension ( 100, 45));
		titulofield.setFont(new Font("Arial", 0, 20));
		
		preguntatest = new JRadioButton("Tipo test");
		preguntatest.setFont(new Font("Arial",0,27));
		preguntatest.setBackground(new Color (0,255,255));
		
	    preguntamultiple = new JRadioButton("Tipo multiple");
	    preguntamultiple.setFont(new Font("Arial",0,27));
	    preguntamultiple.setBackground(new Color (0,255,255));
	    
	    preguntalibre = new JRadioButton("Tipo libre");
	    preguntalibre.setFont(new Font("Arial",0,27));
	    preguntalibre.setBackground(new Color (0,255,255));
	 
	        group = new ButtonGroup();
	        group.add(preguntatest);
	        group.add(preguntamultiple);
	        group.add(preguntalibre);
	        
		
		
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		
		layout.putConstraint("HorizontalCenter", labeltitulo, 200, "HorizontalCenter", this);
		layout.putConstraint("VerticalCenter", labeltitulo, -250, "VerticalCenter", this);
		
		layout.putConstraint(SpringLayout.NORTH, titulofield, 25, SpringLayout.SOUTH, labeltitulo);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, titulofield, 0, SpringLayout.HORIZONTAL_CENTER, labeltitulo);
		
		
		layout.putConstraint(SpringLayout.NORTH, labellistapreguntas, 25, SpringLayout.SOUTH, titulofield);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labellistapreguntas, 0, SpringLayout.HORIZONTAL_CENTER, labeltitulo);
		
		layout.putConstraint(SpringLayout.NORTH, barraDesplazamiento, 25, SpringLayout.SOUTH, labellistapreguntas);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, barraDesplazamiento, 0, SpringLayout.HORIZONTAL_CENTER, labellistapreguntas);
		
		
		
layout.putConstraint(SpringLayout.NORTH, preguntatest, 50, SpringLayout.NORTH, barraDesplazamiento);
		
		layout.putConstraint(SpringLayout.EAST, preguntatest, -280, SpringLayout.WEST, barraDesplazamiento);
		
		
layout.putConstraint(SpringLayout.NORTH, preguntamultiple, 50, SpringLayout.NORTH, preguntatest);
		
		layout.putConstraint(SpringLayout.WEST, preguntamultiple, 0, SpringLayout.WEST, preguntatest);
		
		
layout.putConstraint(SpringLayout.NORTH, preguntalibre, 50, SpringLayout.NORTH, preguntamultiple);
		
		layout.putConstraint(SpringLayout.WEST, preguntalibre, 0, SpringLayout.WEST, preguntamultiple);
		
		
layout.putConstraint(SpringLayout.SOUTH, seleccion, -30, SpringLayout.NORTH, preguntatest);
		
		layout.putConstraint(SpringLayout.WEST, seleccion, 0, SpringLayout.WEST, preguntatest);
		
		
		add(labeltitulo);
		add(titulofield);
		add(labellistapreguntas);
		add(barraDesplazamiento);
		add(preguntatest);
		add(preguntamultiple);
		add(preguntalibre);
		add(seleccion);
		
		
		setBackground(new Color(0, 255, 255));
		setVisible(true); 
		
	}
	
	
	
	

}
