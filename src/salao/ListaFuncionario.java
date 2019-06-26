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

import util.ConnectionFactory;

public class ListaFuncionario extends JFrame{
	
	public List<Funcionario> listaFuncionario() throws SQLException{

		JPanel painelListaFuncionario = new JPanel();
		painelListaFuncionario.setLayout(new FlowLayout());
		JButton bVoltar = new JButton("Voltar");
					
			this.setContentPane(painelListaFuncionario); 
	        this.setSize(900,400);   
	        this.setDefaultCloseOperation(EXIT_ON_CLOSE);   
	        this.setLocationRelativeTo(null);   
	        this.setTitle("Listar Clientes");
	        this.setVisible(true);
	        
	        try {
				// conectando com o banco de dados
				Connection bd = ConnectionFactory.getConnection();
				
				// escrevendo a query
				String sql = "SELECT * FROM FUNCIONARIO";
				
				PreparedStatement stmt = bd.prepareStatement(sql);
				
				ResultSet rs = stmt.executeQuery(sql);
				
				List<Cliente> cliente = new ArrayList<>();
				
				//Cirando e populando os objetos
				while(rs.next()) {
					JButton bEditar = new JButton("Editar");
					painelListaFuncionario.add(new JLabel("<HTML>"+rs.getString("COD_FUNC")+"<BR></HTML>"));
					painelListaFuncionario.add(new JLabel("<HTML>"+rs.getString("NOME")+"<BR></HTML>"));
					painelListaFuncionario.add(new JLabel("<HTML>"+rs.getString("EMAIL")+"<BR></HTML>"));
					painelListaFuncionario.add(new JLabel("<HTML>"+rs.getString("TELEFONE")+"<BR></HTML>"));
					painelListaFuncionario.add(bEditar);
					
					String id = rs.getString("COD_FUNC");
					bEditar.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							dispose();
							try {
								new EditaFuncionario(id);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
					});
					
				}
				
		        painelListaFuncionario.add(bVoltar);
		        
		        bVoltar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
						Atendimento atendimento = new Atendimento();
						atendimento.show();
						
					}
				});
			      
				return null;
	        }catch (SQLException e) {
				System.out.println(e.getMessage());
				return null;
			}

		
	}
	



}