package dev.wocampo.soap.server.enumerations;

import dev.wocampo.soap.server.webservice.ServiceStatus;

public enum SoapStatus {

    OK("0001", "Proceso exitoso."), FAIL("0002", "Proceso fallido."),
    INTERNAL_ERROR("0003", "Problemas con el servicio."),
    NOT_FOUND("0003", "El recurso no existe.");

    private final ServiceStatus status;

    SoapStatus(String code, String message) {
        status = new ServiceStatus();
        this.status.setCode(code);
        this.status.setMessage(message);
    }

    public ServiceStatus getStatus() {
        return status;
    }

}
