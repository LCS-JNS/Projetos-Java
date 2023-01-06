package ManipuladorDeDados.ManipuladorDeNumeros;

public class ApagaNumDup {
    private String[] strList;
    private Integer[] nList;
    private String str = "";

    public ApagaNumDup(Integer[] nList) {
        setnList(nList);
        nListTOstrList();
    }

    public String apgNumDup() {
        for (int i = strList.length - 1; i >= 0; i--) {
            String atual = strList[i];
            for (int j = 0; j < strList.length; j++) {
                if(atual.equals(strList[j]) && i != j) {
                    strList[i] = "repeated number";
                }
            }
        }

        for (int i = 0; i < strList.length; i++) {
            if(!strList[i].equals("repeated number")) {
                this.str += strList[i];
                if(i < strList.length - 1) {
                    this.str += ", ";
                }
            }
        }
        return this.str;
    }

    private void nListTOstrList() {
        String[] list = new String[this.nList.length];
        for (int i = 0; i < list.length; i++) {
            list[i] = String.valueOf(this.nList[i]);
        }
        this.strList = list;
    }

    private void setnList(Integer[] nList) {
        this.nList = nList;
    }
}
