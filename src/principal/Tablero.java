package principal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Tablero extends JPanel {

	private JButton[] botones = new JButton[9];
	private int indiceBoton = 0;

	private JLabel lblJugador;
	private JLabel lblPuntajeX;
	private JLabel lblPuntajeY;
	private int contadorX = 0;
	private int contadorY = 0;
	private JFrame marcoMensaje;
	private String starGame = "X";

	public Tablero() {
		
		setLayout(new GridLayout(3,5,5,5));//GridLayout(int filas, int columnas, int hgap, int vgap)
		
		crea_casillas_tablero("", indiceBoton);// JButton 0, JButton 1, JButton 2
		crea_casilla_jugador("Jugador X", Color.BLUE);
		
		lblPuntajeX = new JLabel(String.valueOf(contadorX),SwingConstants.CENTER);
		lblPuntajeX.setOpaque(true);
		lblPuntajeX.setBackground(new Color(255,255,255));
		lblPuntajeX.setFont(new Font("Arial",Font.BOLD,20));
		add(lblPuntajeX);
		
		crea_casillas_tablero("", indiceBoton);//JButton 3, JButton 4, JButton 5
		crea_casilla_jugador("Jugador O", Color.RED);
		
		lblPuntajeY = new JLabel(String.valueOf(contadorY),SwingConstants.CENTER);
		lblPuntajeY.setOpaque(true);
		lblPuntajeY.setBackground(new Color(255,255,255));
		lblPuntajeY.setFont(new Font("Arial",Font.BOLD,20));
		add(lblPuntajeY);
		
		crea_casillas_tablero("", indiceBoton);// JButton 6, JButton7, JButton 8 
		crea_casillas_menus("REINICIAR");
		crea_casillas_menus("SALIR");

	}

	public void crea_casillas_tablero(String rotulo, int indice) {

		for (int i = 0; i < 3; i++) {

			botones[indice] = new JButton(rotulo);
			botones[indice].addActionListener(new Marcar_Casilla(indice));
			add(botones[indice]);
			indice++;
			indiceBoton++;

		}

	}

	public void crea_casillas_menus(String rotulo) {

		JButton btnCasilla = new JButton(rotulo);
		btnCasilla.setFont(new Font("Arial", Font.BOLD, 18));

		btnCasilla.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String boton = e.getActionCommand();

				if (boton.equalsIgnoreCase("SALIR")) {
					marcoMensaje = new JFrame("Exist");

					if (JOptionPane.showConfirmDialog(marcoMensaje, "Comfirme que usted quiere salir del juego",
							"TIC TAC TOC", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {

						System.exit(0);
					}
				}

				else if (boton.equalsIgnoreCase("REINICIAR")) {

					for (int i = 0; i < 9; i++) {
						botones[i].setText("");
					}

				}
			}

		});

		add(btnCasilla);

	}

	public void crea_casilla_jugador(String rotulo, Color color) {

		lblJugador = new JLabel(rotulo, SwingConstants.CENTER);
		lblJugador.setOpaque(true);
		lblJugador.setForeground(color);
		lblJugador.setBackground(new Color(210, 210, 210));
		lblJugador.setFont(new Font("Arial", Font.BOLD, 20));

		add(lblJugador);

	}

	public void elegirJugador() {

		if (starGame.equalsIgnoreCase("X")) {
			starGame = "O";
		} else {
			starGame = "X";
		}
	}

	public void jugar() {

		int victoriaX = 0;
		int victoriaY = 0;

		// evaluar a X ganador
		if (botones[0].getText().equals("X") && botones[1].getText().equals("X") && botones[2].getText().equals("X")) {

			contadorX++;
			lblPuntajeX.setText(String.valueOf(contadorX));
			victoriaX++;

		} else if (botones[0].getText().equals("X") && botones[4].getText().equals("X")
				&& botones[8].getText().equals("X")) {

			contadorX++;
			lblPuntajeX.setText(String.valueOf(contadorX));
			victoriaX++;

		} else if (botones[0].getText().equals("X") && botones[3].getText().equals("X")
				&& botones[6].getText().equals("X")) {

			contadorX++;
			lblPuntajeX.setText(String.valueOf(contadorX));
			victoriaX++;

		} else if (botones[3].getText().equals("X") && botones[4].getText().equals("X")
				&& botones[5].getText().equals("X")) {

			contadorX++;
			lblPuntajeX.setText(String.valueOf(contadorX));
			victoriaX++;

		} else if (botones[6].getText().equals("X") && botones[7].getText().equals("X")
				&& botones[8].getText().equals("X")) {

			contadorX++;
			lblPuntajeX.setText(String.valueOf(contadorX));
			victoriaX++;

		} else if (botones[6].getText().equals("X") && botones[4].getText().equals("X")
				&& botones[2].getText().equals("X")) {

			contadorX++;
			lblPuntajeX.setText(String.valueOf(contadorX));
			victoriaX++;

		} else if (botones[1].getText().equals("X") && botones[4].getText().equals("X")
				&& botones[7].getText().equals("X")) {

			contadorX++;
			lblPuntajeX.setText(String.valueOf(contadorX));
			victoriaX++;

		} else if (botones[2].getText().equals("X") && botones[5].getText().equals("X")
				&& botones[8].getText().equals("X")) {

			contadorX++;
			lblPuntajeX.setText(String.valueOf(contadorX));
			victoriaX++;

		}

		// evaluar Y ganador

		else if (botones[0].getText().equals("O") && botones[1].getText().equals("O")
				&& botones[2].getText().equals("O")) {

			contadorY++;
			lblPuntajeY.setText(String.valueOf(contadorY));
			victoriaY++;

		} else if (botones[0].getText().equals("O") && botones[4].getText().equals("O")
				&& botones[8].getText().equals("O")) {

			contadorY++;
			lblPuntajeY.setText(String.valueOf(contadorY));
			victoriaY++;

		} else if (botones[0].getText().equals("O") && botones[3].getText().equals("O")
				&& botones[6].getText().equals("O")) {

			contadorY++;
			lblPuntajeY.setText(String.valueOf(contadorY));
			victoriaY++;

		} else if (botones[3].getText().equals("O") && botones[4].getText().equals("O")
				&& botones[5].getText().equals("O")) {

			contadorY++;
			lblPuntajeY.setText(String.valueOf(contadorY));
			victoriaY++;

		} else if (botones[6].getText().equals("O") && botones[7].getText().equals("O")
				&& botones[8].getText().equals("O")) {

			contadorY++;
			lblPuntajeY.setText(String.valueOf(contadorY));
			victoriaY++;

		} else if (botones[6].getText().equals("O") && botones[4].getText().equals("O")
				&& botones[2].getText().equals("O")) {

			contadorY++;
			lblPuntajeY.setText(String.valueOf(contadorY));
			victoriaY++;

		} else if (botones[1].getText().equals("O") && botones[4].getText().equals("O")
				&& botones[7].getText().equals("O")) {

			contadorY++;
			lblPuntajeY.setText(String.valueOf(contadorY));
			victoriaY++;

		} else if (botones[2].getText().equals("O") && botones[5].getText().equals("O")
				&& botones[8].getText().equals("O")) {

			contadorY++;
			lblPuntajeY.setText(String.valueOf(contadorY));
			victoriaY++;

		}

		if (victoriaX > 0) {

			JOptionPane.showMessageDialog(marcoMensaje, "GANO EL JUGADOR X", "Victoria!!",
					JOptionPane.INFORMATION_MESSAGE);

		} else if (victoriaY > 0) {

			JOptionPane.showMessageDialog(marcoMensaje, "GANO EL JUGADOR O", "Victoria!!",
					JOptionPane.INFORMATION_MESSAGE);

		} else if (!botones[0].getText().equals("") && !botones[1].getText().equals("")
				&& !botones[2].getText().equals("") && !botones[3].getText().equals("")
				&& !botones[4].getText().equals("") && !botones[5].getText().equals("")
				&& !botones[6].getText().equals("") && !botones[7].getText().equals("")
				&& !botones[8].getText().equals("")) {

			JOptionPane.showMessageDialog(marcoMensaje, "EMPATE", "Empate", JOptionPane.INFORMATION_MESSAGE);

		}

	}
	
	private class Marcar_Casilla implements ActionListener{
		
		public Marcar_Casilla(int num) {
			
			numIndice = num;
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String boton = e.getActionCommand();
			if(boton.equalsIgnoreCase("") || !boton.equalsIgnoreCase(starGame)) {
				
				botones[numIndice].setText(starGame);
				botones[numIndice].setFont(new Font("Arial",Font.BOLD, 40));
				
				if(starGame.equalsIgnoreCase("X")) {
					botones[numIndice].setForeground(Color.BLUE);
				}
				else {
					botones[numIndice].setForeground(Color.RED);
				}
				
			}
			elegirJugador();
			jugar();
			
		}
		
		private int numIndice;
		
	}

}
