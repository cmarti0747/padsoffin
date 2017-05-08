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
	private PanelApuntesAlumno panelapuntesalumno;
	private PanelCrearSubtema panelcrearsubtema;

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
		panelcrearsubtema = new PanelCrearSubtema();
		panelapuntes = new PanelApuntes();
		panelapuntesalumno = new PanelApuntesAlumno();
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
		panelcontenedor.add(paneltemaalumno, "paneltemaAlumno");
		panelcontenedor.add(panelapuntes, "panelApuntes");
		panelcontenedor.add(panelapuntesalumno, "panelapuntesAlumno");
		panelcontenedor.add(panelcrearsubtema, "panelcrearSubtema");

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
				evt.getSource();
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
					} else {
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
				if (panelhomealumno.getListamisasignaturas().getSelectedItem() != null) {
					panelasignaturaalumno
							.setNombreAsignatura((String) panelhomealumno.getListamisasignaturas().getSelectedItem());
					controlador.cargarTemasAlumno((String) panelhomealumno.getListamisasignaturas().getSelectedItem());
					cl.show(panelcontenedor, "panelasignaturaAlumno");
				} else {
					JOptionPane.showMessageDialog(null, "No hay asignaturas seleccionadas");
				}
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
				evt.getSource();
				if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {

					paneltema.setNombreTema(panelasignatura.getLista().getSelectedValue());
					controlador.cargarApuntesProfesor(panelasignatura.getLista().getSelectedValue());
					controlador.cargarSubtemasProfesor(panelasignatura.getLista().getSelectedValue());
					// Double-click detected
					cl.show(panelcontenedor, "panelTema");

				} else if (evt.getButton() == MouseEvent.BUTTON3) {
					if (panelasignatura.getLista().getSelectedValue() != null) {
						String tema = panelasignatura.getLista().getSelectedValue();

						JOptionPane.showMessageDialog(null, "Estado:" + controlador.visibilidadTema(tema));
					} else {
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

		panelasignatura.getCambiarvis().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				controlador.cambiarVisTema(panelasignatura.getLista().getSelectedValue());
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
				evt.getSource();
				if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {

					paneltemaalumno.setNombreTema(panelasignaturaalumno.getListatemas().getSelectedValue());
					controlador.cargarApuntesAlumno(panelasignaturaalumno.getListatemas().getSelectedValue());
					controlador.cargarSubtemasAlumno(panelasignaturaalumno.getListatemas().getSelectedValue());
					// Double-click detected
					cl.show(panelcontenedor, "paneltemaAlumno");

				}

			}

		});
		
		paneltema.getCambiarvisA().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String apuntes = paneltema.getApuntes().getSelectedValue();
				controlador.cambiarVisApuntes(apuntes);
				
			}
		});

		paneltema.getApuntes().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				evt.getSource();
				if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {
					if (paneltema.getApuntes().getSelectedValue() != null) {
						panelapuntes.setTitulo((String) paneltema.getApuntes().getSelectedValue());
						controlador.abrirApuntes((String) paneltema.getApuntes().getSelectedValue());
						// Double-click detected
						cl.show(panelcontenedor, "panelApuntes");

					} else {
						JOptionPane.showMessageDialog(null, "No hay seleccionado ningun apunte");
					}
				} else if (evt.getButton() == MouseEvent.BUTTON3) {
					if ((String) paneltema.getApuntes().getSelectedValue() != null) {
						String titulo = (String) paneltema.getApuntes().getSelectedValue();

						JOptionPane.showMessageDialog(null, "Estado:" + controlador.visibilidadApuntes(titulo));
					} else {
						JOptionPane.showMessageDialog(null, "Seleccione una asignatura");
					}
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
				String titulo = paneltema.getNombreTema().getText();
				String tema = controlador.buscartemaPadre(titulo);
				paneltema.getlApuntes().clear();
				paneltema.getlEjercicios().clear();
				paneltema.getlSubtemas().clear();
				if (tema == null) {
					cl.show(panelcontenedor, "panelAsignatura");
				} else {
					controlador.cargarApuntesProfesor(tema);
					controlador.cargarSubtemasProfesor(tema);
					paneltema.getNombreTema().setText(tema);
					cl.show(panelcontenedor, "panelTema");
				}

			}
		});
		paneltema.getCrearSub().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(panelcontenedor, "panelcrearSubtema");

			}
		});

		panelcrearsubtema.getBoton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String titulo = panelcrearsubtema.getTitulo().getText();
				boolean visibilidad = panelcrearsubtema.getCheck1().isSelected();
				String tema = paneltema.getNombreTema().getText();
				if (visibilidad == true) {
					controlador.crearSubtema(titulo, Visibilidad.VISIBLE, tema);
				} else {
					controlador.crearSubtema(titulo, Visibilidad.INVISIBLE, tema);
				}
				cl.show(panelcontenedor, "panelTema");
				panelcrearsubtema.getTitulo().setText("");
				panelcrearsubtema.getCheck1().setSelected(false);
				paneltema.getlSubtemas().addElement(titulo);

			}
		});

		paneltema.getEliminarSub().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String titulo = paneltema.getSubtemas().getSelectedValue();
				String tema = paneltema.getNombreTema().getText();
				controlador.eliminarSubtemas(tema, titulo);
				paneltema.getlSubtemas().remove(paneltema.getSubtemas().getSelectedIndex());

			}
		});

		panelapuntes.getModificar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String titulo = panelapuntes.getTitulo().getText();
				controlador.modificarApuntes(titulo);
				paneltema.getlApuntes().clear();
				controlador.cargarApuntesProfesor(paneltema.getNombreTema().getText());
				cl.show(panelcontenedor, "panelTema");

			}
		});

		paneltema.getSubtemas().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent evt) {
				evt.getSource();
				if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {
					String t = (String) paneltema.getSubtemas().getSelectedValue();
					paneltema.setNombreTema(t);
					paneltema.getlApuntes().clear();
					paneltema.getlEjercicios().clear();
					paneltema.getlSubtemas().clear();
					controlador.cargarApuntesProfesor(t);
					controlador.cargarSubtemasProfesor(t);

					// Double-click detected
					cl.show(panelcontenedor, "panelTema");

				} else if (evt.getButton() == MouseEvent.BUTTON3) {
					if ((String) paneltema.getSubtemas().getSelectedValue() != null) {
						String tema = (String) paneltema.getSubtemas().getSelectedValue();

						JOptionPane.showMessageDialog(null, "Estado:" + controlador.visibilidadTema(tema));
					} else {
						JOptionPane.showMessageDialog(null, "Seleccione una asignatura");
					}
				}
			}

		});

		paneltemaalumno.getSubtemas().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent evt) {
				evt.getSource();
				if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {
					String t = (String) paneltemaalumno.getSubtemas().getSelectedValue();
					paneltemaalumno.setNombreTema(t);
					paneltemaalumno.getlApuntes().clear();
					paneltemaalumno.getlEjercicios().clear();
					paneltemaalumno.getlSubtemas().clear();
					controlador.cargarApuntesAlumno(t);
					controlador.cargarSubtemasAlumno(t);

					// Double-click detected
					cl.show(panelcontenedor, "paneltemaAlumno");

				} else if (evt.getButton() == MouseEvent.BUTTON3) {
					if ((String) paneltemaalumno.getSubtemas().getSelectedValue() != null) {
						String tema = (String) paneltemaalumno.getSubtemas().getSelectedValue();

						JOptionPane.showMessageDialog(null, "Estado:" + controlador.visibilidadTema(tema));
					} else {
						JOptionPane.showMessageDialog(null, "Seleccione una asignatura");
					}
				}
			}

		});

		paneltemaalumno.getApuntes().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				evt.getSource();
				if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {

					panelapuntesalumno.getTitulo().setText((String) paneltemaalumno.getApuntes().getSelectedValue());
					controlador.abrirApuntesAlumno((String) paneltemaalumno.getApuntes().getSelectedValue());
					// Double-click detected
					cl.show(panelcontenedor, "panelapuntesAlumno");

				}
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
				if (panelcrearapuntes.getCheck1().isSelected() == true) {
					controlador.crearApuntes(titulo, texto, Visibilidad.VISIBLE);
				} else {
					controlador.crearApuntes(titulo, texto, Visibilidad.INVISIBLE);
				}

				paneltema.getlApuntes().addElement(titulo);
				panelcrearapuntes.getTitulofield().setText("");
				panelcrearapuntes.getTextofield().setText("");
				cl.show(panelcontenedor, "panelTema");
			}
		});

		panelapuntesalumno.getVolver().addMouseListener(new MouseListener() {

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
				panelapuntesalumno.getTextofield().removeAll();
				cl.show(panelcontenedor, "paneltemaAlumno");

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

	public PanelApuntesAlumno getPanelapuntesalumno() {
		return panelapuntesalumno;
	}

}
