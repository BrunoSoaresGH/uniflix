package br.unifor.uniflix.controller;

import br.unifor.uniflix.facade.UniFlixFacade;
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
    	UniFlixFacade facade = new UniFlixFacade();
		List<Filme> filmes = facade.listFilme();
		return Response.ok(filmes).build();
    }
}
