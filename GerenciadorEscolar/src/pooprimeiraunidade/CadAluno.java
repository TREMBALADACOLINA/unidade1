package pooprimeiraunidade;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import util.Icons;

public class CadAluno extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7315228472458410561L;
	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfMatri;
	private JLabel lblEmail;
	private JTextField tfEmail;
	private JLabel lblCadastroDeAlunos;
	private static Gerente geren = new Gerente();
	private Gravador gra;

	public CadAluno() {
		gra = new Gravador();
		setResizable(false);
		setIconImage(Icons.LOGO_UFPB.getImage());
		setTitle("Cadastrar Aluno");
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(26, 60, 61, 16);

		contentPane.add(lblNome);

		tfNome = new JTextField();
		tfNome.setBounds(97, 55, 310, 28);
		contentPane.add(tfNome);
		tfNome.setColumns(10);

		JLabel lblNewLabel = new JLabel("Matricula:");
		lblNewLabel.setBounds(26, 100, 67, 16);
		contentPane.add(lblNewLabel);

		tfMatri = new JTextField();
		tfMatri.setBounds(97, 95, 310, 28);
		contentPane.add(tfMatri);
		tfMatri.setColumns(10);

		lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(26, 140, 61, 16);
		contentPane.add(lblEmail);

		tfEmail = new JTextField();
		tfEmail.setBounds(97, 135, 310, 28);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String nome = tfNome.getText();
				String matricula = tfMatri.getText();
				String email = tfEmail.getText();
				System.out.println(nome);
				if (nome.equals("") || matricula.equals("") || email.equals("")) {
					JOptionPane.showMessageDialog(null, "Informe seus dados");
				} else {
					Aluno a = new Aluno(matricula, nome, email);
					geren.cadastrarAluno(a);
					
					try {
						gra.gravar(a.getNome(), a.toString());

					} catch (IOException e1) {

						e1.printStackTrace();
					}

					tfMatri.setText("");
					tfEmail.setText("");
					tfNome.setText("");
					JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
				}
			}
		});
		btnNewButton.setBounds(95, 210, 110, 30);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaInicial ti = new TelaInicial();
				ti.setVisible(true);
				dispose();

			}
		});
		btnNewButton_1.setBounds(230, 210, 110, 30);
		contentPane.add(btnNewButton_1);

		btnNewButton.setFocusPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBackground(Color.blue);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setOpaque(true);

		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBackground(Color.red);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setOpaque(true);

		lblCadastroDeAlunos = new JLabel("Cadastro de alunos");
		lblCadastroDeAlunos.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblCadastroDeAlunos.setBounds(162, 17, 150, 16);
		contentPane.add(lblCadastroDeAlunos);
	}
}
