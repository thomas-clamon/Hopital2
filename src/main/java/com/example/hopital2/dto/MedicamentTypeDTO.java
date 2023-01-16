package com.example.hopital2.dto;

import jakarta.persistence.criteria.CriteriaBuilder;

public class MedicamentTypeDTO {

    private Integer cachet;

    private Integer piqure;

    private Integer pommade;

    private Integer sirop;

    public Integer getSirop() {
        return sirop;
    }

    public void setSirop(Integer sirop) {
        this.sirop = sirop;
    }

    public Integer getCachet() {
        return cachet;
    }

    public void setCachet(Integer cachet) {
        this.cachet = cachet;
    }

    public Integer getPiqure() {
        return piqure;
    }

    public void setPiqure(Integer piqure) {
        this.piqure = piqure;
    }

    public Integer getPommade() {
        return pommade;
    }

    public void setPommade(Integer pommade) {
        this.pommade = pommade;
    }
}
