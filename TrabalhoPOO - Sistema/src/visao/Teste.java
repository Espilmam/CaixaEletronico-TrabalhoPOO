package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Teste extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teste frame = new Teste();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Teste() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(128, 124, 97, 25);
		contentPane.add(button);
		
		JButton button_1 = new JButton("5");
		button_1.setBounds(128, 162, 97, 25);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("10");
		button_2.setBounds(128, 200, 97, 25);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("20");
		button_3.setBounds(355, 124, 97, 25);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("50");
		button_4.setBounds(355, 162, 97, 25);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("100");
		button_5.setBounds(355, 200, 97, 25);
		contentPane.add(button_5);
		
		JLabel lblValorSacado = new JLabel("Valor sacado:");
		lblValorSacado.setBounds(239, 44, 97, 16);
		contentPane.add(lblValorSacado);
		
		textField = new JTextField();
		textField.setBounds(239, 63, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnVoltarAoMenu = new JButton("Voltar ao menu");
		btnVoltarAoMenu.setBounds(239, 315, 121, 25);
		contentPane.add(btnVoltarAoMenu);
		
		JButton btnZerar = new JButton("Zerar");
		btnZerar.setBounds(372, 62, 97, 25);
		contentPane.add(btnZerar);
	}
}
