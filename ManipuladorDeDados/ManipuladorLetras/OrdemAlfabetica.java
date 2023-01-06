package ManipuladorDeDados.ManipuladorLetras;

import java.util.Arrays;

public class OrdemAlfabetica {

    private String[] strList;

    public OrdemAlfabetica(String[] strList) {
        setStrList(strList);
    }

    public String alfabeticalOrder() {
        Arrays.sort(this.strList);
        String str = "";
        for (int i = 0; i < strList.length; i++) {
            str += strList[i];
            if(i != strList.length - 1) {
                str += ", ";
            }
        }
        return str;
    }

    public void setStrList(String[] strList) {
        this.strList = strList;
    }

    
}
