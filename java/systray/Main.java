package br.com.pe.urbana.vemnotifier.watcher;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

import br.com.pe.urbana.vemnotifier.core.Crawler;
import br.com.pe.urbana.vemnotifier.entidades.Chamado;
import br.com.pe.urbana.vemnotifier.entidades.Mensagem;
import br.com.pe.urbana.vemnotifier.utils.Utils;

/**
 * 
 * @author Paulo Mateus
 * @place Urbana - PE
 * @email paulo.silva@urbana-pe.com.br
 * @date 12/03/2018
 *
 */
public class Main extends JFrame {

	public static TrayIcon trayIcon;
	public static SystemTray tray;
	public static MensagemWatcher mw = new MensagemWatcher();

	private boolean automaticPrinting = true;
	public MenuItem print = null;

	private String imgPath = "img/icone2.png";


	public Main() {
		hideToSystemTray();

		try {
			tray.add(trayIcon);
		} catch (AWTException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
		setVisible(false);
		mw.add(new Mensagem(Utils.appName, " Iniciando..."));

		startListner();

		try {
			mw.start();
		}catch(Exception e) {

		}
	}

	public void hideToSystemTray() {
		if (SystemTray.isSupported()) {
			tray = SystemTray.getSystemTray();

			Image image = Toolkit.getDefaultToolkit().getImage(imgPath);
			ActionListener exitListener = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			};

			PopupMenu popup = new PopupMenu();
			MenuItem defaultItem = new MenuItem("Abrir configurações");
			defaultItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
							if ("Windows".equals(info.getName())) {
								javax.swing.UIManager.setLookAndFeel(info.getClassName());
								break;
							}
						}
					} catch (ClassNotFoundException ex) {
						java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
					} catch (InstantiationException ex) {
						java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
					} catch (IllegalAccessException ex) {
						java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
					} catch (javax.swing.UnsupportedLookAndFeelException ex) {
						java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
					}
					//</editor-fold>

					/* Create and display the form */
					java.awt.EventQueue.invokeLater(new Runnable() {
						public void run() {
							//do stuff here
						}
					});
				}
			});
			popup.add(defaultItem);
			print = new MenuItem("PARAR atualizações");
			print.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//do stuff
				}
			});
			popup.add(print);
			popup.addSeparator();

			defaultItem = new MenuItem("Fechar");
			defaultItem.addActionListener(exitListener);
			popup.add(defaultItem);

			trayIcon = new TrayIcon(image, Utils.appName, popup);
			trayIcon.setImageAutoSize(true);
		} else {
		}
		addWindowStateListener(new WindowStateListener() {
			public void windowStateChanged(WindowEvent e) {
				if (e.getNewState() == ICONIFIED) {
					try {
						tray.add(trayIcon);
						setVisible(false);
					} catch (AWTException ex) {
					}
				}
				if (e.getNewState() == 7) {
					try {
						tray.add(trayIcon);
						setVisible(false);
					} catch (AWTException ex) {
					}
				}
				if (e.getNewState() == MAXIMIZED_BOTH) {
					tray.remove(trayIcon);
					setVisible(true);
				}
				if (e.getNewState() == NORMAL) {
					tray.remove(trayIcon);
					setVisible(true);
				}
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(imgPath));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void sendMessage(Mensagem msg) {
		if(msg.action == null) {
			trayIcon.displayMessage(msg.title, msg.msg, TrayIcon.MessageType.INFO);
			try {
				ActionListener[] actions = trayIcon.getActionListeners();
				for(ActionListener in: actions) {
					trayIcon.removeActionListener(in);
				}
			} catch(Exception e) {}
		} else {
			trayIcon.addActionListener(msg.action);
			trayIcon.displayMessage(msg.title, msg.msg + "\n\nClique aqui para realizar ação.", TrayIcon.MessageType.INFO);
		}		
	}

	public static void main(String[] args) {
		Utils.escreverEmArquivo("log.txt", "", false);
		new Main();
	}
}
