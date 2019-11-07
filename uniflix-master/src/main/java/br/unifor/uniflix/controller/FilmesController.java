package br.unifor.uniflix.controller;

import br.unifor.uniflix.adapter.FilmeAdapter;
import br.unifor.uniflix.factory.RequestFactory;
import br.unifor.uniflix.model.Filme;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Path("/filmes")
public class FilmesController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response popularMovies() throws IOException {

    	RequestFactory requestFactory = new RequestFactory();
    	
    	Call call = requestFactory.create("/movie/popular");

        okhttp3.Response response = call.execute();
        if (response.isSuccessful()) {
            JSONObject jsonResponse = new  JSONObject(response.body().string());
            JSONArray result = jsonResponse.getJSONArray("results");
            List<Filme> filmes = new ArrayList<>();
            FilmeAdapter filme = new FilmeAdapter();
            
            for (int i = 0; i < result.length(); ++i) {
                JSONObject movieJson = result.getJSONObject(i);
                filmes.add(filme.getFilme(movieJson));
            }
            
            return Response.ok(filmes).build();
        }
        return Response.serverError().build();
    }
}
