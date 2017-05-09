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

public class PanelEstadisticas extends JPanel{

	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private DefaultListModel<String> model;
private JList<String> listaestadistica;
private JLabel labelestadisticas, labelalumno;
private JLabel volver;

public PanelEstadisticas(){
	
	
	model = new DefaultListModel<String>();
	listaestadistica = new JList<String>(model); 

	listaestadistica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
	
	
	JScrollPane barraDesplazamiento = new JScrollPane(listaestadistica); 
	barraDesplazamiento.setPreferredSize(new Dimension(300,300));
	barraDesplazamiento.getViewport().setBackground(Color.WHITE);
	
	labelestadisticas = new JLabel("Estadisticas de: ");
	labelestadisticas.setFont(new Font("Arial", 0, 35));
	
	labelalumno = new JLabel();
	labelalumno.setFont(new Font("Arial", 0, 35));
	
	volver = new JLabel();
	volver.setFont(new Font("Arial", 0, 25));
	volver.setForeground(Color.BLUE);
	
	
	SpringLayout layout = new SpringLayout();
	setLayout(layout);
	
	layout.putConstraint("HorizontalCenter", barraDesplazamiento, 0, "HorizontalCenter", this);
	layout.putConstraint("VerticalCenter", barraDesplazamiento, 0, "VerticalCenter", this);
	
	
	layout.putConstraint(SpringLayout.SOUTH, labelestadisticas, -25, SpringLayout.NORTH, barraDesplazamiento);
	
	layout.putConstraint(SpringLayout.WEST, labelestadisticas, 0, SpringLayout.WEST, barraDesplazamiento);
	
	

	layout.putConstraint(SpringLayout.NORTH, labelalumno, -25, SpringLayout.NORTH, labelestadisticas);
	
	layout.putConstraint(SpringLayout.WEST, labelalumno, 10, SpringLayout.EAST, labelestadisticas);
	
layout.putConstraint(SpringLayout.NORTH, volver, 50, SpringLayout.SOUTH, barraDesplazamiento);
	
	layout.putConstraint(SpringLayout.EAST, volver, 0, SpringLayout.EAST, barraDesplazamiento);
	
	add(barraDesplazamiento);
	add(volver);
	add(labelestadisticas);
	add(labelalumno);
	
	setBackground(new Color(0, 255, 255));
	setVisible(true);
	
	
}

public DefaultListModel<String> getModel() {
	return model;
}

public void setModel(DefaultListModel<String> model) {
	this.model = model;
}

public JList<String> getListaestadistica() {
	return listaestadistica;
}

public void setListaestadistica(JList<String> listaestadistica) {
	this.listaestadistica = listaestadistica;
}

public JLabel getLabelestadisticas() {
	return labelestadisticas;
}

public void setLabelestadisticas(JLabel labelestadisticas) {
	this.labelestadisticas = labelestadisticas;
}

public JLabel getLabelalumno() {
	return labelalumno;
}

public void setLabelalumno(JLabel labelalumno) {
	this.labelalumno = labelalumno;
}

public JLabel getVolver() {
	return volver;
}

public void setVolver(JLabel volver) {
	this.volver = volver;
}


}
