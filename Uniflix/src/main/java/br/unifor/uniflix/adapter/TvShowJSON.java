package br.unifor.uniflix.adapter;

import org.json.JSONObject;

import br.unifor.uniflix.model.TvShow;

public interface TvShowJSON {
	
	TvShow getTvShow(JSONObject jsonObject);

}
