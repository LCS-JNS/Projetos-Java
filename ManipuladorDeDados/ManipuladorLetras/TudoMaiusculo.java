package ManipuladorDeDados.ManipuladorLetras;

public class TudoMaiusculo {
    private String str;

    public TudoMaiusculo(String str) {
        setStr(str);
    }

    public String getTudoMaiusculo() {
        return str.toUpperCase();
    }

    private void setStr(String str) {
        this.str = str;
    }
}
