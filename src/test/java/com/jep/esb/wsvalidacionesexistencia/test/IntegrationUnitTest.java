package com.jep.esb.test;

import javax.inject.Inject;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.AdviceWith;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.support.DefaultExchange;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@QuarkusTest
@TestInstance(Lifecycle.PER_CLASS)
public class IntegrationUnitTest {
/*
    @Inject
    CamelContext context;

    @Inject
    ProducerTemplate template;

    private String startRouteId = "transformationRoute";
    private String startEndpoint = "direct:transformationRoute";
    private String endEndpointTest = "mock:transformationRouteTest";

    @BeforeAll
    public void configureRoute() throws Exception {
        AdviceWith.adviceWith(context, startRouteId, a -> {
            a.weaveAddFirst().to(endEndpointTest);
            a.weaveByToUri(endEndpointTest).after().stop();
        });
    }

    @Test
    public void successTest() throws Exception {
        template.sendBody(startEndpoint, "Hello World");
        MockEndpoint mockEndpoint = context.getEndpoint(endEndpointTest, MockEndpoint.class);
        mockEndpoint.setExpectedCount(1);
        mockEndpoint.assertIsSatisfied();
    }

    @Test
    public void failedTest() throws Exception {
        AdviceWith.adviceWith(context, startRouteId, a -> {
            a.weaveAddLast().throwException(NullPointerException.class, "generated test");
        });
        Exchange exchange = new DefaultExchange(context, ExchangePattern.InOut);
        exchange.getIn().setBody("HelloWorld");
        exchange = template.send(startEndpoint, exchange);
    }
*/
}