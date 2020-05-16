package com.uoc.tfm.domain.location;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StationLocationMain {

    private long last_updated;
    private int ttl;
    private StationsLocation data;

    public StationLocationMain() {

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

    public StationsLocation getData() {
        return data;
    }

    public void setData(StationsLocation data) {
        this.data = data;
    }
}