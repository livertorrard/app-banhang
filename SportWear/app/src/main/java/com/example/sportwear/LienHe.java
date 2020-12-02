package com.example.sportwear;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class LienHe extends AppCompatActivity {
    Toolbar toolbar;
    ImageButton bntfb,bnttw,bntcall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lien_he);
        toolbar = findViewById(R.id.toolbarLienHe);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bntfb = (ImageButton)findViewById(R.id.FB);
        bnttw = (ImageButton)findViewById(R.id.twitter);
        bntcall = (ImageButton)findViewById(R.id.Call);
        bntcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0396537184"));
                startActivity(intent);
            }
        });

        bntfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GotoFB("sict.udn.vn/?epa=SEARCH_BOX");
            }
        });
        bnttw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GotoTW();
            }
        });
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
private void GotoFB(String id){
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/"+id));
            startActivity(intent);
        }catch (ActivityNotFoundException e){
            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.facebook.com/"+id));
            startActivity(intent);
        }
        }
private void GotoTW(){
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://twitter.com/explore"));
        startActivity(intent);

}

}

