package com.tutorials.hp.imageviewfilesystem;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    TextView nameTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        img= (ImageView) findViewById(R.id.img);
       nameTxt= (TextView) findViewById(R.id.nameTxt);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                File downloadsFolder= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                Uri file=Uri.fromFile(new File(downloadsFolder,"person.png"));

                if(file.toString() != null && file.toString().length()>0)
                {
                    Picasso.with(MainActivity.this).load(file).placeholder(R.drawable.placeholder).into(img);
                    nameTxt.setText(file.toString());
                }else
                {
                    Toast.makeText(MainActivity.this, "Empty URI", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
