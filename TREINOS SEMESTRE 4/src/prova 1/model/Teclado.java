package prova1.model;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Teclado {

    //Criamos uma nova instancia da classe BufferedReader - Ler dados do teclado
    //Depois criamos outra instancia da classe InputStreamReader - Converte bytes para caracteres
    //System.in - Entrada de dados do teclado
    private static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

    //Cada tipo primitivo possui um metodo de leitura especifico

    public static String getUmString() {
        String ret = null; //Especificar que o nulo / vazio eh do tipo do metodo, nesse caso string

        try {
            ret = teclado.readline(); //Os dados transformados de bytes para caracteres ja sao do tipo String
        } catch (IOException e) {} //Nao precisa tratar erros

        return ret;
    }

    public static getUmInt() throws Exception {

        //Tipo string eh o padrao, mas para outros tipos devemos especificar
        int ret = 0; //Especificar que o nulo / vazio eh do tipo do metodo, nesse caso int
        // byte ret = (byte) 0;
        // short ret = (short) 0;
        // long ret = 0L;
        // float ret = 0F;
        // double ret = 0.0;
        // boolean ret = false;
        // char ret = ' ';

        try{
            ret = Integer.parseInt(teclado.readline()); //Devemos transformar ret em int
        }

        //Temos dois catchs para os outros tipos
        catch (Exception e) {}
        catch (NumeroFormatException e) {
            throw new Exception("Integer invalido");
        }
    }

    //PARA O TIPO CHAR DEVEMOS USAR UMA OUTRA VARIAVEL STRING PARA SALVAR LETRA POSICAO ZERO
    //PARA TIPO BOOLEAN DEVEMOS ????????????????????????????/

    //FODASE ESSA MERDA DE TECLADO







}