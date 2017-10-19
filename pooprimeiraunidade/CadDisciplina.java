package pooprimeiraunidade;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadDisciplina extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfCodigo;
	private JTextField tfArea;
	private static Gerente gr = new Gerente();
	private static TelaInicial alex = new TelaInicial();

	public CadDisciplina() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(27, 105, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Código");
		lblNewLabel_1.setBounds(27, 151, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Área");
		lblNewLabel_2.setBounds(27, 193, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		tfNome = new JTextField();
		tfNome.setBounds(100, 99, 134, 28);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(100, 145, 134, 28);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		tfArea = new JTextField();
		tfArea.setBounds(100, 187, 134, 28);
		contentPane.add(tfArea);
		tfArea.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Cadastrar Disciplinas");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_3.setBounds(135, 45, 158, 16);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = tfNome.getText();
				String codigo = tfCodigo.getText();
				String area = tfArea.getText();
				if(nome.equals("") || codigo.equals("") || area.equals("")){
					JOptionPane.showMessageDialog(null, "Informe dados válidos!");
				}else{
					Disciplina dc = new Disciplina(codigo, nome, area);
					gr.cadastrarDisciplina(dc);
					JOptionPane.showMessageDialog(null, "Disciplina cadastrada com sucesso!");
					tfNome.setText("");
					tfCodigo.setText("");
					tfArea.setText("");
				}
					
			}
		});
		btnNewButton.setBounds(286, 121, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar ao menu principal");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alex.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(255, 188, 178, 29);
		contentPane.add(btnNewButton_1);
	}

}
