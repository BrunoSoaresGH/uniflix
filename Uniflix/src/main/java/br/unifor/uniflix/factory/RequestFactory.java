package br.unifor.uniflix.factory;

import okhttp3.Request;
import okhttp3.Call;
import okhttp3.OkHttpClient;

public class RequestFactory {

	public Call requestCreate(String path) {
		
		OkHttpClient client = new OkHttpClient();
		Request request = new Request
				.Builder()
				.url("https://api.themoviedb.org/3" + path + "?api_key=1074b5813af13b5469d0f74467529178")
				.build();
		
		return client.newCall(request);
		
	}
	
}
