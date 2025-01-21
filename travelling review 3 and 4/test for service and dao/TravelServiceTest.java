@RunWith(MockitoJUnitRunner.class)
public class TravelServiceTest {

    @InjectMocks
    private TravelService travelService;

    @Mock
    private TravelDAO travelDAO;

    @Test
    public void testGetTravelDetails() {
        // Arrange
        Travel mockTravel = new Travel(1L, "Paris", LocalDate.now(), LocalDate.now().plusDays(7), 1500.0);
        when(travelDAO.findTravelById(1L)).thenReturn(mockTravel);

        // Act
        Travel travel = travelService.getTravelDetails(1L);

        // Assert
        assertNotNull(travel);
        assertEquals("Paris", travel.getDestination());
    }

    @Test
    public void testBookTravel() {
        // Arrange
        Travel mockTravel = new Travel(1L, "Paris", LocalDate.now().plusDays(1), LocalDate.now().plusDays(7), 1500.0);
        when(travelDAO.findTravelById(1L)).thenReturn(mockTravel);

        // Act
        travelService.bookTravel(1L, "John Doe");

        // Assert
        verify(travelDAO, times(1)).saveBooking(any(Booking.class));
    }

    @Test(expected = IllegalStateException.class)
    public void testBookTravel_ShouldThrowExceptionIfTravelHasAlreadyStarted() {
        // Arrange
        Travel mockTravel = new Travel(1L, "Paris", LocalDate.now().minusDays(1), LocalDate.now().plusDays(7), 1500.0);
        when(travelDAO.findTravelById(1L)).thenReturn(mockTravel);

        // Act
        travelService.bookTravel(1L, "John Doe");
    }

    @Test
    public void testGetBookingsForTravel() {
        // Arrange
        Booking booking1 = new Booking(1L, "John Doe", LocalDate.now());
        Booking booking2 = new Booking(1L, "Jane Doe", LocalDate.now());
        List<Booking> bookings = Arrays.asList(booking1, booking2);
        when(travelDAO.findBookingsForTravel(1L)).thenReturn(bookings);

        // Act
        List<Booking> result = travelService.getBookingsForTravel(1L);

        // Assert
        assertEquals(2, result.size());
    }
}
