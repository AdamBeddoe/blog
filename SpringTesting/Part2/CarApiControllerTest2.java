// ...
public abstract class CarApiControllerTest {

    @InjectMocks
    private CarApiController carApiController;

    public MockMvc mvc;

    @Before
    public void before() {
        mvc = MockMvcBuilders.standaloneSetup(carApiController)
                //.setControllerAdvice(new ExceptionHandlers())
                .build();
    }

    //...
}
