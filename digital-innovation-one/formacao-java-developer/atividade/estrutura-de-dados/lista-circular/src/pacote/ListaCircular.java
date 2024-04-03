package pacote;

public class ListaCircular<T> {

    private No<T> cabeca;
    private No<T> cauda;
    private int tamanhoLista;

    public int size() {
        return this.tamanhoLista;
    }

    public boolean isEmpty() {
        return this.tamanhoLista == 0;
    }

    public void add(T conteudo) {
        No<T> novoNo = new No<>(conteudo);
        if (this.tamanhoLista == 0) {
            this.cabeca = novoNo;
            this.cauda = this.cabeca;
            this.cabeca.setProximoNo(this.cauda);
        } else {
            novoNo.setProximoNo(this.cauda);
            this.cabeca.setProximoNo(novoNo);
            this.cauda = novoNo;
        }
        this.tamanhoLista++;
    }

    public void remove(int index) {
        if (index >= this.tamanhoLista)
            throw new IndexOutOfBoundsException("O índice é maior que o tamanho da lista");

        No<T> noAuxiliar = this.cauda;
        
        if (index == 0) {
            this.cauda = this.cauda.getProximoNo();
            this.cabeca.setProximoNo(this.cauda);
        } else if (index == 1) {
            this.cauda.setProximoNo(this.cauda.getProximoNo().getProximoNo());
        } else {
            for (int i = 0; i < index - 1; i++) {
                noAuxiliar = noAuxiliar.getProximoNo();
            }
            noAuxiliar.setProximoNo(noAuxiliar.getProximoNo().getProximoNo());
        }
        this.tamanhoLista--;
    }

    public T get(int index) {
        return this.getNo(index).getConteudo();
    }

    private No<T> getNo(int index) {
        if (this.isEmpty())
            throw new IndexOutOfBoundsException("A lista está vazia.");

        if (index == 0) {
            return this.cauda;
        }

        if (index == this.size() - 1) {
            return this.cabeca;
        }

        /* x
        if (index > this.size() - 1)
            throw new IndexOutOfBoundsException("Impossível retornar o elemento no index " + index + ". A lista possui "
                    + this.size() + " elementos.");
        */

        No<T> noAuxiliar = this.cauda;

        for (int i = 0; (i < index); i++) {
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        return noAuxiliar;
    }

    @Override
    public String toString() {
        String strRetorno = "";
        No<T> noAuxiliar = this.cauda;
        for (int i = 0; i < this.size(); i++) {
            strRetorno += "[ No{ conteudo = " + noAuxiliar.getConteudo() + " }] --> ";
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        strRetorno += this.size() != 0 ? "(Retorna ao início)" : "[]";
        return strRetorno;
    }
}
