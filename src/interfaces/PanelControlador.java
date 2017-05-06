package interfaces;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import academia.Visibilidad;

public class PanelControlador {

	private JFrame ventana;
	private JPanel panelcontenedor;
	private ControladorPanelControlador controlador;
	private PanelHomeProfesor panelhomeprofesor;
	private PanelCrearAsignatura panelcrearasignatura;
	private JPanel ExitField;
	private JLabel icono;
	private Container academia;
	private JButton desconectar;
	private Container contenedor;
	private PanelAsignatura panelasignatura;
	private PanelCrearApuntes panelcrearapuntes;
	private PanelTema paneltema;
	private PanelCrearEjercicio panelcrearejercicio;
	private PanelCrearTema panelcreartema;
	private PanelHomeAlumno panelhomealumno;
	private CardLayout cl;
	private PanelAsignaturaAlumno panelasignaturaalumno;
	private PanelTemaAlumno paneltemaalumno;
	private PanelApuntes panelapuntes;

	public PanelControlador() {

		ventana = new JFrame("Academia");

		contenedor = ventana.getContentPane();
		contenedor.setLayout(new BorderLayout());

		panelasignaturaalumno = new PanelAsignaturaAlumno();
		panelhomealumno = new PanelHomeAlumno();
		panelhomeprofesor = new PanelHomeProfesor();
		panelcrearasignatura = new PanelCrearAsignatura();
		panelasignatura = new PanelAsignatura();
		paneltema = new PanelTema();
		panelcrearapuntes = new PanelCrearApuntes();
		panelcrearejercicio = new PanelCrearEjercicio();
		panelcreartema = new PanelCrearTema();
		paneltemaalumno = new PanelTemaAlumno();
		panelapuntes = new PanelApuntes();
		panelcontenedor = new JPanel();
		desconectar = new JButton("Desconectar");

		ExitField = new JPanel();
		ExitField.setLayout(new BorderLayout());
		icono = new JLabel();
		academia = new JLabel("Academia Lopez");
		academia.setFont(new Font("Arial", Font.PLAIN, 90));
		icono.setIcon(new ImageIcon("src/imagenes/descarga.png"));
		ExitField.setBackground(new Color(255, 255, 255));
		ExitField.add(icono, BorderLayout.WEST);
		ExitField.add(academia, BorderLayout.CENTER);
		ExitField.add(desconectar, BorderLayout.EAST);

		desconectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controlador.desconectar();
				} catch (IOException e1) {
					JOptionPane.showInputDialog("Error al desconectar");
				}
			}

		});

		cl = new CardLayout();

		panelcontenedor.setLayout(cl);
		panelcontenedor.add(panelasignatura, "panelAsignatura");
		panelcontenedor.add(panelhomeprofesor, "panelhomeProfesor");
		panelcontenedor.add(panelcrearasignatura, "panelcrearAsignatura");
		panelcontenedor.add(paneltema, "panelTema");
		panelcontenedor.add(panelcrearapuntes, "panelcrearApuntes");
		panelcontenedor.add(panelcrearejercicio, "panelcrearEjercicio");
		panelcontenedor.add(panelcreartema, "panelcrearTema");
		panelcontenedor.add(panelhomealumno, "panelhomeAlumno");
		panelcontenedor.add(panelasignaturaalumno, "panelasignaturaAlumno");
		panelcontenedor.add(paneltemaalumno,"paneltemaAlumno");
		panelcontenedor.add(panelapuntes,"panelApuntes");

		contenedor.add(panelcontenedor, BorderLayout.CENTER);
		contenedor.add(ExitField, BorderLayout.NORTH);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.pack();
		ventana.setSize(1020, 850);
		ventana.setVisible(true);

		panelhomeprofesor.getCrearAsignatura().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(panelcontenedor, "panelcrearAsignatura");

			}
		});

		panelcrearasignatura.getVolver().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				cl.show(panelcontenedor, "panelhomeProfesor");

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// Estadisticas
				cl.show(panelcontenedor, "panelhomeProfesor");
			}
		});

		panelcrearasignatura.getCrear().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String titulo = panelcrearasignatura.getTitulo().getText();
				boolean visibilidad = panelcrearasignatura.getCheck1().isSelected();
				if (visibilidad == false) {
					controlador.crearAsignatura(titulo, Visibilidad.INVISIBLE);
				} else {
					controlador.crearAsignatura(titulo, Visibilidad.VISIBLE);
				}

				cl.show(panelcontenedor, "panelhomeProfesor");
				panelcrearasignatura.getTitulo().setText("");
				panelhomeprofesor.getModelo().addElement(titulo);

			}

		});

		panelhomeprofesor.getAceptar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String solicitud = panelhomeprofesor.getListaMatriculas().getSelectedValue();
				if (solicitud != null) {
					String[] trozos = solicitud.split("/");

					controlador.aceptarMatricula(trozos);
					((DefaultListModel<String>) panelhomeprofesor.getListaMatriculas().getModel())
							.remove(panelhomeprofesor.getListaMatriculas().getSelectedIndex());
				} else {
					JOptionPane.showMessageDialog(null, "No hay ninguna matricula selccionada", "ERROR",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		panelhomeprofesor.getDenegar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String solicitud = panelhomeprofesor.getListaMatriculas().getSelectedValue();
				if (solicitud != null) {
					String[] trozos = solicitud.split("/");

					controlador.denegarMatricula(trozos);
					((DefaultListModel<String>) panelhomeprofesor.getListaMatriculas().getModel())
							.remove(panelhomeprofesor.getListaMatriculas().getSelectedIndex());
				} else {
					JOptionPane.showMessageDialog(null, "No hay ninguna matricula selccionada", "ERROR",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		panelhomeprofesor.getCombobox().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cl.show(panelcontenedor, "panelAsignatura");
			}
		});

		panelhomeprofesor.getListaAsignaturas().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent evt) {
				JList<String> list = (JList<String>) evt.getSource();
				if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {

					panelasignatura.setNombreAsignatura(panelhomeprofesor.getListaAsignaturas().getSelectedValue());
					controlador.cargarTemasProfesor(panelhomeprofesor.getListaAsignaturas().getSelectedValue());
					controlador.alumnosMatriculados(panelhomeprofesor.getListaAsignaturas().getSelectedValue());
					// Double-click detected
					cl.show(panelcontenedor, "panelAsignatura");

				} else if (evt.getButton() == MouseEvent.BUTTON3) {
					if (panelhomeprofesor.getListaAsignaturas().getSelectedValue() != null) {
						String asignatura = panelhomeprofesor.getListaAsignaturas().getSelectedValue();

						JOptionPane.showMessageDialog(null, "Estado:" + controlador.visibilidadAsignatura(asignatura));
					}else{
						JOptionPane.showMessageDialog(null, "Seleccione una asignatura");
					}
					
				}
			}

		});

		panelhomealumno.getListamisasignaturas().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				panelasignaturaalumno.setNombreAsignatura((String) panelhomealumno.getListamisasignaturas().getSelectedItem());
				controlador.cargarTemasAlumno((String) panelhomealumno.getListamisasignaturas().getSelectedItem());
				cl.show(panelcontenedor, "panelasignaturaAlumno");
			}

		});

		panelhomealumno.getPedirmatricula().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String asignatura = panelhomealumno.getTodasasignaturas().getSelectedValue();
				if (controlador.pedirMatricula(asignatura) == true) {
					panelhomealumno.getModel().remove(panelhomealumno.getTodasasignaturas().getSelectedIndex());
				} else {
					JOptionPane.showMessageDialog(null, "No puedes realizar esta solicitud", "ERROR",
							JOptionPane.WARNING_MESSAGE);
				}

			}
		});

		panelasignatura.getCrearTema().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(panelcontenedor, "panelcrearTema");

			}
		});
		panelasignatura.getVolver().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				panelasignatura.getModel().clear();
				panelasignatura.getCombobox().removeAllItems();
				cl.show(panelcontenedor, "panelhomeProfesor");

			}
		});

		panelasignatura.getEliminarTema().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String tema = panelasignatura.getLista().getSelectedValue();
				String asignatura = panelasignatura.getNombreAsignatura().getText();
				controlador.eliminarTema(tema, asignatura);
				panelasignatura.getModel().remove(panelasignatura.getLista().getSelectedIndex());

			}
		});
		panelasignatura.getLista().addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent evt) {
				JList<String> list = (JList<String>) evt.getSource();
				if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {

					paneltema.setNombreTema(panelasignatura.getLista().getSelectedValue());
					controlador.cargarApuntesProfesor(panelasignatura.getLista().getSelectedValue());
					// Double-click detected
					cl.show(panelcontenedor, "panelTema");

				} else if (evt.getButton() == MouseEvent.BUTTON3) {
					if (panelhomeprofesor.getListaAsignaturas().getSelectedValue() != null) {
						String asignatura = panelhomeprofesor.getListaAsignaturas().getSelectedValue();

						JOptionPane.showMessageDialog(null, "Estado:" + controlador.visibilidadAsignatura(asignatura));
					}else{
						JOptionPane.showMessageDialog(null, "Seleccione una asignatura");
					}
					
				}
			}

		});
		
		panelcreartema.getBoton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String titulo = panelcreartema.getTitulo().getText();
				String asignatura = panelasignatura.getNombreAsignatura().getText();
				boolean visibilidad = panelcreartema.getCheck1().isSelected();
				if (visibilidad == true) {
					controlador.crearTema(asignatura, titulo, Visibilidad.VISIBLE);
				} else {
					controlador.crearTema(asignatura, titulo, Visibilidad.INVISIBLE);
				}

				cl.show(panelcontenedor, "panelAsignatura");
				panelcreartema.getTitulo().setText("");
				panelasignatura.getModel().addElement(titulo);

			}
		});

		panelhomeprofesor.getCambiarvis().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String asignatura = panelhomeprofesor.getListaAsignaturas().getSelectedValue();
				controlador.cambiarVisAsignatura(asignatura);

			}
		});

		panelasignaturaalumno.getVolver().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				panelasignaturaalumno.getModel().clear();
				cl.show(panelcontenedor, "panelhomeAlumno");

			}
		});
		
		panelasignaturaalumno.getListatemas().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList<String> list = (JList<String>) evt.getSource();
				if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {

					paneltemaalumno.setNombreTema(panelasignaturaalumno.getListatemas().getSelectedValue());
					controlador.cargarApuntesAlumno(panelasignaturaalumno.getListatemas().getSelectedValue());
					// Double-click detected
					cl.show(panelcontenedor, "paneltemaAlumno");

				}
			}
			
		});
		paneltema.getApuntes().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList<String> list = (JList<String>) evt.getSource();
				if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {

					panelapuntes.setTitulo((String) paneltema.getApuntes().getSelectedValue());
					controlador.abrirApuntes((String) paneltema.getApuntes().getSelectedValue());
					// Double-click detected
					cl.show(panelcontenedor, "panelApuntes");

				}
			}
		});
		
		paneltema.getCrearA().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(panelcontenedor, "panelcrearApuntes");
				
			}
		});
		paneltema.getEliminarA().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String titulo = (String) paneltema.getApuntes().getSelectedValue();
				controlador.eliminarApuntes(titulo);
				paneltema.getlApuntes().remove(paneltema.getApuntes().getSelectedIndex());
			}
		});
		
		paneltema.getVolver().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				paneltema.getlApuntes().clear();
				paneltema.getlEjercicios().clear();
				paneltema.getlSubtemas().clear();
				cl.show(panelcontenedor, "panelAsignatura");
				
			}
		});
		paneltemaalumno.getVolver().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				paneltemaalumno.getlEjercicios().clear();
				paneltemaalumno.getlApuntes().clear();
				paneltemaalumno.getlSubtemas().clear();
				cl.show(panelcontenedor, "panelasignaturaAlumno");
				
			}
		});
		
		panelcrearapuntes.getCrearapunte().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String titulo = panelcrearapuntes.getTitulofield().getText();
				String texto = panelcrearapuntes.getTextofield().getText();
				if(panelcrearapuntes.getCheck1().isSelected()==true){
					controlador.crearApuntes(titulo,texto,Visibilidad.VISIBLE);
				}else{
					controlador.crearApuntes(titulo,texto,Visibilidad.INVISIBLE);
				}
				
				paneltema.getlApuntes().addElement(titulo);
				panelcrearapuntes.getTitulofield().setText("");
				panelcrearapuntes.getTextofield().setText("");
				cl.show(panelcontenedor, "panelTema");
			}
		});
		

	}

	public void login() {
		if (controlador.login() == 0) {
			cl.show(panelcontenedor, "panelhomeProfesor");
		} else {
			cl.show(panelcontenedor, "panelhomeAlumno");
		}
	}

	public void setControlador(ControladorPanelControlador controlador) {
		this.controlador = controlador;

	}

	public PanelHomeProfesor getPanelhomeprofesor() {
		return panelhomeprofesor;
	}

	public PanelCrearAsignatura getPanelcrearAsignatura() {
		return panelcrearasignatura;
	}

	public void setVisibilidad(boolean b) {
		ventana.setVisible(false);

	}

	public PanelHomeAlumno getPanelhomealumno() {
		return panelhomealumno;
	}

	public JPanel getPanelcontenedor() {
		return panelcontenedor;
	}

	public PanelAsignatura getPanelasignatura() {
		return panelasignatura;
	}

	public PanelCrearApuntes getPanelcrearApuntes() {
		return panelcrearapuntes;
	}

	public PanelTema getPaneltema() {
		return paneltema;
	}

	public PanelCrearEjercicio getPanelcrearEjercicio() {
		return panelcrearejercicio;
	}

	public PanelCrearTema getPanelcrearTema() {
		return panelcreartema;
	}

	public JFrame getVentana() {
		return ventana;
	}

	public ControladorPanelControlador getControlador() {
		return controlador;
	}

	public JPanel getExitField() {
		return ExitField;
	}

	public JLabel getIcono() {
		return icono;
	}

	public Container getAcademia() {
		return academia;
	}

	public JButton getDesconectar() {
		return desconectar;
	}

	public Container getContenedor() {
		return contenedor;
	}

	public CardLayout getCl() {
		return cl;
	}

	public PanelAsignaturaAlumno getPanelasignaturaalumno() {
		return panelasignaturaalumno;
	}

	public PanelCrearAsignatura getPanelcrearasignatura() {
		return panelcrearasignatura;
	}

	public PanelCrearApuntes getPanelcrearapuntes() {
		return panelcrearapuntes;
	}

	public PanelCrearEjercicio getPanelcrearejercicio() {
		return panelcrearejercicio;
	}

	public PanelCrearTema getPanelcreartema() {
		return panelcreartema;
	}

	public PanelTemaAlumno getPaneltemaalumno() {
		return paneltemaalumno;
	}

	public PanelApuntes getPanelapuntes() {
		return panelapuntes;
	}
	
	
	

}
