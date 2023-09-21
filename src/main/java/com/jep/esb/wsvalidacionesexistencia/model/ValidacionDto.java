package com.jep.esb.wsvalidacionesexistencia.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name="validacionExistencia",namespace = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class ValidacionDto implements Serializable {

    @NotNull
    @XmlElement(name="body")
    @Valid
    protected GestionExpedienteValidacionRequestDto body;

    public GestionExpedienteValidacionRequestDto getBody() {
        return body;
    }

    public void setBody(GestionExpedienteValidacionRequestDto body) {
        this.body = body;
    }
}
