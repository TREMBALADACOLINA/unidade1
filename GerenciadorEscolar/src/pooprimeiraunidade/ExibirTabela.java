package pooprimeiraunidade;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import util.Icons;

public class ExibirTabela extends JDialog {

	private static final long serialVersionUID = 7315228472458410561L;
	private JPanel contentPane;
	private JScrollPane jScrollPane;
	private JTable jTable;

	public void alunos(List<Aluno> alunos) {
		setTitle("Exibindo Alunos");
		String[] columnName = { "Mat", "Nome", "Email" };
		DefaultTableModel dtm = new DefaultTableModel(columnName, 0);
		for (int i = 0; i < alunos.size(); i++) {
			dtm.addRow(new String[] { (alunos.get(i)).getMatricula(), (alunos.get(i)).getNome(),
					(alunos.get(i)).getEmail() });
			
		}
		jTable.setModel(dtm);

	}

	public void professores(List<Professor> d) {
		setTitle("Exibindo Professores");
		String[] columnName = { "Mat", "Nome" };
		DefaultTableModel dtm = new DefaultTableModel(columnName, 0);
		for (int i = 0; i < d.size(); i++) {
			dtm.addRow(new String[] { d.get(i).getMatricula(), d.get(i).getNome() });
			
		}
		jTable.setModel(dtm);

	}

	public void disciplina(List<Disciplina> d) {
		setTitle("Exibindo Disciplinas");
		String[] columnName = { "Cod", "Nome", "Area" };
		DefaultTableModel dtm = new DefaultTableModel(columnName, 0);
		for (int i = 0; i < d.size(); i++) {
			dtm.addRow(new String[] { d.get(i).getCodigo(), d.get(i).getNome(), d.get(i).getArea() });
		}
		jTable.setModel(dtm);
	}

	public void turma(List<Turma> d) {
		setTitle("Exibindo Turmas");
		String[] columnName = { "Ident", "Discip", "Prof" };
		DefaultTableModel dtm = new DefaultTableModel(columnName, 0);
		for (int i = 0; i < d.size(); i++) {
			dtm.addRow(new String[] { d.get(i).getCodigo(), d.get(i).getDisciplina().getNome(),
					d.get(i).getProfessor().getNome() });
		}
		jTable.setModel(dtm);
		
	}

	public ExibirTabela() {
		setResizable(false);
		setIconImage(Icons.LOGO_UFPB.getImage());
		setTitle("Tabela");
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		jScrollPane = new JScrollPane();
		jScrollPane.setBounds(10, 10, 410, 200);
		jTable = new JTable();
		jScrollPane.setViewportView(jTable);
		contentPane.add(jScrollPane);
		jTable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		jTable.setFont(new Font("Arial", Font.BOLD, 12));
		jTable.setAutoCreateRowSorter(true);		
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaInicial ti = new TelaInicial();
				ti.setVisible(true);
				dispose();

			}
		});
		btnNewButton_1.setBounds(172, 215, 110, 30);
		contentPane.add(btnNewButton_1);

		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBackground(Color.red);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setOpaque(true);

	}
}
