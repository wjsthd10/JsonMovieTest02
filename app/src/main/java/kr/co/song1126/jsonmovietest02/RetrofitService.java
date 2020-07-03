package kr.co.song1126.jsonmovietest02;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {

    @GET("searchDailyBoxOfficeList.json")
    Call<Map<String, Object>> getMovieList(@Query("key") String key, @Query("targetDt") String targetDt);

}
