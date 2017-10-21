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

public class CadDisciplina extends JDialog	 {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2029219826210335416L;
	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfCodigo;
	private JTextField tfArea;
	private static Gerente gr = new Gerente();
	private static TelaInicial alex = new TelaInicial();

	public CadDisciplina() {
		setResizable(false);
		setIconImage(Icons.LOGO_UFPB.getImage());
		setTitle("Cadastrar Disciplina");
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.white);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(30, 100, 61, 16);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Código:");
		lblNewLabel_1.setBounds(30, 140, 61, 16);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Área:");
		lblNewLabel_2.setBounds(30, 180, 61, 16);
		contentPane.add(lblNewLabel_2);

		tfNome = new JTextField();
		tfNome.setBounds(80, 95, 340, 28);
		contentPane.add(tfNome);
		tfNome.setColumns(10);

		tfCodigo = new JTextField();
		tfCodigo.setBounds(80, 135, 340, 28);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);

		tfArea = new JTextField();
		tfArea.setBounds(80, 175, 340, 28);
		contentPane.add(tfArea);
		tfArea.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Cadastrar Disciplinas");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_3.setBounds(135, 45, 158, 16);
		contentPane.add(lblNewLabel_3);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nome = tfNome.getText();
				String codigo = tfCodigo.getText();
				String area = tfArea.getText();
				if (nome.equals("") || codigo.equals("") || area.equals("")) {
					JOptionPane.showMessageDialog(null, "Informe dados válidos!");
				} else {
					Disciplina dc = new Disciplina(codigo, nome, area);
					gr.cadastrarDisciplina(dc);
					JOptionPane.showMessageDialog(null, "Disciplina cadastrada com sucesso!");
					tfNome.setText("");
					tfCodigo.setText("");
					tfArea.setText("");
				}

			}
		});
		btnNewButton.setBounds(80, 220, 120, 30);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				alex.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(240, 220, 120, 30);
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

	}

}
