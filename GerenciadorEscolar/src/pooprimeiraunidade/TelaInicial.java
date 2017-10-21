package pooprimeiraunidade;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import util.Icons;

public class TelaInicial extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7970120193865225576L;
	private JPanel contentPane;
	TelaInicial frame;
	private static Gerente g = new Gerente();

	public TelaInicial() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 327);
		setLocationRelativeTo(null);
		setIconImage(Icons.LOGO_UFPB.getImage());
		contentPane = new JPanel();
		contentPane.setBackground(Color.white);
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Sistema de Gerenciamento Escolar");
		setResizable(false);
		contentPane.setLayout(null);
		ImageIcon fotoC = Icons.LOGO_SYS;
		JLabel lblNewLabel = new JLabel(fotoC);
		lblNewLabel.setBounds(91, 93, 344, 167);
		contentPane.add(lblNewLabel);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(6, 6, 498, 22);
		contentPane.add(menuBar);

		JMenu mnCad = new JMenu("Cadastrar");
		menuBar.add(mnCad);

		JMenuItem mntmPpppp = new JMenuItem("Aluno");
		mntmPpppp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CadAluno alunocd = new CadAluno();
				alunocd.setVisible(true);
				dispose();
			}
		});
		mnCad.add(mntmPpppp);

		JMenuItem mntmProfessor = new JMenuItem("Professor");
		mntmProfessor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				CadProfessor a = new CadProfessor();
				a.setVisible(true);
				dispose();

			}
		});
		mnCad.add(mntmProfessor);

		JMenuItem mntmTurma = new JMenuItem("Turma");
		mntmTurma.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CadTurma a = new CadTurma();
				a.setVisible(true);
				dispose();
			}
		});
		mnCad.add(mntmTurma);

		JMenuItem mntmDisciplina = new JMenuItem("Disciplina");
		mntmDisciplina.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CadDisciplina alex = new CadDisciplina();
				alex.setVisible(true);
				dispose();
			}
		});
		mnCad.add(mntmDisciplina);

		JMenu mnNewMenu = new JMenu("Pesquisar");
		menuBar.add(mnNewMenu);

		JMenuItem mntmPorAluno = new JMenuItem("Por Aluno");
		mntmPorAluno.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String m = JOptionPane.showInputDialog("Informe o nome da matricula do aluno:");
				try {
					Aluno a = g.buscaAluno(m);
					JOptionPane.showMessageDialog(null, a.toString());
				} catch (Exception ee) {
					JOptionPane.showMessageDialog(null, ee.getMessage());
				}
			}
		});
		mnNewMenu.add(mntmPorAluno);

		JMenuItem mntmPorProfessor = new JMenuItem("Por Professor");
		mntmPorProfessor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String m = JOptionPane.showInputDialog("Informe a matricula do professor: ");
				try {
					Professor a = g.buscaProfessor(m);
					JOptionPane.showMessageDialog(null, a.toString());
				} catch (Exception ee) {
					JOptionPane.showMessageDialog(null, ee.getMessage());
				}
			}
		});
		mnNewMenu.add(mntmPorProfessor);

		JMenuItem mntmPorDisciplina = new JMenuItem("Por Disciplina");
		mntmPorDisciplina.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String m = JOptionPane.showInputDialog("Informe o código da disciplina: ");
				try {
					Disciplina a = g.buscaDisciplina(m);
					JOptionPane.showMessageDialog(null, a.toString());
				} catch (Exception ee) {
					JOptionPane.showMessageDialog(null, ee.getMessage());
				}

			}
		});
		mnNewMenu.add(mntmPorDisciplina);

		JMenu menuListar = new JMenu("Listar");
		menuBar.add(menuListar);
		JMenuItem listarAluno = new JMenuItem("Alunos");
		listarAluno.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				ExibirTabela exibirTabela = new ExibirTabela();
				exibirTabela.alunos(Gerente.getAlunos());
				exibirTabela.setVisible(true);
			}
		});
		menuListar.add(listarAluno);

		JMenuItem listarProfessores = new JMenuItem("Professor");
		listarProfessores.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				ExibirTabela exibirTabela = new ExibirTabela();
				exibirTabela.professores(Gerente.getProfessores());
				exibirTabela.setVisible(true);
			}
		});
		menuListar.add(listarProfessores);
		
		JMenuItem listarTurmas = new JMenuItem("Turmas");
		listarTurmas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				ExibirTabela exibirTabela = new ExibirTabela();
				exibirTabela.turma(Gerente.getTurmas());
				exibirTabela.setVisible(true);
			}
		});
		menuListar.add(listarTurmas);
		
		
		JMenuItem listarDisciplinas = new JMenuItem("Disciplinas");
		listarDisciplinas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				ExibirTabela exibirTabela = new ExibirTabela();
				exibirTabela.disciplina(Gerente.getDisciplinas());
				exibirTabela.setVisible(true);
				
			}
		});
		menuListar.add(listarDisciplinas);
		JMenu mnSobre = new JMenu("Sobre");

		mnSobre.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				new Sobre().setVisible(true);
				dispose();

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});

		menuBar.add(mnSobre);

		JMenu mntmSair = new JMenu("Sair");
		mntmSair.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				if(JOptionPane.showConfirmDialog(null,"Deseja realmente encerrar o programa?","Encerrar Sistema",0)== JOptionPane.YES_OPTION){
					System.exit(0);
				}
				
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		menuBar.add(mntmSair);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { lblNewLabel }));
	}
}
