package ohtu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Tapahtumankuuntelija implements ActionListener {
    private JButton plus;
    private JButton miinus;
    private JButton nollaa;
    private JButton undo;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private Komento edellinen;

    public Tapahtumankuuntelija(JButton plus, JButton miinus, JButton nollaa, JButton undo, JTextField tuloskentta, JTextField syotekentta) {
        this.plus = plus;
        this.miinus = miinus;
        this.nollaa = nollaa;
        this.undo = undo;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        Komentotehdas tehdas = new Komentotehdas(Integer.parseInt(tuloskentta.getText()));
        int laskunTulos = Integer.parseInt(tuloskentta.getText());
        JButton painettu = (JButton) ae.getSource();
        Komento komento = tehdas.haeKomento(painettu.getText());

        if (komento != null) {
          if (syotekentta.getText().isEmpty()) {
            laskunTulos = komento.suorita(0);
          }
          else {
            laskunTulos = komento.suorita(Integer.parseInt(syotekentta.getText()));
          }
          edellinen = komento;
        }
        else {
          laskunTulos = edellinen.undo();
          edellinen = null;
        }

        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);

        nollaa.setEnabled(laskunTulos !=0);
        undo.setEnabled(edellinen!=null);
    }
}
