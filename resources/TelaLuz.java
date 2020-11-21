/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;

public class TelaLuz extends javax.swing.JFrame {

    /**
     * Creates new form TelaLuz
     */
    public TelaLuz() {
        initComponents();
        this.clientes = new HashMap<>();
        this.historico = new ArrayList<>();
        
        
        Action saveAction = new AbstractAction("save") {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                save();   
            }
        };
    
    String key = "save";
    
    salvarButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK), key);
    
    salvarButton.getActionMap().put(key, saveAction);


        Action searchAction = new AbstractAction("search") {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
					search();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}   
            }
        };
    
    String key2 = "search";
    
    procurarButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK), key2);
    
    procurarButton.getActionMap().put(key2, searchAction);
    
    
            Action clearAction = new AbstractAction("clear") {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                clear();   
            }
        };
    
    String key3 = "clear";
    
    procurarButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK), key3);
    
    procurarButton.getActionMap().put(key3, clearAction);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        instalacaoField = new javax.swing.JTextField();
		try {
				javax.swing.text.MaskFormatter format_textField3 = new javax.swing.text.MaskFormatter("########");
				instalacaoField= new javax.swing.JFormattedTextField(format_textField3);
			} 
		catch (Exception e){}
        jLabel1 = new javax.swing.JLabel();
        nomeClienteField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        vencimentoField = new javax.swing.JTextField();
		try {
				javax.swing.text.MaskFormatter format_textField3 = new javax.swing.text.MaskFormatter("##/##/####");
				vencimentoField= new javax.swing.JFormattedTextField(format_textField3);
			} 
		catch (Exception e){}
        jLabel4 = new javax.swing.JLabel();
        contaMesField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        consumoField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tarifaField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        pisField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cofinsField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        icmsField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        totalPagarField = new javax.swing.JTextField();
        salvarButton = new javax.swing.JButton();
        procurarButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        limparButton = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        arquivoButton = new javax.swing.JButton();

        jButton2.setText("HistÃ³rico");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("InstalaÃ§Ã£o");

        jLabel2.setText("Cliente");

        jLabel3.setText("Vencimento");

        jLabel4.setText("Conta do MÃªs");

        jLabel5.setText("Consumo KWH");

        jLabel6.setText("Tarifa");

        jLabel7.setText("PIS");

        jLabel8.setText("COFINS");

        jLabel9.setText("ICMS");

        jLabel10.setText("Total a Pagar");

        salvarButton.setText("Salvar");
        salvarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarButtonActionPerformed(evt);
            }
        });

        procurarButton.setText("Procurar");
        procurarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procurarButtonActionPerformed(evt);
            }
        });

        jLabel11.setText("ctrl + s");

        jLabel12.setText("ctrl + d");

        limparButton.setText("Limpar");
        limparButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparButtonActionPerformed(evt);
            }
        });

        jLabel13.setText("ctrl + f");

        arquivoButton.setText("Criar Arquivo");
        arquivoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arquivoButtonActionPerformed(evt);
            }
        });
        
        btnAtualizar = new JButton("Atualizar");
        btnAtualizar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		try {
					update();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
        	}
        });
        
        btnExcluir = new JButton("Excluir");
        btnExcluir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		try {
					delete();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
        	}
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        							.addComponent(pisField, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        							.addComponent(vencimentoField)
        							.addComponent(instalacaoField)
        							.addComponent(jLabel1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        							.addComponent(jLabel3, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        							.addComponent(jLabel5, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        							.addComponent(consumoField))
        						.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        						.addComponent(icmsField, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(nomeClienteField, 300, 300, 300)
        						.addComponent(contaMesField, 300, 300, 300)
        						.addComponent(tarifaField, 300, 300, 300)
        						.addComponent(cofinsField, 300, 300, 300)
        						.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        						.addComponent(totalPagarField, 300, 300, 300)))
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel11)
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        								.addComponent(btnAtualizar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addComponent(salvarButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
        							.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        								.addGroup(layout.createSequentialGroup()
        									.addGap(18)
        									.addComponent(arquivoButton, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
        								.addGroup(layout.createSequentialGroup()
        									.addGap(18)
        									.addComponent(btnExcluir, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(procurarButton, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel12))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(limparButton, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel13))))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(21)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel2))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(nomeClienteField, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        				.addComponent(instalacaoField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        				.addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(vencimentoField, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        				.addComponent(contaMesField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        				.addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(consumoField, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        				.addComponent(tarifaField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(pisField, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        				.addComponent(cofinsField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(jLabel10, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        				.addComponent(jLabel9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(icmsField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        				.addComponent(totalPagarField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel11)
        				.addComponent(jLabel12)
        				.addComponent(jLabel13))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(salvarButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        				.addComponent(procurarButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        				.addComponent(limparButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        				.addComponent(arquivoButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
        			.addGap(4)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnAtualizar, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salvarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarButtonActionPerformed
        // TODO add your handling code here:
        ContaLuz cliente = new ContaLuz(instalacaoField.getText(), nomeClienteField.getText(), vencimentoField.getText(), contaMesField.getText(), consumoField.getText(), tarifaField.getText(), pisField.getText(), cofinsField.getText(), icmsField.getText(), totalPagarField.getText());
        String instalacao = instalacaoField.getText();
        //double x = checarTotal();
        
        try {
			post(instalacaoField.getText(), nomeClienteField.getText(), vencimentoField.getText(), contaMesField.getText(), consumoField.getText(), tarifaField.getText(), pisField.getText(), cofinsField.getText(), icmsField.getText(), totalPagarField.getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        if(checarDados(cliente)==0) {
            
            if(!clientes.containsKey(instalacao)) {
                //if(x != Double.valueOf(totalPagarField.getText())) {
                //    JOptionPane.showMessageDialog(null, "Total divergente");
                //}
                this.clientes.put(instalacao, cliente);
                this.historico.add(cliente);
            } else {
                clientes.get(instalacao).setNomeCliente(nomeClienteField.getText());
                clientes.get(instalacao).setVencimento(vencimentoField.getText());
                clientes.get(instalacao).setContaMes(contaMesField.getText());
                clientes.get(instalacao).setConsumo(consumoField.getText());
                clientes.get(instalacao).setTarifa(tarifaField.getText());
                clientes.get(instalacao).setPis(pisField.getText());
                clientes.get(instalacao).setCofins(cofinsField.getText());
                clientes.get(instalacao).setIcms(icmsField.getText());
                clientes.get(instalacao).setTotalPagar(totalPagarField.getText());                           
            }
                limparDados();
        }
        
        instalacaoField.requestFocus();
    }//GEN-LAST:event_salvarButtonActionPerformed
    
    
    public void save() {
        ContaLuz cliente = new ContaLuz(instalacaoField.getText(), nomeClienteField.getText(), vencimentoField.getText(), contaMesField.getText(), consumoField.getText(), tarifaField.getText(), pisField.getText(), cofinsField.getText(), icmsField.getText(), totalPagarField.getText());
        String instalacao = instalacaoField.getText();
        //double x = checarTotal();
        
        try {
			post(instalacaoField.getText(), nomeClienteField.getText(), vencimentoField.getText(), contaMesField.getText(), consumoField.getText(), tarifaField.getText(), pisField.getText(), cofinsField.getText(), icmsField.getText(), totalPagarField.getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        if(checarDados(cliente)==0) {
            
            if(!clientes.containsKey(instalacao)) {
                //if(x != Double.valueOf(totalPagarField.getText())) {
                //    JOptionPane.showMessageDialog(null, "Total divergente");
                //}
                this.clientes.put(instalacao, cliente);
                this.historico.add(cliente);
            } else {
                clientes.get(instalacao).setNomeCliente(nomeClienteField.getText());
                clientes.get(instalacao).setVencimento(vencimentoField.getText());
                clientes.get(instalacao).setContaMes(contaMesField.getText());
                clientes.get(instalacao).setConsumo(consumoField.getText());
                clientes.get(instalacao).setTarifa(tarifaField.getText());
                clientes.get(instalacao).setPis(pisField.getText());
                clientes.get(instalacao).setCofins(cofinsField.getText());
                clientes.get(instalacao).setIcms(icmsField.getText());
                clientes.get(instalacao).setTotalPagar(totalPagarField.getText());                           
            }
                limparDados();
        }
        
        instalacaoField.requestFocus();       
    }
    
    public static void post(String instalacao, String nomeCliente, String vencimento, String contaMes, String consumo, String tarifa, 
    		String pis, String cofins, String icms, String totalPagar) throws Exception {
		try {
			Connection conexao = FabricaConexao.getConexao();
			
			String sql = "INSERT INTO conta_luz VALUES (?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement posted = conexao.prepareStatement(sql);
			posted.setString(1, instalacao);
			posted.setString(2, nomeCliente);
			posted.setString(3, vencimento);
			posted.setString(4, contaMes);
			posted.setString(5, consumo);
			posted.setString(6, tarifa);
			posted.setString(7, pis);
			posted.setString(8, cofins);
			posted.setString(9, icms);
			posted.setString(10, totalPagar);
			posted.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("catch do post " + e);
		}
		finally {
			System.out.println("dados inseridos");
		}
	}
    
    private void procurarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procurarButtonActionPerformed

    	
    	try {
			search();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        //String instalacao = instalacaoField.getText();
        
        //if(clientes.containsKey(instalacao)) {
        //    nomeClienteField.setText(clientes.get(instalacao).getNomeCliente());
        //    vencimentoField.setText(clientes.get(instalacao).getVencimento());
        //    contaMesField.setText(clientes.get(instalacao).getContaMes());
        //    consumoField.setText(clientes.get(instalacao).getConsumo());
        //    tarifaField.setText(clientes.get(instalacao).getTarifa());
        //    pisField.setText(clientes.get(instalacao).getTarifa());
        //   cofinsField.setText(clientes.get(instalacao).getCofins());
        //    icmsField.setText(clientes.get(instalacao).getIcms());
        //    totalPagarField.setText(clientes.get(instalacao).getTotalPagar());
        //}
    }//GEN-LAST:event_procurarButtonActionPerformed

    private void limparButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparButtonActionPerformed
        // TODO add your handling code here:
        limparDados();
        instalacaoField.requestFocus();
    }//GEN-LAST:event_limparButtonActionPerformed

    private void arquivoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arquivoButtonActionPerformed
        try {
            SalvarDados();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "NÃ£o foi possÃ­vel criar arquivo");
        }
    }//GEN-LAST:event_arquivoButtonActionPerformed
    
    
    public void clear() {
        limparDados();
        instalacaoField.requestFocus();
    }
    
    
    //public void search() {
    //
    //    String instalacao = instalacaoField.getText();
    //    
    //    if(clientes.containsKey(instalacao)) {
    //        nomeClienteField.setText(clientes.get(instalacao).getNomeCliente());
    //        vencimentoField.setText(clientes.get(instalacao).getVencimento());
    //        contaMesField.setText(clientes.get(instalacao).getContaMes());
    //       consumoField.setText(clientes.get(instalacao).getConsumo());
    //        tarifaField.setText(clientes.get(instalacao).getTarifa());
    //        pisField.setText(clientes.get(instalacao).getPis());
    //        cofinsField.setText(clientes.get(instalacao).getCofins());
    //        icmsField.setText(clientes.get(instalacao).getIcms());
    //        totalPagarField.setText(clientes.get(instalacao).getTotalPagar());
    //    }        
    //}
    
    //public double checarTotal() {
    //    
    //    double tarifa = Double.valueOf(tarifaField.getText());
    //    double pis = Double.valueOf(pisField.getText());
    //    double cofins = Double.valueOf(cofinsField.getText());
    //    double icms = Double.valueOf(icmsField.getText());
    //    double total = Double.valueOf(totalPagarField.getText());
    //    double quantidade = Double.valueOf(consumoField.getText());
    //    
    //    double totalReal = (total*pis/100) + (total*cofins/100) + (total*icms/100) + (quantidade*tarifa);
    //    
    //   totalReal = Math.round(totalReal*100) / 100.0;
    //    
    //    return totalReal;
    //    
    //}
    
    
    public int checarDados(ContaLuz dados) {
        
        int count = 0;
        
        if(dados.getInstalacao().equals("")) {
            return ++count;
        } else if(dados.getNomeCliente().equals("")) {
            return ++count;
        } else if(dados.getVencimento().equals("")) {
            return ++count;
        } else if(dados.getContaMes().equals("")) {
            return ++count;
        } else if(dados.getConsumo().equals("")) {
            return ++count;
        } else if(dados.getTarifa().equals("")) {
            return ++count;
        } else if(dados.getPis().equals("")) {
            return ++count;
        } else if(dados.getCofins().equals("")) {
            return ++count;
        } else if(dados.getIcms().equals("")) {
            return ++count;
        } else if(dados.getTotalPagar().equals("")) {
            return ++count;
        } else {
            return count;
        }
    }
    
    
    public void SalvarDados() throws IOException {
        
        try (FileWriter myWriter = new FileWriter("contaLuzDataBase.txt")) {
            for (String key: this.clientes.keySet()) {
                
                myWriter.write(this.clientes.get(key).toString());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "NÃ£o foi possÃ­vel criar arquivo");
        }
    }
    
    
    public void limparDados(){
        
        instalacaoField.setText("");
        nomeClienteField.setText("");
        vencimentoField.setText("");
        contaMesField.setText("");
        consumoField.setText("");
        tarifaField.setText("");
        pisField.setText("");
        cofinsField.setText("");
        icmsField.setText("");
        totalPagarField.setText("");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLuz().setVisible(true);
            }
        });
    }
    
    
    
	public void search() throws SQLException {
			
	    	Connection conexao = FabricaConexao.getConexao();
	    	
	    	// Atribuindo oque foi digitado no textField a variavel x
	    	String x = instalacaoField.getText();
	    	
	    	// Pesquisando no BD oque foi digitado no textField
			String sql = "SELECT * FROM conta_luz WHERE instalacao='"+ x + "'";
			
			Statement stmt = conexao.createStatement();
			
			// ESTA SENDO ATRIBUIDO A VARIAVEL RESULTADO O RETORNO DA VARIAVEL SQL COM A CONSULTA DO BANCO
			ResultSet resultado = stmt.executeQuery(sql);
			
			resultado.next();
			
			// Setando o retorno do BD nos textField
			instalacaoField.setText(resultado.getString("instalacao"));
			nomeClienteField.setText(resultado.getString("nomeCliente"));
			vencimentoField.setText(resultado.getString("vencimento"));
			contaMesField.setText(resultado.getString("contaMes"));
			consumoField.setText(resultado.getString("consumo"));
			tarifaField.setText(resultado.getString("tarifa"));
			pisField.setText(resultado.getString("pis"));
			cofinsField.setText(resultado.getString("confins"));
			icmsField.setText(resultado.getString("icms"));
			totalPagarField.setText(resultado.getString("totalPagar"));
			
			System.out.println("Dados buscados com sucesso");
			
			conexao.close();
		}
    
    
	public void update() throws SQLException {
	    	
	    	Connection conexao = FabricaConexao.getConexao();
	    	
	    	// Atribuindo oque foi digitado no textField a variavel x
	    	String x = instalacaoField.getText();
			
	    	// String SQL
			String updateSQL = "UPDATE conta_luz SET nomeCliente = ?, vencimento = ?, contaMes = ?, consumo = ?, tarifa = ?, "
					+ "pis = ?, confins = ?, icms = ?, totalPagar = ? WHERE instalacao='"+ x + "'";
			
			// Recebendo o updateSQL
			PreparedStatement stmt = conexao.prepareStatement(updateSQL);		
			
			// Setando no banco
			stmt.setString(1, nomeClienteField.getText());
			stmt.setString(2, vencimentoField.getText());
			stmt.setString(3, contaMesField.getText());
			stmt.setString(4, consumoField.getText());
			stmt.setString(5, tarifaField.getText());
			stmt.setString(6, pisField.getText());
			stmt.setString(7, cofinsField.getText());
			stmt.setString(8, icmsField.getText());
			stmt.setString(9, totalPagarField.getText());
			
			stmt.executeUpdate();
			
			System.out.println("Dados atualizados com sucesso");
			
			// Fechando conexoes
			stmt.close();
			conexao.close();
	    }
    
    
	
	
	public void delete() throws SQLException {
	    	
	    	Connection conexao = FabricaConexao.getConexao();
	    	
	    	// Atribuindo oque foi digitado no textField a variavel x
	    	String x = instalacaoField.getText();
	    	
	    	String deleteSQL = "DELETE FROM conta_luz WHERE instalacao='"+ x + "'";
	    	
	    	PreparedStatement stmt = conexao.prepareStatement(deleteSQL);
	    	
	    	stmt.execute();
	    	
	    	instalacaoField.setText("");
			nomeClienteField.setText("");
			vencimentoField.setText("");
			contaMesField.setText("");
			consumoField.setText("");
			tarifaField.setText("");
			pisField.setText("");
			cofinsField.setText("");
			icmsField.setText("");
			totalPagarField.setText("");
			
			System.out.println("Dados excluidos com sucesso");
	
	    	
	    	conexao.close(); 	
	    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton arquivoButton;
    private javax.swing.JTextField cofinsField;
    private javax.swing.JTextField consumoField;
    private javax.swing.JTextField contaMesField;
    private javax.swing.JTextField icmsField;
    private javax.swing.JTextField instalacaoField;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton limparButton;
    private javax.swing.JTextField nomeClienteField;
    private javax.swing.JTextField pisField;
    private javax.swing.JButton procurarButton;
    private javax.swing.JButton salvarButton;
    private javax.swing.JTextField tarifaField;
    private javax.swing.JTextField totalPagarField;
    private javax.swing.JTextField vencimentoField;
    // End of variables declaration//GEN-END:variables
    private HashMap<String, ContaLuz> clientes;
    private ArrayList<ContaLuz> historico;
    private JButton btnAtualizar;
    private JButton btnExcluir;
    
}
