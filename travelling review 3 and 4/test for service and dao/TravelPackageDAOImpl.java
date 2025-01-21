package com.travel.dao;

import com.travel.model.TravelPackage;
import java.util.List;
import java.util.ArrayList;

public class TravelPackageDAOImpl implements TravelPackageDAO {
    public List<TravelPackage> getAllPackages() {
        // In a real DAO, this would query the database
        return new ArrayList<>();
    }

    public TravelPackage getPackageById(int id) {
        // In a real DAO, this would query the database for a single package
        return new TravelPackage("Package 1", "Beach", 500);
    }
}
