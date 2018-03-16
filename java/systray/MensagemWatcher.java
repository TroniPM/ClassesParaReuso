package br.com.pe.urbana.vemnotifier.core;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.pe.urbana.vemnotifier.entidades.Mensagem;
import br.com.pe.urbana.vemnotifier.gui.Main;
import br.com.pe.urbana.vemnotifier.utils.Utils;


/**
 * Essa classe existe para fazer um timer ao tentar enviar notificações para a tela.
 * Não existe uma pilha de notificações, então se vc enviar em um curto espaço de tempo,
 * Todas serão plotadas, então só a ultima ficará aparecendo. Essa classe tem a finalidade de 
 * criar uma fila de mensagens
 * 
 * @author Paulo Mateus
 * @place Urbana - PE
 * @email paulo.silva@urbana-pe.com.br
 * @date 12/03/2018
 *
 */
public class MensagemWatcher extends Thread {
	private static ArrayList<Mensagem> mensagens = null;
	private final String TAG = MensagemWatcher.class.getName();
	private final static int tempoDeEspera = 5;//in seconds

	private static boolean running = true;

	public MensagemWatcher() {
		mensagens = new ArrayList<>();
	}

	public void parar() {
		running = false;
		try{
			this.interrupt();
			this.stop();
		} catch(Exception e) {

		}
	}

	public void comecar() {
		this.start();
	}

	@Override
	public void run() {

		while(running) {
			Utils.log(TAG, "Procurando por mensagens...");
			//Verificar se tem mensagens
			Mensagem msg = get();
			if(msg!=null) {
				Utils.log(TAG, ">>> Mensagem encontrada. Plotando..." + "\n" + msg.toString());
				Main.sendMessage(msg);
			} else {
				Utils.log(TAG, "Nenhuma mensagem encontrada.");
			}

			synchronized (this) {
				try {
					Utils.log(TAG, "Dormindo por " + tempoDeEspera + " segundos...");
					wait(tempoDeEspera * 1000);
				} catch (IllegalMonitorStateException | InterruptedException ex) {
					Logger.getLogger(MensagemWatcher.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}

	public boolean add(Mensagem nova) {
		return mensagens.add(nova);
	}

	private Mensagem get() {
		if(mensagens!=null && mensagens.size()>0) {
			Mensagem rs = mensagens.get(0);
			mensagens.remove(rs);
			return rs;
		}
		return null;
	}
}
