package com.example.recyclerviewdemo5

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.Serializable

class Post(var username: String,
           var postTitle: String,
           var imageId : Int ): Serializable{

}