package com.example.gilgamesh.mupy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ImageView img = (ImageView) findViewById(R.id.img_1);
        img.setOnClickListener(this);
        ImageView img2 = (ImageView) findViewById(R.id.img_2);
        img2.setOnClickListener(this);
        ImageView img3 = (ImageView) findViewById(R.id.img_3);
        img3.setOnClickListener(this);
        ImageView img4 = (ImageView) findViewById(R.id.img_4);
        img4.setOnClickListener(this);
        ImageView img5 = (ImageView) findViewById(R.id.img_5);
        img5.setOnClickListener(this);
        ImageView img6 = (ImageView) findViewById(R.id.img_6);
        img6.setOnClickListener(this);
        ImageView img7 = (ImageView) findViewById(R.id.img_7);
        img7.setOnClickListener(this);
        ImageView img8 = (ImageView) findViewById(R.id.img_8);
        img8.setOnClickListener(this);
        ImageView img9 = (ImageView) findViewById(R.id.img_9);
        img9.setOnClickListener(this);
    }
    public void onClick(View view)
    {

        switch (view.getId())
        {
            case R.id.img_1:
                Toast.makeText(this,"Avikant Saini",Toast.LENGTH_LONG).show();
                break;
            case R.id.img_3:
                Toast.makeText(this,"Chinmay Nivsarkar",Toast.LENGTH_LONG).show();
                break;
            case R.id.img_2:
                Toast.makeText(this,"Yash Kumar Lal",Toast.LENGTH_LONG).show();
                break;
            case R.id.img_4:
                Toast.makeText(this,"Sachi Angle",Toast.LENGTH_LONG).show();
                break;
            case R.id.img_8:
                Toast.makeText(this,"Abhishek Vora",Toast.LENGTH_LONG).show();
                break;
            case R.id.img_5:
                Toast.makeText(this,"Anam Ahmed",Toast.LENGTH_LONG).show();
                break;
            case R.id.img_9:
                Toast.makeText(this,"Pramod Shenoy",Toast.LENGTH_LONG).show();
                break;
            case R.id.img_7:
                Toast.makeText(this,"Bhawesh Bhansali",Toast.LENGTH_LONG).show();
                break;
            case R.id.img_6:
                Toast.makeText(this,"Sahal Shams",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
