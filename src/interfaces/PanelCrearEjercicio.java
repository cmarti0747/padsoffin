package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;


public class PanelCrearEjercicio extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList<String> listapreguntas;
	private JLabel labeltitulo, labellistapreguntas, seleccion, fechaInicio,fechaFin,labelponderacion;
	private JTextField titulofield,fechainiciofield,fechafinfield;
	private JRadioButton preguntatest, preguntamultiple, preguntalibre;
	private ButtonGroup group;
	private DefaultListModel<String> modelo;
	private JButton crearPregunta;
	private JButton crearEjercicio;
	private JButton cancelar;
	private JButton eliminarPregunta;
	private JTextArea ponderacionfield;
	private JCheckBox check1;
	
	
	public PanelCrearEjercicio(){
		
		
		
		modelo = new DefaultListModel<String>();
		listapreguntas = new JList<String>(modelo);
		listapreguntas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); 
		JScrollPane barraDesplazamiento = new JScrollPane(listapreguntas); 
		barraDesplazamiento.setPreferredSize(new Dimension(400,200));
		barraDesplazamiento.getViewport().setBackground(Color.WHITE);
		listapreguntas.setFont(new Font("Arial",0,17));
		
		
		
		labelponderacion = new JLabel("Peso:");
		crearPregunta = new JButton("A�adir pregunta");
		crearEjercicio = new JButton("Crear Ejercicio");
		cancelar = new JButton("Cancelar");
		eliminarPregunta = new JButton("Eliminar pregunta");
		
		labeltitulo = new JLabel("TITULO DEL EJERCICIO");
		labeltitulo.setFont(new Font("Arial",0,40));
		
		check1=new JCheckBox("Visbilidad");
        check1.setBounds(10,10,150,30);
        check1.setBackground(new Color(0,255,255));
		
		seleccion = new JLabel("SELECCIONE TIPO DE PREGUNTA");
		seleccion.setFont(new Font("Arial",0,20));
		
		fechaInicio = new JLabel("Fecha inicio:");
		fechaInicio.setFont(new Font("Arial",0,20));
		
		fechaFin = new JLabel("Fecha fin:");
		fechaFin.setFont(new Font("Arial",0,20));
		
		ponderacionfield = new JTextArea();
		ponderacionfield.setPreferredSize(new Dimension ( 60, 40));
		ponderacionfield.setFont(new Font("Arial", 0, 20));
		ponderacionfield.setLineWrap(true);
		
		fechainiciofield = new JTextField(10);
		fechainiciofield.setPreferredSize(new Dimension (25,20));
		fechainiciofield.setFont(new Font("Arial", 0, 15));
		
		fechafinfield = new JTextField(10);
		fechafinfield.setPreferredSize(new Dimension (25,20));
		fechafinfield.setFont(new Font("Arial", 0, 15));
		
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

layout.putConstraint(SpringLayout.NORTH, crearPregunta, 25, SpringLayout.SOUTH, preguntalibre);
		
		layout.putConstraint(SpringLayout.WEST, crearPregunta, 0, SpringLayout.WEST, preguntalibre);
		
layout.putConstraint(SpringLayout.NORTH, crearEjercicio,20 , SpringLayout.SOUTH, barraDesplazamiento);
		
		layout.putConstraint(SpringLayout.WEST, crearEjercicio, 0, SpringLayout.WEST, barraDesplazamiento);

layout.putConstraint(SpringLayout.NORTH, cancelar,0 , SpringLayout.NORTH, crearEjercicio);
		
		layout.putConstraint(SpringLayout.WEST, cancelar, 20, SpringLayout.EAST, crearEjercicio);

layout.putConstraint(SpringLayout.NORTH, eliminarPregunta,0 , SpringLayout.NORTH, crearPregunta);
		
		layout.putConstraint(SpringLayout.WEST, eliminarPregunta, 20, SpringLayout.EAST, crearPregunta);

		
layout.putConstraint(SpringLayout.SOUTH, seleccion, -30, SpringLayout.NORTH, preguntatest);
		
		layout.putConstraint(SpringLayout.WEST, seleccion, 0, SpringLayout.WEST, preguntatest);
		
		
layout.putConstraint(SpringLayout.NORTH, fechaInicio, 20, SpringLayout.SOUTH, crearPregunta);
		
		layout.putConstraint(SpringLayout.WEST, fechaInicio, 0, SpringLayout.WEST, crearPregunta);
		
layout.putConstraint(SpringLayout.NORTH, fechainiciofield, 0, SpringLayout.NORTH, fechaInicio);
		
		layout.putConstraint(SpringLayout.WEST, fechainiciofield, 10, SpringLayout.EAST, fechaInicio);
		
layout.putConstraint(SpringLayout.NORTH, fechaFin, 20, SpringLayout.SOUTH, fechaInicio);
		
		layout.putConstraint(SpringLayout.WEST, fechaFin, 0, SpringLayout.WEST, fechaInicio);
		
layout.putConstraint(SpringLayout.NORTH, fechafinfield, 0, SpringLayout.NORTH, fechaFin);
		
		layout.putConstraint(SpringLayout.WEST, fechafinfield, 0, SpringLayout.WEST, fechainiciofield);
		
