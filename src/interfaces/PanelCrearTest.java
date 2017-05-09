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

public class PanelCrearTest extends JPanel{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel enunciado, volver, ponderacion, opcion, opciones;
	private JTextArea enunciadofield, opcionfield, ponderacionfield;
	private JCheckBox check1;
	private JButton anyadirOpcion;
	private DefaultListModel<String> model;
	private JList<String> listaopciones;
	private JButton eliminarOpcion;
	private JButton crearPregunta;
	
	public PanelCrearTest(){
		
		
		

		
		enunciado = new JLabel("Enunciado");
		enunciado.setFont(new Font("Arial",0,20));
		
		ponderacion = new JLabel("Ponderacion");
		ponderacion.setFont(new Font("Arial",0,20));
		
		
		opcion = new JLabel("Escriba una opcion");
		opcion.setFont(new Font("Arial",0,20));
		opciones = new JLabel("Opciones");
		opciones.setFont(new Font("Arial",0,20));
		
		
		volver = new JLabel("Volver");
		volver.setFont(new Font("Arial",0,25));
		volver.setForeground(Color.BLUE);
		
		anyadirOpcion = new JButton("A�adir opcion");
		eliminarOpcion = new JButton("Eliminar opcion");
		crearPregunta = new JButton("Crear pregunta");
		
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

		listaopciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		
		
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
		
		layout.putConstraint(SpringLayout.NORTH, eliminarOpcion, 0, SpringLayout.NORTH, anyadirOpcion);
		layout.putConstraint(SpringLayout.WEST, eliminarOpcion, 20, SpringLayout.EAST, anyadirOpcion);
		
		layout.putConstraint(SpringLayout.NORTH, crearPregunta, 0, SpringLayout.SOUTH, barraDesplazamiento);
		layout.putConstraint(SpringLayout.WEST, crearPregunta, 0, SpringLayout.WEST, ponderacionfield);
		
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
		add(crearPregunta);
		add(barraDesplazamiento);
		add(opciones);
		add(eliminarOpcion);
		add(check1);
		
		
		
		
		setBackground(new Color(0, 255, 255));
		setVisible(true); 
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JLabel getEnunciado() {
		return enunciado;
	}

	public JLabel getVolver() {
		return volver;
	}

	public JLabel getPonderacion() {
		return ponderacion;
	}

	public JLabel getOpcion() {
		return opcion;
	}

	public JLabel getOpciones() {
		return opciones;
	}

	public JTextArea getEnunciadofield() {
		return enunciadofield;
	}

	public JTextArea getOpcionfield() {
		return opcionfield;
	}

	public JTextArea getPonderacionfield() {
		return ponderacionfield;
	}

	public JCheckBox getCheck1() {
		return check1;
	}

	public JButton getAnyadirOpcion() {
		return anyadirOpcion;
	}

	public DefaultListModel<String> getModel() {
		return model;
	}

	public JList<String> getListaopciones() {
		return listaopciones;
	}

	public JButton getEliminarOpcion() {
		return eliminarOpcion;
	}

	public JButton getCrearPregunta() {
		return crearPregunta;
	}
	
	
	
	
}
