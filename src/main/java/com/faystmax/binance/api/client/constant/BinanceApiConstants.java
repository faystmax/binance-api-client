package com.faystmax.binance.api.client.constant;

/**
 * Constants used throughout Binance's API
 */
public class BinanceApiConstants {
    /**
     * Base Binance Api url
     */
    public static final String BASE_URL = "https://api.binance.com/";

    /**
     * HTTP Header to be used for API-KEY authentication
     */
    public static final String API_KEY_HEADER = "X-MBX-APIKEY";

    /**
     * Decorator to indicate that an endpoint requires a signature
     */
    public static final String ENDPOINT_SECURITY_TYPE_SIGNED = "SIGNED";
    public static final String ENDPOINT_SECURITY_TYPE_SIGNED_HEADER = ENDPOINT_SECURITY_TYPE_SIGNED + ": #";

    /**
     * Default receiving window.
     */
    public static final long DEFAULT_RECEIVING_WINDOW = 60_000L;
}
