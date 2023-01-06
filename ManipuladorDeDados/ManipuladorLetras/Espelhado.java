package ManipuladorDeDados.ManipuladorLetras;


public class Espelhado {
    private String str;

    public Espelhado(String str) {
        setStr(str);
        
    }

    public String getEspelhado() {
        String[] strList = str.split("");
        this.str = "";
        for (int i = strList.length - 1; i >= 0; i--) {
            str += strList[i];
        }
        return str;
    }

    private void setStr(String str) {
        this.str = str;
    }

}
