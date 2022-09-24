package com.sample.carmarket.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum StatusValues implements EnumClass<Integer> {

    IN_STOCK(10),
    SOLD(20);

    private Integer id;

    StatusValues(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static StatusValues fromId(Integer id) {
        for (StatusValues at : StatusValues.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}