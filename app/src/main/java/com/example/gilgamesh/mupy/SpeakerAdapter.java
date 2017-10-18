package com.example.gilgamesh.mupy;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class SpeakerAdapter extends RecyclerView.Adapter<SpeakerAdapter.MyViewHolder> {

    private List<Speaker> speakerList;
     LinearLayout ll;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView topic,time,venue,speaker,track;

        public MyViewHolder(View view) {
            super(view);
            topic = (TextView) view.findViewById(R.id.topic);
            time = (TextView) view.findViewById(R.id.time);
            venue = (TextView) view.findViewById(R.id.venue);
            speaker = (TextView) view.findViewById(R.id.speaker);
            track = (TextView) view.findViewById(R.id.track);
            ll = (LinearLayout) view.findViewById(R.id.linear_main);
        }

        /*
        public  View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;

            if (row == null) {
                row = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, null);
            }

            TextView tv = (TextView) row.findViewById(R.id.track);
            String tr = (String)tv.getText();

            ll=(LinearLayout) row.findViewById(R.id.linear_main);
            if(tr.equalsIgnoreCase("track one"))
                ll.setBackground(Drawable.createFromPath("/home/gilgamesh/AndroidStudioProjects/MUPy/app/src/main/res/drawable/shape_purple.xml"));
            else
                ll.setBackground(Drawable.createFromPath("/home/gilgamesh/AndroidStudioProjects/MUPy/app/src/main/res/drawable/shape.xml"));



            return ll;
        }*/
    }


    public SpeakerAdapter(List<Speaker> moviesList) {
        this.speakerList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.row_item, parent, false);

        return new MyViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Speaker movie = speakerList.get(position);
        holder.speaker.setText(movie.getSpeaker());
        holder.topic.setText(movie.getTopic());
        holder.time.setText(movie.getTime());
        holder.venue.setText(movie.getVenue());
        holder.track.setText((movie.getType()));

    }

    @Override
    public int getItemCount() {
        return speakerList.size();
    }
}