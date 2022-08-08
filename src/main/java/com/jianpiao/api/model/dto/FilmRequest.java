package com.jianpiao.api.model.dto;


import java.util.Date;

public class FilmRequest {

    private String filmName;

    private String introduction;

    private Date releasedTime;

    private Integer duration;

    private String director;

    private String leadingActor;

    private String posterUrl;

    private Double score;

    public FilmRequest() {
    }

    public FilmRequest(String filmName, String introduction, Date releasedTime, Integer duration, String director, String leadingActor, String posterUrl, Double score) {
        this.filmName = filmName;
        this.introduction = introduction;
        this.releasedTime = releasedTime;
        this.duration = duration;
        this.director = director;
        this.leadingActor = leadingActor;
        this.posterUrl = posterUrl;
        this.score = score;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Date getReleasedTime() {
        return releasedTime;
    }

    public void setReleasedTime(Date releasedTime) {
        this.releasedTime = releasedTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getLeadingActor() {
        return leadingActor;
    }

    public void setLeadingActor(String leadingActor) {
        this.leadingActor = leadingActor;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
