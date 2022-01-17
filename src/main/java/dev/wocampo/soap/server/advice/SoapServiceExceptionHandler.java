package dev.wocampo.soap.server.advice;

import javax.xml.namespace.QName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.SoapFaultDetail;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;

import dev.wocampo.soap.server.enumerations.SoapStatus;
import dev.wocampo.soap.server.exceptions.ServiceFaultException;
import dev.wocampo.soap.server.webservice.ServiceStatus;

public class SoapServiceExceptionHandler extends SoapFaultMappingExceptionResolver {

    private static final QName CODE = new QName("code");
    private static final QName MESSAGE = new QName("message");
    private static final Logger LOGGER = LoggerFactory.getLogger(SoapServiceExceptionHandler.class);

    @Override
    protected void customizeFault(Object endpoint, Exception ex, SoapFault fault) {
        SoapFaultDetail detail = fault.addFaultDetail();
        if (ex instanceof ServiceFaultException) {
            ServiceStatus serviceStatus = ((ServiceFaultException) ex).getServiceStatus();
            detail.addFaultDetailElement(CODE).addText(serviceStatus.getCode());
            detail.addFaultDetailElement(MESSAGE).addText(serviceStatus.getMessage());
        } else {
            LOGGER.error(ex.getMessage());
            detail.addFaultDetailElement(CODE).addText(SoapStatus.INTERNAL_ERROR.getStatus().getCode());
            detail.addFaultDetailElement(MESSAGE).addText(SoapStatus.INTERNAL_ERROR.getStatus().getMessage());
        }
    }

}
