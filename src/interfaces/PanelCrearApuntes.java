package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class PanelCrearApuntes extends JPanel{

	
	private JLabel titulo, texto, volver;
	private JTextField titulofield, textofield;
	private JButton crearapunte;
	private JCheckBox check1;
	
	public PanelCrearApuntes(){
		
		crearapunte = new JButton("Crear apunte");
		
		
		titulo = new JLabel("TITULO DEL APUNTE");
		titulo.setFont(new Font("Arial",0,35));
		
		volver = new JLabel ("Volver");
		volver.setFont(new Font("Arial",0,20));
		
		texto = new JLabel("TEXTO DEL APUNTE");
		texto.setFont(new Font("Arial",0,35));
		
		check1=new JCheckBox("Visbilidad");
        check1.setBounds(10,10,150,30);
        check1.setBackground(new Color(0,255,255));
		
		
		titulofield = new JTextField();
		titulofield.setPreferredSize(new Dimension ( 750, 100));
		titulofield.setFont(new Font("Arial", 0, 20));
		textofield = new JTextField();
		textofield.setFont(new Font("Arial", 0, 20));
		textofield.setPreferredSize(new Dimension (750,250));
		
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		
		layout.putConstraint("HorizontalCenter", titulo, 0, "HorizontalCenter", this);
		layout.putConstraint("VerticalCenter", titulo, -300, "VerticalCenter", this);
		
		layout.putConstraint(SpringLayout.NORTH, titulofield, 50, SpringLayout.SOUTH, titulo);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, titulofield, 0, SpringLayout.HORIZONTAL_CENTER, titulo);
		
		layout.putConstraint(SpringLayout.NORTH, texto, 20, SpringLayout.SOUTH, titulofield);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, texto, 0, SpringLayout.HORIZONTAL_CENTER, titulo);
		
		layout.putConstraint(SpringLayout.NORTH, textofield, 20, SpringLayout.SOUTH, texto);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, textofield, 0, SpringLayout.HORIZONTAL_CENTER, titulo);
		
		layout.putConstraint(SpringLayout.NORTH, check1, 20, SpringLayout.SOUTH, textofield);
		layout.putConstraint(SpringLayout.WEST, check1, 0, SpringLayout.WEST, textofield);
		
		
		layout.putConstraint(SpringLayout.NORTH, crearapunte, 15, SpringLayout.SOUTH, textofield);
		layout.putConstraint(SpringLayout.EAST, crearapunte, 0, SpringLayout.EAST, textofield);
		
		layout.putConstraint(SpringLayout.NORTH, volver, 50, SpringLayout.SOUTH, crearapunte);
		layout.putConstraint(SpringLayout.WEST, volver, 40, SpringLayout.EAST, crearapunte);
		
		
		add(titulo);
		add(texto);
		add(textofield);
		add(titulofield);
		add(crearapunte);
		add(volver);
		add(check1);
		
		setBackground(new Color(0, 255, 255));
		setVisible(true); 
		
	}

	public JLabel getTitulo() {
		return titulo;
	}

	public JLabel getTexto() {
		return texto;
	}

	public JLabel getVolver() {
		return volver;
	}

	public JTextField getTitulofield() {
		return titulofield;
	}

	public JTextField getTextofield() {
		return textofield;
	}

	public JButton getCrearapunte() {
		return crearapunte;
	}

	public JCheckBox getCheck1() {
		return check1;
	}
	
	
}
