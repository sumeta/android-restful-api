package io.github.sumeta.android.androidrestapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import io.github.sumeta.android.androidrestapi.Retrofit2.Retrofit2Activity;
import io.github.sumeta.android.androidrestapi.rxjava2.RxJava2Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button retrofit2 = findViewById(R.id.btnRetrofit2);
        Button btnRxJava2 = findViewById(R.id.btnRxJava2);

        final Intent intent = new Intent(this, Retrofit2Activity.class);
        final Intent intentRx = new Intent(this, RxJava2Activity.class);

        retrofit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        btnRxJava2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentRx);
            }
        });

    }
}
