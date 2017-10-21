package pooprimeiraunidade;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import util.Icons;

public class CadTurma extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6713995835015092414L;
	private JPanel contentPane;
	private JTextField tfProfessor;
	private JTextField tfDisciplina;
	private JTextField tfCodigo;
	private static Gerente gr = new Gerente();
	private static TelaInicial a = new TelaInicial();

	
	public CadTurma() {
		setResizable(false);
		setIconImage(Icons.LOGO_UFPB.getImage());
		setTitle("Cadastrar Turma");
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 330);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Matrícula do Professor:");
		lblNewLabel.setBounds(30, 80, 170, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Matrícula da Disciplina:");
		lblNewLabel_1.setBounds(30, 120, 170, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Identificação da Turma:");
		lblNewLabel_2.setBounds(30, 160, 170, 16);
		contentPane.add(lblNewLabel_2);
		
		tfProfessor = new JTextField();
		tfProfessor.setBounds(170, 75, 235, 30);
		contentPane.add(tfProfessor);
		tfProfessor.setColumns(10);
		
		tfDisciplina = new JTextField();
		tfDisciplina.setBounds(170, 115, 235, 30);
		contentPane.add(tfDisciplina);
		tfDisciplina.setColumns(10);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(170, 155, 235, 30);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String professor = tfProfessor.getText();
				String disciplina = tfDisciplina.getText();
				String codigo = tfCodigo.getText();
				try{
				Professor p =  gr.buscaProfessor(professor);
				Disciplina d = gr.buscaDisciplina(disciplina);
				
				
				if(p.equals("") || d.equals("") || codigo.equals("")){
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
		btnNewButton.setBounds(120, 215, 100, 30);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setOpaque(true);
		
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				a.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setBounds(240, 215, 100, 30);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBackground(Color.red);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setOpaque(true);
		JLabel lblCadastrarTurma = new JLabel("Cadastro de Turmas");
		lblCadastrarTurma.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblCadastrarTurma.setBounds(156, 34, 157, 16);
		contentPane.add(lblCadastrarTurma);
	}

}
