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

public class CadTurma extends JFrame {

	private JPanel contentPane;
	private JTextField tfProfessor;
	private JTextField tfDisciplina;
	private JTextField tfCodigo;
	private static Gerente gr = new Gerente();
	private static TelaInicial a = new TelaInicial();

	
	public CadTurma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Professor");
		lblNewLabel.setBounds(30, 94, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Disciplina");
		lblNewLabel_1.setBounds(30, 141, 80, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Código");
		lblNewLabel_2.setBounds(30, 192, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		tfProfessor = new JTextField();
		tfProfessor.setBounds(122, 88, 134, 28);
		contentPane.add(tfProfessor);
		tfProfessor.setColumns(10);
		
		tfDisciplina = new JTextField();
		tfDisciplina.setBounds(122, 135, 134, 28);
		contentPane.add(tfDisciplina);
		tfDisciplina.setColumns(10);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(122, 186, 134, 28);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String professor = tfProfessor.getText();
				String disciplina = tfDisciplina.getText();
				String codigo = tfCodigo.getText();
				try{
				Professor p =  gr.buscaProfessor(professor);
				Disciplina d = gr.buscaDisciplina(disciplina);
				
				if(p==null || d == null || codigo.equals("")){
					JOptionPane.showMessageDialog(null, "Professor ou Disciplina nao localizada, por favor informe dados válidos!");
				}else{
					Turma a = new Turma(codigo, p, d);
					gr.cadastrarTurma(a);
					JOptionPane.showMessageDialog(null, "Turma criada com sucesso!");
					tfProfessor.setText("");
					tfDisciplina.setText("");
					tfCodigo.setText("");
					
				}
				}catch(Exception ee){
					JOptionPane.showMessageDialog(null, ee.getMessage());
				}
				
			}
		});
		btnNewButton.setBounds(280, 89, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar ao menu principal");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setBounds(257, 147, 187, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblCadastrarTurma = new JLabel("Cadastro de Turmas");
		lblCadastrarTurma.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblCadastrarTurma.setBounds(156, 34, 157, 16);
		contentPane.add(lblCadastrarTurma);
	}

}
