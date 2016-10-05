package com.arjunalabs.android.untest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by bobbyadiprabowo on 9/8/16.
 */
public class DetailActivity extends AppCompatActivity {

    private String title;
    private String description;
    private String url;

    private TextView textTitle;
    private TextView textDescription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();
        title = bundle.getString("title");
        description = bundle.getString("description");
        url = bundle.getString("url");

        setContentView(R.layout.activity_detail);

        textTitle = (TextView) findViewById(R.id.text_title);
        textDescription = (TextView) findViewById(R.id.text_description);

        textTitle.setText(title);
        textDescription.setText(description);

    }
}
