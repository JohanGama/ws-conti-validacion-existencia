
package com.jep.esb.wsvalidacionesexistencia.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para validacionExistencia complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="validacionExistencia"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="body" type="{http://servicios.mercurio.servisoft.com.co/}gestionExpedienteValidarRequets" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "validacionExistenciaExpediente", propOrder = {
    "body"
})
public class ValidacionExistencia {

    protected GestionExpedienteValidarRequets body;

    /**
     * Obtiene el valor de la propiedad body.
     * 
     * @return
     *     possible object is
     *     {@link GestionExpedienteValidarRequets }
     *     
     */
    public GestionExpedienteValidarRequets getBody() {
        return body;
    }

    /**
     * Define el valor de la propiedad body.
     * 
     * @param value
     *     allowed object is
     *     {@link GestionExpedienteValidarRequets }
     *     
     */
    public void setBody(GestionExpedienteValidarRequets value) {
        this.body = value;
    }

}
