package ManipuladorDeDados.ManipuladorLetras;

public class TudoMaiusculo {
    private String str;

    public TudoMaiusculo(String str) {
        setStr(str);
        System.out.println(getTudoMaiusculo());
    }

    public String getTudoMaiusculo() {
        return str.toUpperCase();
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
