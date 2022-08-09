package com.jianpiao.api.model.entity.converter;

import javax.persistence.AttributeConverter;
import java.sql.Time;

public class StringToTimeConverter implements AttributeConverter<String, Time> {
    @Override
    public Time convertToDatabaseColumn(String attribute) {
        return Time.valueOf(attribute);
    }

    @Override
    public String convertToEntityAttribute(Time time) {
        return time.toString().substring(0,time.toString().lastIndexOf(':'));
    }
}
