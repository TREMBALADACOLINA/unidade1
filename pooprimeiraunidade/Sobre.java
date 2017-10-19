package pooprimeiraunidade;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sobre extends JFrame {

	private JPanel contentPane;


	public Sobre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon fotoC = new ImageIcon("/Users/Xande/Documents/workspace/Unidade1/ufpb.png");
		
		JLabel lblNewLabel = new JLabel(fotoC);
		lblNewLabel.setBounds(139, 17, 137, 166);
		contentPane.add(lblNewLabel);
		
		JLabel lblUniversidadeFederalDa = new JLabel("Universidade Federal da Paraíba");
		lblUniversidadeFederalDa.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblUniversidadeFederalDa.setBounds(95, 212, 311, 16);
		contentPane.add(lblUniversidadeFederalDa);
		
		JLabel lblDisciplinaProgramaoOrientado = new JLabel("Disciplina: Programação Orientado a Objetos");
		lblDisciplinaProgramaoOrientado.setBounds(62, 258, 318, 16);
		contentPane.add(lblDisciplinaProgramaoOrientado);
		
		JLabel lblDesenvolvedoresAlexandreDe = new JLabel("Desenvolvedores: Alexandre de Santana, Kyn Kannato");
		lblDesenvolvedoresAlexandreDe.setBounds(32, 318, 359, 16);
		contentPane.add(lblDesenvolvedoresAlexandreDe);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial v = new TelaInicial();
				v.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(175, 382, 74, 29);
		contentPane.add(btnVoltar);
	}
}
