package pacote.models;

public class Obj extends ObjArvore<Obj>{

    private Integer num;

    public Obj(Integer num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Obj)) return false;
        Obj outro = (Obj) obj;
        return this.num.equals(outro.getNum());
    }

    @Override
    public int hashCode() {
        return this.num.hashCode();
    }

    @Override
    public int compareTo(Obj o) {
        return this.num.compareTo(o.getNum());
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return this.num.toString();
    }   
    
    
    

}
