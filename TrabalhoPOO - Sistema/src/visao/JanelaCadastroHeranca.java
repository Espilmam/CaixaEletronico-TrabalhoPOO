package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JanelaCadastroHeranca extends JFrame {
	private JPanel painel;
	private JLabel lblNome;
	private JTextField txtNome;
	private JButton btnCadastrar;
	private JButton btnPesquisar;
	
	public JanelaCadastroHeranca() {
		super("Janela Cadastro por Herança");
		painel = new JPanel();
		
		lblNome = new JLabel("Nome : ");
		txtNome = new JTextField(30);
		
		btnCadastrar = new JButton("Cadastrar");
		btnPesquisar = new JButton("Pesquisar");
		
		painel.add(lblNome);
		painel.add(txtNome);
		painel.add(btnCadastrar);
		painel.add(btnPesquisar);
		
		this.setContentPane(painel);
		
		this.setSize( 400, 200 );
		this.setVisible( true );
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
		
	public static void main(String[] args) { 
			new JanelaCadastroHeranca();

	}


}
