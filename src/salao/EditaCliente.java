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


public class EditaCliente extends JFrame{
	
	public EditaCliente(String id) throws SQLException{
		JPanel painelCliente = new JPanel();
		painelCliente.setLayout(new FlowLayout());
		
		JLabel jNomeCliente = new JLabel("Nome do cliente: ");
		JTextField txtNomeCliente = new JTextField(20);

		JLabel jCpfCliente = new JLabel("CPF: " + id);
		
		JLabel jTelefoneCliente = new JLabel("Telefone: ");
		JTextField txtTelefoneCliente = new JTextField(20);
		
		JLabel jEmail = new JLabel("E-mail: ");
		JTextField txtEmail = new JTextField(20);
	
		JButton bAtualizar = new JButton("Atualizar");
		JButton bLimpar = new JButton("Limpar Dados");
		JButton bVoltar = new JButton("Voltar");
		
		painelCliente.add(jNomeCliente);
		painelCliente.add(txtNomeCliente);
		painelCliente.add(jTelefoneCliente);
		painelCliente.add(txtTelefoneCliente);
		painelCliente.add(jEmail);
		painelCliente.add(txtEmail);
		painelCliente.add(bAtualizar);
		painelCliente.add(bLimpar);
		painelCliente.add(bVoltar);
		painelCliente.add(jCpfCliente);
		
		
		 	this.setContentPane(painelCliente); 
	        this.setSize(900,400);   
	        this.setDefaultCloseOperation(EXIT_ON_CLOSE);   
	        this.setLocationRelativeTo(null);   
	        this.setTitle("Cadastrar Cliente");
	        this.setVisible(true);
	        
	    bAtualizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					// conectando com o banco de dados
					Connection bd = ConnectionFactory.getConnection();
					
					// escrevendo a query
					// cirando a variável da query e preparando e inserindo os dados
					String sql = "UPDATE CLIENTE SET NOME = ?, EMAIL = ?, TELEFONE = ?	WHERE COD_CLI = ?";
					PreparedStatement stmt = bd.prepareStatement(sql);
					stmt.setString(1,txtNomeCliente.getText());
					stmt.setString(2, txtEmail.getText() );
					stmt.setString(3, txtTelefoneCliente.getText());
					stmt.setString(4, id);
					
				

					
					// utilizei o execute.Update, pois não consegui executar com executeQuery
					stmt.executeUpdate();
					
					// fechando a janela e abrindo novo atendimento
					
					}catch (SQLException r) {
						System.out.println(r.getMessage());
						
					}
			}
		});    
	} 

}
