package io.github.sumeta.android.androidrestapi.RecyclerView;

import android.os.Bundle;
import android.os.StrictMode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.github.sumeta.android.androidrestapi.R;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<RecyclerViewModel> dataList = new ArrayList<>();
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("RecyclerView");
        setContentView(R.layout.activity_recyclerview);

        mRecyclerView = findViewById(R.id.listView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RecyclerViewAdapter(this, dataList);
        mRecyclerView.setAdapter(adapter);

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
            dataList.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(Contributor c : contributors) {
            System.out.println(c.login + " (" + c.contributions + ")");
            RecyclerViewModel model = new RecyclerViewModel();
            model.setLogin(c.login);
            model.setNumber(c.contributions);
            dataList.add(model);
        }

        //adapter.notifyDataSetChanged();

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
