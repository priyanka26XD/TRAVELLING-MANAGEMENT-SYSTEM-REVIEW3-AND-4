public interface TravelDAO {
    Travel findTravelById(Long id);
    List<Travel> findAllTravels();
    void saveTravel(Travel travel);
    void deleteTravel(Long id);

    Booking findBookingById(Long id);
    void saveBooking(Booking booking);
    List<Booking> findBookingsForTravel(Long travelId);
}
