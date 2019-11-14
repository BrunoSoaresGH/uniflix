package br.unifor.uniflix.adapter;

import org.json.JSONObject;

import br.unifor.uniflix.model.Filme;

public class FilmeAdapter implements FilmeJSON{
	
	@Override
	public Filme getFilme(JSONObject jsonObject) {
		Filme filme = new Filme();
		filme.setTitulo(jsonObject.getString("title"));
        filme.setSinopse(jsonObject.getString("overview"));
        filme.setAdulto(jsonObject.getBoolean("adult"));
        filme.setNota(jsonObject.getDouble("vote_average"));
		return filme;
	}

}
