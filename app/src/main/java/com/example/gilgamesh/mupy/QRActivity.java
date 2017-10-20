package com.example.gilgamesh.mupy;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

public class QRActivity extends AppCompatActivity {

    ImageView imageView;

    Bitmap bitmap ;

    String regno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        imageView = (ImageView)findViewById(R.id.qr_img);

        try {
            String path = new Utils.SessionManager(this).getImagePath();
            Log.d("HEY", path);
            bitmap = BitmapFactory.decodeFile(path);
            imageView.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}