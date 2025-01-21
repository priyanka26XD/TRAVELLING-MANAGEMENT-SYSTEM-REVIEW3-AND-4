package com.travel.dao;

import com.travel.model.TravelPackage;
import java.util.List;

public interface TravelPackageDAO {
    List<TravelPackage> getAllPackages();
    TravelPackage getPackageById(int id);
}
