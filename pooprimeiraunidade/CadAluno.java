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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class CadAluno extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfMatri;
	private JLabel lblEmail;
	private JTextField tfEmail;
	private JLabel lblCadastroDeAlunos;
	private static Gerente geren = new Gerente();

	public CadAluno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(26, 61, 61, 16);
		contentPane.add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setBounds(97, 55, 134, 28);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Matricula:");
		lblNewLabel.setBounds(26, 117, 67, 16);
		contentPane.add(lblNewLabel);
		
		tfMatri = new JTextField();
		tfMatri.setBounds(97, 111, 134, 28);
		contentPane.add(tfMatri);
		tfMatri.setColumns(10);
		
		lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(26, 165, 61, 16);
		contentPane.add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(97, 159, 134, 28);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = tfNome.getText();
				String matricula = tfMatri.getText();
				String email = tfEmail.getText();
				System.out.println(nome);
				if(nome.equals("") || matricula.equals("") || email.equals("")){
					JOptionPane.showMessageDialog(null,"Informe seus dados");
				}else{
				Aluno a = new Aluno(matricula, nome,email);
				geren.cadastrarAluno(a);
				
				tfMatri.setText("");
				tfEmail.setText("");
				tfNome.setText("");
				JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
				}
			}
		});
		btnNewButton.setBounds(285, 73, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar ao menu principal");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial ti = new TelaInicial();
				ti.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setBounds(253, 132, 191, 29);
		contentPane.add(btnNewButton_1);
		
		lblCadastroDeAlunos = new JLabel("Cadastro de alunos");
		lblCadastroDeAlunos.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblCadastroDeAlunos.setBounds(162, 17, 150, 16);
		contentPane.add(lblCadastroDeAlunos);
	}
}
