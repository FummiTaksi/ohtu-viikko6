package ohtu;

public class Nollaus implements Komento {

  private int alkuarvo;


  public Nollaus(int alkuarvo) {
   this.alkuarvo = alkuarvo;
  }

  public void nollaaAlkuarvo() {
      alkuarvo = 0;
  }

  

 @Override
 public int suorita(int luku) {
   return 0;
 }

 @Override
 public int undo() {
   int palautus = alkuarvo;
   nollaaAlkuarvo();
   return palautus;
 }
}
