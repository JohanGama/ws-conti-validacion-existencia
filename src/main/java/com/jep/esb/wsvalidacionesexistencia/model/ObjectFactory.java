
package com.jep.esb.wsvalidacionesexistencia.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the co.com.servisoft.mercurio.servicios package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {
    private final static QName _ValidacionExistencia_QNAME = new QName("http://servicios.mercurio.servisoft.com.co/", "validacionExistencia");
    private final static QName _ValidacionExistenciaResponse_QNAME = new QName("http://servicios.mercurio.servisoft.com.co/", "validacionExistenciaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.com.servisoft.mercurio.servicios
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ValidacionExistencia }
     * 
     */
    public ValidacionExistencia createValidacionExistencia() {
        return new ValidacionExistencia();
    }

    /**
     * Create an instance of {@link ValidacionExistenciaResponse }
     * 
     */
    public ValidacionExistenciaResponse createValidacionExistenciaResponse() {
        return new ValidacionExistenciaResponse();
    }

    /**
     * Create an instance of {@link GestionExpedienteValidarRequets }
     * 
     */
    public GestionExpedienteValidarRequets createGestionExpedienteValidarRequets() {
        return new GestionExpedienteValidarRequets();
    }

    /**
     * Create an instance of {@link GestionExpedienteValidarResponse }
     * 
     */
    public GestionExpedienteValidarResponse createGestionExpedienteValidarResponse() {
        return new GestionExpedienteValidarResponse();
    }
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidacionExistencia }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ValidacionExistencia }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicios.mercurio.servisoft.com.co/", name = "validacionExistenciaExpediente")
    public JAXBElement<ValidacionExistencia> createValidacionExistencia(ValidacionExistencia value) {
        return new JAXBElement<ValidacionExistencia>(_ValidacionExistencia_QNAME, ValidacionExistencia.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidacionExistenciaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ValidacionExistenciaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicios.mercurio.servisoft.com.co/", name = "validacionExistenciaResponseExpediente")
    public JAXBElement<ValidacionExistenciaResponse> createValidacionExistenciaResponse(ValidacionExistenciaResponse value) {
        return new JAXBElement<ValidacionExistenciaResponse>(_ValidacionExistenciaResponse_QNAME, ValidacionExistenciaResponse.class, null, value);
    }

}
