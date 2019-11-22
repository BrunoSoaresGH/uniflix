package br.unifor.uniflix.adapter;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public abstract class JSONAdapter <T> {

	abstract T adapter(JSONObject value);
	
	public List<T> adapterJsonArray(JSONArray array){
		List<T> adaptedList = new ArrayList<T>();
		for (int i = 0; i < array.length(); ++i) {
	        JSONObject jsonObject = array.getJSONObject(i);
	        T object = adapter(jsonObject);
	        adaptedList.add(object);  
	    }
		return adaptedList;
	}
	
}
