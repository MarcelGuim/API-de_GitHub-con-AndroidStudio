package com.example.api_githubpetitions;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView input;
    TextView output;
    Button btn;
    GitHubService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        input = findViewById(R.id.input);
        output = findViewById(R.id.output);
        btn = findViewById(R.id.btn1);
        btn.setOnClickListener(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(GitHubService.class);
    }

    @Override
    public void onClick(View V) {
        String user = input.getText().toString();
        Call<List<Repo>> call = service.listRepos(user);
        call.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Repo> repos = response.body();
                    PrintInfo(repos);
                } else {
                    output.setText("ERROR en la API");
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable throwable) {
                output.setText("error en la API");
            }
        });
    }

    public void PrintInfo(List<Repo> repos)
    {
        String respuesta = "";
        for (Repo repo:repos)
        {
            respuesta = respuesta + "The username: " + repo.name + " has a project with description: " +repo.description + " an a total of: " + repo.stargazers_count + "\n";
        }
        output.setText(respuesta);
    }
}
