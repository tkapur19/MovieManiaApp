package com.example.tarunkapur.vollymovie;

/**
 * Created by tarunkapur on 17/02/18.
 */

public class ModalClass {

    private String movieTitle;
    private String releaseDate;
    private String PosterPath;
    private String overView;
    private int rating;


    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }




    public ModalClass(String movieTitle, String releaseDate, String posterPath, String overView, int rating) {
        this.movieTitle = movieTitle;
        this.releaseDate = releaseDate;
        this.PosterPath=posterPath;
        this.overView = overView;
        this.rating=rating;


    }


    public String getOverView() {
        return overView;
    }

    public void setOverView(String overView) {
        this.overView = overView;
    }

    public String getPosterPath() {
        return PosterPath;
    }


    public void setPosterPath(String posterPath) {
        this.PosterPath = posterPath;
    }



    public String getMovieTitle() {
        return movieTitle;
    }


    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
