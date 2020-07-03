package kr.co.song1126.jsonmovietest02;

public class MovieItem {

    String rank;
    String movieNm;
    String openDt;
    String audiCnt;
    String rankOldAndNew;

    public MovieItem(String rank, String movieNm, String openDt, String audiCnt, String rankOldAndNew) {
        this.rank = rank;
        this.movieNm = movieNm;
        this.openDt = openDt;
        this.audiCnt = audiCnt;
        this.rankOldAndNew = rankOldAndNew;
    }

    public MovieItem() {
    }
}
