package ManipuladorDeDados.ManipuladorLetras;

public class ContaCaractere {

    private String str;

    public ContaCaractere(String str) {
        setStr(str);
        System.out.println(getQtdCaractere() + " carateres presentes");
    }

    private int getQtdCaractere() {
        return this.str.length();
    }

    private void setStr(String str) {
        this.str = str;
    }

    
}
