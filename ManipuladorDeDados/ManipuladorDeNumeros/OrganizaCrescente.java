package ManipuladorDeDados.ManipuladorDeNumeros;

import java.util.Arrays;

public class OrganizaCrescente {

    private String str  = "";
    private Integer[] nList;

    public OrganizaCrescente(Integer[] nList) {
        setnList(nList);
        System.out.println(orgCresc());
    }

    private String orgCresc() {
        Arrays.sort(nList);
        for (int i = 0; i < nList.length; i++) {
            this.str += String.valueOf(nList[i]);
            if(i < nList.length - 1) {
                this.str += ", ";
            }
        }
        return this.str;
    }

    private void setnList(Integer[] nList) {
        this.nList = nList;
    }
}
