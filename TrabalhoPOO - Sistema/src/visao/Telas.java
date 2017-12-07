package visao;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

import controle.CtrDadosCliente;
import controle.CtrCedulas;
import modelo.AddDados;
import modelo.Saldo;
import modelo.Cedulas;

public class Telas implements ActionListener {
	
	private static JFrame ta;
	private static JFrame tm;
	private static JFrame ts;
	private static JFrame tp;
	private static JFrame tt;
	private static JFrame tadm;
	private static JFrame tadd;
	private static JFrame tsal;
	private ButtonGroup tipoTransf;
	private ButtonGroup tipoDado;
	private ButtonGroup tipoConta;
	private ButtonGroup tipoPagar;
	private JButton btnAcessar;
	private JButton btnAddValor;
	private JButton btnADM;
	private JButton btnSaque;
	private JButton btnDeposito;
	private JButton btnTransf;
	private JButton btnSaldo;
	private JButton btnSair;
    private JButton btn2;
    private int r$2 = 0;
	private JButton btn5;
	private int r$5 = 0;
	private JButton btn10;
	private int r$10 = 0;
	private JButton btn20;
	private int r$20 = 0;
	private JButton btn50;
	private int r$50 = 0;
	private JButton btn100;
	private int r$100 = 0;
	private JButton btnZerar;
	private JButton btnVoltar;
	private JButton btnTransferir;
	private JButton btnAdicionar;
	private JButton btnVerificar;
	private JButton btnMostrar;
	private JButton btnRemover;
	private JComboBox<String> cbxBanco;
	private JPanel painelTelaLogin;
	private JPanel painelTelaMenu;
	private JPanel painelTelaSaque;
	private JPanel painelTelaDep;
	private JPanel painelTelaTransf;
	private JPanel painelTelaAdd;
	private JPanel painelTelaADM;
	private JPanel painelTelaSaldo;
	private JPasswordField txtSenha;
	private JRadioButton chkContaCor;
	private JRadioButton chkPoupanca;
	private JRadioButton chkCheque;
	private JRadioButton chkMoney;
	private JRadioButton chkDOC;
	private JRadioButton chkTED;
	private JRadioButton chkCPF;
	private JRadioButton chkCNPJ;
	private JTextField txtCartao;
	private JTextField txtNome;
	private JTextField txtSaldo;
	private JTextField txtAgencia;
	private JTextField txtConta;
	private JTextField txtLogin;
	private JTextField txtValor;
	private JTextField txtMostraSaque;
	private JTextField txtR$2; 
	private JTextField txtR$5; 
	private JTextField txtR$10; 
	private JTextField txtR$20; 
	private JTextField txtR$50; 
	private JTextField txtR$100; 
	private static Telas tl = new Telas();
	private CtrDadosCliente ctrConta = new CtrDadosCliente();
	private CtrDadosCliente ctrDeposito = new CtrDadosCliente();
	private CtrCedulas saque = new CtrCedulas();
	private CtrCedulas addCedula = new CtrCedulas();
	private CtrCedulas removeCedula = new CtrCedulas();
	private CtrCedulas zeraCedula = new CtrCedulas();
	private AddDados usuario = new AddDados();
	private Cedulas sq = new Cedulas();
	private int aux = 0;
	private static Cedulas totalCaixa = new Cedulas();
	
