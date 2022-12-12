package ManipuladorDeDados.ManipuladorLetras;

public class TudoMinusculo {
    private String str;

    public TudoMinusculo(String str) {
        setStr(str);
        System.out.println(getTudoMinusculo());
    }

    public String getTudoMinusculo() {
        return str.toLowerCase();
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
