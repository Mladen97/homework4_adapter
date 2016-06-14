package com.example.kristian.activityhomework;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {
    TextView txt_info;
    Button show_adress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        txt_info = (TextView) findViewById(R.id.txt_info);
        String name = getIntent().getStringExtra("name");
        String years = getIntent().getStringExtra("years");
        final String city = getIntent().getStringExtra("city");
        final String adress = getIntent().getStringExtra("adress");
        String date = getIntent().getStringExtra("date");
        String fullInfo = name + ", " + years + ", " + city + ", " + adress + ", " + date;
        txt_info.setText(fullInfo);
        show_adress = (Button) findViewById(R.id.btn_show_adress);
        show_adress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.co.in/maps?q=" + city + " " + adress));
                startActivity(mapIntent);
            }
        });
    }


}
