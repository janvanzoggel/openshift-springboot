import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import hello.wsdl.GetQuote;
import hello.wsdl.GetQuoteResponse;

@RestController
public class HelloWildFlyController extends WebServiceGatewaySupport
{
    @RequestMapping("hello")
    public String sayHello()
    {
        return ("Hi, this is SpringBoot on WildFly with OpenShift S2I");
    }

    @RequestMapping("soap")
    public GetQuoteResponse sayHello2()
    {
        GetQuote request = new GetQuote();
        String ticker = "MSFT";
        request.setSymbol(ticker);

        // log.info("Requesting quote for " + ticker);

        GetQuoteResponse response = (GetQuoteResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://www.webservicex.com/stockquote.asmx",
                        request,
                        new SoapActionCallback("http://www.webserviceX.NET/GetQuote"));

        return response;
    }

}