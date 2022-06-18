package pl.polsl.autobusy.entities;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

/**
 * Klasa zawierająca informacje detaliczne o Autobusie
 * @author Kacper Nitkiewicz
 * @version  1.1
 *
 */

@Entity
@Table(name = "Autobusy")
public class Autobus{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long AutobusID;
    private int Numer;
    private String NumerRejestracyjny;
    private int LiczbaMiejsc;
    private boolean CzySprawny;

    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,orphanRemoval=true)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Przejazd> Przejazdy;

    public long getAutobusID() {
        return AutobusID;
    }

    public void setAutobusID(long autobusID) {
        this.AutobusID = autobusID;
    }

    public int getNumer() {
        return Numer;
    }

    public void setNumer(int numer) {
        Numer = numer;
    }

    public String getNumerRejestracyjny() {
        return NumerRejestracyjny;
    }

    public void setNumerRejestracyjny(String numerRejestracyjny) {
        NumerRejestracyjny = numerRejestracyjny;
    }

    public int getLiczbaMiejsc() {
        return LiczbaMiejsc;
    }

    public void setLiczbaMiejsc(int liczbaMiejsc) {
        LiczbaMiejsc = liczbaMiejsc;
    }

    public boolean isCzySprawny() {
        return CzySprawny;
    }

    public void setCzySprawny(boolean czySprawny) {
        CzySprawny = czySprawny;
    }

    public List<Przejazd> getPrzejazdy() {
        return Przejazdy;
    }

    public void setPrzejazdy(List<Przejazd> przejazdy) {
        Przejazdy = przejazdy;
    }

    @Override
    public String toString() {
        return "Autobus{" +
                "ID=" + AutobusID +
                ", Numer=" + Numer +
                ", NumerRejestracyjny='" + NumerRejestracyjny + '\'' +
                ", LiczbaMiejsc=" + LiczbaMiejsc +
                ", CzySprawny=" + CzySprawny +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Autobus autobus = (Autobus) o;

        return AutobusID == autobus.AutobusID;
    }

    @Override
    public int hashCode() {
        return (int) (AutobusID ^ (AutobusID >>> 32));
    }
}