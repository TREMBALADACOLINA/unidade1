package pooprimeiraunidade;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadProfessor extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfMatricula;
	private static Gerente geren = new Gerente();
	private static TelaInicial tl = new TelaInicial();

	
	public CadProfessor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(29, 98, 61, 16);
		contentPane.add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setBounds(102, 92, 134, 28);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblMatrcula = new JLabel("Matrícula");
		lblMatrcula.setBounds(29, 144, 73, 16);
		contentPane.add(lblMatrcula);
		
		tfMatricula = new JTextField();
		tfMatricula.setBounds(102, 138, 134, 28);
		contentPane.add(tfMatricula);
		tfMatricula.setColumns(10);
		
		JLabel lblCadastroDeProfessores = new JLabel("Cadastro de Professores");
		lblCadastroDeProfessores.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblCadastroDeProfessores.setBounds(110, 26, 165, 16);
		contentPane.add(lblCadastroDeProfessores);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = tfNome.getText();
				String matricula = tfMatricula.getText();
				Professor a = new Professor(matricula, nome);
				geren.cadastrarProfessor(a);
				tfNome.setText("");
				tfMatricula.setText("");
				if(nome.equals("") || matricula.equals("")){
					JOptionPane.showMessageDialog(null,"informe seus dados!");
				}else{
					Professor b = new Professor(nome, matricula);
					geren.cadastrarProfessor(b);
					JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso!");
				
				}
			}
			});
		btnCadastrar.setBounds(280, 93, 126, 29);
		contentPane.add(btnCadastrar);
		
		JButton btnVoltarAoMenu = new JButton("Voltar ao menu principal");
		btnVoltarAoMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tl.setVisible(true);
				dispose();
			}
		});
		btnVoltarAoMenu.setBounds(258, 131, 186, 29);
		contentPane.add(btnVoltarAoMenu);
	}

}
