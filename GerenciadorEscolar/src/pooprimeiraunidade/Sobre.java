package pooprimeiraunidade;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.Icons;

public class Sobre extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 299339152926340051L;
	private JPanel contentPane;

	public Sobre() {
		setResizable(false);

		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 440, 360);
		contentPane = new JPanel();
		contentPane.setBackground(Color.white);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon fotoC = Icons.LOGO_UFPB;
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Sobre os Desenvolvedores");
		setIconImage(Icons.LOGO_UFPB.getImage());
		JLabel lblNewLabel = new JLabel(fotoC);
		lblNewLabel.setBounds(139, 17, 137, 166);
		contentPane.add(lblNewLabel);

		String text = "<html><center> " + "<b>Universidade Federal da Paraíba<b><p>"
				+ "Disciplina: Programação Orientado a Objetos<p>"
				+ "Desenvolvedores: Alexandre de Santana, Kyn Kannato" + "</center></html>";

		JLabel lblUniversidadeFederalDa = new JLabel(text);

		lblUniversidadeFederalDa.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblUniversidadeFederalDa.setBounds(42, 120, 60, 140);
		lblUniversidadeFederalDa.setSize(400, 200);

		contentPane.add(lblUniversidadeFederalDa);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFocusPainted(false);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setBackground(Color.blue);
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setOpaque(true);
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaInicial v = new TelaInicial();
				v.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(175, 270, 74, 29);
		contentPane.add(btnVoltar);
	}

}
