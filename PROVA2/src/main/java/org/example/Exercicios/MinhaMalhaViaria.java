public class MinhaMalhaViaria extends MalhaViaria {

    //Metodo 1 - Construtor, a classe MalhaViaria exige os atributos qc e qv, logo implementamos eles no construtor (qc = quantidade de cidades, qv = quantidade de vias) APENAS QUANTIDADES
    public MinhaMalhaViaria(int qc, int qv) {
        if (qc < 0 || qv < 0) {
            throw new IllegalArgumentException("Quantidade de cidades e vias deve ser maior que zero"); //Sempre validar
        }
        super(qc, qv); // Chama o construtor da superclasse
    }

    //Metodo 2 - Verifica se todas as vias de (pista dupla) tem extensão (maior ou igual) a especificada,
    public boolean viasDePistaDuplaTemAoMenos(float extensao) {
        if (extensao < 0) { //Sempre validar
            throw new IllegalArgumentException("Extensão deve ser maior que zero");
        }

        //Aqui percorremos pois temos apenas os tamanhos e nao sabemos se existe conteudo dentro deles ou nao
        for (int i = 0; i < super.malha.length; i++) { // Percorre as linhas da matriz (vertical)
            for (int j = 0; j < super.malha[i].length; j++) { // Percorre as colunas da matriz (horizontal)
                if (this.malha[i][j] != null && //Ve se existe a via entre as duas rodovias
                        this.malha[i][j].getQtdPistas() == 2 && //Ve se a quantidade de pistas eh dupla
                        this.malha[i][j].getExtensao() < extensao) { //Ve se a extensao eh menor que a especificada

                    return false; // Se alguma via dupla tem extensão menor, retorna falso
                }
            }
        }
        return true; // Todas as vias duplas têm extensão igual ou maior que o valor especificado
    }

    //Metodo 3 - Verifica a quantidade de cidades vizinhas que atendem aos critérios especificados (pop menor e pistas) baseadas em uma das cidades presente na lista dadas pelo nome identificando ela
    public int qtdVizinhasComoEspecificadas(String nomCid, int pop, int pst) throws Exception {

        //Sempre validar
        if (nomCid == null) throw new Exception("Cidade ausente");
        if (pop <= 0) throw new Exception("População inválida");
        if (pst <= 0) throw new Exception("Quantidade de pistas inválida");

        //Iremos encontrar a cidade com base na lista, pois sabemos qual eh mas nao sabemos onde ela esta
        int k; //Salvamos posicao da cidade pois usaremos no futuro
        for (k = 0; k < super.cidade.length; k++) { // Procura a cidade pelo nome
            if (nomCid.equals(super.cidade[k].getNome())) {
                break; // Encontrou a cidade
            }
        }

        if (k == super.cidade.length) {
            // Não encontrou a cidade no vetor
            throw new Exception("Cidade inexistente");
        }

//           for (int k=0; k<super.cidade.length; k++) {
//            if(nomCid.equals(super.cidade[k].getNome())) {
//                break;
//            if(k==super.cidade.length) {
//                throw new Exception ("Cidade inexistente");
//            }
//        }

        //Analisaremos as cidades vizinhas a partir da cidade encontrada de i ate k DIRETO
        int cont = 0; //Contador pois exercicio falou que sera necessario
        // Verifica conexões de cidades com populações e pistas especificadas
        for (int i = 0; i < this.cidade.length; i++) { //percorre as cidades
            if (i != k && // Ignora a própria cidade
                    this.cidade[i].getPopulacao() >= pop && // Verifica a população se eh menor que a especificada
                    this.via[i][k] != null && // Há uma via da cidade `i` para `k`
                    this.via[i][k].qtdPistas() == pst) { // A via tem o número de pistas especificado
                cont++; //Se a cidade tiver menor pop, existir uma via e mesma quantidade de pistas, quer dizer q ela eh igual a especificada
            }
        }

        // Verifica VIAS UNILATERAIS das cidades vizinhas com populações e pistas especificadas de j ate k e de k ate j RETORNO
        for (int j = 0; j < this.cidade.length; j++) { //percorre as cidades
            if (j != k && // Ignora a própria cidade
                    this.cidade[j].getPopulacao() >= pop && // Verifica a população se eh menor que a especificada
                    this.via[k][j] != null && // Há uma via da cidade `k` para `j`
                    this.via[k][j].qtdPistas() == pst && // A via tem o número de pistas especificado
                    (this.via[j][k] == null || this.via[j][k].qtdPistas() != pst) // Não há retorno Ou o retorno não tem as pistas especificadas, se ela nao existe, tambem nao existira pistas
                cont++;
            }
        }
        return cont; // Retorna a quantidade de cidades vizinhas que atendem aos critérios
    }
}









