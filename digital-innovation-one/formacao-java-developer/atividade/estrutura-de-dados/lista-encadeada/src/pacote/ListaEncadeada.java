package pacote;

public class ListaEncadeada<T> {
    No<T> referenciaEntrada = null;


    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo);
        if(this.isEmpty()){
            referenciaEntrada = novoNo;
            return;
        }
        No<T> noAuxiliar = referenciaEntrada;
        for(int i = 0; i < this.size()-1; i++){
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        noAuxiliar.setProximoNo(novoNo);
    }

    public T get(int index){
        return getNo(index).getConteudo();
    }

    public int size(){
        int tamanhoLista = 0;
        No<T> referenciaAux = referenciaEntrada;
        while(true){
            if(referenciaAux != null){
                tamanhoLista++;
                if(referenciaAux.getProximoNo() != null){
                    referenciaAux = referenciaAux.getProximoNo();
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        return tamanhoLista;
    }

    public boolean isEmpty() {
        return referenciaEntrada == null ? true : false;
    }

    private No<T> getNo(int index){
        validaIndice(index);
        No<T> noAuxiliar = referenciaEntrada;
        No<T> noRetorno = null;
        for (int i = 0; i <= index; i++){
            noRetorno = noAuxiliar;
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        return noRetorno;
    }

    private void validaIndice(int index){
        if(index >= size()){
            int ultimoIndice = size() - 1;
            throw new IndexOutOfBoundsException("Não existe conteúdo no índice " + index + " desta lista. Esta lista só vai até o índice " + ultimoIndice + ".");
        }
    }

    public T remove(int index){
        No<T> noPivor = this.getNo(index);
        if(index == 0){
            referenciaEntrada = noPivor.getProximoNo();
            return noPivor.getConteudo();
        }
        No<T> noAnterior = getNo(index - 1);
        noAnterior.setProximoNo(noPivor.getProximoNo());
        return noPivor.getConteudo();
    }

    @Override
    public String toString() {
        String stringRetorno = "";
        No<T> noAuxiliar = referenciaEntrada;
        for(int i = 0; i < this.size(); i++){
            stringRetorno += "No [{ conteudo = " + noAuxiliar.getConteudo() + " }] --> ";
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        stringRetorno += "null";
        return stringRetorno; 
    }

    

}
