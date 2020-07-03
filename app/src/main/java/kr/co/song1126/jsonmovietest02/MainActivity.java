package kr.co.song1126.jsonmovietest02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<MovieItem> items=new ArrayList<>();
    MovieAdapter adapter;

    String key="df67dfffbe363b0fc9bf1ccd96b187a4";

    String now;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Date date=new Date();
        date=new Date(date.getTime()+(1000*60*60*24*-1));
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
        now=sdf.format(date);

        recyclerView=findViewById(R.id.recycler);
        adapter=new MovieAdapter(this, items);
        recyclerView.setAdapter(adapter);


    }

    public void loadDB(){
        Retrofit retrofit=RetrofitHelper.getInstance();
        RetrofitService retrofitService=retrofit.create(RetrofitService.class);

        Call<Map<String, Object>> call=retrofitService.getMovieList(key, now);
        call.enqueue(new Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                if (response.isSuccessful()) {
                    Map<String, Object> objectMap=(Map<String, Object>) response.body().get("boxOfficeResult");
                    ArrayList<Map<String, Object>> movieList=(ArrayList<Map<String, Object>>) objectMap.get("dailyBoxOfficeList");
                    for (int i=0;i<movieList.size();i++){
                        items.add(new MovieItem(movieList.get(i).get("rank").toString(),
                                movieList.get(i).get("movieNm").toString(),
                                movieList.get(i).get("openDt").toString(),
                                movieList.get(i).get("audiCnt").toString(),
                                movieList.get(i).get("rankOldAndNew").toString()));

                        adapter.notifyItemInserted(i);
                    }
                }
            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                Log.d("SHOW",t.getMessage());
                //canceled due to java.lang.SecurityException: Permission denied (missing INTERNET permission?)
            }
        });

    }

    public void clickBtn(View view) {
        loadDB();
        Button btn=findViewById(R.id.btn);
        btn.setVisibility(View.GONE);

        //로딩중이라고 알려주는 거

        //아이템 다시 만들기


    }
}
