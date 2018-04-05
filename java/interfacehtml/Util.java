package com.tronipm.java.interfacehtml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Util {

	public static void escreverEmArquivo(String path, String content, boolean isAppend) {
		FileOutputStream fop = null;
		File file;
		try {
			file = new File(path);
			fop = new FileOutputStream(file, isAppend);
			//Se arquivo não existe, é criado
			if (!file.exists()) {
				file.createNewFile();
			}
			//pega o content em bytes
			byte[] contentInBytes = content.getBytes();
			fop.write(contentInBytes);
			//flush serve para garantir o envio do último lote de bytes
			fop.flush();
			fop.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fop != null) {
					fop.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
