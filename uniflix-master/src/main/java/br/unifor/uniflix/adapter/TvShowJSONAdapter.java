package br.unifor.uniflix.adapter;

import org.json.JSONObject;

import br.unifor.uniflix.model.TvShow;

public class TvShowJSONAdapter implements TvShowJSON {

	@Override
	public TvShow getTvShow(JSONObject jsonObject) {
		TvShow tvShow = new TvShow();
		tvShow.setNome(jsonObject.getString("name"));
		tvShow.setSinopse(jsonObject.getString("overview"));
        tvShow.setDate(jsonObject.getString("first_air_date"));
        tvShow.setAvaliacao(jsonObject.getDouble("vote_average"));
		return tvShow;
	}

}
