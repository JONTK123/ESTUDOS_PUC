//Nomenclatura - Letras minusculas e sem espacos
//Utilize o "." para acessar subpastas
package prova1.model;

//Nomenclatura - Letas minusculas separadas por "."
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Vector;


import prova1.model.Data;
import prova1.model.Pessoa;
import prova1.model.Usuario;

//Nomenclatura - Inicial maiuscula
//Public pois a classe sera acessada por outras classes como a Main ao instanciar um objeto
//implements - Adiciona mgitetodos nao obrigatorios a classe (Comparable) e Cloneable e tambem Herda Heterogenea da interface Usuario
//Não existe tipo primitivo de String
//Extends - Herda atributos e metodos da classe Pessoa

//Exemplo de JAVADOC
/**
 * A classe Aluno representa um aluno de uma instituição de ensino.
 * @author Thiago Luiz Fossa
 * @since 2000
 */
public class Aluno extends Pessoa implements Comparable<Aluno>, Cloneable, Usuario {

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
        super(CPF);
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

        //diaNascimento eh um atributo de outro tipo, outra instancia - logo, criar nova instancia com dia mes e ano
        this.dataNascimento = new Data (other.dataNascimento);
    }

    //---------------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------------

    //GETTERS

    //Métodos Getters - Acessam os atributos instancia e retornam
    //Não precisa passar instancia como parametro pois é implicito
    //SEMPRE desenvolver esses métodos
    public string getRA() {
        return this.RA;
    }

    public string getEmail() {
        return this.email;
    }

    //Metodo try-catch dentro de um metodo tratando erros. Desse modo a MAIN nao precisa fazer nada pois o metodo faz
    public String getNomeCompleto() {
        try {
            if (this.nomeCompleto == null) {
                throw new Exception("Nome completo não pode ser nulo");
            }
            return this.nomeCompleto;
        } catch (Exception e) {
            System.err.println("Erro ao obter o nome completo: " + e.getMessage());
            return null;
        }
    }

    public Byte getFaltas() {
        return this.faltas.byteValue();
        //return this.fatlas //UNBOXED
    }

    //throws Exception - somente para indicar q esse metodo pode tratar uma exception
    //So fara efeito se na MAIN tiver um try-catch para pegar esse erro, se nao, nada ocorre
    public byte getIdade() throws Exception {
        return this.idade;
    }

    //---------------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------------

    //SETTERS

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

    //---------------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------------

    //METODOS - JAVA

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
    //Implementar SOMENTE quando queremos comparar atributos da mesma classe
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

    //Implementar essa funcao e construtor de copia somente quando na classe tiver metodos que alteram o this ( setters e etc... )\
    //Existem 2 tipos de clone SUPERFICIAL E PROFUNDO
    //PROFUNDO - Copia atributos/instancia de outra classe - Precisa construtor de copia
    //SUPERFICIAL - Copia tipos primitivos - Nem precisa de construtor de copia apenas user super.clone()
    //Temos alguns jeitos de executar, SEM consturtor de copia e COM.
    //Aqui estamos clonando superficialmente os tipos primitivos e depois clonando o dataNascimento separadamente com metodo clone presente na classe Data
    //SEM:
    @Override
    public Aluno clone() {
        try{
            alunoClonado = (Aluno) super.clone(); //Realiza clonagem superficial com tipos primitivos
            alunoClonado.dataNascimento = this.dataNascimento.clone(); //Realiza clonagem profunda somente do atributo data
            return alunoClonado;
        } catch(Exception e) {
            throw new AssertionError("Clonagem erro")
        }
    }

//    //Aqui ja estamos clonando o atributo diaNascimento() diretamente no construtor de copia
//    //COM:
//    @Override
//    public Aluno clone() {
//        try{
//            return new Aluno(this);
//        } catch(Exception e) {
//            throw new AssertionError("Clonagem erro")
//        }
//    }

    //---------------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------------

    //HERANCA

    //Aqui estamos adicionando um metodo que calcula a idade do aluno
    //Possui mesmo nome do metodo da classe Pessoa, mas com parametros diferentes
    public int calcularIdade(int numero) {
        return 0;
    }

    //O atributo CPF agora faz parte do objeto Aluno
    public String getCPF() {
        return CPF;
    }

    //Testando o super e protected
    @Override
    protected void mostrarNome() {
        super.mostrarNome(); //Chama metodo original
        System.out.println("Sobreescrevendo metodo mostrarNome() da classe Pessoa"); //Sobreescreve
    }

    //---------------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------------

    //JAVADOC

    //Metodo para exemplificar JAVADOC
    //Metodo qualquer
    /**
     * Titulo da funcao Verifica se o aluno é maior de idade.
     * Lanca nova excecao
     * @param idade - Idade do aluno
     * @throws IllegalArgumentException - Se a idade for menor que 18
     * @return - Retorna true se o aluno for maior de idade
     * <ol>
     *    <li>
     *        Resumo da funcao - Verifica se o aluno é maior de idade
     *    </li>
     * <li/>
     */
    public int calcularAnosDeMatricula(int anoAtual, int anoDeMatricula) {
        if (anoAtual < anoDeMatricula) {
            throw new IllegalArgumentException("O ano atual não pode ser menor que o ano de matrícula.");
        }
        return anoAtual - anoDeMatricula;
    }

    //Usando JAVADOC no cmd ->
        //cd C:\caminho\para\seus\arquivos
        //javadoc *. Java

    //---------------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------------

    //REGEX ->

    //Criamos uma variavel constante regex
    private static final String regExNom = "^[A-Z][a-z]*$";

    //Compila o padrao de validacao. Torna o regex ativo a partir de agora
    private static final Pattern padraoNome = Pattern.compile(regExNom);

    //Metodo para validar o nome, verificar se esta dentro do regex
    protected static void valideNome (String nome) throws exception {
        if (nome == null) {
            throw new IllegalArgumentException("Nome não pode ser nulo");
        }

        //Verifica se o nome passado por parametro bate com o padrao de validacao
        if (!Aluno.padraoNome.matcher(nome).matches()) {
            throw new Exception ("Nome inválido");
        }
    }


    //---------------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------------

    //INTERFACE

    //Apenas declarei um metodo na interface Usuario e aqui na classe Aluno eu a desenvolvi
    //Nao podemos instancia-las, apenas criar objeto
    //Usei @Override pois eh uma boa pratica para indicar que veio de uma interface
    //Aqui eu escolhi retornar um email para indicar que eh um login, mas eu poderia criar um novo atributo String login
    @Override
    public String getLogin() {
        return this.email;
    }

    //Explicacao de POLIMORFISMO esta na main

    //---------------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------------

    //CLASS ABSTRACT

    //Funciona parecido com uma interface, mas a diferenca eh que a classe abstrata pode ter metodos comuns e variaveis
    //Nao podemos instancia-las
    //Obrigatorio usar os metodos e atributos herdados
    //Nao existe polimorfismo
    @Override
    public String adicionarAluno() {
        return "Adicionando aluno";
    }

    @Override
    public String removerAluno() {
        return "Removendo aluno";
    }

    //---------------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------------

    //GUI -> FODASE NAO ENTENDI NADA DESSA MERDA

    //---------------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------------

    //VECTOR

    //Vector <Aluno> v;     -> Armazena outras classes, v eh um vetor de Alunos



}

//ESTUDAR VECTOR
//INTERFACE
//CLASSE ABSTRACT