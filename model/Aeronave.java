package aplicativos.model;

public class Aeronave {
        private String modeloNave;
        private int velocidadeNave = 0;
        private int velocidadeMax;
        private String identificacao;
        private Pessoa piloto;

        public Aeronave(String modeloNave, String identificacao,int velocidadeMax, Pessoa piloto) {
            this(piloto);
            this.modeloNave = modeloNave;
            this.velocidadeMax = velocidadeMax;
            this.identificacao = identificacao; 
        }
        public Aeronave(Pessoa piloto){
            this.piloto = piloto;
            piloto.setNaveAtual(this);
        }
        public int acelerar(){
            velocidadeNave++;
            return velocidadeNave;
        }
    
        void acelerar(int limite){
            for (int i = 0; i < limite; i++) {
                acelerar();
            }
        }
        public int getVelocidadeMax() {
            return velocidadeMax;
        }
        public void setVelocidadeMax(int velocidadeMax) {
            this.velocidadeMax = velocidadeMax;
        }
        public int getVelocidadeNave() {
            return velocidadeNave;
        }
        public void setVelocidadeNave(int velocidadeNave) {
            this.velocidadeNave = velocidadeNave;
        }
        public Pessoa getPiloto() {
            return piloto;
        }
        public void setPiloto(Pessoa piloto) {
            this.piloto = piloto;
        }
        public String getModeloNave() {
            return modeloNave;
        }
        public void setModeloNave(String modeloNave) {
            this.modeloNave = modeloNave;
        }
        public String getIdentificacao() {
            return identificacao;
        }
        public void setIdentificacao(String identificacao) {
            this.identificacao = identificacao;
        }

}   
