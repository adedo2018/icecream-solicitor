package com.example.lta.demo.domain;

import javax.persistence.Id;
import javax.persistence.*;
import java.util.Objects;


@Entity
public class Solicitor {

    @Id
    private Long id;
    private String name;

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private boolean flag;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="address_id", unique= true, nullable=true, insertable=true, updatable=true)
    private Address address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solicitor)) return false;
        Solicitor solicitor = (Solicitor) o;
        return flag == solicitor.flag &&
                Objects.equals(id, solicitor.id) &&
                Objects.equals(name, solicitor.name) &&
                Objects.equals(address, solicitor.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, flag, address);
    }

    @Override
    public String toString() {
        return "Solicitor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", flag=" + flag +
                ", address=" + address +
                '}';
    }
}
