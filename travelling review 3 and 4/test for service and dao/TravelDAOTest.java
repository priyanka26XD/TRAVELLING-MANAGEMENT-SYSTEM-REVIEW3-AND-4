@RunWith(MockitoJUnitRunner.class)
public class TravelDAOTest {

    @InjectMocks
    private TravelDAOImpl travelDAO;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testFindTravelById() {
        // Arrange
        Travel mockTravel = new Travel(1L, "Paris", LocalDate.now(), LocalDate.now().plusDays(7), 1500.0);
        when(jdbcTemplate.queryForObject(anyString(), any(Object[].class), any(RowMapper.class)))
            .thenReturn(mockTravel);

        // Act
        Travel travel = travelDAO.findTravelById(1L);

        // Assert
        assertNotNull(travel);
        assertEquals("Paris", travel.getDestination());
    }

    @Test
    public void testSaveBooking() {
        // Arrange
        Booking booking = new Booking(1L, "John Doe", LocalDate.now());
        doNothing().when(jdbcTemplate).update(anyString(), any(), any(), any());

        // Act
        travelDAO.saveBooking(booking);

        // Assert
        verify(jdbcTemplate, times(1)).update(anyString(), any(), any(), any());
    }
}
