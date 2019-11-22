package br.unifor.uniflix.adapter;

import org.json.JSONObject;

import br.unifor.uniflix.model.TvShow;

public class TvShowJSONAdapter extends JSONAdapter<TvShow> {

	@Override
	public TvShow adapter(JSONObject jsonObject) {
		
		TvShow tvShow = new TvShow();
        tvShow.setNome(jsonObject.getString("name"));
        tvShow.setSinopse(jsonObject.getString("overview"));
        tvShow.setData(jsonObject.getString("first_air_date"));
        tvShow.setAvaliacao(jsonObject.getDouble("vote_average"));
		
		return tvShow;
	}

	
}
