import hello.wsdl.GetQuoteResponse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    CommandLineRunner lookup(QuoteClient quoteClient) {
        return args -> {
            String ticker = "MSFT";

            if (args.length > 0) {
                ticker = args[0];
            }
            GetQuoteResponse response = quoteClient.getQuote(ticker);
            System.err.println(response.getGetQuoteResult());
        };
    }

}