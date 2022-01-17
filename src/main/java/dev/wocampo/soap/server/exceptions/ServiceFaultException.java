package dev.wocampo.soap.server.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.wocampo.soap.server.webservice.ServiceStatus;

public class ServiceFaultException extends RuntimeException {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceFaultException.class);

    private ServiceStatus serviceStatus;

    public ServiceFaultException(String message, ServiceStatus serviceStatus) {
        super(message);
        this.serviceStatus = serviceStatus;
    }

    public ServiceFaultException(String message, Throwable e, ServiceStatus serviceStatus) {
        super(message, e);
        this.serviceStatus = serviceStatus;
        LOGGER.warn(message);
    }

    public ServiceStatus getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(ServiceStatus serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

}
