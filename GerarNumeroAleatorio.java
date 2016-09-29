package uri;

import java.util.Random;

public class GerarNumeroAleatorio {

    public static void gerarInt() {
        //instância um objeto da classe Random especificando a semente 
        Random gerador = new Random();
        //imprime sequência de 10 números inteiros aleatórios entre 0 e 25
        for (int i = 0; i < 10; i++) {
            System.out.println(gerador.nextInt(26));
        }
    }

    public static void gerarReal() {
        
        Random gerador = new Random();

        //SEMPRE entre 0 e 1. Podemultiplicar por algum número != 1 e trunco o resultado
        System.out.println(gerador.nextDouble());
        System.out.println(gerador.nextFloat());
    }
    
        public static void gerarBoolean() {
        Random gerador = new Random();

        //SEMPRE entre 0 e 1. Podemultiplicar por algum número != 1, 90, por ex.
        System.out.println(gerador.nextBoolean());
    }

}
