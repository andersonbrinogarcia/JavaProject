package salao;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

import util.ConnectionFactory;

public class Servico extends JFrame{
	
	void criaServico(double valor, String tipo, int numero, String funcionario, String cliente ) {
		JPanel painelServico = new JPanel();  	       
        painelServico.setLayout(new FlowLayout());
        
        //testando o Cliente
        try {
			Connection bd = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM CLIENTE";
			PreparedStatement stmt = bd.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			
	
			        JLabel msgServico = new JLabel("<HTML> O servico foi criado com sucesso! <br> "
	        		+ "Com as seguintes informaçẽos: <br>"
	        		+ "Cliente: " + cliente + "<br> Funcionario: " + funcionario 
	        		+ "<br> Servico: " + tipo 
	        		+"<br> Valor: " + valor + "</HTML>");	
	        JButton bEnviar = new JButton("OK");
	        
	        painelServico.add(msgServico);
	        painelServico.add(bEnviar);
	        
	        
	        bEnviar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					dispose();
					Atendimento atendimento = new Atendimento();
					atendimento.show();
				}
			});
			
			
			
	        this.setContentPane(painelServico); 
	        this.setSize(900,400);   
	        this.setDefaultCloseOperation(EXIT_ON_CLOSE);   
	        this.setLocationRelativeTo(null);   
	        this.setTitle("Registro");
	        this.setVisible(true);
	        
	        
			
			
				 
			

		} catch (Exception e) {
			
		}
        

        

        
		
	}
}
