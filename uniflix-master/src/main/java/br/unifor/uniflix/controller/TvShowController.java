package br.unifor.uniflix.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;
import br.unifor.unflix.facade.UniflixFacade;
import br.unifor.uniflix.model.TvShow;

@Path("/tvshows")
public class TvShowController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response airingToday() throws IOException {
		
		UniflixFacade facade = new UniflixFacade();
		List<TvShow> tvShows = facade.getTvShows();
			
		return Response.ok(tvShows).build();
	}
		
}

	

