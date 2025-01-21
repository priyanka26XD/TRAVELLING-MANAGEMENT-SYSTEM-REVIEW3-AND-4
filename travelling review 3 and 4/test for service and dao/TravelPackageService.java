package com.travel.service;

import com.travel.dao.TravelPackageDAO;
import com.travel.model.TravelPackage;
import java.util.List;

public class TravelPackageService {
    private final TravelPackageDAO travelPackageDAO;

    public TravelPackageService(TravelPackageDAO travelPackageDAO) {
        this.travelPackageDAO = travelPackageDAO;
    }

    public List<TravelPackage> getAllPackages() {
        return travelPackageDAO.getAllPackages();
    }

    public TravelPackage getPackageById(int id) {
        return travelPackageDAO.getPackageById(id);
    }
}
