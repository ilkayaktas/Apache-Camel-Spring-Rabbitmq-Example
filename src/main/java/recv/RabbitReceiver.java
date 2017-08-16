package recv;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.stereotype.Component;

@Component
public class RabbitReceiver {
	public static void main(String args[]) throws Exception {

        CamelContext context = new DefaultCamelContext();

        context.addRoutes(new RouteBuilder() {
            public void configure() {
                from("rabbitmq://localhost/exchangeName?queue=myQueue").to("stream:out"); // receive from rabbitmq and output to console
            }
        });
        
        context.start();
    }
}
