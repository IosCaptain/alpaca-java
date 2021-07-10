package net.jacobpeterson.alpaca.refactor.util.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDate;
import java.time.ZonedDateTime;

/**
 * {@link GsonUtil} contains utility methods relating to {@link Gson}.
 */
public class GsonUtil {

    /** A {@link Gson} instance with registered date/time adapters. */
    public static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeAdapter())
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .enableComplexMapKeySerialization()
            .setLenient()
            .create();
}
