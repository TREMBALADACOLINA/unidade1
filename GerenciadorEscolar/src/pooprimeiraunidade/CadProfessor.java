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

public class CadProfessor extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8489989942949331565L;
	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfMatricula;
	private static Gerente geren = new Gerente();
	private static TelaInicial tl = new TelaInicial();
	private Gravador gra;

	public CadProfessor() {
		
		gra = new Gravador();
		setResizable(false);
		setIconImage(Icons.LOGO_UFPB.getImage());
		setTitle("Cadastrar Professor");
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
				setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(29, 98, 61, 16);
		contentPane.add(lblNome);

		tfNome = new JTextField();
		tfNome.setBounds(102, 92, 300, 28);
		contentPane.add(tfNome);
		tfNome.setColumns(10);

		JLabel lblMatrcula = new JLabel("Matrícula:");
		lblMatrcula.setBounds(29, 144, 73, 16);
		contentPane.add(lblMatrcula);

		tfMatricula = new JTextField();
		tfMatricula.setBounds(102, 138, 300, 28);
		contentPane.add(tfMatricula);
		tfMatricula.setColumns(10);

		JLabel lblCadastroDeProfessores = new JLabel("Cadastro de Professores");
		lblCadastroDeProfessores.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblCadastroDeProfessores.setBounds(110, 26, 165, 16);
		contentPane.add(lblCadastroDeProfessores);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nome = tfNome.getText();
				String matricula = tfMatricula.getText();
				
				
				if (nome.equals("") || matricula.equals("")) {
					JOptionPane.showMessageDialog(null, "informe seus dados!");
				} else {
					Professor b = new Professor(matricula,nome);
					geren.cadastrarProfessor(b);
					try {
						gra.gravar(b.getNome(), b.toString());
					} catch (IOException e1) {

						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso!");
					tfNome.setText("");
					tfMatricula.setText("");
				}
			}
		});
		
		
		btnCadastrar.setFocusPainted(false);
		btnCadastrar.setContentAreaFilled(false);
		btnCadastrar.setBackground(Color.blue);
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setOpaque(true);

		

		btnCadastrar.setBounds(80, 200, 126, 30);
		contentPane.add(btnCadastrar);

		JButton btnVoltarAoMenu = new JButton("Voltar");
		
		btnVoltarAoMenu.setFocusPainted(false);
		btnVoltarAoMenu.setContentAreaFilled(false);
		btnVoltarAoMenu.setBackground(Color.red);
		btnVoltarAoMenu.setForeground(Color.WHITE);
		btnVoltarAoMenu.setOpaque(true);
		btnVoltarAoMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				tl.setVisible(true);
				dispose();
			}
		});
		btnVoltarAoMenu.setBounds(230, 200, 126, 30);
		contentPane.add(btnVoltarAoMenu);
	}

}
