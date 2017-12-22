package vista;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.StaticHttpHandler;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * Main class.
 *
 */
public class MainRest {
    // Base URI the Grizzly HTTP server will listen on
<<<<<<< HEAD
    public static final String BASE_URI = "http://147.83.7.206:8088/1O-survival/";
    //public static final String BASE_URI = "http://localhost:8080/1O-survival/";
=======
    public static final String BASE_URI = "http://10.193.222.188:8088/1O-survival/";
    //public static final String BASE_URI = "http://147.83.7.206:8080/1O-survival/";
>>>>>>> 3558c79ae64873b4e7520d5573983ada7090a0cd

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in edu.upc.modelo package

        final ResourceConfig rc = new ResourceConfig().packages("vista");


        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }


    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();

        StaticHttpHandler staticHttpHandler = new StaticHttpHandler("./public/");
        server.getServerConfiguration().addHttpHandler(staticHttpHandler, "/");


        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));

        System.in.read();
        server.stop();
    }
}

