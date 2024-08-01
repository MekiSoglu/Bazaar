package by.zeus.demo.payment.creditcard.domain;

import by.zeus.demo.base.domain.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "entity")
public class StateEntity extends BaseEntity {
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private CountryEntity countryEntity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CountryEntity getCountry() {
        return countryEntity;
    }

    public void setCountry(CountryEntity countryEntity) {
        this.countryEntity = countryEntity;
    }
}
