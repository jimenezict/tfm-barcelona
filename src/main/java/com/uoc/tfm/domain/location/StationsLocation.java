package com.uoc.tfm.domain.location;

import java.util.List;

public class StationsLocation {

    private List<StationLocation> stations;

    public StationsLocation() {

    }

    public List<StationLocation> getStations() {
        return stations;
    }

    public void setStations(List<StationLocation> stations) {
        this.stations = stations;
    }
}