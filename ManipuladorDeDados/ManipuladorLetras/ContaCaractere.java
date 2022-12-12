package ManipuladorDeDados.ManipuladorLetras;

public class ContaCaractere {

    private String str;

    public ContaCaractere(String str) {
        setStr(str);
        System.out.println(getQtdCaractere() + " carateres presentes");
    }

    public int getQtdCaractere() {
        return this.str.length();
    }

    public String getStr() {
        return str;
    }
    public void setStr(String str) {
        this.str = str;
    }

    
}
