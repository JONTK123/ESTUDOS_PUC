//Nomenclatura - Letras minusculas e sem espacos
//Utilize o "." para acessar subpastas
package prova1.model;


//Nomenclatura - Letas minusculas separadas por "."
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

//Nomenclatura - Inicial maiuscula
//Public pois a classe sera acessada por outras classes como a Main ao instanciar um objeto
//implements - Adiciona mgitetodos nao obrigatorios a classe (Comparable) e Cloneable
//Não existe tipo primitivo de String
public class Aluno implements Comparable<Aluno>, Cloneable {

    //Nomenclatura - Letras minusculas e maiuscula na primeira palavra
    //Private pois a variavel sera acessada apenas dentro da classe SEMPRE PRIVATE pois a variavel nao deve ser acessada DIRETAMENTE
    private String nome;
    private String nomeCompleto;
    private String email;
    private String RA;
    private byte idade;

    //Vamos usar esse atributo para exemplificar o uso da classe Byte wrapper para tipos primitivos
    private Byte faltas;

    //public - pois o atributo sera acessado por outras classes
    //static - pois o atributo sera o mesmo para todas as instancias da classe, nao ha necessidade de instanciar a classe para acessar esse atributo
    //final - pois o atributo nao pode ser alterado
    //Atributos constantes sao os unicos que podem ser public
    public static final Byte IDADE_MINIMA = 18;

    //Atributo do tipo Data (Classe Data)
    private Data dataNascimento;

    //Nomenclatura - Nome do construtor igual nome da Classe sempre
    //Public pois o construtor sera acessado por outras classes ao instanciar um objeto
    //this - sao atributos da instancia criada
    //this - atribui valor para os atributos da instancia com o valor passado por parametro
    //Estamos construindo os atributos da classe com seus determinados tipos
    public Aluno(String nomeCompleto, String RA, Byte idade, Data dataNascimento, Byte faltas) {
        this.nomeCompleto = nomeCompleto;
        this.RA = RA;
        this.idade = idade;
        this.dataNascimento = dataNascimento;

        //Atribuimos valor de faltas criando uma instancia da classe Byte Wrapper, BOXED dentro de faltas OU
        //Criando novo ponteiro/instancia da classe wrapper
        this.faltas = new Byte (faltas);

        //Metodo UNBOXED, rapido das classes wrapped
        //Utilizando mesmo ponteiro/instancia da classe wrapper
        //this.faltas = faltas;
    }

    //Construtor de copia - Recebe um objeto do mesmo tipo e copia seus atributos
    //other = intancia a ser copiada, pode ter qualquer nome
    //SOMENTE ESCREVER construtor de copia / metodo clone e implements cloneable se temos metodos que alteram atributos da classe
    public Aluno(Aluno other) {
        this.nomeCompleto = other.nomeCompleto;
        this.RA = other.RA;
        this.idade = other.idade;
        this.dataNascimento = other.dataNascimento;
    }

    //-----------------------------------------------------------------
    //-----------------------------------------------------------------

    //Métodos Getters - Acessam os atributos instancia e retornam
    //Não precisa passar instancia como parametro pois é implicito
    //SEMPRE desenvolver esses métodos
    public string getRA() {
        return this.RA;
    }

    public string getEmail() {
        return this.email;
    }

    public string getNomeCompleto() {
        return this.nomeCompleto;
    }

    public Byte getFaltas() {
        return this.faltas.byteValue();
        //return this.fatlas //UNBOXED
    }

    public byte getIdade() {
        reutrn this.idade
    }

    //-----------------------------------------------------------------
    //-----------------------------------------------------------------

    //Métodos Setters - Atribuem valor aos atributos da instancia
    //SEMPRE desenvolver esses métodos
    public void setRA(String RA) {
        this.RA = RA;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public void setFaltas(Byte faltas) {
        this.faltas = new Byte(faltas);
        //this.faltas = faltas; //UNBOXED
    }

    public void setIdade(Byte idade) {
        this.idade = idade;
    }

    //-----------------------------------------------------------------
    //-----------------------------------------------------------------

    //Métodos obrigatórios - SEMPRE desenvolver esses métodos na prova
    //Todos os prints deverão ser desse jeito
    //S maisuculo pois wrapper, nao existe string tipo primitivo
    @Override
    public String toString() {
        return( "Nome completo: " + this.nomeCompleto +
                "\nRA: " + this.RA +
                "\nIdade: " + this.idade +
                "\nData de nascimento: " + this.dataNascimento +
                "\nFaltas: " + this.faltas
                );
    }

    //
    @Override
    public boolean equals (Object obj) { //Object pois pode ser comparado com qualquer objeto
        if (this == obj) return true; // Verifica se instancia = obj a ser comparado, logo true
        if (obj == null) return false; // Verifica se objeto a ser comparado existe
        if (obj.getClass() != this.getClass()) return false; // Verifica se objeto a ser comparado é da mesma classe

        Aluno aluno = (Aluno) obj; // Muda o tipo do objeto a ser comparado para Aluno

        //Compara cada atributo
        if (aluno.nomeCompleto != this.nomeCompleto) return false;
        if (aluno.RA != this.RA) return false;
        if (aluno.idade != this.idade) return false;
        if (aluno.dataNascimento != this.dataNascimento) return false;
        if (aluno.faltas != this.faltas) return false;

        return true; // Se todos os atributos forem iguais, retorna true
    }

    @Override
    public int hashCode() {
        int ret = 1;

        // Atributos de instância
        ret = ret * 7 + this.nomeCompleto.hashCode();
        ret = ret * 7 + this.RA.hashCode();
        ret = ret * 7 + this.dataNascimento.hashCode();

        // Atributos primitivos utilizando wrappers
        ret = ret * 2 + this.idade.hashCode();
        ret = ret * 11 + Byte.valueOf(this.faltas).hashCode();

        return ret;
    }

    //Método obrigatório mas SITUACIONAL
    //implements Comparable<Aluno>
    //compareTo - compara dois objetos da mesma classe
    @Override
    public int compareTo(Aluno a) {

        //compareTo - método da classe String wrapper que compara duas strings
        //Se for 0 quer dizer que são iguais
        if (this.nomeCompleto.compareTo(a.nomeCompleto) > 0) { return 666; }
        if (this.nomeCompleto.compareTo(a.nomeCompleto) < 0) { return -666; }
        if (this.RA.compareTo(a.RA) > 0) { return 666; }
        if (this.RA.compareTo(a.RA) < 0) { return -666; }
        if (this.email).compareTo(a.email) > 0) { return 666; }
        if (this.email).compareTo(a.email) < 0) { return -666; }
        if (this.idade > a.idade) { return 666; }
        if (this.idade > a.idade) { return -666; }

        //Chamamos o método compareTo da classe Data, NÃO CONFUNDIR COM MÉTODO WRAPPER
        if (this.dataNascimento.compareTo(a.dataNascimento) > 0) { return 666; }
        if (this.dataNascimento.compareTo(a.dataNascimento) < 0) { return -666; }

        //Chamamos o método compareTo da classe Byte
        if (this.faltas.compareTo(a.faltas) > 0) { return 666; }
        if (this.faltas.compareTo(a.faltas) < 0) { return -666; }




        return 0;
    }

}