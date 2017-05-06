package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;

public class PanelAsignaturaAlumno extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultListModel<String> model;
	private JList<String> listatemas;
	private JLabel labeltemas, volver,nombreAsignatura;
	private JScrollPane barraDesplazamiento;
	
	public PanelAsignaturaAlumno(){
		
		model = new DefaultListModel<String>();
		listatemas = new JList<String>(model);
		
		listatemas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); 
		listatemas.setFont(new Font("Arial", 0, 25));
		barraDesplazamiento = new JScrollPane(listatemas); 
		barraDesplazamiento.setPreferredSize(new Dimension(500,400));
		barraDesplazamiento.getViewport().setBackground(Color.WHITE);
		
		labeltemas = new JLabel("Temas disponibles");
		labeltemas.setFont(new Font("Arial", 0, 25));
		
		nombreAsignatura = new JLabel();
		nombreAsignatura.setFont(new Font("Arial", 0, 25));
		
		volver = new JLabel("Volver");
		volver.setFont(new Font("Arial", 0, 17));
		
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		
		layout.putConstraint("HorizontalCenter", barraDesplazamiento, -130, "HorizontalCenter", this);
		layout.putConstraint("VerticalCenter", barraDesplazamiento, -3, "VerticalCenter", this);
		
		
		
		
		layout.putConstraint(SpringLayout.SOUTH, labeltemas, -15, SpringLayout.NORTH, barraDesplazamiento);
		layout.putConstraint(SpringLayout.WEST, labeltemas, 0, SpringLayout.WEST, barraDesplazamiento);
		
		layout.putConstraint(SpringLayout.SOUTH, nombreAsignatura, -15, SpringLayout.NORTH, labeltemas);
		layout.putConstraint(SpringLayout.WEST, nombreAsignatura, 0, SpringLayout.WEST, labeltemas);
		
		
		
		layout.putConstraint(SpringLayout.NORTH, volver, 25, SpringLayout.SOUTH, barraDesplazamiento);
		layout.putConstraint(SpringLayout.WEST, volver, 200, SpringLayout.EAST, barraDesplazamiento);
		
		setBackground(new Color(0,255,255));
		
		add(barraDesplazamiento);
		add(volver);
		add(labeltemas);
		add(nombreAsignatura);
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public DefaultListModel<String> getModel() {
		return model;
	}


	public JList<String> getListatemas() {
		return listatemas;
	}


	public JLabel getLabeltemas() {
		return labeltemas;
	}


	public JLabel getVolver() {
		return volver;
	}


	public JLabel getNombreAsignatura() {
		return nombreAsignatura;
	}


	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura.setText(nombreAsignatura);
	}
	
	

}
