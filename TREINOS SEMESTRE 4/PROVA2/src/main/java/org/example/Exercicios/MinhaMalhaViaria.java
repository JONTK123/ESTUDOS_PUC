public class MinhaMalhaViaria extends MalhaViaria {

   public MinhaMalhaViaria (int qc, int qv) {
        super(qc,qv);
   } 

   public boolean viasDePistaDuplaTemAoMenos(float extensao) {
        //for (int i=0; i<this.malha; i++) {
        for (int i=0; i<super.malha.length; i++) {
            for (int j=0; j<super.malha[i].length; j++) {
                if (this.malha[i][j]==null &&
                    this.malha[i][j].getQtdPistas()==2 &&
                    this.malha[i][j].getExtensao()<extensao) {
                        return false;
                }
            }
        }
        return true;
    }

    public int qtdVizinhasComoEspecificadas (String nomCid, int pop, int pst) {
        
        if (nomCid==null) throw new Exception ("Cidade ausente");
        
        int k;
        for (k=0, k<this.cidade.length; k++) {
            if(nomCid.equals(this.cidade[k]~.getNome())) {
                break;
            }
        }

        if(k=this.cidade.length) throw new Exception ("Cidade inexistente");
        
        for (int i=0; i<this.cidade.length; i++) {
            if (i!=k && this.cidade[i].getPopulacao>=pop &&
                this.cidade[i][k] != null &&
                this.via[i][k].getQtdPistas() == pst &&
                (this.via[j][k] !=null ||
                this.via[j][k].qtdPistas()!=pst)) {
                    cont ++;
                }
                
            


    }
}   
