package com.natalia.service.dto;

public class RateDto {
    private String userName;
    private String movieName;
    private Integer rate;

    public RateDto(String userName, String movieName, Integer rate) {
        this.userName = userName;
        this.movieName = movieName;
        this.rate = rate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "RateDto{" +
                "userName='" + userName + '\'' +
                ", movieName='" + movieName + '\'' +
                ", rate=" + rate +
                '}';
    }
}
