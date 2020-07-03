package kr.co.song1126.jsonmovietest02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<MovieItem> items;

    public MovieAdapter(Context context, ArrayList<MovieItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itenView=LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false);
        VH holder=new VH(itenView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh=(VH) holder;

        vh.rank.setText(items.get(position).rank);
        vh.movieNm.setText(items.get(position).movieNm);
        vh.rankOldAndNew.setText(items.get(position).rankOldAndNew);
        vh.audiCnt.setText(items.get(position).audiCnt);
        vh.openDt.setText(items.get(position).openDt);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

class  VH extends RecyclerView.ViewHolder{

    TextView rank;
    TextView movieNm;
    TextView rankOldAndNew;
    TextView audiCnt;
    TextView openDt;


    public VH(@NonNull View itemView) {
        super(itemView);
        rank=itemView.findViewById(R.id.tv_rankShow);
        movieNm=itemView.findViewById(R.id.tv_movieNm);
        openDt=itemView.findViewById(R.id.openDt);
        audiCnt=itemView.findViewById(R.id.audiCnt);
        rankOldAndNew=itemView.findViewById(R.id.tv_rankOldAndNew);



    }
}
