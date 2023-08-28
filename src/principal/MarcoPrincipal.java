package principal;
import javax.swing.*;
import java.awt.*;

public class MarcoPrincipal extends JFrame{
	
	public MarcoPrincipal() {
		
		Image icono = Toolkit.getDefaultToolkit().getImage("src/img/iconoGame.png");
		setSize(750,450);
		setTitle("Tic Tac Toe");
		setIconImage(icono);
		
		add(new Tablero());
		
	}

}
