package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;

public class PanelCrearMultiple extends JPanel{

	
	private JLabel enunciado, volver, ponderacion, opcion, opciones;
	private JTextArea enunciadofield, opcionfield, ponderacionfield;
	private JCheckBox check1;
	private JButton anyadirOpcion;
	private DefaultListModel<String> model;
	private JList<String> listaopciones;
	
	public PanelCrearMultiple(){
		
		
		

		
		enunciado = new JLabel("Enunciado");
		enunciado.setFont(new Font("Arial",0,20));
		
		ponderacion = new JLabel("Ponderacion");
		ponderacion.setFont(new Font("Arial",0,20));
		
		
		opcion = new JLabel("Escriba una opcion");
		opcion.setFont(new Font("Arial",0,20));
		opciones = new JLabel("Opciones");
		opciones.setFont(new Font("Arial",0,20));
		
		
		volver = new JLabel("Volver");
		volver.setFont(new Font("Arial",0,20));
		
		anyadirOpcion = new JButton("Añadir opcion");
		
		check1=new JCheckBox("Visbilidad");
		check1.setFont(new Font("Arial", 0, 20));
        check1.setBounds(10,10,150,30);
        check1.setBackground(new Color(0,255,255));
		
		enunciadofield = new JTextArea();
		enunciadofield.setPreferredSize(new Dimension ( 750, 100));
		enunciadofield.setFont(new Font("Arial", 0, 20));
		enunciadofield.setLineWrap(true);
		ponderacionfield = new JTextArea();
		ponderacionfield.setPreferredSize(new Dimension ( 60, 40));
		ponderacionfield.setFont(new Font("Arial", 0, 20));
		ponderacionfield.setLineWrap(true);
		opcionfield = new JTextArea();
		opcionfield.setFont(new Font("Arial", 0, 20));
		opcionfield.setPreferredSize(new Dimension (400,30));
		opcionfield.setLineWrap(true);
		
		
		model = new DefaultListModel<String>();
		listaopciones = new JList<String>(model); 

		listaopciones.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); 
		
		
		JScrollPane barraDesplazamiento = new JScrollPane(listaopciones); 
		barraDesplazamiento.setPreferredSize(new Dimension(300,300));
		barraDesplazamiento.getViewport().setBackground(Color.WHITE);
		
		
		
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		
		layout.putConstraint("HorizontalCenter", enunciado, 0, "HorizontalCenter", this);
		layout.putConstraint("VerticalCenter", enunciado, -300, "VerticalCenter", this);
		
		
		layout.putConstraint(SpringLayout.NORTH, enunciadofield, 20, SpringLayout.SOUTH, enunciado);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, enunciadofield, 0, SpringLayout.HORIZONTAL_CENTER, enunciado);
		
		layout.putConstraint(SpringLayout.NORTH, opcion, 40, SpringLayout.SOUTH, enunciadofield);
		layout.putConstraint(SpringLayout.WEST, opcion, 0, SpringLayout.WEST, enunciadofield);
		
		layout.putConstraint(SpringLayout.NORTH, opcionfield, 20, SpringLayout.SOUTH, opcion);
		layout.putConstraint(SpringLayout.WEST, opcionfield, 0, SpringLayout.WEST, opcion);
		
		layout.putConstraint(SpringLayout.NORTH, anyadirOpcion, 20, SpringLayout.SOUTH, opcionfield);
		layout.putConstraint(SpringLayout.WEST, anyadirOpcion, 0, SpringLayout.WEST, opcionfield);
		
		layout.putConstraint(SpringLayout.NORTH, volver, 50, SpringLayout.SOUTH, anyadirOpcion);
		layout.putConstraint(SpringLayout.WEST, volver, 50, SpringLayout.EAST, anyadirOpcion);
		
		layout.putConstraint(SpringLayout.NORTH, ponderacion, 30, SpringLayout.SOUTH, anyadirOpcion);
		layout.putConstraint(SpringLayout.WEST, ponderacion,0 , SpringLayout.WEST, anyadirOpcion);
		
		
		
		layout.putConstraint(SpringLayout.NORTH, ponderacionfield, 15, SpringLayout.SOUTH, ponderacion);
		layout.putConstraint(SpringLayout.WEST, ponderacionfield, 0, SpringLayout.WEST, ponderacion);
		
		layout.putConstraint(SpringLayout.NORTH, check1, 0, SpringLayout.NORTH, ponderacion);
		layout.putConstraint(SpringLayout.WEST, check1, 35, SpringLayout.EAST, ponderacion);
		
		layout.putConstraint(SpringLayout.NORTH, barraDesplazamiento, 0, SpringLayout.NORTH, opcionfield);
		layout.putConstraint(SpringLayout.WEST, barraDesplazamiento, 100, SpringLayout.EAST, opcionfield);
		
		layout.putConstraint(SpringLayout.SOUTH, opciones, -20, SpringLayout.NORTH, barraDesplazamiento);
		layout.putConstraint(SpringLayout.WEST, opciones, 0, SpringLayout.WEST, barraDesplazamiento);
		
		
		add(enunciado);
		add(enunciadofield);
		
		add(opcionfield);
		add(volver);
		add(anyadirOpcion);
		add(ponderacion);
		add(ponderacionfield);
		add(opcion);
		
		add(barraDesplazamiento);
		add(opciones);
		
		add(check1);
		
		
		
		
		setBackground(new Color(0, 255, 255));
		setVisible(true); 
	}
	
	
}
