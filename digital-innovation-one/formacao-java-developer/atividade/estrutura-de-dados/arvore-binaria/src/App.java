import pacote.ArvoreBinaria;
import pacote.models.Obj;

public class App {
    public static void main(String[] args) throws Exception {
        
        ArvoreBinaria<Obj> minhaArvore = new ArvoreBinaria<>();

        minhaArvore.insert(new Obj(13));
        minhaArvore.insert(new Obj(10));
        minhaArvore.insert(new Obj(25));
        minhaArvore.insert(new Obj(2));
        minhaArvore.insert(new Obj(12));
        minhaArvore.insert(new Obj(20));
        minhaArvore.insert(new Obj(31));
        minhaArvore.insert(new Obj(29));

        minhaArvore.exibirInOrdem();
        minhaArvore.exibirPreOrdem();
        minhaArvore.exbirPosOrdem();

        minhaArvore.insert(new Obj(32));

        minhaArvore.exibirInOrdem();
        minhaArvore.exibirPreOrdem();
        minhaArvore.exbirPosOrdem();

    }
}
