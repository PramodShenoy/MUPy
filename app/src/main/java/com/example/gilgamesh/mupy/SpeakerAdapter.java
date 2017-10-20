package com.example.gilgamesh.mupy;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
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


    }


    public SpeakerAdapter(List<Speaker> moviesList) {
        this.speakerList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.row_item, parent, false);
        LinearLayout ll1 = (LinearLayout)itemView.findViewById(R.id.linear_main);
        //Speaker movie = speakerList.get(position);
        //final RecyclerView.ViewHolder holder = new RecyclerView.ViewHolder(itemView);
        //holder.getAdapterPosition();
        Speaker movie = speakerList.get(viewType);

        if(movie.getType().equalsIgnoreCase("Track One"))
        {
            //ll.setBackground(R.drawable.shape);
            ll1.setBackgroundResource(R.drawable.shape_purple);//GREEN
            //holder.venue.setText("1");
            //.getResources().getDrawable(R.drawable.img
            Log.d("TRACK ONE","_____________"+movie.getSpeaker()+"____________________");


        }
        else {
            ll1.setBackgroundResource(R.drawable.shape);
            //holder.venue.setText("2");
            Log.d("TRACK TWO","_____________"+movie.getSpeaker()+"____________________");
        }


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
        /*if(movie.getType().equalsIgnoreCase("Track One"))
        {
            //ll.setBackground(R.drawable.shape);
            ll.setBackgroundResource(R.drawable.shape_purple);//GREEN
            holder.venue.setText("1");
            //.getResources().getDrawable(R.drawable.img
            Log.d("TRACK ONE","_____________"+movie.getSpeaker()+"____________________");


        }
        else {
            ll.setBackgroundResource(R.drawable.shape);
            holder.venue.setText("2");
            Log.d("TRACK TWO","_____________"+movie.getSpeaker()+"____________________");
        }*/


    }

    @Override
    public int getItemViewType(int position) {
        //your code
        return position;
    }

    @Override
    public int getItemCount() {
        return speakerList.size();
    }
}