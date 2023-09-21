
package com.jep.esb.wsvalidacionesexistencia.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para validacionExistenciaResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="validacionExistenciaResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://servicios.mercurio.servisoft.com.co/}gestionExpedienteValidarResponse" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "validacionExistenciaResponseExpediente", propOrder = {
    "_return"
})
public class ValidacionExistenciaResponse {

    @XmlElement(name = "return")
    protected GestionExpedienteValidarResponse _return;

    /**
     * Obtiene el valor de la propiedad return.
     * 
     * @return
     *     possible object is
     *     {@link GestionExpedienteValidarResponse }
     *     
     */
    public GestionExpedienteValidarResponse getReturn() {
        return _return;
    }

    /**
     * Define el valor de la propiedad return.
     * 
     * @param value
     *     allowed object is
     *     {@link GestionExpedienteValidarResponse }
     *     
     */
    public void setReturn(GestionExpedienteValidarResponse value) {
        this._return = value;
    }

}
