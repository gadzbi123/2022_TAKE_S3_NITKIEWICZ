package pl.polsl.autobusy.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Klasa zawierająca informacje o trasie autobusowej
 * @author Kacper Nitkiewicz
 * @version  1.1
 *
 */
@Entity
public class Trasa{
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private long TrasaID;
    private String MiastoPoczatkowe;
    private String MiastoKoncowe;
    private float DystansKM;

    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,orphanRemoval=true)
    private List<Przejazd> Przejazdy;

    public float obliczRentownoscTrasy() {
        return 0.0f;
    }

    public long getTrasaID() {
        return TrasaID;
    }

    public void setTrasaID(long trasaID) {
        this.TrasaID = trasaID;
    }

    public String getMiastoPoczatkowe() {
        return MiastoPoczatkowe;
    }

    public void setMiastoPoczatkowe(String miastoPoczatkowe) {
        MiastoPoczatkowe = miastoPoczatkowe;
    }

    public String getMiastoKoncowe() {
        return MiastoKoncowe;
    }

    public void setMiastoKoncowe(String miastoKoncowe) {
        MiastoKoncowe = miastoKoncowe;
    }

    public float getDystansKM() {
        return DystansKM;
    }

    public void setDystansKM(float dystansKM) {
        DystansKM = dystansKM;
    }

    public List<Przejazd> getPrzejazdy() {
        return Przejazdy;
    }

    public void setPrzejazdy(List<Przejazd> przejazdy) {
        Przejazdy = przejazdy;
    }

    @Override
    public String toString() {
        return "Trasa{" +
                "ID=" + TrasaID +
                ", MiastoPoczatkowe='" + MiastoPoczatkowe + '\'' +
                ", MiastoKoncowe='" + MiastoKoncowe + '\'' +
                ", DystansKM=" + DystansKM +
                ", Przejazdy=" + Przejazdy +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trasa trasa = (Trasa) o;

        return TrasaID == trasa.TrasaID;
    }

    @Override
    public int hashCode() {
        return (int) (TrasaID ^ (TrasaID >>> 32));
    }
}