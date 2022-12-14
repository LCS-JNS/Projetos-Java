package ManipuladorDeDados.ManipuladorDeNumeros;
import java.util.Arrays;
import java.util.Collections;

public class OrganizaDecrescente {
    private String str  = "";
    private Integer[] nList;

    public OrganizaDecrescente(Integer[] nList) {
        setnList(nList);
    }

    public String orgDec() {
        Arrays.sort(nList, Collections.reverseOrder());
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
