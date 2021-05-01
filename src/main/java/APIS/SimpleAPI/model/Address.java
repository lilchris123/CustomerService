package APIS.SimpleAPI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue
    @Column(name = "address_id")
    private int id;
    @Column
    private String address;
    @Column
    private String address2;
    @Column
    private String district;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    @Column(name = "postal_code")
    private int zipCode;
    @Column
    private long phone;

    public Address(String address, String address2, String district, City city, int zipCode, long phone) {
        this.address = address;
        this.address2 = address2;
        this.district = district;
        this.city = city;
        this.zipCode = zipCode;
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }


}
