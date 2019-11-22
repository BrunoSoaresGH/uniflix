package br.unifor.uniflix.adapter;

import org.json.JSONObject;

import br.unifor.uniflix.model.Filme;

public class FilmeJSONAdapter extends JSONAdapter<Filme>{

	@Override
	public Filme adapter(JSONObject jsonObject) {	
	
		Filme filme = new Filme();
        filme.setTitulo(jsonObject.getString("title"));
        filme.setSinopse(jsonObject.getString("overview"));
        filme.setAdulto(jsonObject.getBoolean("adult"));
        filme.setNota(jsonObject.getDouble("vote_average"));		
		
		return filme;
	}

}
