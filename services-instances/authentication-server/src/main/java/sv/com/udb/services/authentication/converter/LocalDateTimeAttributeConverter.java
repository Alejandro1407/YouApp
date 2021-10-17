package sv.com.udb.services.authentication.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter
      implements AttributeConverter<LocalDateTime, Timestamp> {
   @Override
   public Timestamp convertToDatabaseColumn(LocalDateTime attribute) {
      return attribute == null ? null : Timestamp.valueOf(attribute);
   }

   @Override
   public LocalDateTime convertToEntityAttribute(Timestamp dbData) {
      return dbData == null ? null : dbData.toLocalDateTime();
   }
}
