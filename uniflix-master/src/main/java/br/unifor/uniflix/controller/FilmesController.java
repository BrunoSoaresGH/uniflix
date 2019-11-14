package br.unifor.uniflix.controller;

import br.unifor.unflix.facade.UniflixFacade;
import br.unifor.uniflix.model.Filme;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

@Path("/filmes")
public class FilmesController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response popularMovies() throws IOException {
           
            UniflixFacade facade = new UniflixFacade(); 
            
            List<Filme> filmes = facade.getFilmes();
            return Response.ok(filmes).build();
        
    }
}
