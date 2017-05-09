package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

public class PanelCrearLibre extends JPanel{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel enunciado, solucion, volver, ponderacion;
	private JTextArea enunciadofield, solucionfield, ponderacionfield;
	private JCheckBox check1;
	private JButton crearPregunta;
	
	public PanelCrearLibre(){
		
		enunciado = new JLabel("Enunciado");
		enunciado.setFont(new Font("Arial",0,20));
		
		ponderacion = new JLabel("Ponderacion");
		ponderacion.setFont(new Font("Arial",0,20));
		
		solucion = new JLabel("Solucion");
		solucion.setFont(new Font("Arial",0,20));
		
		volver = new JLabel("Volver");
		volver.setFont(new Font("Arial",0,25));
		volver.setForeground(Color.BLUE);
		
		check1=new JCheckBox("Visbilidad");
		check1.setFont(new Font("Arial", 0, 20));
        check1.setBounds(10,10,150,30);
        check1.setBackground(new Color(0,255,255));
        
        crearPregunta = new JButton("Crear Pregunta");
		
		enunciadofield = new JTextArea();
		enunciadofield.setPreferredSize(new Dimension ( 750, 100));
		enunciadofield.setFont(new Font("Arial", 0, 20));
		enunciadofield.setLineWrap(true);
		ponderacionfield = new JTextArea();
		ponderacionfield.setPreferredSize(new Dimension ( 60, 40));
		ponderacionfield.setFont(new Font("Arial", 0, 20));
		ponderacionfield.setLineWrap(true);
		solucionfield = new JTextArea();
		solucionfield.setFont(new Font("Arial", 0, 20));
		solucionfield.setPreferredSize(new Dimension (750,250));
		solucionfield.setLineWrap(true);
		
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		
		layout.putConstraint("HorizontalCenter", enunciado, 0, "HorizontalCenter", this);
		layout.putConstraint("VerticalCenter", enunciado, -300, "VerticalCenter", this);
		
		
		layout.putConstraint(SpringLayout.NORTH, enunciadofield, 20, SpringLayout.SOUTH, enunciado);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, enunciadofield, 0, SpringLayout.HORIZONTAL_CENTER, enunciado);
		
		layout.putConstraint(SpringLayout.NORTH, solucion, 50, SpringLayout.SOUTH, enunciadofield);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, solucion, 0, SpringLayout.HORIZONTAL_CENTER, enunciadofield);
		
		layout.putConstraint(SpringLayout.NORTH, solucionfield, 20, SpringLayout.SOUTH, solucion);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, solucionfield, 0, SpringLayout.HORIZONTAL_CENTER, solucion);
		
		layout.putConstraint(SpringLayout.NORTH, volver, 50, SpringLayout.SOUTH, solucionfield);
		layout.putConstraint(SpringLayout.WEST, volver, 50, SpringLayout.EAST, solucionfield);
		
		layout.putConstraint(SpringLayout.NORTH, ponderacion, 10, SpringLayout.SOUTH, solucionfield);
		layout.putConstraint(SpringLayout.WEST, ponderacion,0 , SpringLayout.WEST, solucionfield);
		
		
		
		layout.putConstraint(SpringLayout.NORTH, ponderacionfield, 15, SpringLayout.SOUTH, ponderacion);
		layout.putConstraint(SpringLayout.WEST, ponderacionfield, 0, SpringLayout.WEST, ponderacion);
		
		layout.putConstraint(SpringLayout.NORTH, check1, 0, SpringLayout.NORTH, ponderacion);
		layout.putConstraint(SpringLayout.WEST, check1, 35, SpringLayout.EAST, ponderacion);
		
		
		layout.putConstraint(SpringLayout.NORTH, crearPregunta, 20, SpringLayout.SOUTH, solucionfield);
		layout.putConstraint(SpringLayout.EAST, crearPregunta, 0, SpringLayout.EAST, solucionfield);
		
		
		add(enunciado);
		add(enunciadofield);
		add(solucion);
		add(solucionfield);
		add(volver);
		add(ponderacion);
		add(ponderacionfield);
		add(check1);
		add(crearPregunta);
		
		
		
		setBackground(new Color(0, 255, 255));
		setVisible(true); 
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JLabel getEnunciado() {
		return enunciado;
	}

	public JLabel getSolucion() {
		return solucion;
	}

	public JLabel getVolver() {
		return volver;
	}

	public JLabel getPonderacion() {
		return ponderacion;
	}

	public JTextArea getEnunciadofield() {
		return enunciadofield;
	}

	public JTextArea getSolucionfield() {
		return solucionfield;
	}

	public JTextArea getPonderacionfield() {
		return ponderacionfield;
	}

	public JCheckBox getCheck1() {
		return check1;
	}

	public JButton getCrearPregunta() {
		return crearPregunta;
	}
	
	
	
}
