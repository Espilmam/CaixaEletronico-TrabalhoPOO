package visao;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JanelaCadastroAgregacao{
	private JFrame janela;
	private JPanel painel;
	private JLabel lblNome;
	private JTextField txtNome;
	private JButton btnCadastrar;
	public JanelaCadastroAgregacao() {
		janela = new JFrame("Janela Cadastro por Agregacao");
		painel = new JPanel();
		
		lblNome = new JLabel("Nome : ");
		txtNome = new JTextField(30);
		btnCadastrar = new JButton("Cadastrar");
		
		painel.add(lblNome);
		painel.add(txtNome);
		
		janela.setContentPane(painel);
		
		janela.setSize( 400, 200 );
		janela.setVisible( true );
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
//	public static void main(String[] args) { 
//		while (true) {
//			new JanelaCadastro();
//		}
//	}
	
	public static void main(String[] args) {
		JanelaCadastroHeranca j1 = new JanelaCadastroHeranca();
		JanelaCadastroAgregacao j2 = new JanelaCadastroAgregacao();
	}
}
