package ManipuladorDeDados.ManipuladorLetras;

public class ContaCaractere {

    private String str;

    public ContaCaractere(String str) {
        setStr(str);
    }

    public int getQtdCaractere() {
        return this.str.length();
    }

    private void setStr(String str) {
        this.str = str;
    }

    
}