	public static void main(String[] args) {
		
		ta = new JFrame("Acesso");
		ts = new JFrame("Saque");
		tp = new JFrame("Depósito");
		tt = new JFrame("Transferencia");
		tadm = new JFrame("Administrador");
		tadd = new JFrame("Adiciona Valores");
		tl.telaAcesso();
	}
	public void telaAcesso() {
			
		painelTelaLogin = new JPanel(new GridLayout(4,3));
		JPanel painelDados = new JPanel(new GridLayout(3,2));
		JPanel painelBotoes = new JPanel(new GridLayout(1,3));
		
		JPanel painelLogin = new JPanel ();
		JLabel login = new JLabel("Nº cartão:");
		txtLogin = new JTextField(20);
		
		PlainDocument verLogin = (PlainDocument) txtLogin.getDocument();
		verLogin.setDocumentFilter(new verificaTexto(16, "Int"));
		
		painelLogin.add(login);
		painelLogin.add(txtLogin);
		
		JPanel painelSenha = new JPanel ();
		JLabel senha = new JLabel("Senha:");	
		txtSenha = new JPasswordField(20);
		painelSenha.add(senha);
		painelSenha.add(txtSenha);
		
		btnAcessar = new JButton("Acessar");
		btnAddValor = new JButton("Adicionar Valores...");
		btnADM = new JButton("Admin");
		btnSair = new JButton("Sair");
		btnAcessar.addActionListener(this);
		btnAddValor.addActionListener(this);
		btnADM.addActionListener(this);
		btnSair.addActionListener(this);
		btnSair.setActionCommand("SairLogin");
		
		JPanel painelAcessar = new JPanel ();	
		painelAcessar.add(btnAcessar);
		
		JPanel painelAddValor = new JPanel ();		
		painelAddValor.add(btnAddValor);
		
		JPanel painelADM = new JPanel ();		
		painelADM.add(btnADM);
		
		JPanel painelSair = new JPanel();
		painelSair.add(btnSair);
			
		painelBotoes.add(painelAddValor);
		painelBotoes.add(painelAcessar);
		painelBotoes.add(painelADM);
		painelBotoes.add(painelSair);
		painelDados.add(painelLogin);
		painelDados.add(painelSenha);
		
		painelTelaLogin.add(new JPanel());
		painelTelaLogin.add(painelDados);
		painelTelaLogin.add(painelBotoes);
		painelTelaLogin.add(new JPanel());
		
		usuario = ctrDeposito.recebeSaldo();
		//ta.setUndecorated(true);
		//ta.setLocationRelativeTo(null);
		ta.setContentPane(painelTelaLogin);		
		ta.setVisible(true);
		ta.setSize(600,400);	
		ta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void telaMenu() {
		
		painelTelaMenu = new JPanel(new GridLayout(1,3));
		JPanel painelBotoesEsquerdo = new JPanel(new GridLayout(10,1));
		JPanel painelBotoesDireito = new JPanel(new GridLayout(10,1));
		JPanel painelSuperior = new JPanel(new GridLayout(4,1));
		
		JLabel msgBanco = new JLabel("<html><center>Bem vindo ao placebo de Caixa Eletrônico</html>");
		
		btnSaque = new JButton("Realizar Saque");
		btnDeposito = new JButton("Realizar Depósito");
		btnTransf = new JButton("Realizar Transferencia");
		btnSaldo = new JButton("Ver Saldo");
		btnSair = new JButton("Finalizar");
		btnSaque.addActionListener(this);
		btnDeposito.addActionListener(this);
		btnSaldo.addActionListener(this);
		btnSair.addActionListener(this);
		btnTransf.addActionListener(this);
		
		JPanel painelSaque = new JPanel();	
		painelSaque.add(btnSaque);
		
		JPanel painelDeposito = new JPanel();		
		painelDeposito.add(btnDeposito);
		
		JPanel painelTransf = new JPanel();		
		painelTransf.add(btnTransf);
		
		JPanel painelSaldo = new JPanel();		
		painelSaldo.add(btnSaldo);
		
		JPanel painelSair = new JPanel();		
		painelSair.add(btnSair);
		
		painelSuperior.add(msgBanco);
		painelBotoesEsquerdo.add(new JPanel());
		painelBotoesEsquerdo.add(new JPanel());
		painelBotoesEsquerdo.add(new JPanel());
		painelBotoesEsquerdo.add(painelSaque);;
		painelBotoesEsquerdo.add(new JPanel());
		painelBotoesEsquerdo.add(painelDeposito);
		painelBotoesDireito.add(new JPanel());
		painelBotoesDireito.add(new JPanel());
		painelBotoesDireito.add(new JPanel());
		painelBotoesDireito.add(painelTransf);
		painelBotoesDireito.add(new JPanel());
		painelBotoesDireito.add(painelSaldo);
		painelBotoesDireito.add(new JPanel());
		painelBotoesDireito.add(painelSair);
		painelBotoesDireito.add(new JPanel());
		painelBotoesDireito.add(new JPanel());
		
		painelTelaMenu.add(painelBotoesEsquerdo);
		painelTelaMenu.add(painelSuperior);
		painelTelaMenu.add(painelBotoesDireito);
	}
	public void telaSaque() {
		
	    painelTelaSaque = new JPanel(new BorderLayout());
	    JPanel painelValores = new JPanel (new GridLayout(1,3));
		JPanel painelBotoesEsquerdo = new JPanel(new GridLayout(5,1));
		JPanel painelBotoesDireito = new JPanel(new GridLayout(5,1));
		JPanel painelBotoesValores = new JPanel(new GridLayout(2,1));
		
		btnZerar = new JButton("Zerar");
		btnZerar.addActionListener(this);
		btnZerar.setActionCommand("ZerarSaque");
		btn2 = new JButton("2");
		btn2.addActionListener(this);
		btn5 = new JButton("5");
		btn5.addActionListener(this);
		btn10 = new JButton("10");
		btn10.addActionListener(this);
		btn20 = new JButton("20");
		btn20.addActionListener(this);
		btn50 = new JButton("50");
		btn50.addActionListener(this);
		btn100 = new JButton("100");
		btn100.addActionListener(this);
		btnSaque = new JButton("Sacar");
		btnSaque.addActionListener(this);
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(this);
		btnVoltar.setActionCommand("VoltarSaque");
		
		JLabel lblSaque = new JLabel ("Valor a ser sacado:");
		txtMostraSaque = new JTextField(10);
		JPanel pnSaque = new JPanel();
		pnSaque.add(lblSaque);
		pnSaque.add(txtMostraSaque);
		pnSaque.add(btnZerar);
		txtMostraSaque.setEnabled(false);
		
		JPanel painelNota2 = new JPanel();
		painelNota2.add(btn2);
		
		JPanel painelNota5 = new JPanel();		
		painelNota5.add(btn5);
		
		JPanel painelNota10 = new JPanel();		
		painelNota10.add(btn10);
		
		JPanel painelNota20 = new JPanel();		
		painelNota20.add(btn20);
		
		JPanel painelNota50 = new JPanel();		
		painelNota50.add(btn50);
		
		JPanel painelNota100 = new JPanel();		
		painelNota100.add(btn100);
		
		JPanel painelBaixo = new JPanel();	
		painelBaixo.add(btnSaque);
		painelBaixo.add(btnVoltar);
			
		painelBotoesEsquerdo.add(new JPanel());
		painelBotoesEsquerdo.add(new JPanel());
	
		painelBotoesEsquerdo.add(painelNota2);
		painelBotoesEsquerdo.add(painelNota5);
		painelBotoesEsquerdo.add(painelNota10);

		painelBotoesDireito.add(new JPanel());
		painelBotoesDireito.add(new JPanel());
		painelBotoesDireito.add(painelNota20);
		painelBotoesDireito.add(painelNota50);
		painelBotoesDireito.add(painelNota100);
		
		painelValores.add(painelBotoesEsquerdo);
		painelValores.add(painelBotoesDireito);
		
		painelBotoesValores.add(painelValores);
		painelBotoesValores.add(pnSaque);
		
		painelTelaSaque.add(painelBotoesValores, BorderLayout.CENTER);
		painelTelaSaque.add(painelBaixo, BorderLayout.SOUTH);
		
        ts.setContentPane(painelTelaSaque);	
		ts.setVisible(true);
		ts.setSize(600, 400);
		ts.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void telaDeposito() {
		
		painelTelaDep = new JPanel(new BorderLayout());
		JPanel painelEsquerdo = new JPanel(new GridLayout(1,2));
		JPanel painelDireito = new JPanel(new GridLayout(1,2));
        
		chkContaCor = new JRadioButton("Conta Corrente");
		chkPoupanca = new JRadioButton("Poupança");
		chkCheque = new JRadioButton("Cheque");
		chkMoney = new JRadioButton("Dinheiro");
		tipoConta = new ButtonGroup();
		tipoPagar = new ButtonGroup();
		tipoConta.add(chkContaCor);
		tipoConta.add(chkPoupanca);
		tipoPagar.add(chkCheque);
		tipoPagar.add(chkMoney);
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(this);
		btnVoltar.setActionCommand("VoltarDeposito");
		btnDeposito = new JButton("Depositar");
		btnDeposito.addActionListener(this);
		
		JLabel lblAgencia = new JLabel("Agência: ");
		txtAgencia = new JTextField(20);
		
		PlainDocument verAgencia = (PlainDocument) txtAgencia.getDocument();
		verAgencia.setDocumentFilter(new verificaTexto(4, "Int"));
		
		JLabel lblNumConta = new JLabel("Número da conta: ");
		txtConta = new JTextField(20);
		PlainDocument verNumConta = (PlainDocument) txtConta.getDocument();
		verNumConta.setDocumentFilter(new verificaTexto(10, "Int"));
		
		JLabel lblBanco = new JLabel("Banco");
		cbxBanco = new JComboBox<String>();
		cbxBanco.addItem("Itaú");
		cbxBanco.addItem("Santander");
		cbxBanco.addItem("Banco do Brasil");
		cbxBanco.addItem("Bradesco");
		cbxBanco.addItem("Caixa Econômica");
		cbxBanco.addItem("HSBC");
		cbxBanco.addItem("Banco Original");
		
		JLabel lblValor = new JLabel("Valor do depósito: ");
	    txtValor = new JTextField(20);		
		PlainDocument vertxtValor = (PlainDocument) txtValor.getDocument();
		vertxtValor.setDocumentFilter(new verificaTexto(10,"Int"));	
		JPanel painelDep = new JPanel(new GridLayout(4,3));
		painelDep.add(lblBanco);
		painelDep.add(cbxBanco);
		painelDep.add(lblAgencia);
		painelDep.add(txtAgencia);
		painelDep.add(lblNumConta);
		painelDep.add(txtConta);
		painelDep.add(lblValor);
		painelDep.add(txtValor);
		
		JPanel painelBaixo = new JPanel();	
		painelBaixo.add(btnDeposito);
		painelBaixo.add(btnVoltar);
		
		painelEsquerdo.add(chkContaCor);
		painelEsquerdo.add(chkPoupanca);
		painelDireito.add(chkCheque);
		painelDireito.add(chkMoney);
		
		JPanel painelCk = new JPanel();
		painelCk.add(painelEsquerdo);
		painelCk.add(new JSeparator(JSeparator.VERTICAL));
		painelCk.add(painelDireito);
		
		
	    painelTelaDep.add(painelCk, BorderLayout.NORTH);
	    painelTelaDep.add(painelDep, BorderLayout.CENTER);
	    painelTelaDep.add(painelBaixo, BorderLayout.SOUTH);
		
		tp.setContentPane(painelTelaDep);
		tp.setVisible(true);
		tp.setSize(600, 300);
		tp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void telaTransferencia() {
		
		painelTelaTransf = new JPanel(new BorderLayout());
		JPanel painelEsquerdo = new JPanel(new GridLayout(10,1));
		JPanel painelBaixo = new JPanel();
		JLabel lblTrasnf = new JLabel("Tipo de transferencia");
		chkDOC = new JRadioButton("DOC");
		chkTED = new JRadioButton("TED");
		tipoTransf = new ButtonGroup();
	    tipoTransf.add(chkDOC);
	    tipoTransf.add(chkTED);
		JPanel painelTransf = new JPanel();
		
		JLabel lblDest = new JLabel("Dados destinatário");
		chkCPF = new JRadioButton("CPF");
		chkCNPJ = new JRadioButton("CNPJ");
		tipoDado = new ButtonGroup();
		tipoDado.add(chkCPF);
		tipoDado.add(chkCNPJ);
	    JPanel painelDest = new JPanel();
	    
	    JTextField txtCPFCNPJ = new JTextField(15);
	    PlainDocument verCPFCNPJ = (PlainDocument) txtCPFCNPJ.getDocument();    // <----- VERIFICAR 
		verCPFCNPJ.setDocumentFilter(new verificaTexto(11, "Int"));
	    JPanel painelCPFCNPJ = new JPanel();
	    painelCPFCNPJ.add(txtCPFCNPJ);
	    
		JLabel lblAgencia = new JLabel("Agência: ");
		txtAgencia = new JTextField(5);	
		PlainDocument verAgencia = (PlainDocument) txtAgencia.getDocument();
		verAgencia.setDocumentFilter(new verificaTexto(4, "Int"));
		JPanel painelAgencia = new JPanel();
		
		JLabel lblConta = new JLabel("Conta: ");
		txtConta = new JTextField(10);
		PlainDocument verConta = (PlainDocument) txtConta.getDocument();
		verConta.setDocumentFilter(new verificaTexto(10, "Int"));
		JPanel painelConta = new JPanel();	
		
		JLabel lblBanco = new JLabel("Banco");
		cbxBanco = new JComboBox<String>();
		cbxBanco.addItem("Itaú");
		cbxBanco.addItem("Santander");
		cbxBanco.addItem("Banco do Brasil");
		cbxBanco.addItem("Bradesco");
		cbxBanco.addItem("Caixa Econômica");
		cbxBanco.addItem("HSBC");
		cbxBanco.addItem("Banco Original");
		JPanel painelBanco = new JPanel();
			
		JLabel lblValor = new JLabel("Valor: ");
		txtValor = new JTextField(15);	
		PlainDocument verValor = (PlainDocument) txtValor.getDocument();
		verValor.setDocumentFilter(new verificaTexto(15,"Double"));
		JPanel painelValor = new JPanel();
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(this);
		btnVoltar.setActionCommand("VoltarTransf");
		btnTransferir = new JButton("Tranferir");
		btnTransferir.addActionListener(this);
		
		painelTransf.add(lblTrasnf);
		painelTransf.add(chkDOC);
		painelTransf.add(chkTED);;
		painelDest.add(lblDest);
		painelDest.add(chkCPF);
		painelDest.add(chkCNPJ);
		painelDest.add(painelCPFCNPJ);
		painelAgencia.add(lblAgencia);
		painelAgencia.add(txtAgencia);
		painelConta.add(lblConta);
		painelConta.add(txtConta);
		painelBanco.add(lblBanco);
		painelBanco.add(cbxBanco);
		painelValor.add(lblValor);
		painelValor.add(txtValor);
		painelEsquerdo.add(painelTransf);
		painelEsquerdo.add(painelDest);
		painelEsquerdo.add(painelAgencia);
		painelEsquerdo.add(painelConta);
		painelEsquerdo.add(painelBanco);
		painelEsquerdo.add(painelValor);
		painelBaixo.add(btnTransferir);
		painelBaixo.add(btnVoltar);
		
		painelTelaTransf.add(painelEsquerdo, BorderLayout.CENTER);
		painelTelaTransf.add(painelBaixo, BorderLayout.SOUTH);
		
		tt.setContentPane(painelTelaTransf);
		tt.setVisible(true);
		tt.setSize(800, 600);
		tt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void telaSaldo() {
		
		painelTelaSaldo = new JPanel(new BorderLayout());
		JPanel painelMostrar = new JPanel(new GridLayout(7,1));
		JPanel painelBotoes = new JPanel();
		
		btnVerificar = new JButton("Verificar");
		btnVerificar.addActionListener(this);
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(this);
		btnVoltar.setActionCommand("VoltarSaldo");
		
		JLabel lblCartao = new JLabel("Numero do Cartão:");
		JTextField txtCartao = new JTextField(16);
		PlainDocument verCartao = (PlainDocument) txtCartao.getDocument();
		verCartao.setDocumentFilter(new verificaTexto(16, "Int"));
		JPanel painelCartao = new JPanel();
		
		JLabel lblNome = new JLabel("Nome:");
		JTextField txtNome = new JTextField(20);
		txtNome.setEnabled(false);
		JPanel painelNome = new JPanel();
		
		JLabel lblBanco = new JLabel("Banco:");
		JTextField txtBanco = new JTextField(10);
		txtBanco.setEnabled(false);
		JPanel painelBanco = new JPanel();
		
		JLabel lblConta = new JLabel("Conta");
		JTextField txtConta = new JTextField(10);
		txtConta.setEnabled(false);
		JPanel painelConta = new JPanel();
		
		painelCartao.add(lblCartao);
		painelCartao.add(txtCartao);
		painelCartao.add(btnVerificar);
		painelNome.add(lblNome);
		painelNome.add(txtNome);
		painelBanco.add(lblBanco);
		painelBanco.add(txtBanco);
		painelConta.add(lblConta);
		painelConta.add(txtConta);
		
		painelMostrar.add(painelCartao);
		painelMostrar.add(painelNome);
		painelMostrar.add(painelBanco);
		painelMostrar.add(painelConta);
		
		painelBotoes.add(btnVoltar);
		
		painelTelaSaldo.add(painelMostrar, BorderLayout.CENTER);
		painelTelaSaldo.add(painelBotoes, BorderLayout.SOUTH);
		
		tsal.setContentPane(painelTelaSaldo);
		tsal.setVisible(true);
		tsal.setSize(600, 400);
		tsal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void telaADM() {
		
		painelTelaADM = new JPanel(new BorderLayout());
		JPanel painelValores = new JPanel (new GridLayout(1,3));
		JPanel painelBotoesEsquerdo = new JPanel(new GridLayout(5,1));
		JPanel painelBotoesDireito = new JPanel(new GridLayout(5,1));
		JPanel painelGeral = new JPanel(new GridLayout(2,1));
		
		btnAdicionar = new JButton("Adicionar cédulas");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setActionCommand("AdicionarCedula");
		btnRemover = new JButton("Remover cédulas");
		btnRemover.addActionListener(this);
		btnRemover.setActionCommand("RemoverCedula");
		btnMostrar = new JButton("Mostrar cedulas");
		btnMostrar.addActionListener(this);
		btnMostrar.setActionCommand("MostrarCedula");
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(this);
		btnVoltar.setActionCommand("VoltarADM");
		btnZerar = new JButton("Zerar BD");	
		btnZerar.addActionListener(this);
		btnZerar.setActionCommand("ZerarCedula");
		
		JLabel lbl2 = new JLabel ("R$ 2");
		txtR$2 = new JTextField(10);
		PlainDocument vertxtR$2 = (PlainDocument) txtR$2.getDocument();
		vertxtR$2.setDocumentFilter(new verificaTexto(5, "Int"));
		txtR$2.setText("0");
		JPanel painelR$2 = new JPanel();
		painelR$2.add(lbl2);
		painelR$2.add(txtR$2);
		
		JLabel lbl5 = new JLabel ("R$ 5");
		txtR$5 = new JTextField(10);
		PlainDocument vertxtR$5 = (PlainDocument) txtR$5.getDocument();
		vertxtR$5.setDocumentFilter(new verificaTexto(5, "Int"));
		txtR$5.setText("0");
		JPanel painelR$5 = new JPanel();
		painelR$5.add(lbl5);
		painelR$5.add(txtR$5);
		
		JLabel lbl10 = new JLabel ("R$ 10");
		txtR$10 = new JTextField(10);
		PlainDocument vertxtR$10 = (PlainDocument) txtR$10.getDocument();
		vertxtR$10.setDocumentFilter(new verificaTexto(5, "Int"));
		txtR$10.setText("0");
		JPanel painelR$10 = new JPanel();
		painelR$10.add(lbl10);
		painelR$10.add(txtR$10);
		
		JLabel lbl20 = new JLabel ("R$ 20");
		txtR$20 = new JTextField(10);
		PlainDocument vertxtR$20 = (PlainDocument) txtR$20.getDocument();
		vertxtR$20.setDocumentFilter(new verificaTexto(5, "Int"));
		txtR$20.setText("0");
		JPanel painelR$20 = new JPanel();
		painelR$20.add(lbl20);
		painelR$20.add(txtR$20);
		
		JLabel lbl50 = new JLabel ("R$ 50");
		txtR$50 = new JTextField(10);
		PlainDocument vertxtR$50 = (PlainDocument) txtR$50.getDocument();
		vertxtR$50.setDocumentFilter(new verificaTexto(5, "Int"));
		txtR$50.setText("0");
		JPanel painelR$50 = new JPanel();
		painelR$50.add(lbl50);
		painelR$50.add(txtR$50);
		
		JLabel lbl100 = new JLabel ("R$ 100");
		txtR$100 = new JTextField(10);
		PlainDocument vertxtR$100 = (PlainDocument) txtR$100.getDocument();
		vertxtR$100.setDocumentFilter(new verificaTexto(5, "Int"));
		txtR$100.setText("0");
		JPanel painelR$100 = new JPanel();
		painelR$100.add(lbl100);
		painelR$100.add(txtR$100);
		
		JLabel lblTotal = new JLabel("Total no caixa");
		JTextField txtTotal = new JTextField(15);
		JPanel painelTotal = new JPanel();
		txtTotal.setEnabled(false);
		painelTotal.add(lblTotal);
		painelTotal.add(txtTotal);
		
		JPanel painelBaixo = new JPanel();	
		painelBaixo.add(btnAdicionar);
		painelBaixo.add(btnRemover);
		painelBaixo.add(btnMostrar);
		painelBaixo.add(btnZerar);	
		painelBaixo.add(btnVoltar);
			
		painelBotoesEsquerdo.add(new JPanel());
		painelBotoesEsquerdo.add(new JPanel());
	
		painelBotoesEsquerdo.add(painelR$2);
		painelBotoesEsquerdo.add(painelR$5);
		painelBotoesEsquerdo.add(painelR$10);

		painelBotoesDireito.add(new JPanel());
		painelBotoesDireito.add(new JPanel());
		painelBotoesDireito.add(painelR$20);
		painelBotoesDireito.add(painelR$50);
		painelBotoesDireito.add(painelR$100);
		
		painelValores.add(painelBotoesEsquerdo);
		painelValores.add(painelBotoesDireito);
		painelGeral.add(painelValores);
		painelGeral.add(painelTotal);
		
		painelTelaADM.add(painelGeral, BorderLayout.CENTER);
		painelTelaADM.add(painelBaixo, BorderLayout.SOUTH);
		
        tadm.setContentPane(painelTelaADM);	   
		tadm.setVisible(true);
		tadm.setSize(600, 400);
		tadm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void telaAddValores() {
		
		painelTelaAdd = new JPanel(new BorderLayout());
		JPanel painelDados = new JPanel(new GridLayout(7,1));
				
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setActionCommand("AdicionarDados");
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(this);
		btnVoltar.setActionCommand("VoltarAddValores");
		JPanel painelBotoes = new JPanel();	
		
		JLabel lblCartao = new JLabel("Numero do Cartão:");
		txtCartao = new JTextField(16);
		PlainDocument verCartao = (PlainDocument) txtCartao.getDocument();
		verCartao.setDocumentFilter(new verificaTexto(16, "Int"));
		JPanel painelCartao = new JPanel();
		
		JLabel lblSenha = new JLabel("Senha:");
		txtSenha = new JPasswordField(5);
		JPanel painelSenha = new JPanel();
		
		JLabel lblNome = new JLabel("Nome:");
		txtNome = new JTextField(30);
		PlainDocument verNome = (PlainDocument) txtNome.getDocument();
		verNome.setDocumentFilter(new verificaTexto(30, "Texto"));
		JPanel painelNome = new JPanel();
		
		JLabel lblSaldo = new JLabel("Saldo:");
		txtSaldo = new JTextField(10);
		PlainDocument verSaldo = (PlainDocument) txtSaldo.getDocument();
		verSaldo.setDocumentFilter(new verificaTexto(10, "Int"));
		JPanel painelSaldo = new JPanel();
		
		JLabel lblBanco = new JLabel("Banco:");
		cbxBanco = new JComboBox<String>();
		cbxBanco.addItem("Itau");
		cbxBanco.addItem("Santander");
		cbxBanco.addItem("Banco do Brasil");
		cbxBanco.addItem("Bradesco");
		cbxBanco.addItem("Caixa Economica");
		cbxBanco.addItem("HSBC");
		cbxBanco.addItem("Banco Original");
		JPanel painelBanco = new JPanel();
		
		JLabel lblAgencia = new JLabel("Agencia");
		txtAgencia = new JTextField(5);
		PlainDocument verAgencia = (PlainDocument) txtAgencia.getDocument();
		verAgencia.setDocumentFilter(new verificaTexto(5, "Int"));
		JPanel painelAgencia = new JPanel();
		
		JLabel lblConta = new JLabel("Conta");
		txtConta = new JTextField(10);
		PlainDocument verConta = (PlainDocument) txtConta.getDocument();
		verConta.setDocumentFilter(new verificaTexto(10, "Int"));
		JPanel painelConta = new JPanel();	
		
		painelCartao.add(lblCartao);
		painelCartao.add(txtCartao);
		painelSenha.add(lblSenha);
		painelSenha.add(txtSenha);
		painelNome.add(lblNome);
		painelNome.add(txtNome);
		painelSaldo.add(lblSaldo);
		painelSaldo.add(txtSaldo);
		painelBanco.add(lblBanco);
		painelBanco.add(cbxBanco);
		painelAgencia.add(lblAgencia);
		painelAgencia.add(txtAgencia);
		painelConta.add(lblConta);
		painelConta.add(txtConta);
		
		painelDados.add(painelCartao);
		painelDados.add(painelSenha);
		painelDados.add(painelNome);
		painelDados.add(painelSaldo);
		painelDados.add(painelBanco);
		painelDados.add(painelAgencia);
		painelDados.add(painelConta);
		
		painelBotoes.add(btnAdicionar);
		painelBotoes.add(btnVoltar);
		
		painelTelaAdd.add(painelBotoes, BorderLayout.SOUTH);
		painelTelaAdd.add(painelDados, BorderLayout.CENTER);
		
		tadd.setContentPane(painelTelaAdd);
		tadd.setVisible(true);
		tadd.setSize(600, 400);
		tadd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg) {
		
		String cmd = arg.getActionCommand();
		
		if ("Acessar".equals(cmd)) {
			
			login();
		} 
		else if ("Adicionar Valores...".equals(cmd)) {
			
			tadd = new JFrame("Adiciona Valores");
			tl.telaAddValores();
		} 
		else if ("VoltarAddValores".equals(cmd)) {
			
			tadd.dispose();
		}
		else if ("AdicionarDados".equals(cmd)) {
			
			colocarDados();
		}
		else if ("Admin".equals(cmd)) {
			
			tadm = new JFrame("Administrador");
			tl.telaADM();
		}
		else if ("SairLogin".equals(cmd)) {
			
			System.exit(0);
		}
		else if ("AdicionarCedula".equals(cmd)) {
			
			colocarDinheiro();
		}
		else if ("RemoverCedula".equals(cmd)) {
			
			removerDinheiro();
		}
		else if ("MostrarCedula".equals(cmd)) {
			
			mostrarDinheiro();
		}
		else if ("ZerarCedula".equals(cmd)) {
			
			zerarDinheiro();
		}
		else if ("VoltarADM".equals(cmd)) {
			
			tadm.dispose();
		}
		else if ("Realizar Saque".equals(cmd)) {
			
			ts = new JFrame("Saque");
		    tl.telaSaque();
		}
		else if ("ZerarSaque".equals(cmd)) {
			
			zerarCedulasTemp();
		}
		else if ("2".equals(cmd)) {
			
			int nota2 = 2;
			r$2++;
			totalSaque(nota2);
			sq.setN2(r$2);
		}
		else if ("5".equals(cmd)) {
			int nota5 = 5;
			r$5++;
			totalSaque(nota5);
			sq.setN5(r$5);
		}
		else if ("10".equals(cmd)) {
			
			int nota10 = 10;
			r$10++;
			totalSaque(nota10);
			sq.setN10(r$10);
		}
		else if ("20".equals(cmd)) {
			
			int nota20 = 20;
			r$20++;
			totalSaque(nota20);
			sq.setN20(r$20);
		}
		else if ("50".equals(cmd)) {
			
			int nota50 = 50;
			r$50++;
			totalSaque(nota50);
			sq.setN50(r$50);
		}
		else if ("100".equals(cmd)) {
			
			int nota100 = 100;
			r$100++;
			totalSaque(nota100);
			sq.setN100(r$100);
		}
		else if ("Sacar".equals(cmd)) {
			
			vouSacar();
		}
		else if ("VoltarSaque".equals(cmd)) {
			
			zerarCedulasTemp();
			ts.dispose();
		}
		else if ("Realizar Depósito".equals(cmd)) {
			
			tp = new JFrame("Depósito");
			tl.telaDeposito();
		}
		else if ("Depositar".equals(cmd)) {
			
			realizaDeposito();
		}
		else if ("VoltarDeposito".equals(cmd)) {
			
			tp.dispose();
		}
		else if ("Realizar Transferencia".equals(cmd)) {
			
			tt = new JFrame("Transferencia");
			tl.telaTransferencia();
		}
		else if ("Ver Saldo".equals(cmd)) {
			
			tsal = new JFrame("Saldo");
			tl.telaSaldo();
		}
		else if ("Verificar".equals(cmd)) {
			
			verSaldo();
		}
		else if ("VoltarSaldo".equals(cmd)) {
			
			tsal.dispose();
		}
		else if ("VoltarTransf".equals(cmd)) {
			
			tt.dispose();
		}
		else if ("Finalizar".equals(cmd)) {
			
			telaAcesso();
			painelTelaMenu.setVisible(false);
			ta.setContentPane(painelTelaLogin);
			painelTelaLogin.setVisible(true);
		}	
	}
	public void login() {
		
		String senha = new String(txtSenha.getPassword());
		
		if (txtLogin.getText().isEmpty() || senha.isEmpty()) {
			
			JOptionPane.showMessageDialog(null,"Os campos DEVEM ser preenchidos");
		}
		else {			
			usuario.setNumCartao(txtLogin.getText());
			usuario.setSenha(senha);
			
			boolean ok = ctrConta.verificaLogin(usuario);
			
			if (ok == false) {
				
				JOptionPane.showMessageDialog(null, "Nº do cartão ou senha inválidos");
			} 
			else {
				
				telaMenu();
				painelTelaLogin.setVisible(false);
				ta.setContentPane(painelTelaMenu);	
				painelTelaMenu.setVisible(true);
				ta.invalidate();
				ta.revalidate();
				ta.repaint();
			}				
		}
	}
	public void colocarDados() {
		
		AddDados addDados = new AddDados();
		
		String senha = new String(txtSenha.getPassword());
		
		if (txtCartao.getText().isEmpty() || senha.isEmpty() || txtNome.getText().isEmpty() || txtAgencia.getText().isEmpty() || txtConta.getText().isEmpty()) {
			
			JOptionPane.showMessageDialog(null,"Todos os campos DEVEM ser preenchidos");
		}
		else if (Double.parseDouble(txtSaldo.getText()) <= 0) {
			
			JOptionPane.showMessageDialog(null,"Todos os campos DEVEM ser preenchidos");
		}
		else {
			
			addDados.setSenha(senha);
			addDados.setBanco(cbxBanco.getSelectedItem().toString());
			addDados.setAgencia(txtAgencia.getText());
			addDados.setConta(txtConta.getText());
			addDados.setNome(txtNome.getText());
			addDados.setNumCartao(txtCartao.getText());
			addDados.setSaldo(Double.parseDouble(txtSaldo.getText()));
			
			ctrConta.criaConta(addDados);
		}
	}
	public void colocarDinheiro() {
		
		if (txtR$2.getText().isEmpty() || txtR$5.getText().isEmpty() || txtR$10.getText().isEmpty() || txtR$20.getText().isEmpty()
		    || txtR$50.getText().isEmpty() || txtR$100.getText().isEmpty() || Integer.parseInt(txtR$2.getText()) < 0
		    || Integer.parseInt(txtR$5.getText()) < 0 || Integer.parseInt(txtR$10.getText()) < 0 || Integer.parseInt(txtR$20.getText()) < 0
		    || Integer.parseInt(txtR$50.getText()) < 0 || Integer.parseInt(txtR$100.getText()) < 0) {
			
			JOptionPane.showMessageDialog(null,"Adicione um valor válido em cada espaço");
		}
		else {
			
			totalCaixa = saque.recebeNotas();
			Cedulas tempAdiciona = totalCaixa;
			
			tempAdiciona.setN2(tempAdiciona.getN2() + Integer.parseInt(txtR$2.getText()));
			tempAdiciona.setN5(tempAdiciona.getN5() + Integer.parseInt(txtR$5.getText()));
			tempAdiciona.setN10(tempAdiciona.getN10() + Integer.parseInt(txtR$10.getText()));
			tempAdiciona.setN20(tempAdiciona.getN20() + Integer.parseInt(txtR$20.getText()));
			tempAdiciona.setN50(tempAdiciona.getN50() + Integer.parseInt(txtR$50.getText()));
			tempAdiciona.setN100(tempAdiciona.getN100() + Integer.parseInt(txtR$100.getText()));
			
			totalCaixa = addCedula.tratarCedulas(tempAdiciona);
		}
	}
	public void removerDinheiro() {
		
		if (txtR$2.getText().isEmpty() || txtR$5.getText().isEmpty() || txtR$10.getText().isEmpty() || txtR$20.getText().isEmpty()
			|| txtR$50.getText().isEmpty() || txtR$100.getText().isEmpty() || Integer.parseInt(txtR$2.getText()) < 0
			|| Integer.parseInt(txtR$5.getText()) < 0 || Integer.parseInt(txtR$10.getText()) < 0 || Integer.parseInt(txtR$20.getText()) < 0
			|| Integer.parseInt(txtR$50.getText()) < 0 || Integer.parseInt(txtR$100.getText()) < 0) {
				
			JOptionPane.showMessageDialog(null,"Adicione um valor válido em cada espaço");
		}
		else {
			
			Cedulas tempRemove = totalCaixa;
			
			tempRemove.setN2(tempRemove.getN2());
			tempRemove.setN5(tempRemove.getN5());
			tempRemove.setN10(tempRemove.getN10());
			tempRemove.setN20(tempRemove.getN20());
			tempRemove.setN50(tempRemove.getN50());
			tempRemove.setN100(tempRemove.getN100());
			
			if (tempRemove.getN2() - Integer.parseInt(txtR$2.getText()) < 0 || tempRemove.getN5() - Integer.parseInt(txtR$5.getText()) < 0
			   || tempRemove.getN10() - Integer.parseInt(txtR$10.getText()) < 0 || tempRemove.getN20() - Integer.parseInt(txtR$20.getText()) < 0
			   || tempRemove.getN50() - Integer.parseInt(txtR$50.getText()) < 0 || tempRemove.getN100() - Integer.parseInt(txtR$100.getText()) < 0) {
				
				JOptionPane.showMessageDialog(null,"Valor da retirada maior que o valor armazenado. Operação cancelada");
			}
			else {
				
				tempRemove.setN2(tempRemove.getN2() - Integer.parseInt(txtR$2.getText()));
				tempRemove.setN5(tempRemove.getN5() - Integer.parseInt(txtR$5.getText()));
				tempRemove.setN10(tempRemove.getN10() - Integer.parseInt(txtR$10.getText()));
				tempRemove.setN20(tempRemove.getN20() - Integer.parseInt(txtR$20.getText()));
				tempRemove.setN50(tempRemove.getN50() - Integer.parseInt(txtR$50.getText()));
				tempRemove.setN100(tempRemove.getN100() - Integer.parseInt(txtR$100.getText()));
				
				totalCaixa = removeCedula.tratarCedulas(tempRemove);
			}
		}
	}
	public void realizaDeposito() {
		
		if (txtAgencia.getText().isEmpty() || txtConta.getText().isEmpty() || txtValor.getText().isEmpty()) {
			
			JOptionPane.showMessageDialog(null, "Os campos DEVEM ser preenchidos");
		}
		else {
			
			AddDados addDep = new AddDados();
			
			addDep.setBanco(cbxBanco.getSelectedItem().toString());
			addDep.setAgencia(txtAgencia.getText());
			addDep.setConta(txtConta.getText());
			addDep.setValor(addDep.getValor() + Double.parseDouble(txtValor.getText()));
			
			ctrDeposito.verificaDeposito(addDep);
		}
	}
	public void mostrarDinheiro() {
		
		Cedulas tempMostra = totalCaixa;
		
		tempMostra.setN2(tempMostra.getN2());
		tempMostra.setN5(tempMostra.getN5());
		tempMostra.setN10(tempMostra.getN10());
		tempMostra.setN20(tempMostra.getN20());
		tempMostra.setN50(tempMostra.getN50());
		tempMostra.setN100(tempMostra.getN100());
		
			
		txtR$2.setText(Integer.toString(tempMostra.getN2()));
		txtR$5.setText(Integer.toString(tempMostra.getN5()));
		txtR$10.setText(Integer.toString(tempMostra.getN10()));
		txtR$20.setText(Integer.toString(tempMostra.getN20()));
		txtR$50.setText(Integer.toString(tempMostra.getN50()));
		txtR$100.setText(Integer.toString(tempMostra.getN100()));		
	}
	public void zerarDinheiro() {
		
		Cedulas tempZerar = totalCaixa;
		
		tempZerar.setN2(tempZerar.getN2() - tempZerar.getN2());
		tempZerar.setN5(tempZerar.getN5() - tempZerar.getN5());
		tempZerar.setN10(tempZerar.getN10() - tempZerar.getN10());
		tempZerar.setN20(tempZerar.getN20() - tempZerar.getN20());
		tempZerar.setN50(tempZerar.getN50() - tempZerar.getN50());
		tempZerar.setN100(tempZerar.getN100() - tempZerar.getN100());
		
		totalCaixa = zeraCedula.tratarCedulas(tempZerar);
	}
	public void vouSacar() {
		
		Cedulas tempSaque = totalCaixa;
		
		tempSaque.setN2(tempSaque.getN2() - r$2);
		tempSaque.setN5(tempSaque.getN5() - r$5);
		tempSaque.setN10(tempSaque.getN10() - r$10);
		tempSaque.setN20(tempSaque.getN20() - r$20);
		tempSaque.setN50(tempSaque.getN50() - r$50);
		tempSaque.setN100(tempSaque.getN100() - r$100);
		
		//usuario.modificaSaldo(totalSaque(aux));
		
		totalCaixa = saque.sacarValor(tempSaque, usuario);
		zerarCedulasTemp();
	}
	public void totalSaque(int valor) {
			
		aux = aux + valor;
		
		if (aux > usuario.getSaldo()) {
			
			JOptionPane.showMessageDialog(null, "O valor desejado é maior que seu saldo. Operação cancelada");
			zerarCedulasTemp();
		}
		else {
			
			txtMostraSaque.setText(Integer.toString(aux));	
		}
	}
	public void zerarCedulasTemp() {
		
		sq.setN2(0);
		sq.setN5(0);
		sq.setN10(0);
		sq.setN20(0);
		sq.setN50(0);
		sq.setN100(0);
		r$2 = 0; r$5 = 0 ; r$10 = 0; r$20 = 0; r$50 = 0; r$100 = 0;	
		aux = 0;
		txtMostraSaque.setText(Integer.toString(aux));
	}
	public void verSaldo() {
	    
		AddDados addDep = new AddDados();
		
		if (txtCartao.getText().isEmpty()) {
			
			JOptionPane.showMessageDialog(null,"O campo do número do cartão deve ser preenchido");
		}
		else {
			
		}
	}
	class verificaTexto extends DocumentFilter {     // Realiza o limite de caracteres nos JTextField's

		private int limite;
		private String tipo;

		public verificaTexto(int limite, String tipo) {
			
			this.tipo = tipo;
			this.limite = limite;
		}

		@Override
		public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {

			Document doc = fb.getDocument();
			StringBuilder sb = new StringBuilder();
			sb.append(doc.getText(0, doc.getLength()));
			sb.insert(offset, string);

			if (test(sb.toString())) {
				
				super.insertString(fb, offset, string, attr);
			} 
			else {
				
			}
		}
		private boolean test(String text) {
			
			if ("Texto".equals(tipo)) {

				if (text.length() <= limite) {

					return true;
				} 
				else {

					return false;
				}
			} 
			else if ("Int".equals(tipo)) {

				if (text.length() <= limite) {

					try {

						Long.parseLong(text);

						return true;
					} 
					catch (NumberFormatException e) {

						return false;
					}
				} 
				else {

					return false;
				}
			} 
			else if ("Double".equals(tipo)) {

				if (text.length() <= limite) {

					try {

						Double.parseDouble(text);

						return true;
					} 
					catch (NumberFormatException e) {

						return false;
					}
				}
				else {

					return false;
				}
			}
			return false;
		}

		@Override
		public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
			
			Document doc = fb.getDocument();
			StringBuilder sb = new StringBuilder();
			sb.append(doc.getText(0, doc.getLength()));
			sb.replace(offset, offset + length, text);

			if (test(sb.toString())) {
				
				super.replace(fb, offset, length, text, attrs);
			} 
			else {
				
			}
		}

		@Override
		public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
			
			Document doc = fb.getDocument();
			StringBuilder sb = new StringBuilder();
			sb.append(doc.getText(0, doc.getLength()));
			sb.delete(offset, offset + length);

			if (test(sb.toString())) {
				
				super.remove(fb, offset, length);
			} 
			else {
				
			}
		}
	}
}