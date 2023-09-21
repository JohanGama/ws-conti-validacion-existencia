package com.jep.esb.wsvalidacionesexistencia.transformations;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.apache.camel.Exchange;

import io.quarkus.logging.Log;
import io.quarkus.runtime.annotations.RegisterForReflection;

@ApplicationScoped
@Named("transformationComponent")
@RegisterForReflection
public class TransformationComponent {

    public void transform(Exchange ex) {
        Log.info("transform using bean");
    }
}