package ManipuladorDeDados.ManipuladorLetras;

public class ApagaDuplicado {
    
    private String str;

    public ApagaDuplicado(String str) {
        setStr(str);
        System.out.println(apgDup());
    }

    public String apgDup() {
        String[] strList = str.split("");

        for (int i = strList.length - 1; i >= 0; i--) {
            String atual = strList[i];
            for (int j = 0; j < strList.length; j++) {
                if(atual.equals(strList[j]) && i != j) {
                    strList[i] = "repeated letter";
                }
            }
        }

        this.str = "";

        for (int i = 0; i < strList.length; i++) {
            if(!strList[i].equals("repeated letter")) {
                this.str += strList[i];
            }
        }
        return this.str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
    
}
