package kr.co.song1126.jsonmovietest02;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {

    public static Retrofit getInstance(){
        Retrofit.Builder builder=new Retrofit.Builder();
        builder.baseUrl("http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/");
        builder.addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit=builder.build();
        return retrofit;
    }
}
