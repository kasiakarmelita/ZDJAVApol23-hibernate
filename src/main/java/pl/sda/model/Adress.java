package pl.sda.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Adress {
    @Column(name = "street")
    private String street;

    @Column (name = "house_number")
    private int houseNumber;

    @Column (name = "city")
    private String city;

    @Column (name = "postcode")
    private String postcode;

    public Adress(String street, int houseNumber, String city, String postcode) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.city = city;
        this.postcode = postcode;
    }

    public Adress() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adress adress = (Adress) o;
        return Objects.equals(street, adress.street) &&
                Objects.equals(houseNumber, adress.houseNumber) &&
                Objects.equals(city, adress.city) &&
                Objects.equals(postcode, adress.postcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, houseNumber, city, postcode);
    }

    @Override
    public String toString() {
        return "Adress{" +
                "street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", city='" + city + '\'' +
                ", postcode='" + postcode + '\'' +
                '}';
    }
}
