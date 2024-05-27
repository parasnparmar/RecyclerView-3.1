package com.example.recyclerviewdemo5

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewPostAndAd: RecyclerView
    private val posts= ArrayList<Post>()
    private val advertiments = ArrayList<Advertisment>()
    private lateinit var postAdapter: AdapterImplementation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        initViews()
        initAdapter()
    }
    private inner class MyOnPostClickListner : AdapterImplementation.OnClickPostListner{
        override fun onClickPost(position: Int, post: Post) {
                    if(isLoggedIn()){
                        val intent = Intent(this@MainActivity,Post_details::class.java)
                        intent.putExtra("post",post)
                        startActivity(intent)
                        Toast.makeText(this@MainActivity,"Post ${post.imageId}",Toast.LENGTH_SHORT).show()
                    }else{
                        val intent = Intent(this@MainActivity,LogIn::class.java)
                        startActivity(intent)
                        Toast.makeText(this@MainActivity,"Please Login!",Toast.LENGTH_SHORT).show()
                    }
        }
    }
    private inner class MyOnAdvertismentClickListner : AdapterImplementation.OnClickAdvertismentListner{
        override fun onClickAdvertisment(position: Int, advertisment: Advertisment) {
            if(isLoggedIn()){
                val intent = Intent(this@MainActivity,AdvertisementDetails::class.java)
                intent.putExtra("advertisment",advertisment)
                startActivity(intent)
                Toast.makeText(this@MainActivity,"Advertisment: ${advertisment.title}",Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this@MainActivity,LogIn::class.java)
                startActivity(intent)
                Toast.makeText(this@MainActivity,"Please Login!",Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun isLoggedIn():Boolean{
        return Random.nextBoolean()
    }
    fun initViews(){
        recyclerViewPostAndAd = findViewById(R.id.recyclerViewPostAndAd);
    }
    fun initData(){
        for (i in 1..10){
            posts.add(Post("username $i","Post Title $i",R.drawable.ic_launcher_foreground))
            advertiments.add(Advertisment("Advertisment Title $i","advertismenturl$1.com"))
        }
    }
    fun initAdapter(){
        postAdapter = AdapterImplementation(posts,advertiments)
        recyclerViewPostAndAd.layoutManager = LinearLayoutManager(this)
        recyclerViewPostAndAd.adapter =postAdapter

        postAdapter.OnClickPostListner1 = MyOnPostClickListner()
        postAdapter.OnClickAdvertismentListner1 = MyOnAdvertismentClickListner()


    }
}