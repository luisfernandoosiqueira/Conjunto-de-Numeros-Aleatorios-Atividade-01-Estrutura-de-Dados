package modelos;

import java.time.LocalTime;
import java.util.Random;

/**
 *
 * @author Luís Fernando
 */
public class Conjunto {

    private int tamanho;
    private int[] arrayOriginal;

    public Conjunto(int tamanho) throws Exception {

        if (tamanho <= 0) {
            throw new Exception("O tamanho do vetor não pode ser menor ou igual a zero");
        }
        this.tamanho = tamanho;
        arrayOriginal = new int[tamanho];

        // Obtém a hora atual do sistema
        LocalTime agora = LocalTime.now();
        // Extrai os segundos
        int segundos = agora.getSecond();
        // Cria um objeto Random usando os segundos como semente
        Random random = new Random(segundos);
        int contador = 0;

        do {
            // Gera um número aleatório inteiro
            int numeroAleatorio = random.nextInt();

            numeroAleatorio = numeroAleatorio % 1001;

            if (numeroAleatorio < 0) {
                numeroAleatorio = numeroAleatorio * (-1);
            }

            arrayOriginal[contador] = numeroAleatorio;

            // Incrementa o contador
            contador++;
        } while (contador < tamanho);
        
    }  
       

    public String obterArray() {
        int contador = 0;
        String valor = "";

        for (int i = 0; i < arrayOriginal.length; i++) {

          valor += arrayOriginal[i] + " | ";
            
        /* contador++;

        // Verifica se já foram impressos 20 números na linha atual
        if (contador == 20) {
            valor += "\n"; // Adiciona uma nova linha
            contador = 0;   // Reseta o contador para a próxima linha
        } 
                   
        */
        
        }

        return valor;

    }

}


