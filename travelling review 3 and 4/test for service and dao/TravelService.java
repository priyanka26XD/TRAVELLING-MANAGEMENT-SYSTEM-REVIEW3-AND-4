@Service
public class TravelService {

    @Autowired
    private TravelDAO travelDAO;

    public Travel getTravelDetails(Long travelId) {
        return travelDAO.findTravelById(travelId);
    }

    public void bookTravel(Long travelId, String customerName) {
        Travel travel = travelDAO.findTravelById(travelId);
        if (travel != null && LocalDate.now().isBefore(travel.getStartDate())) {
            Booking booking = new Booking(travelId, customerName, LocalDate.now());
            travelDAO.saveBooking(booking);
        } else {
            throw new IllegalStateException("Cannot book travel package. Travel has already started or doesn't exist.");
        }
    }

    public List<Booking> getBookingsForTravel(Long travelId) {
        return travelDAO.findBookingsForTravel(travelId);
    }
}
