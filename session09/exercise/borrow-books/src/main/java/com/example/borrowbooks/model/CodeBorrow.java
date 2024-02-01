package com.example.borrowbooks.model;

import jakarta.persistence.AttributeConverter;

import java.util.Arrays;
import java.util.List;

public class CodeBorrow implements AttributeConverter<List<String>, String> {
    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        return attribute != null ? String.join(", ", attribute) : null;
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        String[] list = dbData.split(", ");
        return Arrays.asList(list);
    }
}
