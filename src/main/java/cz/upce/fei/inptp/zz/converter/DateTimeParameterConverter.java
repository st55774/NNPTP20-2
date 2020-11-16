package cz.upce.fei.inptp.zz.converter;

import com.beust.jcommander.IStringConverter;
import cz.upce.fei.inptp.zz.entity.Parameter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Converter from text to @{@link Parameter.DateTimeParameter}.
 *
 * */
public class DateTimeParameterConverter implements IStringConverter<Parameter.DateTimeParameter> {
    private static final DateTimeFormatter DATE_PARSER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    @Override
    public Parameter.DateTimeParameter convert(String dateTime) {
        return new Parameter.DateTimeParameter(LocalDateTime.parse(dateTime, DATE_PARSER));
    }
}
