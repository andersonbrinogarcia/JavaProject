package salao;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;

import util.ConnectionFactory;

public class Funcionario extends JFrame{

	
	public Funcionario() {
		JPanel painelFuncionario = new JPanel();
		painelFuncionario.setLayout(new FlowLayout());
		
		JLabel jNomeFuncionario = new JLabel("Nome do funcionario: ");
		JTextField txtNomeFuncionario = new JTextField(20);

		JLabel jCpfFuncionario = new JLabel("CPF: ");
		JTextField txtCpfFuncionario = new JTextField(20);
		
		JLabel jTelefoneFuncionario = new JLabel("Telefone: ");
		JTextField txtTelefoneFuncionario = new JTextField(20);
		
		JLabel jEmail = new JLabel("E-mail: ");
		JTextField txtEmail = new JTextField(20);
	
		JButton bCadastrar = new JButton("Cadastrar");
		JButton bLimpar = new JButton("Limpar Dados");
		JButton bVoltar = new JButton("Voltar");
		
		painelFuncionario.add(jNomeFuncionario);
		painelFuncionario.add(txtNomeFuncionario);
		painelFuncionario.add(jCpfFuncionario);
		painelFuncionario.add(txtCpfFuncionario);
		painelFuncionario.add(jTelefoneFuncionario);
		painelFuncionario.add(txtTelefoneFuncionario);
		painelFuncionario.add(jEmail);
		painelFuncionario.add(txtEmail);
		painelFuncionario.add(bCadastrar);
		painelFuncionario.add(bLimpar);
		painelFuncionario.add(bVoltar);
		
        this.setContentPane(painelFuncionario); 
        this.setSize(900,400);   
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);   
        this.setLocationRelativeTo(null);   
        this.setTitle("Cadastrar Funcionário");
        this.setVisible(true);
		
		bCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		bLimpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtNomeFuncionario.setText("");
				txtCpfFuncionario.setText("");
				txtTelefoneFuncionario.setText("");
				txtEmail.setText("");
			}
		});
		
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
						String sql = "INSERT INTO FUNCIONARIO VALUES (?,?,?,?)";
										
						// cirando a variável da query e preparando e inserindo os dados
						PreparedStatement stmt = bd.prepareStatement(sql);
						stmt.setString(1, txtCpfFuncionario.getText());
						stmt.setString(2, txtNomeFuncionario.getText());
						stmt.setString(3, txtEmail.getText());
						stmt.setString(4, txtTelefoneFuncionario.getText());
						
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
