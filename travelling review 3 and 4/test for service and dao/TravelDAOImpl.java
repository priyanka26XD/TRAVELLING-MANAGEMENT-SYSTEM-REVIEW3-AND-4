@Repository
public class TravelDAOImpl implements TravelDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Travel findTravelById(Long id) {
        String sql = "SELECT * FROM travels WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new TravelRowMapper());
    }

    @Override
    public List<Travel> findAllTravels() {
        String sql = "SELECT * FROM travels";
        return jdbcTemplate.query(sql, new TravelRowMapper());
    }

    @Override
    public void saveTravel(Travel travel) {
        String sql = "INSERT INTO travels (destination, start_date, end_date, price) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, travel.getDestination(), travel.getStartDate(), travel.getEndDate(), travel.getPrice());
    }

    @Override
    public void deleteTravel(Long id) {
        String sql = "DELETE FROM travels WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Booking findBookingById(Long id) {
        String sql = "SELECT * FROM bookings WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BookingRowMapper());
    }

    @Override
    public void saveBooking(Booking booking) {
        String sql = "INSERT INTO bookings (travel_id, customer_name, booking_date) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, booking.getTravelId(), booking.getCustomerName(), booking.getBookingDate());
    }

    @Override
    public List<Booking> findBookingsForTravel(Long travelId) {
        String sql = "SELECT * FROM bookings WHERE travel_id = ?";
        return jdbcTemplate.query(sql, new Object[]{travelId}, new BookingRowMapper());
    }
}
