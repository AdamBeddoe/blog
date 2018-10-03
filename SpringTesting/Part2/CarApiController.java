@RestController
@RequestMapping("/api/car/")
public class CarApiController {

    @Inject
    private CarRepository carRepository;

    @Inject
    private CarService carService;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Car> getCar(@PathVariable("id") final Integer id) {
        Car car = carRepository.findById(id);
        if (car == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(car);
        }
    }

    @PostMapping(value = "/", consumes = "application/json")
    public ResponseEntity postCar(@Valid @RequestBody final Car car) {
        carRepositoy.create(car);
        return ResponseEntity.ok().build();
    }

    //...

}
