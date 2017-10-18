package com.example.gilgamesh.mupy;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class SpeakerAdapter extends RecyclerView.Adapter<SpeakerAdapter.MyViewHolder> {

    private List<Speaker> speakerList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView topic,time,venue,speaker;

        public MyViewHolder(View view) {
            super(view);
            topic = (TextView) view.findViewById(R.id.topic);
            time = (TextView) view.findViewById(R.id.time);
            venue = (TextView) view.findViewById(R.id.venue);
            speaker = (TextView) view.findViewById(R.id.speaker);

        }
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

    }

    @Override
    public int getItemCount() {
        return speakerList.size();
    }
}