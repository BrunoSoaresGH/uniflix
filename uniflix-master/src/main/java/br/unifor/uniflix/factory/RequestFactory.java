package br.unifor.uniflix.factory;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class RequestFactory {
	
	public Call create(String path) throws IOException {
		
		OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
        		.url("https://api.themoviedb.org/3" + path + "?api_key=4c6222185fe9147537906df0f2fddcc5")
                .build();
	
        return client.newCall(request);
	
	}

}
