package br.com.pe.urbana.vemnotifier.entidades;

import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import br.com.pe.urbana.vemnotifier.utils.Utils;

/**
 * 
 * @author Paulo Mateus
 * @place Urbana - PE
 * @email paulo.silva@urbana-pe.com.br
 * @date 12/03/2018
 *
 */
public class Mensagem {
	public String title;
	public String msg;
	public ActionListener action = null;

	public Mensagem() {

	}

	public Mensagem(String titulo, String msg) {
		this.title = titulo;
		this.msg = msg;
	}

	public Mensagem(String titulo, String msg, ActionListener action) {
		this.title = titulo;
		this.msg = msg;
		this.action = action;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		String newLine = System.getProperty("line.separator");

		//result.append( this.getClass().getName() );
		//result.append( " Mensagem {" );
		result.append(newLine);

		Field[] fields = this.getClass().getDeclaredFields();

		for ( Field field : fields  ) {
			try {
				result.append( Utils.capitalizeFirstLetter(field.getName()));
				result.append(": ");
				result.append( field.get(this) );
			} catch ( IllegalAccessException ex ) {
				ex.getStackTrace();
			}
			result.append(newLine);
		}
		//result.append("}");

		return result.toString().trim();
	}
}
