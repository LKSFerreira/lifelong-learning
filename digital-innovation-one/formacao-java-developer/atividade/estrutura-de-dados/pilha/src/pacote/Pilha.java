package pacote;

public class Pilha {
    
    private No RefNoEntradaPilha;

    public Pilha() {
        this.RefNoEntradaPilha = null;
    }

    public boolean isEmpty() {
        return RefNoEntradaPilha == null ? true : false;
    }

    public No top() {
        return RefNoEntradaPilha;
    }

    public void push (No novoNo) {
        No RefAuxiliar = RefNoEntradaPilha;
        RefNoEntradaPilha = novoNo;
        RefNoEntradaPilha.setRefNo(RefAuxiliar);
    }

    public No pop() {
        if (!this.isEmpty()) {
            No noPoped = RefNoEntradaPilha;
            RefNoEntradaPilha = RefNoEntradaPilha.getRefNo();
            return noPoped;
        }
        return null;
    }

    public int size(){
        int tamanhoPilha = 0;
        No noAuxiliar = RefNoEntradaPilha;
        while (true) {
            if (noAuxiliar != null) {
                tamanhoPilha++;
                if (noAuxiliar.getRefNo() != null) {
                    noAuxiliar = noAuxiliar.getRefNo();
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        return tamanhoPilha;
    }

    @Override
    public String toString() {
        String stringRetorno = "------------------\n";
        stringRetorno += "    Pilha\n";
        stringRetorno += "------------------\n";

        No noAuxiliar = RefNoEntradaPilha;

        while (true) {
            
            if (noAuxiliar != null) {
                stringRetorno += "[No{dado=" + noAuxiliar.getDado() + "}]\n";
                noAuxiliar = noAuxiliar.getRefNo();
            } else {
                break;
            }
        }
        stringRetorno += "==================\n";
        return stringRetorno;
    }

    

}
