package pl.polsl.autobusy.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Klasa zawierająca informacje o przejezdzie autobusu
 * @author Kacper Nitkiewicz
 * @version  1.1
 *
 */
@Entity
public class Przejazd{
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private long PrzejazdID;
    private LocalDateTime GodzinaWyjazdu;
    private LocalDateTime GodzinaPrzyjazdu;
    private float CalkowityKoszt;

    @ManyToOne(fetch=FetchType.EAGER)
    private Trasa Trasa;

    @ManyToOne(fetch=FetchType.EAGER)
    private Autobus Autobus;

    @ManyToMany(mappedBy = "Przejazdy")
    private List<Klient> Klienci;

    public long getPrzejazdID() {
        return PrzejazdID;
    }

    public void setPrzejazdID(long przejazdID) {
        this.PrzejazdID = przejazdID;
    }

    public LocalDateTime getGodzinaWyjazdu() {
        return GodzinaWyjazdu;
    }

    public void setGodzinaWyjazdu(LocalDateTime godzinaWyjazdu) {
        GodzinaWyjazdu = godzinaWyjazdu;
    }

    public LocalDateTime getGodzinaPrzyjazdu() {
        return GodzinaPrzyjazdu;
    }

    public void setGodzinaPrzyjazdu(LocalDateTime godzinaPrzyjazdu) {
        GodzinaPrzyjazdu = godzinaPrzyjazdu;
    }

    public float getCalkowityKoszt() {
        return CalkowityKoszt;
    }

    public void setCalkowityKoszt(float calkowityKoszt) {
        CalkowityKoszt = calkowityKoszt;
    }

    public pl.polsl.autobusy.entities.Trasa getTrasa() {
        return Trasa;
    }

    public void setTrasa(pl.polsl.autobusy.entities.Trasa trasa) {
        Trasa = trasa;
    }

    public pl.polsl.autobusy.entities.Autobus getAutobus() {
        return Autobus;
    }

    public void setAutobus(pl.polsl.autobusy.entities.Autobus autobus) {
        Autobus = autobus;
    }

    public List<Klient> getKlienci() {
        return Klienci;
    }

    public void setKlienci(List<Klient> klienci) {
        Klienci = klienci;
    }

    @Override
    public String toString() {
        return "Przejazd{" +
                "ID=" + PrzejazdID +
                ", GodzinaWyjazdu=" + GodzinaWyjazdu +
                ", GodzinaPrzyjazdu=" + GodzinaPrzyjazdu +
                ", CalkowityKoszt=" + CalkowityKoszt +
                ", Trasa=" + Trasa +
                ", Autobus=" + Autobus +
                ", Klienci=" + Klienci +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Przejazd przejazd = (Przejazd) o;

        return PrzejazdID == przejazd.PrzejazdID;
    }

    @Override
    public int hashCode() {
        return (int) (PrzejazdID ^ (PrzejazdID >>> 32));
    }
}