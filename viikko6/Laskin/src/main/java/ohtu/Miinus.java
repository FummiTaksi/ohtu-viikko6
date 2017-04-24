package ohtu;

public class Miinus implements Komento{

  private int tulos;
  private int vahennettava;

  public Miinus(int arvo) {
    this.tulos = arvo;
    this.vahennettava = 0;
  }


  public void muutaVahennettava(int uusi) {
    vahennettava = uusi;
  }

  @Override
  public int suorita(int luku) {
    muutaVahennettava(luku);
    return tulos -= luku;
  }

  @Override
  public int undo() {
    tulos += vahennettava;
    muutaVahennettava(0);
    return tulos;
  }
}
