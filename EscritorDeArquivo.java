/**
 * Universidade Federal Rural de Pernambuco
 *
 * @author Paulo Mateus <paulomatew@gmail.com>
 * Classe par aleitura de Arquivos.
 *
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class EscritorDeArquivo {

    /**
     * Classe que escreve em arquivo. Parâmetro isAppend é para dizer ao
     * construtor se ele irá adicionar o conteúdo ao final do arquivo, ou
     * sobrescreverá o arquivo. Sobrescrever = false | Para adicionar = true.
     *
     * @param caminho
     * @param content
     * @param isAppend
     */
    public static void escreverEmArquivo(String caminho, String content, boolean isAppend) {
        FileOutputStream fop = null;
        File file;
        try {
            file = new File(caminho);
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
