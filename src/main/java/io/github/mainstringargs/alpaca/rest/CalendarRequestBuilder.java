package io.github.mainstringargs.alpaca.rest;

/**
 * The Class CalendarUrlBuilder.
 */
public class CalendarUrlBuilder extends AlpacaUrlBuilder {



  /** The Constant CALENDAR_ENDPOINT. */
  public final static String CALENDAR_ENDPOINT = "calendar";



  /**
   * Instantiates a new calendar url builder.
   *
   * @param baseUrl the base url
   */
  public CalendarUrlBuilder(String baseUrl) {
    super(baseUrl);
  }

  /*
   * (non-Javadoc)
   * 
   * @see io.github.mainstringargs.alpaca.rest.AlpacaUrlBuilder#endpoint()
   */
  @Override
  public String getEndpoint() {
    return CALENDAR_ENDPOINT;
  }


}