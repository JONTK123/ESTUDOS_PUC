class Alunos { //Se fosse public class, entao seria uma classe de outro arquivo
    private String nome;
    private String nome2;

    private String nome3;

    //Construtor
    public Alunos() {
        this.nome = "Joao";
        this.nome2 = "Maria";
        this.nome3 = "";
    }

    //Constructor
    public Alunos(String nome) {
        this.nome3 = nome;
        this.nome2 = "Maria";
        this.nome = "Joao";
    }

    //Setter
    public void setNome(String nominho) {
        this.nome = nominho; //this.nome se refere ao atributo da classe ORIGINAL
    }

    //Getter -> Encapsulamento
    public String getNome() {
        return nome;
    }

    public String getNome3(){
        return nome3;
    }
    
    //Método de instância
    public void speakNome() {
        System.out.println("Meu nome eh: " + nome);
    }

    //Metodo de instancia com retorno
    public int calculeNota() {
        return 10;
    }

    //Método de classe, nao pode acessar instancias da classe
    public static void speakNome2() {
        System.out.println("Meu nome eh: Pedrinho");
    }
}


public class Treino {

    public static void main(String[] args) { //Static pois é um método de classe e nao de instancia
        Alunos aluno1 = new Alunos();
        aluno1.speakNome();
        int resultado = aluno1.calculeNota();

        System.out.println("Nota do aluno: " + resultado);

        Alunos.speakNome2();

        String nome = aluno1.getNome();
        System.out.println("Nome do aluno: " + nome);

        aluno1.setNome("Pedro");
        System.out.println("Nome do aluno: " + aluno1.getNome());

        Alunos aluno2 = new Alunos("Pedro");
        System.out.println("Nome do aluno: " + aluno2.getNome3());
    }
}
