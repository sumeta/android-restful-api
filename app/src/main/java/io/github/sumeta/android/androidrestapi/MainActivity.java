package io.github.sumeta.android.androidrestapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import io.github.sumeta.android.androidrestapi.RecyclerView.RecyclerViewActivity;
import io.github.sumeta.android.androidrestapi.Retrofit2.Retrofit2Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button retrofit2 = findViewById(R.id.btnRetrofit2);
        Button recyclerView = findViewById(R.id.btnRecyclerView);

        final Intent intentRetrofit2 = new Intent(this, Retrofit2Activity.class);
        final Intent intentRecyclerView = new Intent(this, RecyclerViewActivity.class);

        retrofit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentRetrofit2);
            }
        });

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentRecyclerView);
            }
        });


    }
}
