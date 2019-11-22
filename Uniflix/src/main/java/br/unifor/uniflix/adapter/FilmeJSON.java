package br.unifor.uniflix.adapter;

import org.json.JSONObject;

import br.unifor.uniflix.model.Filme;

public interface FilmeJSON {
	
	Filme getFilme(JSONObject jsonobject);
	
}
