package ManipuladorDeDados.Display;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import ManipuladorDeDados.ManipuladorLetras.*;
import ManipuladorDeDados.ManipuladorDeNumeros.*;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceUsuario {

    private JFrame frame;
    private JTextField tfLetras;
    private JTextField tfNumeros;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InterfaceUsuario window = new InterfaceUsuario();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public InterfaceUsuario() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setResizable(false);
        frame.setTitle("Manipulador de letras e números");
        frame.setBounds(100, 100, 449, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 15, 413, 237);
        frame.getContentPane().add(tabbedPane);

        JPanel panel = new JPanel();
        tabbedPane.addTab("Manipular Letras", null, panel, null);
        panel.setLayout(null);

        JComboBox cbLetras = new JComboBox();
        cbLetras.setModel(new DefaultComboBoxModel(new String[] { "Escrever frase/palavra espelhado",
                "Deixar todas as letras maíusculas", "deixar todas as letras minúsculas",
                "Informar quantos caracteres possui", "Apagar caracteres duplicados" }));
        cbLetras.setBounds(10, 27, 230, 22);
        panel.add(cbLetras);

        JLabel lblNewLabel = new JLabel("Que ação deseja realizar?");
        lblNewLabel.setBounds(10, 11, 166, 14);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Inserir Frase/Palavra:");
        lblNewLabel_1.setBounds(10, 60, 147, 14);
        panel.add(lblNewLabel_1);

        tfLetras = new JTextField();
        tfLetras.setBounds(10, 79, 388, 43);
        panel.add(tfLetras);
        tfLetras.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Resultado:");
        lblNewLabel_2.setBounds(10, 133, 95, 14);
        panel.add(lblNewLabel_2);

        JTextPane tpLetras = new JTextPane();
        tpLetras.setBounds(10, 152, 388, 46);
        panel.add(tpLetras);

        JButton btnLetras = new JButton("Executar");
        btnLetras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String str = tfLetras.getText();
                switch (cbLetras.getSelectedIndex()) {
                    case 0:
                        Espelhado esp = new Espelhado(str);
                        tpLetras.setText(esp.getEspelhado());
                        break;

                    case 1:
                        TudoMaiusculo tdm = new TudoMaiusculo(str);
                        tpLetras.setText(tdm.getTudoMaiusculo());
                        break;

                    case 2:
                        TudoMinusculo tm = new TudoMinusculo(str);
                        tpLetras.setText(tm.getTudoMinusculo());
                        break;

                    case 3:
                        ContaCaractere cc = new ContaCaractere(str);
                        tpLetras.setText(String.valueOf(cc.getQtdCaractere()));
                        break;

                    case 4:
                        ApagaDuplicado ad = new ApagaDuplicado(str);
                        tpLetras.setText(ad.apgDup());
                        break;
                }
            }

        });
        btnLetras.setBounds(278, 27, 89, 23);
        panel.add(btnLetras);

        JPanel panel_1 = new JPanel();
        tabbedPane.addTab("Manipular Números", null, panel_1, null);
        panel_1.setLayout(null);

        JLabel lblNewLabel_3 = new JLabel("Que ação deseja realizar?");
        lblNewLabel_3.setBounds(10, 11, 166, 14);
        panel_1.add(lblNewLabel_3);

        JComboBox cbNumeros = new JComboBox();
        cbNumeros.setModel(new DefaultComboBoxModel(
                new String[] { "Organizar em ordem crescente", "Organizar em ordem decrescente",
                        "Mostrar o maior número", "Mostrar o menor número", "Apagar numeros duplicados" }));
        cbNumeros.setBounds(10, 27, 230, 22);
        panel_1.add(cbNumeros);

        JLabel lblNewLabel_4 = new JLabel("Lista de números: ");
        lblNewLabel_4.setBounds(10, 60, 110, 14);
        panel_1.add(lblNewLabel_4);

        tfNumeros = new JTextField();
        tfNumeros.setColumns(10);
        tfNumeros.setBounds(10, 79, 388, 43);
        panel_1.add(tfNumeros);

        JTextPane tpNumeros = new JTextPane();
        tpNumeros.setBounds(10, 152, 388, 46);
        panel_1.add(tpNumeros);

        JLabel lblNewLabel_5 = new JLabel("Resultado:");
        lblNewLabel_5.setBounds(10, 133, 110, 14);
        panel_1.add(lblNewLabel_5);

        JButton btnNumeros = new JButton("Executar");
        btnNumeros.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String str = tfNumeros.getText();

                    String[] strList = null;
                    if (str.contains(",") || str.contains(";") && !str.contains(" "))
                        if(str.contains(";")) strList = str.split(";");
                        else strList = str.split(",");
                    else if (str.contains(", ") || str.contains("; "))
                        if(str.contains("; ")) strList = str.split("; ");
                        else strList = str.split(", ");
                    else if (!str.contains(",") && !str.contains(";") && str.contains(" "))
                        strList = str.split(" ");
                    else  strList = str.split("");

                    Integer[] nList = new Integer[strList.length];
                    for (int i = 0; i < strList.length; i++) {
                        nList[i] = Integer.parseInt(strList[i]);
                    }

                    switch (cbNumeros.getSelectedIndex()) {
                        case 0:
                            OrganizaCrescente oc = new OrganizaCrescente(nList);
                            tpNumeros.setText(oc.orgCresc());
                            break;

                        case 1:
                            OrganizaDecrescente od = new OrganizaDecrescente(nList);
                            tpNumeros.setText(od.orgDec());
                            break;

                        case 2:
                            MaiorNum man = new MaiorNum(nList);
                            tpNumeros.setText(String.valueOf(man.getMaior()));
                            break;

                        case 3:
                            MenorNum men = new MenorNum(nList);
                            tpNumeros.setText(String.valueOf(men.getMenor()));
                            break;

                        case 4:
                            ApagaNumDup and = new ApagaNumDup(nList);
                            tpNumeros.setText(and.apgNumDup());
                            break;
                    }

                } catch (NullPointerException exc) {
                    JOptionPane.showMessageDialog(frame, "Entrada inválida");
                    tfNumeros.setText("");
                    tfNumeros.requestFocus();
                }

            }
        });
        btnNumeros.setBounds(278, 27, 89, 23);
        panel_1.add(btnNumeros);

    }
}
