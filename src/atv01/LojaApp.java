package atv01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LojaApp extends JFrame {
    
    public LojaApp() {
        setTitle("MVP Loja - Entrada de Vendas");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        // Campo de entrada para valor da venda
        JTextField campoVenda = new JTextField(10);
        add(new JLabel("Valor da Venda:"));
        add(campoVenda);
        
        // Botão para confirmar o valor
        JButton btnConfirmar = new JButton("Confirmar");
        add(btnConfirmar);
        
        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Obter e validar o valor da venda
                    double valorVenda = Double.parseDouble(campoVenda.getText());
                    
                    if (valorVenda > 500) {
                        // Solicitar o desconto se o valor for maior que 500
                        String descontoStr = JOptionPane.showInputDialog(
                                null, 
                                "Informe o percentual de desconto (%):", 
                                "Desconto",
                                JOptionPane.QUESTION_MESSAGE
                        );
                        
                        // Validar e calcular o desconto
                        double desconto = Double.parseDouble(descontoStr);
                        if (desconto < 0 || desconto > 100) {
                            JOptionPane.showMessageDialog(null, "Percentual de desconto inválido. Informe um valor entre 0 e 100.");
                            return;
                        }
                        // Calcular o valor final com desconto
                        double valorComDesconto = valorVenda - (valorVenda * desconto / 100);
                        JOptionPane.showMessageDialog(null, "Valor Total com Desconto: R$" + valorComDesconto);
                    } else {
                        // Sem desconto para valores até 500
                        JOptionPane.showMessageDialog(null, "Valor Total: R$" + valorVenda);
                    }
                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, informe um valor numérico válido.");
                }
            }
        });
    }
}