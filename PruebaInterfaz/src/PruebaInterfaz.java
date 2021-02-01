import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class PruebaInterfaz {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PruebaInterfaz window = new PruebaInterfaz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PruebaInterfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 248, 321);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		
		JLabel lblNewLabel = new JLabel("Mostrar el texto o Ocultar pulsando el boton");
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		JButton btnNewButton = new JButton("Pulsa Aqui");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel.setVisible(!lblNewLabel.isVisible());
			}
		});
		frame.getContentPane().add(btnNewButton, BorderLayout.CENTER);
	}

}
