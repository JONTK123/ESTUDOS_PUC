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
//implements - Adiciona metodos nao obrigatorios a classe (Comparable) e Cloneable
public class Aluno implements Comparable<Aluno>, Cloneable {

    //Nomenclatura - Letras minusculas e maiuscula na primeira palavra
    //Private pois a variavel sera acessada apenas dentro da classe SEMPRE PRIVATE pois a variavel nao deve ser acessada DIRETAMENTE
    private String nome;
    private String nomeCompleto;
    private String email;
    private String RA;
    private Byte idade;

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

    public byte getFaltas() {
        return this.faltas.byteValue();
        //return this.fatlas //UNBOXED
    }

}