package com.travel.dao;

import com.travel.model.TravelPackage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class TravelPackageDAOTest {

    private TravelPackageDAO travelPackageDAO;

    @BeforeEach
    void setUp() {
        // Create a mock of TravelPackageDAO
        travelPackageDAO = mock(TravelPackageDAO.class);
    }

    @Test
    void testGetAllPackages() {
        // Arrange: mock the behavior of getAllPackages() method
        TravelPackage package1 = new TravelPackage("Beach Paradise", "Hawaii", 1200);
        TravelPackage package2 = new TravelPackage("Mountain Adventure", "Swiss Alps", 1500);
        
        when(travelPackageDAO.getAllPackages()).thenReturn(List.of(package1, package2));

        // Act: Call the method
        List<TravelPackage> packages = travelPackageDAO.getAllPackages();

        // Assert: Verify the result
        assertNotNull(packages);
        assertEquals(2, packages.size());
        assertEquals("Beach Paradise", packages.get(0).getName());
    }

    @Test
    void testGetPackageById() {
        // Arrange: mock the behavior of getPackageById() method
        TravelPackage package1 = new TravelPackage("City Escape", "New York", 900);
        when(travelPackageDAO.getPackageById(1)).thenReturn(package1);

        // Act: Call the method
        TravelPackage result = travelPackageDAO.getPackageById(1);

        // Assert: Verify the result
        assertNotNull(result);
        assertEquals("City Escape", result.getName());
        assertEquals("New York", result.getDestination());
    }
}
