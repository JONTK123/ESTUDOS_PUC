
public class Application {
    public static void main(String[] args) {
        // // Criando o objeto Scanner
        // Scanner input = new Scanner(System.in);

        // // Exemplo de entrada de dados e print de uma string
        // System.out.println("Digite um nome: ");
        // String nome = input.nextLine();
        // System.out.println("Nome inserido: " + nome);

        // // Loop do-while que continua até que o número 5 seja inserido
        // int value = 0;
        // do {
        //     System.out.println("Digite um numero: ");
        //     value = input.nextInt();
        // } while (value != 5);

        // System.out.println("Fim do programa");

        // // Exemplo de uso do switch-case
        // System.out.println("Digite um numero para o switch-case: ");
        // int numero = input.nextInt();

        // switch (numero) {
        //     case 1:
        //         System.out.println("Você digitou o número 1");
        //         break;
        //     case 2:
        //         System.out.println("Você digitou o número 2");
        //         break;
        //     case 3:
        //         System.out.println("Você digitou o número 3");
        //         break;
        //     default:
        //         System.out.println("Número não reconhecido");
        //         break;
        // }

        //Inicializa um array de inteiros
        int[] values;

        //Inicializa um array de inteiros com 3 posições
        values = new int[3];

        values[0] = 10;
        values[1] = 20;
        values[2] = 30;

        System.out.println(values[0]);
        System.out.println(values[1]);
        System.out.println(values[2]);

        for(int i=0; i<values.length; i++) {
            System.out.println(values[i]);
        }

        int[] numbers = {5,6,7};

        for(int i=0; i<numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        //Inicializa array com 3 valores na lista, mas sem posições
        int[] numbers2 = {5,6,7};
        //Inicializa array com 3 posições, mas sem valores
        int[] numbers3 = new int[3];
        numbers3[0] = 5;
        numbers3[1] = 6;

        String[] nomes = new String[3];
        nomes[0] = "Pedro";
        nomes[1] = "João";

        System.out.println(nomes);

        int[] values5 = {3,5,2453};
        System.out.println(values5[2]);

        int[][] grid = {
            {3,5,2342},
            {2,4},
        };

        System.out.println(grid[0][2]);
        System.out.println(grid[1][0]);

        String[][] texts = new Strings[2][3];
        texts[0][1] = "Hello there";
    }
    
}
