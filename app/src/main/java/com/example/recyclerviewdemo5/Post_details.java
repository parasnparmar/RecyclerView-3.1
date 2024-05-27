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

public class Post_details extends AppCompatActivity {
    ImageView imgPost;
    TextView txtPostTitle,txtUsername;
    String title,username;
    Post posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);
        initViews();
        extractData();
    }
    private void initViews(){
        imgPost = findViewById(R.id.imgPost);
        txtPostTitle = findViewById(R.id.txtPostTitle);
        txtUsername = findViewById(R.id.txtUsername);
    }
    private void extractData(){
        Intent intent = getIntent();
        Bundle bundle =intent.getExtras();
        posts = (Post) bundle.get("post");
        title=posts.getPostTitle();
        username = posts.getUsername();

        txtPostTitle.setText(title);
        txtUsername.setText(username);

    }
}