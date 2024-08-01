package by.zeus.demo.payment.creditcard.web.dto;

import by.zeus.demo.base.web.dto.BaseDTO;

public class StateDTO extends BaseDTO {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    Long Id;
}
