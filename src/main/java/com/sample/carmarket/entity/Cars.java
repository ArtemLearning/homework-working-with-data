package com.sample.carmarket.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;

@JmixEntity
@Table(name = "CARS", indexes = {
        @Index(name = "IDX_CARS_UNQ", columnList = "REGISTRATION_NUMBER", unique = true),
        @Index(name = "IDX_CARS_MODEL", columnList = "MODEL")
})
@Entity
public class Cars {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Size(message = "{msg://com.sample.carmarket.entity/Cars.registrationNumber.validation.Size}", min = 6, max = 6)
    @InstanceName
    @Column(name = "REGISTRATION_NUMBER", nullable = false, length = 6)
    @NotNull
    private String registrationNumber;

    @Max(message = "{msg://com.sample.carmarket.entity/Cars.productionYear.validation.Max}", value = 2030)
    @Min(message = "{msg://com.sample.carmarket.entity/Cars.productionYear.validation.Min}", value = 1990)
    @Column(name = "PRODUCTION_YEAR")
    private Integer productionYear;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "DATE_OF_SALE")
    private LocalDate dateOfSale;

    @JoinColumn(name = "MODEL")
    @ManyToOne(fetch = FetchType.LAZY)
    private Model model;

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public LocalDate getDateOfSale() {
        return dateOfSale;
    }

    public void setDateOfSale(LocalDate dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    public StatusValues getStatus() {
        return status == null ? null : StatusValues.fromId(status);
    }

    public void setStatus(StatusValues status) {
        this.status = status == null ? null : status.getId();
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}