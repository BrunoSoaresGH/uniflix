package br.unifor.uniflix.controller;

import br.unifor.uniflix.facade.UniFlixFacade;
import br.unifor.uniflix.model.TvShow;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

@Path("/tvshows")
public class TvShowsController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response airingToday() throws IOException {
		 UniFlixFacade facade = new UniFlixFacade();
		 List<TvShow> tvShows = facade.listTvShow();
		 return Response.ok(tvShows).build();
    }
}
