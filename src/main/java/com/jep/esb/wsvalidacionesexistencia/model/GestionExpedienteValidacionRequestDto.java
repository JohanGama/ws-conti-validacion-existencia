package com.jep.esb.wsvalidacionesexistencia.model;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name="body",namespace = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class GestionExpedienteValidacionRequestDto implements Serializable {

    @NotNull
    @XmlElement(name="clave")
    private String clave;

    @NotNull
    @NotBlank
    @NotEmpty
    @XmlElement(name="idExpediente")
    private String idExpediente;

    @NotNull
    @NotBlank
    @NotEmpty
    @XmlElement(name="idUsuario")
    private String idUsuario;


    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(String idExpediente) {
        this.idExpediente = idExpediente;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
}
