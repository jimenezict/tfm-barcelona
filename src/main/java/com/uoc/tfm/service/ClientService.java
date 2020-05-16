package com.uoc.tfm.service;

import com.uoc.tfm.commons.domain.StationsLocation;
import com.uoc.tfm.commons.domain.StationsStatus;

public interface ClientService {

    public StationsLocation getStationsLocation();

    public StationsStatus getStationStatus();

    public String getServiceName();

}
