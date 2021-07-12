package br.com.academia.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ImcGui {

	public void desenharTela() {
		
		Color meuAzulEscuro = new Color(0, 32, 64);
		Font fontTitulo = new Font("Consolas", Font.BOLD, 28);
		Font fontResultado = new Font("Consolas", Font.BOLD, 56);
		Font fontStatus = new Font("Consolas", Font.BOLD, 20);
		
		JFrame telaImc = new JFrame();
		telaImc.setSize(450, 330);
		telaImc.setTitle("Calculadora IMC");
		telaImc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaImc.getContentPane().setBackground(meuAzulEscuro);
		telaImc.setLayout(null);
		
		JLabel labelTituloImc = new JLabel();
		labelTituloImc.setBounds(10, 10, 100, 30);
		labelTituloImc.setFont(fontTitulo);
		labelTituloImc.setForeground(Color.white);
		labelTituloImc.setText("IMC");
		
		JLabel labelSubtituloImc = new JLabel();
		labelSubtituloImc.setBounds(10, 30, 200, 30);
		labelSubtituloImc.setText("Índice de Massa Corporal");
		labelSubtituloImc.setForeground(Color.white);
		
		JLabel labelPeso = new JLabel();
		labelPeso.setBounds(10, 80, 200, 30);
		labelPeso.setText("Qual o seu peso?");
		labelPeso.setForeground(Color.yellow);
		
		JTextField textFieldPeso = new JTextField();
		textFieldPeso.setBounds(10, 110, 130, 40);
		textFieldPeso.setHorizontalAlignment(JTextField.RIGHT);
		textFieldPeso.setFont(fontTitulo);
		
		JLabel labelAltura = new JLabel();
		labelAltura.setBounds(10, 150, 200, 30);
		labelAltura.setText("Qual a sua altura?");
		labelAltura.setForeground(Color.yellow);
		
		JTextField textFieldAltura = new JTextField();
		textFieldAltura.setBounds(10, 180, 130, 40);
		textFieldAltura.setHorizontalAlignment(JTextField.RIGHT);
		textFieldAltura.setFont(fontTitulo);
		
		JLabel labelResultado = new JLabel();
		labelResultado.setForeground(Color.WHITE);
		labelResultado.setFont(fontResultado);
		labelResultado.setBounds(180, 110, 200, 60);
		labelResultado.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel labelStatus = new JLabel();
		labelStatus.setFont(fontStatus);
		labelStatus.setForeground(Color.CYAN);
		labelStatus.setBounds(180, 170, 200, 30);
		labelStatus.setHorizontalAlignment(JLabel.CENTER);
		
		JButton buttonCalcular = new JButton();
		buttonCalcular.setText("Calcular IMC");
		buttonCalcular.setBounds(10, 240, 130, 30);
		buttonCalcular.setBackground(Color.GREEN);
		
		telaImc.getContentPane().add(labelTituloImc);
		telaImc.getContentPane().add(labelSubtituloImc);
		telaImc.getContentPane().add(labelPeso);
		telaImc.getContentPane().add(textFieldPeso);
		telaImc.getContentPane().add(labelAltura);
		telaImc.getContentPane().add(textFieldAltura);
		telaImc.getContentPane().add(buttonCalcular);
		telaImc.getContentPane().add(labelResultado);
		telaImc.getContentPane().add(labelStatus);
		
		telaImc.setVisible(true);
		
		// *** Ouvintes de eventos ****
		// LISTENER -> OUVINTE
		buttonCalcular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				double peso = Double.parseDouble(textFieldPeso.getText());
				double altura = Double.parseDouble(textFieldAltura.getText());
				double imc = calcularImc(peso, altura);
				
				labelResultado.setText(String.format("%.1f", imc));
			}
		});
		
		textFieldPeso.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("Code: " + e.getKeyCode());
				System.out.println("Char: " + e.getKeyChar());
				
				if (e.getKeyCode() == 10) {
					textFieldAltura.requestFocus();
				}
				
			}
		});
		
		textFieldAltura.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				int x = textFieldAltura.getX();
				int y = textFieldAltura.getY();
				
				if (e.getKeyCode() == 39) {
					textFieldAltura.setBounds(x + 5, y, 130, 40);
					if (x == telaImc.getWidth()) {
						textFieldAltura.setBounds(-130, y, 130, 40);
					}
				} else if (e.getKeyCode() == 37) {
					textFieldAltura.setBounds(x - 5, y, 130, 40);
				} else if (e.getKeyCode() == 38) {
					textFieldAltura.setBounds(x, y - 5, 130, 40);
				} else if (e.getKeyCode() == 40) {
					textFieldAltura.setBounds(x, y + 5, 130, 40);
				}
				
			}
		});
		
		telaImc.getContentPane().addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				labelResultado.setText(String.valueOf(x) + "," + String.valueOf(y));
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				System.out.println(e.getSource());;
				
			}
		});
		
	} // Fim do método desenhar tela
	
	private double calcularImc(double peso, double altura) {
		return peso / Math.pow(altura, 2);
	}
	
	
} // Fim da classe ImcGui
