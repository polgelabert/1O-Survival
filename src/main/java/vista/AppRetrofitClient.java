package vista;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;
import java.util.List;

public class AppRetrofitClient
{
    public static final String API_URL = "127.0.0.0";


    public static class Prueba{
        public final String funciona;

        public Prueba(String param){
            this.funciona = param;
        }
    }

    public interface Survival_1O{


    }



    /*public static class Contributor {
        public final String login;
        public final int contributions;
        public final String avatar_url;

        public Contributor(String login, int contributions, String avatar_url) {
            this.login = login;
            this.contributions = contributions;
            this.avatar_url = avatar_url;
        }
    }

    public interface GitHub {
        @GET("/repos/{owner}/{repo}/contributors")
        Call<List<Contributor>> contributors(
                @Path("owner") String owner,
                @Path("repo") String repo);
    }

    public static void main( String[] args ) throws IOException
    {

        // Create a very simple REST adapter which points the GitHub API.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create an instance of our GitHub API interface.
        GitHub github = retrofit.create(GitHub.class);

        // Create a call instance for looking up Retrofit contributors.
        Call<List<Contributor>> call = github.contributors("RouteInjector", "route-injector");

        // Fetch and print a list of the contributors to the library.
        List<Contributor> contributors = call.execute().body();
        for (Contributor contributor : contributors) {
            System.out.println(contributor.login + " (" + contributor.contributions + ") "+ contributor.avatar_url);
        }
    }*/
}
