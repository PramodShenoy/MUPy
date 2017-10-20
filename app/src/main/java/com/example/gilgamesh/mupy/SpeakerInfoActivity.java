package com.example.gilgamesh.mupy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

public class SpeakerInfoActivity extends AppCompatActivity {

    ProgressDialog mProgressDialog;
    ImageView icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaker_info);
        Intent i = getIntent();
        Speaker s = (Speaker) i.getSerializableExtra("speaker");
        //Toast.makeText(this,s.getSpeaker(),Toast.LENGTH_LONG).show();
        TextView speaker_name,topics,speaker_info;
        speaker_name = (TextView) findViewById(R.id.speaker_name);
        topics = (TextView) findViewById(R.id.topics_list);
        speaker_info = (TextView) findViewById(R.id.speaker_info);
        icon = (ImageView) findViewById(R.id.speaker_img);
        speaker_info.setText(s.getAbout());
        speaker_name.setText(s.getSpeaker());
        topics.setText(s.getDesc());
        String url = s.getImage();
        new DownloadImage().execute(url);

    }

    private class DownloadImage extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(SpeakerInfoActivity.this);
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }

        @Override
        protected Bitmap doInBackground(String... URL) {

            String imageURL = URL[0];

            Bitmap bitmap = null;
            try {
                // Download Image from URL
                InputStream input = new java.net.URL(imageURL).openStream();
                // Decode Bitmap
                bitmap = BitmapFactory.decodeStream(input);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            // Set the bitmap into ImageView
            icon.setImageBitmap(result);
            // Close progressdialog
            mProgressDialog.dismiss();
        }
    }
}
