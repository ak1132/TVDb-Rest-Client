package com.tvdbRestClient.models.request;

public class SeriesImageQueryResult {

    public int id;
    public String keyType;
    public String subKey;
    public String fileName;
    public String resolution ;
    public RatingsInfo ratingsInfo;
    public String thumbnail;

    public class RatingsInfo {
        public Double average;
        public Integer count;
    }

}