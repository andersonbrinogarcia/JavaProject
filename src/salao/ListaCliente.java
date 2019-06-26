package salao;

import java.awt.Button;
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

public class ListaCliente extends JFrame{
		
		public List<Cliente> listaCliente() throws SQLException{

			JPanel painelListaCliente = new JPanel();
			painelListaCliente.setLayout(new FlowLayout());
			JButton bVoltar = new JButton("Voltar");
			
						
				this.setContentPane(painelListaCliente); 
		        this.setSize(900,400);   
		        this.setDefaultCloseOperation(EXIT_ON_CLOSE);   
		        this.setLocationRelativeTo(null);   
		        this.setTitle("Listar Clientes");
		        this.setVisible(true);
		        
		        try {
					// conectando com o banco de dados
					Connection bd = ConnectionFactory.getConnection();
					
					// escrevendo a query
					String sql = "SELECT * FROM CLIENTE";
					
					PreparedStatement stmt = bd.prepareStatement(sql);
					
					ResultSet rs = stmt.executeQuery(sql);
					
					List<Cliente> cliente = new ArrayList<>();
					
					//Cirando e populando os objetos
					while(rs.next()) {
				
						JButton bEditar = new JButton("Editar");
						painelListaCliente.add(new JLabel("<HTML>"+rs.getString("COD_CLI")+"<BR></HTML>"));
						painelListaCliente.add(new JLabel("<HTML>"+rs.getString("NOME")+"<BR></HTML>"));
						painelListaCliente.add(new JLabel("<HTML>"+rs.getString("EMAIL")+"<BR></HTML>"));
						painelListaCliente.add(new JLabel("<HTML>"+rs.getString("TELEFONE")+"<BR></HTML>"));
						painelListaCliente.add(bEditar);
						String id = rs.getString("COD_CLI");
						bEditar.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								dispose();
								try {
									new EditaCliente(id);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							}
						});
						
					
						
						
					
					}
					
			        painelListaCliente.add(bVoltar);
			        
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
