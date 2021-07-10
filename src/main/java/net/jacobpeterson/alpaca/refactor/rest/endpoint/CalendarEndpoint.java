package net.jacobpeterson.alpaca.refactor.rest.endpoint;

import com.google.gson.reflect.TypeToken;
import net.jacobpeterson.alpaca.model.endpoint.calendar.Calendar;
import net.jacobpeterson.alpaca.refactor.rest.AlpacaClient;
import net.jacobpeterson.alpaca.refactor.rest.AlpacaClientException;
import okhttp3.HttpUrl;
import okhttp3.Request;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * {@link AbstractEndpoint} for <a href="https://docs.alpaca.markets/api-documentation/api-v2/calendar/">Calendar</a>.
 */
public class CalendarEndpoint extends AbstractEndpoint {

    /**
     * Instantiates a new {@link CalendarEndpoint}.
     *
     * @param alpacaClient the {@link AlpacaClient}
     */
    public CalendarEndpoint(AlpacaClient alpacaClient) {
        super(alpacaClient, "calendar");
    }

    /**
     * Returns the market {@link Calendar} from 1970 to 2029.
     *
     * @return a {@link List} of {@link Calendar}s
     *
     * @throws AlpacaClientException thrown for {@link AlpacaClientException}s
     */
    public List<Calendar> get() throws AlpacaClientException {
        return get(null, null);
    }

    /**
     * Returns the market {@link Calendar}.
     *
     * @param start the first date to retrieve data for (inclusive)
     * @param end   the last date to retrieve data for (inclusive)
     *
     * @return a {@link List} of {@link Calendar}s
     *
     * @throws AlpacaClientException thrown for {@link AlpacaClientException}s
     */
    public List<Calendar> get(LocalDate start, LocalDate end) throws AlpacaClientException {
        HttpUrl.Builder urlBuilder = alpacaClient.urlBuilder()
                .addPathSegment(endpointPathSegment);

        if (start != null) {
            urlBuilder.addQueryParameter("start", start.format(DateTimeFormatter.ISO_DATE));
        }

        if (end != null) {
            urlBuilder.addQueryParameter("end", end.format(DateTimeFormatter.ISO_DATE));
        }

        Request request = alpacaClient.requestBuilder(urlBuilder.build())
                .get()
                .build();
        return alpacaClient.requestObject(request, new TypeToken<ArrayList<Calendar>>() {}.getType());
    }
}
