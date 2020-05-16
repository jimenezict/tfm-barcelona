package com.uoc.tfm.service;

import com.uoc.tfm.domain.location.StationLocationMain;
import com.uoc.tfm.domain.status.StationStatusMain;
import com.uoc.tfm.commons.domain.StationsLocation;
import com.uoc.tfm.commons.domain.StationsStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

import static java.time.LocalDateTime.now;

@Service
public class ClientServiceImpl implements ClientService {

    @Value("${service.name:default}")
    private String serviceName;

    private final String urlStatus = "https://api.bsmsa.eu/ext/api/bsm/gbfs/v2/en/station_status";
    private final String urlLocation = "https://api.bsmsa.eu/ext/api/bsm/gbfs/v2/en/station_information";

    @Override
    public StationsLocation getStationsLocation() {
        RestTemplate restTemplate = new RestTemplate();
        StationLocationMain stationLocation = restTemplate.getForObject(urlLocation, StationLocationMain.class);
        return mapStationsLocation(stationLocation);
    }

    @Override
    public StationsStatus getStationStatus() {
        RestTemplate restTemplate = new RestTemplate();
        StationStatusMain stationStatusMain = restTemplate.getForObject(urlStatus, StationStatusMain.class);
        return  mapStationsStatus(stationStatusMain);
    }

    private StationsStatus mapStationsStatus(StationStatusMain stationStatus) {
        StationsStatus stationsStatus = new StationsStatus(now());
        stationStatus.getData().getStations().forEach(x -> {
            int size = x.getNum_bikes_available() + x.getNum_docks_available();
            stationsStatus.addStation(x.getStation_id(),size, x.getNum_bikes_available());
        });
        return stationsStatus;
    }

    private StationsLocation mapStationsLocation(StationLocationMain stationLocation) {
        StationsLocation stationsLocation = new StationsLocation(LocalDate.now());
        stationLocation.getData().getStations().forEach(x -> {
            stationsLocation.addStation(x.getStation_id(), x.getLat(), x.getLon(), x.getAddress());
        });
        return stationsLocation;
    }

    @Override
    public String getServiceName() {
        return serviceName;
    }
}
