package com.jep.esb.wsvalidacionesexistencia.routes;

import com.jep.esb.wsvalidacionesexistencia.model.GestionExpedienteService;
import com.jep.esb.wsvalidacionesexistencia.model.GestionExpedienteValidarRequets;
import com.jep.esb.wsvalidacionesexistencia.model.GestionExpedienteValidarResponse;
import com.jep.esb.wsvalidacionesexistencia.model.ValidacionDto;
import com.jep.esb.wsvalidacionesexistencia.properties.SoapProducer;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.common.DataFormat;
import org.apache.camel.component.cxf.jaxws.CxfEndpoint;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.http.base.HttpOperationFailedException;
import org.apache.camel.support.jsse.KeyStoreParameters;
import org.apache.camel.support.jsse.SSLContextParameters;
import org.apache.camel.support.jsse.TrustManagersParameters;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.wsdl.WSDLException;
import javax.xml.bind.JAXBContext;
import javax.xml.ws.http.HTTPException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;

@ApplicationScoped
public class SoapProducerRoute extends RouteBuilder {



    @Inject
    private SoapProducer soapProducer;


    @Override
    public void configure() throws Exception {

        JAXBContext jaxbContext = JAXBContext.newInstance(ValidacionDto.class);

        onException(HTTPException.class).handled(true)
                .maximumRedeliveries(3)
                .redeliveryDelay(2000)
                .log(LoggingLevel.ERROR, "WS-04 La comunicación por protocolo HTTP al destino ha fallado presenta errores en la ruta ${routeId}")
                .log(LoggingLevel.ERROR, "ExceptionClass: ${exchangeProperty.CamelExceptionCaught.class}")
                .log(LoggingLevel.ERROR, "StackTrace: ${exception.stacktrace}")
                .end();

        /*
         * @exception ConnectException: el host de destino no ha sido alcanzado presenta errores de conexión
         */
        onException(ConnectException.class).handled(true)
                .maximumRedeliveries(3)
                .redeliveryDelay(2000)
                .log(LoggingLevel.ERROR, "TRV-01 El host de destino no ha sido alcanzado presenta errores de conexión en la ruta ${routeId}")
                .log(LoggingLevel.ERROR, "ExceptionClass: ${exchangeProperty.CamelExceptionCaught.class}")
                .log(LoggingLevel.ERROR, "StackTrace: ${exception.stacktrace}")
                .end();

        onException(WSDLException.class).handled(true)
                .log(LoggingLevel.ERROR, "WS-05 La estrucutura del archivo wsdl presenta errores en la ruta ${routeId}")
                .log(LoggingLevel.ERROR, "ExceptionClass: ${exchangeProperty.CamelExceptionCaught.class}")
                .log(LoggingLevel.ERROR, "StackTrace: ${exception.stacktrace}")
                .end();

        /*
         * @exception NullPointerException: la estructura del mensaje a procesar presenta errores
         */
        onException(NullPointerException.class).handled(true)
                .log(LoggingLevel.ERROR, "TRV-02 La estructura del mensaje a procesar presenta errores en la ruta ${routeId}")
                .log(LoggingLevel.ERROR, "ExceptionClass: ${exchangeProperty.CamelExceptionCaught.class}")
                .log(LoggingLevel.ERROR, "StackTrace: ${exception.stacktrace}")
                .end();

        onException(SocketTimeoutException.class).handled(true)
                .maximumRedeliveries(3)
                .redeliveryDelay(2000)
                .log(LoggingLevel.ERROR, "TRV-04 El tiempo de espera al host de destino se ha agotado presenta errores de conexi�n en la ruta ${routeId}")
                .log(LoggingLevel.ERROR, "ExceptionClass: ${exchangeProperty.CamelExceptionCaught.class}")
                .log(LoggingLevel.ERROR, "StackTrace: ${exception.stacktrace}")
                .end();

        // Excepcion de codigos de error http
        onException(HttpOperationFailedException.class).handled(true)
                .log(LoggingLevel.ERROR, "Error HTTP handled: ${exception.message}")
                .log(LoggingLevel.ERROR, "Response body: ${exception.responseBody}")
                .end();

        TrustManagersParameters trustManagersParameters = new TrustManagersParameters();
        KeyStoreParameters keyStoreParameters = new KeyStoreParameters();
        keyStoreParameters.setResource("keystore.jks");
        keyStoreParameters.setPassword(soapProducer.getKeyCert());
        trustManagersParameters.setKeyStore(keyStoreParameters);
        SSLContextParameters sslContextParameters = new SSLContextParameters();
        sslContextParameters.setTrustManagers(trustManagersParameters);

        CxfEndpoint cxf = new CxfEndpoint();
        cxf.setServiceClass(GestionExpedienteService.class);
        cxf.setDataFormat(DataFormat.RAW);
        cxf.setMtomEnabled(true);
        cxf.setAddress("/");
        cxf.setCamelContext(getCamelContext());

        CxfEndpoint result = new CxfEndpoint();
        result.setServiceClass(GestionExpedienteValidarResponse.class);
        result.setDataFormat(DataFormat.RAW);
        result.setMtomEnabled(true);
        result.setAddress(soapProducer.getUrlSoapProducer());
        result.setSslContextParameters(sslContextParameters);
        result.setCamelContext(getCamelContext());


        from(cxf)
                .setProperty("request",body())
                .setHeader("Content-Type",simple("text/xml;charset=UTF-8"))
                .to("xslt:cleanNamespaces.xsl")
                .log(LoggingLevel.INFO, "Se inicia ruta ws-validaciones-existencia")
                .log(LoggingLevel.DEBUG, "Consumo exitoso ::: ${body}")
                .setBody(xpath("/Envelope/Body/*"))
                .convertBodyTo(String.class)
                .unmarshal(new JaxbDataFormat(jaxbContext))
                .log(LoggingLevel.INFO,"${body.class}")
                .to("bean-validator://x")
                .log(LoggingLevel.INFO, "Se consume servicio al webService ::: " + soapProducer.getUrlSoapProducer())
                .setBody(simple("${exchangeProperty.request}"))
                .to(result)
                .log(LoggingLevel.INFO, "Se envia body al productor")
        .end();
    }
}
