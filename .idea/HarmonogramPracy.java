/**
 * Klasa zawierająca informacje o harmonogramie autobusów
 * @author Kacper Nitkiewicz
 * @version  1.0
 *
 */
public class HarmonogramPracy{
    private enum Dzien{
        Poniedzialek, Wtorek, Sroda, Czwartek, Piatek, Sobota, Niedziela
    }
    long ID;
    Dzien dzien;
    String GodzinaRozpoczecia;
    String GodzinaZakonczenia;
}