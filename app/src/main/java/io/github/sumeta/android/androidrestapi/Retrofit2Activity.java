package io.github.sumeta.android.androidrestapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class Retrofit2Activity extends AppCompatActivity {
    /***
     *
     * Ref : https://medium.com/@phayao/call-api-%E0%B9%83%E0%B8%99-java-%E0%B8%94%E0%B9%89%E0%B8%A7%E0%B8%A2-retrofit2-c5db46824f76
     *
     *
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Retrofit2");
        setContentView(R.layout.activity_retrofit2);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);


        Call<List<Contributor>> call = service.contributor("sumeta", "android-restful-api");
        List<Contributor> contributors = null;
        try {
            contributors = call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(Contributor c : contributors) {
            System.out.println(c.login + " (" + c.contributions + ")");
        }

    }

    public interface GitHubService {
        @GET("/repos/{owner}/{repo}/contributors")
        Call<List<Contributor>> contributor(
                @Path("owner") String owner,
                @Path("repo") String repo
        );
    }

    public static class Contributor {
        final String login;
        final int contributions;

        public Contributor(String login, int contributions) {
            this.login = login;
            this.contributions = contributions;
        }
    }

}
