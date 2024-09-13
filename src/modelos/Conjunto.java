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
    private int[] arraySelectionSort;

    public Conjunto(int tamanho) throws Exception {

        if (tamanho <= 0) {
            throw new Exception("O tamanho do vetor não pode ser menor ou igual a zero");
        }
        this.tamanho = tamanho;
        arrayOriginal = new int[tamanho]; //  Cria um novo array de inteiros com o tamanho especificado pelo parâmetro tamanho
        arraySelectionSort = new int[tamanho]; //  Cria um novo array de inteiros com o tamanho especificado pelo parâmetro tamanho

        // Obtém a hora atual do sistema
        LocalTime agora = LocalTime.now();
        // Extrai os segundos
        int segundos = agora.getSecond();
        // Cria um objeto Random usando os segundos como semente
        Random random = new Random(segundos);

        int contador = 0;
        int contadorBusca = 0;

        do {
            // Gera um número aleatório inteiro
            int numeroAleatorio = random.nextInt();

            numeroAleatorio = numeroAleatorio % 1001;

            if (numeroAleatorio < 0) numeroAleatorio = numeroAleatorio * (-1);
           
            arrayOriginal[contador] = numeroAleatorio;

            // Incrementa o contador
            contador++;

        } while (contador < tamanho);

        // Copia arrayOriginal para arraySelectionSort
        arraySelectionSort = arrayOriginal.clone();

    }

    public String obterArray() {

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

   /* 
    public int buscaSequencial(int elemento) {

        for (int pos = 0; pos < arrayOriginal.length; pos++) {
            // O laço é interrompido se o elemento buscado for encontrado
            if (elemento == arrayOriginal[pos]) {
                return pos;
            }
        }

        // Se o elemento não for encontrado em nenhuma posição do array, retorna -1
        return -1;
    }
   */

    public void OrdenarSelectionSort() {
        // O método OrdenarSelectionSort ordena o array arraySelectionSort em ordem crescente usando o algoritmo de Selection Sort

        // Loop para fazer as comparações. Por exemplo, se são 10 posições, serão feitas 9 comparações.
        for (int etapa = 0; etapa < arraySelectionSort.length - 1; etapa++) {

            // Considera que o menor elemento é o de posição zero. Veja que a variável etapa é inciada com zero.
            int menor = etapa;

            // O elemento de posição etapa será comparado com todos os elementos subsequentes, ou seja, etapa + 1 (i)
            for (int i = etapa + 1; i < arraySelectionSort.length; i++) {

                // Verifica se o elemento de posição i (etapa + 1) é menor do que o elemento da posição menor (etapa)
                if (arraySelectionSort[i] < arraySelectionSort[menor]) {

                    // O indíce do menor elemento encontrado é guardado na varíavel menor
                    menor = i;
                }
            }

            // Troca o elemento na posição "etapa" com o menor elemento encontrado
            int temp = arraySelectionSort[etapa]; // Guarda o valor do elemento que irá perder a posição (posição etapa)
            arraySelectionSort[etapa] = arraySelectionSort[menor]; // A posição etapa (zero no primeiro loop) é preenchida com o menor valor
            arraySelectionSort[menor] = temp; // O valor guardado (elemento que perdeu a posição para o menor valor) é colocado no indíce vago (índice do menor)

            // A variável "etapa" e "i" será incrementada e será feita comparação a partir do próximo índice.
        }
    }

    public String obterArrayOrdenado() {

        OrdenarSelectionSort(); // Chama o método para ordenar os elementos

        String valor = "";

        for (int i = 0; i < arraySelectionSort.length; i++) {

            valor += arraySelectionSort[i] + " | "; // Guarda os valores numa String, separando-os por um "|"
        }

        return valor;
    }

    public int buscaSequencialOrdenada(int elemento) {

        for (int pos = 0; pos < arraySelectionSort.length; pos++) {
               
            if (elemento < arraySelectionSort[pos]) return -1;
            if (elemento == arraySelectionSort[pos]) return pos; // O laço é interrompido se o elemento buscado for encontrado
            
        }
        
        return -1; // Se o elemento não for encontrado em nenhuma posição do array, retorna -1
    }

}
