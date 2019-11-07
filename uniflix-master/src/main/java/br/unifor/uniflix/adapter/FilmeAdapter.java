package br.unifor.uniflix.adapter;

import org.json.JSONObject;

import br.unifor.uniflix.model.Filme;

public class FilmeAdapter implements FilmeJSON{
	
	@Override
	public Filme getFilme(JSONObject movieJson) {
		Filme filme = new Filme();
		filme.setTitulo(movieJson.getString("title"));
        filme.setSinopse(movieJson.getString("overview"));
        filme.setAdulto(movieJson.getBoolean("adult"));
        filme.setNota(movieJson.getDouble("vote_average"));
		return filme;
	}

}
