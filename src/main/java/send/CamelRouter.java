package send;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelRouter extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("direct:routeOne").to("stream:out"); // output to console
		
		from("direct:routeTwo").to("rabbitmq://localhost/exchangeName?queue=myQueue"); // output to rabbit mq
	}

}
