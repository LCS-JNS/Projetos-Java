package ManipuladorDeDados.ManipuladorLetras;

public class TudoMinusculo {
    private String str;

    public TudoMinusculo(String str) {
        setStr(str);
    }

    public String getTudoMinusculo() {
        return str.toLowerCase();
    }

    private void setStr(String str) {
        this.str = str;
    }
}
