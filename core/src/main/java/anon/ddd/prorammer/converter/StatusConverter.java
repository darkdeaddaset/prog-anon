package anon.ddd.prorammer.converter;

import anon.ddd.prorammer.enums.Status;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status, String> {

    @Override
    public String convertToDatabaseColumn(Status status) {
        if (status == null) {
            throw new RuntimeException("Невозможно смапить статус");
        }
        return status.getStatusName();
    }

    @Override
    public Status convertToEntityAttribute(String s) {
        if (s == null) {
            throw new RuntimeException("Невозможно смапить строку");
        }

        return Stream.of(Status.values())
                .filter(status -> status.getStatusName().equals(s))
                .findFirst()
                .orElseThrow(()-> new RuntimeException("Ошибка конвертации"));
    }
}
