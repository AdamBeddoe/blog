@WebMvcTest
@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles("dev")
public abstract class CarApiControllerTest {

    @Mock
    private CarRepository carRepository;

    @Mock
    private CarService carService;

    @InjectMocks
    private CarApiController carApiController;

    public MockMvc mvc;

    @Before
    public void before() {
        mvc = MockMvcBuilders.standaloneSetup(carApiController)
                //.setControllerAdvice(new ExceptionHandlers())
                .build();
    }

    @Test
    public void getCarReturnsValidCarJson() {
        when(carRepository.findById(1)).thenReturn(getTestObject());

        Car testCar = getTestCar();
    
        String result = mvc.perform(get("/api/car/1")
                .with(user("test_api").roles("API")))
                .andReturn().getResponse().getContentAsString();
    
        String testCarJson = objectToJson(testCar);
    
        assertEquals(testMabEntryJson, result);
    }

    @Test
    public void getCarReturnsHttpNotFoundForInvalidId() {
        when(carRepository.findById(1)).thenReturn(null);

        //...

    }

    //...
}
