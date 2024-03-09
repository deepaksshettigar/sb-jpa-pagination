package com.arcadia.splitrun.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;

public class JsonNodeConverter implements AttributeConverter<JsonNode, String> {

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public String convertToDatabaseColumn(JsonNode attribute) {
    if (attribute == null) {
      return null;
    }
    try {
      return objectMapper.writeValueAsString(attribute);
    } catch (Exception e) {
      throw new IllegalArgumentException("Error converting JsonNode to JSON string", e);
    }
  }

  @Override
  public JsonNode convertToEntityAttribute(String dbData) {
    if (dbData == null) {
      return null;
    }
    try {
      return objectMapper.readTree(dbData);
    } catch (Exception e) {
      throw new IllegalArgumentException("Error converting JSON string to JsonNode", e);
    }
  }
}
