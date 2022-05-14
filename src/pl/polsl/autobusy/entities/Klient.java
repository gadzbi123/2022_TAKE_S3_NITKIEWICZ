package pl.polsl.autobusy.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Klasa zawierająca informacje o kliencie biorącym udział w przejeździe autobusem.
 * @author Kacper Nitkiewicz
 * @version  1.1
 *
 */
@Entity
public class Klient{
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private long KlientID;
    private String Imie;
    private String Nazwisko;
    private String PESEL;

    @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name="Przejazd_Klienta", joinColumns = @JoinColumn(name="Klient_KlientID"), inverseJoinColumns = @JoinColumn(name="Przejazd_PrzejazdID"))
    private List<Przejazd> Przejazdy;

    public long getKlientID() {
        return KlientID;
    }

    public void setKlientID(long klientID) {
        this.KlientID = klientID;
    }

    public String getImie() {
        return Imie;
    }

    public void setImie(String imie) {
        Imie = imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        Nazwisko = nazwisko;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public List<Przejazd> getPrzejazdy() {
        return Przejazdy;
    }

    public void setPrzejazdy(List<Przejazd> przejazdy) {
        Przejazdy = przejazdy;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "ID=" + KlientID +
                ", Imie='" + Imie + '\'' +
                ", Nazwisko='" + Nazwisko + '\'' +
                ", PESEL='" + PESEL + '\'' +
                ", Przejazdy=" + Przejazdy +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Klient klient = (Klient) o;

        return KlientID == klient.KlientID;
    }

    @Override
    public int hashCode() {
        return (int) (KlientID ^ (KlientID >>> 32));
    }
}