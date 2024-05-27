package com.example.recyclerviewdemo5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdvertisementDetails extends AppCompatActivity {
    ImageView imgAdvertisement;
    TextView txtAdvertisementTitle,txtUrl;
    Advertisment advertisment;
    String Title,Url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertisement_details);
        initViews();
        extractData();
    }
    private void initViews(){
        txtAdvertisementTitle = findViewById(R.id.txtAdvertisementTitle);
        txtUrl = findViewById(R.id.txtAdvertisementURL);


    }
    private void extractData(){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        advertisment = (Advertisment) bundle.get("advertisment");

        Title = advertisment.getTitle();
        Url = advertisment.getUrl();

        txtAdvertisementTitle.setText(Title);
        txtUrl.setText(Url);
    }
}