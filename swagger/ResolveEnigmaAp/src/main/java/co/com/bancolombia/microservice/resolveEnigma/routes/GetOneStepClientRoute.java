package co.com.bancolombia.microservice.resolveEnigma.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class GetOneStepClientRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		from("direct:get-step-one")
		.setHeader(Exchange.HTTP_METHOD, constant("POST"))
		.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
		.to("http4://localhost:8080/v1/getOneEnigma/getStep");
		
	}

}
