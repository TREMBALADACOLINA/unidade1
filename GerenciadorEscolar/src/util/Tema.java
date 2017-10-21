package util;

import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

public class Tema {

	public static void changeWindows() {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if (info.getName().equals("Windows")) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;

				} else {
					javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
				}

			}

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			JOptionPane.showMessageDialog(null, "Erro ao aplicar o tema.\nErro: " + e.getMessage());
		}

	}

}
