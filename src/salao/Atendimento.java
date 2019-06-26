package salao;

import javax.swing.*;	
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Scanner;

public class Atendimento extends JFrame{
	private static int idAtendimento;
	
    JTextField txtCliente = new JTextField(20);   
    JLabel jLabelCliente = new JLabel("Nome do cliente:"); 
    
    JLabel jLabelTipoAtendimento = new JLabel("Tipo de atendimento:");
    JTextField txtTipoAtendimento = new JTextField(20); 
    
    JLabel jLabelValor = new JLabel("Valor do serviço:"); 
    JTextField txtValor = new JTextField(20); 
    
    JLabel jLabelFuncionario = new JLabel("Funcionario que realizou o serviço:"); 
    JTextField txtFuncionario = new JTextField(20); 
    
    JButton jButton1 = new JButton("Enviar");
    JButton bLimpar = new JButton("Limpar dados");
    JButton bCadastroCliente = new JButton("Cadastrar Cliente");
    JButton bCadastroFuncionario = new JButton("Cadastrar Funcionário");
    JButton bListarCliente = new JButton("Listar Clientes");
    JButton bListarFuncionario = new JButton("Listar Funcionários");
    
	public Atendimento() {   
	        JPanel painel = new JPanel();  
	       
	        painel.setLayout(new FlowLayout());
	        
	        
	        JPanel painel2 = new JPanel();
	        painel2.setLayout(new FlowLayout());
	        
	        
	        painel.add(jLabelCliente);
	        painel.add(txtCliente); 
	        
	        painel.add(jLabelTipoAtendimento);
	        painel.add(txtTipoAtendimento); 
	        
	        painel.add(jLabelValor);
	        painel.add(txtValor); 
	        
	        painel.add(jLabelFuncionario);
	        painel.add(txtFuncionario); 
	        
	        painel.add(painel2);
	        painel.add(jButton1);
	        painel.add(bLimpar);
	        painel.add(bCadastroCliente);
	        painel.add(bCadastroFuncionario);
	        painel.add(bListarCliente);
	        painel.add(bListarFuncionario);
	        
	        this.setContentPane(painel); 
	        this.setSize(900,400);   
	        this.setDefaultCloseOperation(EXIT_ON_CLOSE);   
	        this.setLocationRelativeTo(null);   
	        this.setTitle("Atendimento"); 
	        
	        
	        jButton1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					dispose();
					Servico servico = new Servico();
					servico.criaServico(Double.parseDouble(txtValor.getText()), 
							txtTipoAtendimento.getText(), idAtendimento, txtFuncionario.getText(), txtCliente.getText());
					
				}
			});
	        
	        
	        bLimpar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					txtCliente.setText("");
					txtFuncionario.setText("");
					txtTipoAtendimento.setText("");
					txtValor.setText("");
					
					
				}
			});
	        
	        bCadastroCliente.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					dispose();
					new Cliente();
					
					
				}
			}); 
	        bCadastroFuncionario.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					dispose();
					new Funcionario();
				}
			});
	        bListarCliente.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					ListaCliente cliente = new ListaCliente();
					try {
						cliente.listaCliente();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
	        
	        bListarFuncionario.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					ListaFuncionario func = new ListaFuncionario();
					try {
						func.listaFuncionario();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
	        	
	        
	    }    
		public static void main(String[] args) {   
	        new Atendimento().setVisible(true);  
	        
	        
	    }	

	   
}
