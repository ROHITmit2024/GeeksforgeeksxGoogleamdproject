package com.example.kisan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences sharedPreferences = getSharedPreferences("shared prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username","").toString();
        Toast.makeText(getApplicationContext(),"Welcome"+username,Toast.LENGTH_SHORT).show();

        CardView exit = findViewById(R.id.cardExit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(HomeActivity.this,LoginActivity.class));
            }
        });
        CardView Model = findViewById(R.id.cardModel);
        Model.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,mlmodelActivity.class));
            }
        });
        CardView Report = findViewById(R.id.cardReport);
        Report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,ReportActivity.class));
            }
        });
        CardView Shop = findViewById(R.id.cardshop);
        Shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,ShopActivity.class));
            }
        });
        CardView Article = findViewById(R.id.cardArticle);
        Article.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,ArticleActivity.class));
            }
        });
        CardView Weather = findViewById(R.id.cardWeather);
        Weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,WeatherActivity.class));
            }
        });
    }
}