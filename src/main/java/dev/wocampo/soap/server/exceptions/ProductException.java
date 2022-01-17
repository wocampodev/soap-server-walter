package dev.wocampo.soap.server.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.wocampo.soap.server.enumerations.SoapStatus;

public final class ProductException extends ServiceFaultException {

    public static final String NAMESPACE_URI = "http://www.wocampo.dev/soap/server/webservice/exception";
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductException.class);

    public ProductException(String message) {
        super(message, SoapStatus.FAIL.getStatus());
        LOGGER.warn(message);
    }

}
