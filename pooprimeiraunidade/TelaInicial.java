package pooprimeiraunidade;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame {

	private JPanel contentPane;
	TelaInicial frame; 
	private static Gerente g = new Gerente();

	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/


	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds (100, 100, 513, 327);
		
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		ImageIcon fotoC = new ImageIcon("/Users/Xande/Documents/workspace/Unidade1/images.png");
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
			public void actionPerformed(ActionEvent e) {
				CadAluno alunocd = new CadAluno();
				alunocd.setVisible(true);
				dispose();
			}
		});
		mnCad.add(mntmPpppp);
		
		JMenuItem mntmProfessor = new JMenuItem("Professor");
		mntmProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CadProfessor a = new CadProfessor();
				a.setVisible(true);
				dispose();
				
				
			}
		});
		mnCad.add(mntmProfessor);
		
		JMenuItem mntmTurma = new JMenuItem("Turma");
		mntmTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadTurma a = new CadTurma();
				a.setVisible(true);
				dispose();
			}
		});
		mnCad.add(mntmTurma);
		
		JMenuItem mntmDisciplina = new JMenuItem("Disciplina");
		mntmDisciplina.addActionListener(new ActionListener() {
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
			public void actionPerformed(ActionEvent e) {
				String m = JOptionPane.showInputDialog("Informe o nome da matricula do aluno:");
				try{
				Aluno a = g.buscaAluno(m);
				JOptionPane.showMessageDialog(null, a.toString());
				}catch(Exception ee){
					JOptionPane.showMessageDialog(null, ee.getMessage());
				}
			}
		});
		mnNewMenu.add(mntmPorAluno);
		
		JMenuItem mntmPorProfessor = new JMenuItem("Por Professor");
		mntmPorProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String m = JOptionPane.showInputDialog("Informe a matricula do professor: ");
				try{
				Professor a = g.buscaProfessor(m);
				JOptionPane.showMessageDialog(null, a.toString());
				}catch(Exception ee){
					JOptionPane.showMessageDialog(null, ee.getMessage());
				}
			}
		});
		mnNewMenu.add(mntmPorProfessor);
		
		JMenuItem mntmPorDisciplina = new JMenuItem("Por Disciplina");
		mntmPorDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String m = JOptionPane.showInputDialog("Informe o código da disciplina: ");
				try{
				Disciplina a = g.buscaDisciplina(m);
				JOptionPane.showMessageDialog(null, a.toString());
				}catch(Exception ee){
					JOptionPane.showMessageDialog(null, ee.getMessage());
				}
				
			}
		});
		mnNewMenu.add(mntmPorDisciplina);
		
		JMenu mnSobre = new JMenu("Sobre");
		menuBar.add(mnSobre);
		
		JMenuItem mntmSistemaSecretrio = new JMenuItem("Desenvolvedores");
		mntmSistemaSecretrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre v = new Sobre();
				v.setVisible(true);
				dispose();
			}
		});
		mnSobre.add(mntmSistemaSecretrio);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		menuBar.add(mntmSair);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNewLabel}));
	}
}
