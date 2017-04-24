package ohtu;

public class Plus implements Komento {

  private int tulos;
  private int lisattava;

  public Plus(int luku) {
    this.tulos = luku;
    this.lisattava = 0;
  }

  public void muutaLisattava(int luku) {
    this.lisattava = luku;
  }

  @Override
  public int suorita(int luku) {
    muutaLisattava(luku);
    return tulos += luku;
  }

  @Override
  public int undo() {
    tulos -= lisattava;
    muutaLisattava(0);
    return tulos;
  }

}
