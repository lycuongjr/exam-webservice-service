package example;
import example.service.EmplyeeService;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService()
public class HelloWorld {
  @WebMethod
  public String sayHelloWorldFrom(String from) {
    String result = "Hello, world, from " + from;
    System.out.println(result);
    return result;
  }
  public static void main(String[] argv) {
    String employeeService = "http://localhost:9000/employee-service";
    Endpoint.publish(employeeService, new EmplyeeService());
  }

}
