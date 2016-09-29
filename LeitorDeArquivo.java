
/**
 * Universidade Federal Rural de Pernambuco
 *
 * @author Paulo Mateus <paulomatew@gmail.com>
 * Classe par aleitura de Arquivos.
 *
 */
import java.io.FileInputStream;

public class LeitorDeArquivo {

    /**
     * Carrego arquivo e o retorno é um vetor de INTEIRO. Cada linha do arquivo
     * será uma posição no vetor.
     *
     * @param arquivo
     * @return
     */
    private static int[] carregarArquivoRetornaInt(String arquivo) {
        int[] resp = null;
        try {
            FileInputStream fin = new FileInputStream(arquivo);
            byte[] a = new byte[fin.available()];
            fin.read(a);
            fin.close();
            String[] linhas = new String(a).split("\n");
            resp = new int[linhas.length - 1];
            //Caso queira pular alguma linha inicialmente, alterar valor de i.
            for (int i = 0; i < linhas.length; i++) {
                resp[i - 1] = Integer.parseInt(linhas[i].trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    /**
     * Carrego arquivo e o retorno é um vetor de STRING. Cada linha no arquivo
     * será uma posição no vetor.
     *
     * @param arquivo
     * @return
     */
    private static String[] carregarArquivoRetornaString(String arquivo) {
        String[] linhas = null;
        try {
            FileInputStream fin = new FileInputStream(arquivo);
            byte[] a = new byte[fin.available()];
            fin.read(a);
            fin.close();
            linhas = new String(a).split("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linhas;
    }

    public static void main(String[] args) {
    }

}
