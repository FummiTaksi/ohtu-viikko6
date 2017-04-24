package ohtu;

import java.util.*;

public class Komentotehdas {

  private HashMap<String,Komento> komennot;

  public Komentotehdas(int alkuarvo) {
    this.komennot = new HashMap();
    alustaKomennot(alkuarvo);
  }

  public void alustaKomennot(int alkuarvo) {
     komennot.put("+",new Plus(alkuarvo));
     komennot.put("-", new Miinus(alkuarvo));
     komennot.put("Z", new Nollaus(alkuarvo));
  }

  public Komento haeKomento(String haku) {
    return komennot.get(haku);
  }
}
