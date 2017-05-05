package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class PanelApuntes extends JPanel{

	
	private JLabel titulo, texto, volver;
	private JTextField titulofield, textofield;
	private JButton modificar;
	
	public PanelApuntes(){
		
		modificar = new JButton("Modificar apunte");
		
		
		titulo = new JLabel("TITULO DEL APUNTE");
		titulo.setFont(new Font("Arial",0,35));
		
		volver = new JLabel ("Volver");
		titulo.setFont(new Font("Arial",0,20));
		
		texto = new JLabel("TEXTO DEL APUNTE");
		texto.setFont(new Font("Arial",0,35));
		
		
		
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
		
		layout.putConstraint(SpringLayout.NORTH, modificar, 15, SpringLayout.SOUTH, textofield);
		layout.putConstraint(SpringLayout.EAST, modificar, 0, SpringLayout.EAST, textofield);
		
		layout.putConstraint(SpringLayout.NORTH, volver, 50, SpringLayout.SOUTH, modificar);
		layout.putConstraint(SpringLayout.WEST, volver, 40, SpringLayout.EAST, modificar);
		
		
		add(titulo);
		add(texto);
		add(textofield);
		add(titulofield);
		add(modificar);
		add(volver);
		
		
		setBackground(new Color(0, 255, 255));
		setVisible(true); 
		
	}
	
	
}
