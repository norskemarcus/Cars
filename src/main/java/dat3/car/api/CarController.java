package dat3.car.api;


import dat3.car.entity.Car;
import dat3.car.repository.CarRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



  @RestController
  @RequestMapping("/api/cars")
  public class CarController {

    CarRepository carRepository;

    public CarController(CarRepository carRepository) {
      this.carRepository = carRepository;
    }


    @GetMapping
    Iterable<Car> getCars() {
      return carRepository.findAll();
    }
  }

