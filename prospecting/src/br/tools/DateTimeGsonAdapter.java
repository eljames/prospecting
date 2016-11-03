package br.tools;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import br.prospecting.datetime.DateTimePatternedFormat;

public class DateTimeGsonAdapter implements JsonSerializer<LocalDateTime> {

	@Override
	public JsonElement serialize(LocalDateTime dateTime, Type arg1, JsonSerializationContext arg2) {
		return new JsonPrimitive(DateTimePatternedFormat.get().format(dateTime));
	}

}
