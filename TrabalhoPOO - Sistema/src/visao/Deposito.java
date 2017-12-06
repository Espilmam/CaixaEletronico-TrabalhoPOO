package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Deposito {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposito window = new Deposito();
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
	public Deposito() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 765, 531);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		JPanel painelDeposito = new JPanel();
		frame.getContentPane().add(painelDeposito);
		
		JLabel label = new JLabel("New label");
		GroupLayout gl_painelDeposito = new GroupLayout(painelDeposito);
		gl_painelDeposito.setHorizontalGroup(
			gl_painelDeposito.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_painelDeposito.createSequentialGroup()
					.addContainerGap(347, Short.MAX_VALUE)
					.addComponent(label)
					.addGap(344))
		);
		gl_painelDeposito.setVerticalGroup(
			gl_painelDeposito.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_painelDeposito.createSequentialGroup()
					.addGap(147)
					.addComponent(label)
					.addContainerGap(321, Short.MAX_VALUE))
		);
		painelDeposito.setLayout(gl_painelDeposito);
	}

}
