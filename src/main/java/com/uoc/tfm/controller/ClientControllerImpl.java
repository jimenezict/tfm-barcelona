package com.uoc.tfm.controller;

import com.uoc.tfm.service.ClientService;
import com.uoc.tfm.commons.domain.StationsLocation;
import com.uoc.tfm.commons.domain.StationsStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientControllerImpl implements ClientController {

    private static Logger log = LoggerFactory.getLogger(ClientControllerImpl.class);

    @Autowired
    private ClientService clientService;

    @Override
    public StationsLocation getStationsLocation() {
        log.info("Starting station collections: {}", clientService.getServiceName());
        StationsLocation stationsLocation = clientService.getStationsLocation();
        log.info("Ending station collections: {} with {} registers",
                clientService.getServiceName(),
                stationsLocation.getStationLocationList().size());
        return stationsLocation;

    }

    @Override
    @GetMapping("/status")
    public StationsStatus getStationStatus() {
        log.info("Starting station status collections: {}", clientService.getServiceName());
        StationsStatus stationStatus = clientService.getStationStatus();
        log.info("Ending station status collections: {} with {} registers",
                clientService.getServiceName(),
                stationStatus.getStationStatusList().size());
        return stationStatus;

    }
}
