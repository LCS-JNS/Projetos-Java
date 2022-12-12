package ManipuladorDeDados.ManipuladorLetras;

public class TudoMinusculo {
    private String str;

    public TudoMinusculo(String str) {
        setStr(str);
        System.out.println(getTudoMinusculo());
    }

    private String getTudoMinusculo() {
        return str.toLowerCase();
    }

    private void setStr(String str) {
        this.str = str;
    }
}
