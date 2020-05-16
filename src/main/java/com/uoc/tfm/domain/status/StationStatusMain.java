package com.uoc.tfm.domain.status;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StationStatusMain {

    private long last_updated;
    private int ttl;
    private StationsStatus data;

    public StationStatusMain(){

    }

    public long getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(long last_updated) {
        this.last_updated = last_updated;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public StationsStatus getData() {
        return data;
    }

    public void setData(StationsStatus data) {
        this.data = data;
    }
}