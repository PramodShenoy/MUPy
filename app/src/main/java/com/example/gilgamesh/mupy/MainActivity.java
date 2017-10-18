package com.example.gilgamesh.mupy;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Speaker> speakerList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SpeakerAdapter mAdapter;
    private static final String query ="https://www.pypals.org/schedule";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       new SpeakerAsyncTask().execute(query);

    }

    private class SpeakerAsyncTask extends AsyncTask<String, Void, List<Speaker>> {
        @Override
        protected List<Speaker> doInBackground(String... urls) {

            if (urls.length < 1 || urls[0] == null) {
                return null;
            }
            String jsonresp = QueryUtils.getData(urls[0]);
            if (jsonresp != null) {
                return extractSpeaker(jsonresp);
            } else return null;
        }

        @Override
        protected void onPostExecute(List<Speaker> str) {
            if(str!=null) {
                recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
                mAdapter = new SpeakerAdapter(speakerList);
                recyclerView.setHasFixedSize(true);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(mLayoutManager);
               // recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, LinearLayoutManager.VERTICAL));
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(mAdapter);

                recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        Speaker s = speakerList.get(position);
                        Intent i = new Intent(MainActivity.this,SpeakerInfoActivity.class);
                        i.putExtra("speaker",s);
                        startActivity(i);
                    }

                    @Override
                    public void onLongClick(View view, int position) {

                    }
                }));


            }
            else
                Toast.makeText(MainActivity.this,"CANNOT CONNECT",Toast.LENGTH_LONG).show();
        }
    }

    private List<Speaker> extractSpeaker(String jsonResp) {
        String topic = "";
        String speaker = "";
        String time = "";
        String real_time = "";
        String venue = "";
        String desc = "";
        String about = "";
        String image_url="";
        String type="";
        if (TextUtils.isEmpty(jsonResp)) {
            return null;
        }

        try {
            JSONArray baseJsonResponse = new JSONArray(jsonResp);
            for(int i=0;i<baseJsonResponse.length();i++) {
                JSONObject obj = baseJsonResponse.getJSONObject(i);
                topic = obj.optString("title");
                speaker = obj.optString("speaker");
                about = obj.optString("about_speaker");
                image_url = obj.optString("image");
                desc = obj.optString("description");
                time = obj.optString("begin_time");
                type = obj.optString("type");
                real_time =time.substring(8,12);
                if(Integer.parseInt(real_time)>=1200)
                {
                    real_time = time.substring(8,10);
                    real_time= String.valueOf(Integer.parseInt(real_time)-12);
                    real_time=real_time+" PM,";
                    real_time += time.substring(6,8)+"/"+time.substring(4,6)+"/"+time.substring(0,4);
                }
                else
                {
                    real_time = time.substring(8,10);
                    real_time=real_time+" AM,";
                    real_time += time.substring(6,8)+"/"+time.substring(4,6)+"/"+time.substring(0,4);
                }

                venue = obj.optString("location");
                Speaker speaker1 = new Speaker(topic, real_time, speaker, venue,about,desc,image_url,type);
                speakerList.add(speaker1);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return speakerList;
    }

    public interface ClickListener {
    }
}