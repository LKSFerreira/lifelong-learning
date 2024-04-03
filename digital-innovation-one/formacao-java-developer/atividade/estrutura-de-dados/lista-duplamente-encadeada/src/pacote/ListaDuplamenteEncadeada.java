package pacote;

public class ListaDuplamenteEncadeada<T> {

    NoDuplo<T> primeiroNo;
    NoDuplo<T> ultimoNo;

    private int tamanhoLista;

    public void add(T elemento) {
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);

        if (this.isEmpty()) {
            this.primeiroNo = novoNo;
            this.ultimoNo = novoNo;
        } else {
            this.ultimoNo.setProximoNo(novoNo);
            novoNo.setNoAnterior(this.ultimoNo);
            this.ultimoNo = novoNo;
        }

        this.tamanhoLista++;
    }

    public void add(int index, T elemento) {
        NoDuplo<T> noAuxiliar = this.getNo(index);
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        novoNo.setProximoNo(noAuxiliar);

        if (novoNo.getProximoNo() != null) {
            novoNo.setNoAnterior(noAuxiliar.getNoAnterior());
            novoNo.getProximoNo().setNoAnterior(novoNo);
        } else {
            novoNo.setNoAnterior(this.ultimoNo);
            this.ultimoNo = novoNo;
        }

        if (index == 0) {
            this.primeiroNo = novoNo;
        } else {
            novoNo.getNoAnterior().setProximoNo(novoNo);
        }

        this.tamanhoLista++;
    }

    public void remove(int index) {
        if (index == 0) {
            this.primeiroNo = this.primeiroNo.getProximoNo();

            if (this.primeiroNo != null) {
                this.primeiroNo.setNoAnterior(null);
            }
        } else {
            NoDuplo<T> noAuxiliar = this.getNo(index);
            noAuxiliar.getNoAnterior().setProximoNo(noAuxiliar.getProximoNo());

            if (noAuxiliar != this.ultimoNo) {
                noAuxiliar.getProximoNo().setNoAnterior(noAuxiliar.getNoAnterior());
            } else {
                this.ultimoNo = noAuxiliar;
            }
        }

        this.tamanhoLista--;
    }

    public int size() {
        return tamanhoLista;
    }

    public T get(int index) {
        return this.getNo(index).getConteudo();
    }

    private NoDuplo<T> getNo(int index) {

        if (this.isEmpty())
            throw new IndexOutOfBoundsException("A lista está vazia.");

        if (index == 0) {
            return primeiroNo;
        }

        if (index == this.size() - 1) {
            return ultimoNo;
        }

        if (index > this.size() - 1)
            throw new IndexOutOfBoundsException("Impossível retornar o elemento no index " + index + ". A lista possui "
                    + this.size() + " elementos.");

        NoDuplo<T> noAuxiliar = primeiroNo;

        for (int i = 0; (i < index); i++) {
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        return noAuxiliar;
    }

    public boolean isEmpty() {
        return tamanhoLista == 0;
    }

    @Override
    public String toString() {
        String stringRetorno = "";

        NoDuplo<T> noAuxiliar = primeiroNo;
        for (int i = 0; i < this.size(); i++) {
            stringRetorno += "[ No{ conteudo = " + noAuxiliar.getConteudo() + " }] --> ";
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        stringRetorno += "null";
        return stringRetorno;
    }

}
