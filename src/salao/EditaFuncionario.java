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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import util.ConnectionFactory;

public class EditaFuncionario extends JFrame{
	
	public EditaFuncionario(String id) throws SQLException{
		JPanel painelFunc = new JPanel();
		painelFunc.setLayout(new FlowLayout());
		
		JLabel jNomeFunc = new JLabel("Nome do Funcionario: ");
		JTextField txtNomeFunc = new JTextField(20);

		JLabel jCpfFunc = new JLabel("CPF: " + id);
		
		JLabel jTelefoneFunc = new JLabel("Telefone: ");
		JTextField txtTelefoneFunc = new JTextField(20);
		
		JLabel jEmail = new JLabel("E-mail: ");
		JTextField txtEmail = new JTextField(20);
	
		JButton bAtualizar = new JButton("Atualizar");
		JButton bLimpar = new JButton("Limpar Dados");
		JButton bVoltar = new JButton("Voltar");
		
		painelFunc.add(jNomeFunc);
		painelFunc.add(txtNomeFunc);
		painelFunc.add(jTelefoneFunc);
		painelFunc.add(txtTelefoneFunc);
		painelFunc.add(jEmail);
		painelFunc.add(txtEmail);
		painelFunc.add(bAtualizar);
		painelFunc.add(bLimpar);
		painelFunc.add(bVoltar);
		painelFunc.add(jCpfFunc);
		
		
		 	this.setContentPane(painelFunc); 
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
					String sql = "UPDATE FUNCIONARIO SET NOME = ?, EMAIL = ?, TELEFONE = ?	WHERE COD_FUNC = ?";
					PreparedStatement stmt = bd.prepareStatement(sql);
					stmt.setString(1,txtNomeFunc.getText());
					stmt.setString(2, txtEmail.getText() );
					stmt.setString(3, txtTelefoneFunc.getText());
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
