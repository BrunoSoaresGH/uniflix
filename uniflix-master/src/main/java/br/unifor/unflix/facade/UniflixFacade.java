package br.unifor.unflix.facade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

import br.unifor.uniflix.adapter.FilmeAdapter;
import br.unifor.uniflix.adapter.TvShowJSONAdapter;
import br.unifor.uniflix.factory.RequestFactory;
import br.unifor.uniflix.model.Filme;
import br.unifor.uniflix.model.TvShow;
import okhttp3.Call;

public class UniflixFacade {
	
	public List<Filme> getFilmes() throws IOException{
		
		RequestFactory requestFactory = new RequestFactory();
    	
    	Call call = requestFactory.create("/movie/popular");

        okhttp3.Response response = call.execute();
        if (response.isSuccessful()) {
            JSONObject jsonResponse = new JSONObject(response.body().string());
            JSONArray result = jsonResponse.getJSONArray("results");
            List<Filme> filmes = new ArrayList<>();
            FilmeAdapter filmeAdapter = new FilmeAdapter();
            
            for (int i = 0; i < result.length(); ++i) {
                JSONObject jsonObject = result.getJSONObject(i);
                filmes.add(filmeAdapter.getFilme(jsonObject));
            }   
            return filmes;	
        }
        return new ArrayList<>();
	}
	
	public List<TvShow> getTvShows() throws IOException {
		
		RequestFactory requestFactory = new RequestFactory();
		
		String path = "/tv/airing_today";
    	
    	Call call = requestFactory.create(path);
		
		okhttp3.Response response = call.execute();
		if (response.isSuccessful()) {
			JSONObject jsonResponse = new JSONObject(response.body().string());
			JSONArray result = jsonResponse.getJSONArray("results");
			
			List<TvShow> tvShows = new ArrayList<>();
            TvShowJSONAdapter tvShowAdapter = new TvShowJSONAdapter();
            
            for (int i = 0; i < result.length(); ++i) {
                JSONObject jsonObject = result.getJSONObject(i);
                tvShows.add(tvShowAdapter.getTvShow(jsonObject));
            }
			return tvShows;
		}
		return new ArrayList<>();
	}
}