import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("hello")
public class Resource {

    @GET
    public String getHello(){
        return "Hello from resource!";
    }

}
