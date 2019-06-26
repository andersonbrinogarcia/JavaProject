package salao;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;



import util.ConnectionFactory;
public class Cliente extends JFrame {
	private static String idCliente;
	private static String nomeCli;
	private static String telefoneCli;
	private static String emailCli;
	
	
	public Cliente(){
		JPanel painelCliente = new JPanel();
		painelCliente.setLayout(new FlowLayout());
		
		JLabel jNomeCliente = new JLabel("Nome do cliente: ");
		JTextField txtNomeCliente = new JTextField(20);

		JLabel jCpfCliente = new JLabel("CPF: ");
		JTextField txtCpfCliente = new JTextField(20);
		
		JLabel jTelefoneCliente = new JLabel("Telefone: ");
		JTextField txtTelefoneCliente = new JTextField(20);
		
		JLabel jEmail = new JLabel("E-mail: ");
		JTextField txtEmail = new JTextField(20);
	
		JButton bCadastrar = new JButton("Cadastrar");
		JButton bLimpar = new JButton("Limpar Dados");
		JButton bVoltar = new JButton("Voltar");
		
		idCliente = txtCpfCliente.getText();
		nomeCli = txtNomeCliente.getText();
		telefoneCli = txtTelefoneCliente.getText();
		emailCli = txtEmail.getText();
	
		
		painelCliente.add(jNomeCliente);
		painelCliente.add(txtNomeCliente);
		painelCliente.add(jCpfCliente);
		painelCliente.add(txtCpfCliente);
		painelCliente.add(jTelefoneCliente);
		painelCliente.add(txtTelefoneCliente);
		painelCliente.add(jEmail);
		painelCliente.add(txtEmail);
		painelCliente.add(bCadastrar);
		painelCliente.add(bLimpar);
		painelCliente.add(bVoltar);
		
		
		
        this.setContentPane(painelCliente); 
        this.setSize(900,400);   
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);   
        this.setLocationRelativeTo(null);   
        this.setTitle("Cadastrar Cliente");
        this.setVisible(true);
        
       

        
        
		
		// limpa dados dos campos
		bLimpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtNomeCliente.setText("");
				txtCpfCliente.setText("");
				txtTelefoneCliente.setText("");
				txtEmail.setText("");
			}
		});
		
		
		// volta para a tela principal
		bVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				Atendimento atendimento = new Atendimento();
				atendimento.show();
			}
		});
		
		
		//cadastro de novo cliente
		bCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
				// conectando com o banco de dados
				Connection bd = ConnectionFactory.getConnection();
				
				// escrevendo a query
				String sql = "INSERT INTO CLIENTE VALUES (?,?,?,?)";
								
				// cirando a variável da query e preparando e inserindo os dados
				PreparedStatement stmt = bd.prepareStatement(sql);
				stmt.setString(1, txtCpfCliente.getText());
				stmt.setString(2, txtNomeCliente.getText());
				stmt.setString(3, txtEmail.getText());
				stmt.setString(4, txtTelefoneCliente.getText());
				
				// utilizei o execute.Update, pois não consegui executar com executeQuery
				stmt.executeUpdate();
				
				// fechando a janela e abrindo novo atendimento
				dispose();
				Atendimento atendimento = new Atendimento();
				atendimento.show();
				
				}catch (SQLException r) {
					System.out.println(r.getMessage());
					
				}
			}
		});

	
	}	
	
}
