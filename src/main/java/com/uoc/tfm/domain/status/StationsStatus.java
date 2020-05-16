package com.uoc.tfm.domain.status;

import java.util.List;

public class StationsStatus {

    private List<StationStatus> stations;

    public StationsStatus(){

    }

    public List<StationStatus> getStations() {
        return stations;
    }

    public void setStations(List<StationStatus> stations) {
        this.stations = stations;
    }
}