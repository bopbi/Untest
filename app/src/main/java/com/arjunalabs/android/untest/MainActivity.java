package com.arjunalabs.android.untest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        ArrayList<Post> postArrayList = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            Post post = new Post();
            post.setTitle("Title number "+ i);
            post.setDescription("Description for item is number " + i);
            post.setUrl("http://loripsum.net/api");
            postArrayList.add(post);
        }

        recyclerView.setAdapter(new MainAdapter(postArrayList));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
