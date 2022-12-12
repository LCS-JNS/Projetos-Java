package ManipuladorDeDados.ManipuladorLetras;

public class TudoMaiusculo {
    private String str;

    public TudoMaiusculo(String str) {
        setStr(str);
        System.out.println(getTudoMaiusculo());
    }

    private String getTudoMaiusculo() {
        return str.toUpperCase();
    }

    private void setStr(String str) {
        this.str = str;
    }
}
