package com.fly.company.flyCompanySearch.repository.util;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class MultiDateDeserializer extends StdDeserializer<LocalDateTime> {

	private static final long serialVersionUID = 1L;

	private static final String[] DATE_FORMATS = new String[] {
        "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSXXX",
        "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS",
        "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSS",
        "yyyy-MM-dd'T'HH:mm:ss.SSSSSSS",
        "yyyy-MM-dd'T'HH:mm:ss.SSSSSS",
        "yyyy-MM-dd'T'HH:mm:ss.SSSSS",
        "yyyy-MM-dd'T'HH:mm:ss.SSSS",
        "yyyy-MM-dd'T'HH:mm:ss.SSS",
        "yyyy-MM-dd'T'HH:mm:ss.SS",
        "yyyy-MM-dd'T'HH:mm:ss.S",
    	"yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX",
    	"yyyy-MM-dd'T'HH:mm:ss.SSSSSXXX",
    	"yyyy-MM-dd'T'HH:mm:ss.SSSSXXX",
    	"yyyy-MM-dd'T'HH:mm:ss.SSSXXX",
    	"yyyy-MM-dd'T'HH:mm:ss.SSXXX",
    	"yyyy-MM-dd'T'HH:mm:ss.SXXX",
        "yyyy-MM-dd'T'HH:mm:ssXXX",
        "yyyy-MM-dd'T'HH:mm:ss",
        "yyyy-MM-dd HH:mm:ss",
        "yyyy-MM-dd'T'HH:mm",
        "yyyy-MM-dd"
    };

    public MultiDateDeserializer() {
        this(null);
    }

    public MultiDateDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public LocalDateTime deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        String date = node.textValue();

		if (date.length() == 10)
			date = date + "T00:00";
        
        for (String DATE_FORMAT : DATE_FORMATS) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
                return  LocalDateTime.parse(date, formatter);
            } catch (Exception e) {
            }
        }
        throw new JsonParseException(jp, "Unparseable date: \"" + date + "\". Supported formats: " + Arrays.toString(DATE_FORMATS));
    }
}