package APIS.SimpleAPI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue
    @Column(name = "store_id")
    private int id;
    @Column(name = "manager_staff_id")
    private int managerId;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @Column(name = "last_update")
    private String lastUpdate;

    public Store(int managerId, Address address, String lastUpdate) {
        this.managerId = managerId;
        this.address = address;
        this.lastUpdate = lastUpdate;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getId() {
        return id;
    }


}
