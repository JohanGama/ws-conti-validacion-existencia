package com.jep.esb.wsvalidacionesexistencia.properties;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "soap.producer")
public interface SoapProducer {

    String getUrlSoapProducer();
    String getKeyCert();

}