layout.putConstraint(SpringLayout.NORTH, labelponderacion, 0, SpringLayout.NORTH, fechainiciofield);
		
		layout.putConstraint(SpringLayout.WEST, labelponderacion, 20, SpringLayout.EAST, fechainiciofield);
		
layout.putConstraint(SpringLayout.NORTH, ponderacionfield, 20, SpringLayout.SOUTH, labelponderacion);
		
		layout.putConstraint(SpringLayout.WEST, ponderacionfield, 0, SpringLayout.WEST, labelponderacion);
		
layout.putConstraint(SpringLayout.NORTH, check1, 20, SpringLayout.SOUTH, crearEjercicio);
		
		layout.putConstraint(SpringLayout.WEST, check1, 0, SpringLayout.WEST, crearEjercicio);
		
		
		
		
		
		
		add(labelponderacion);
		add(labeltitulo);
		add(titulofield);
		add(labellistapreguntas);
		add(barraDesplazamiento);
		add(preguntatest);
		add(preguntamultiple);
		add(preguntalibre);
		add(seleccion);
		add(crearPregunta);
		add(crearEjercicio);
		add(cancelar);
		add(eliminarPregunta);
		add(fechaInicio);
		add(fechainiciofield);
		add(fechaFin);
		add(ponderacionfield);
		add(fechafinfield);
		add(check1);
		setBackground(new Color(0, 255, 255));
		setVisible(true); 
		
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public JList<String> getListapreguntas() {
		return listapreguntas;
	}


	public JLabel getLabeltitulo() {
		return labeltitulo;
	}


	public JLabel getLabellistapreguntas() {
		return labellistapreguntas;
	}


	public JLabel getSeleccion() {
		return seleccion;
	}


	public JTextField getTitulofield() {
		return titulofield;
	}


	public JRadioButton getPreguntatest() {
		return preguntatest;
	}


	public JRadioButton getPreguntamultiple() {
		return preguntamultiple;
	}


	public JRadioButton getPreguntalibre() {
		return preguntalibre;
	}


	public ButtonGroup getGroup() {
		return group;
	}


	public DefaultListModel<String> getModelo() {
		return modelo;
	}


	public JButton getCrearPregunta() {
		return crearPregunta;
	}


	public JButton getCrearEjercicio() {
		return crearEjercicio;
	}


	public JButton getCancelar() {
		return cancelar;
	}


	public JButton getEliminarPregunta() {
		return eliminarPregunta;
	}


	public JLabel getFechaInicio() {
		return fechaInicio;
	}


	public JLabel getFechaFin() {
		return fechaFin;
	}


	public JTextField getFechainiciofield() {
		return fechainiciofield;
	}


	public JTextField getFechafinfield() {
		return fechafinfield;
	}


	public JLabel getLabelponderacion() {
		return labelponderacion;
	}


	public JTextArea getPonderacionfield() {
		return ponderacionfield;
	}


	public void setListapreguntas(JList<String> listapreguntas) {
		this.listapreguntas = listapreguntas;
	}


	public void setLabeltitulo(JLabel labeltitulo) {
		this.labeltitulo = labeltitulo;
	}


	public void setLabellistapreguntas(JLabel labellistapreguntas) {
		this.labellistapreguntas = labellistapreguntas;
	}


	public void setSeleccion(JLabel seleccion) {
		this.seleccion = seleccion;
	}


	public void setFechaInicio(JLabel fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public void setFechaFin(JLabel fechaFin) {
		this.fechaFin = fechaFin;
	}


	public void setLabelponderacion(JLabel labelponderacion) {
		this.labelponderacion = labelponderacion;
	}


	public void setTitulofield(String titulofield) {
		this.titulofield.setText(titulofield);;
	}


	public void setFechainiciofield(String fechainiciofield) {
		this.fechainiciofield.setText(fechainiciofield);
	}


	public void setFechafinfield(String fechafinfield) {
		this.fechafinfield.setText(fechafinfield);
	}


	public void setPreguntatest(JRadioButton preguntatest) {
		this.preguntatest = preguntatest;
	}


	public void setPreguntamultiple(JRadioButton preguntamultiple) {
		this.preguntamultiple = preguntamultiple;
	}


	public void setPreguntalibre(JRadioButton preguntalibre) {
		this.preguntalibre = preguntalibre;
	}


	public void setGroup(ButtonGroup group) {
		this.group = group;
	}


	public void setModelo(DefaultListModel<String> modelo) {
		this.modelo = modelo;
	}


	public void setCrearPregunta(JButton crearPregunta) {
		this.crearPregunta = crearPregunta;
	}


	public void setCrearEjercicio(JButton crearEjercicio) {
		this.crearEjercicio = crearEjercicio;
	}


	public void setCancelar(JButton cancelar) {
		this.cancelar = cancelar;
	}


	public void setEliminarPregunta(JButton eliminarPregunta) {
		this.eliminarPregunta = eliminarPregunta;
	}


	public void setPonderacionfield(String ponderacionfield) {
		this.ponderacionfield.setText(ponderacionfield);
	}


	public JCheckBox getCheck1() {
		return check1;
	}
	
	
	
	
	
	

}
