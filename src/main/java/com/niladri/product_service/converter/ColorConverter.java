package com.niladri.product_service.converter;

import com.niladri.product_service.entity.COLORS;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ColorConverter implements AttributeConverter<COLORS, String> {

    @Override
    public String convertToDatabaseColumn(COLORS color) {
        return color != null ? color.getColor() : null;
    }

    @Override
    public COLORS convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;
        
        for (COLORS color : COLORS.values()) {
            if (color.getColor().equals(dbData)) {
                return color;
            }
        }
        throw new IllegalArgumentException("Unknown color: " + dbData);
    }
}