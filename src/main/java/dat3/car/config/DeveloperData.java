package dat3.car.config;

import dat3.car.entity.Car;
import dat3.car.entity.Member;
import dat3.car.repository.CarRepository;
import dat3.car.repository.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.util.*;


@Configuration
  public class DeveloperData implements ApplicationRunner { //CommandLineRunner er ca. det samme. Giver en run metode
    // starter programmet

    final CarRepository carRepository;
    final MemberRepo memberRepo;

    // Bruge constructor i stedet for autowired!
    public DeveloperData(CarRepository carRepository, MemberRepo memberRepo){
      this.carRepository = carRepository;
      this.memberRepo = memberRepo;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
      // Her kan man lægge kode som skal kører hver gang vi starter vores projekt op

      // Cars
      Car tesla = new Car("Tesla", "Model Y", 300, 20);
      Car toyota = new Car("Toyota", "Augo X", 200, 20);
      createCar(tesla);
      createCar(toyota);


      // Members
      Member member1 = new Member("skiordie", "skiordie@gmail.com", "rossignol85", "Marcus", "Holje", "Rødåsen 81", "Gressvik", "1621", false, 0);
      member1.setFavoriteCarColors(new ArrayList<>(Arrays.asList("White", "Silver")));
      member1.setPhones(new HashMap<>(){
        {
          put("Mobil", "52340457");
          put("Arbejde", "8009020");
        }
      });
      createMember(member1);


      Member member2 = new Member("tommyT", "tt@gmail.com", "hiphoplegenden1990!", "Tommy", "Helle Jensen", "Godthåbsvej 100", "Frederiksberg", "2000", true, 100);
      member2.setFavoriteCarColors(new ArrayList<>(Arrays.asList("Black", "Blue")));
      member2.setPhones(new HashMap<>(){
        {
          put("Mobil", "20508090");
          put("Arbejde", "68794060");
        }
      });
      createMember(member2);


      Member member3 = new Member("seb700", "seb@gmail.com", "DetteERmitBEDSTEpassord75487354730!", "Sebastian", "Heiberg", "Nymosevej 18", "Vangede", "2820" , false, 5);
      member3.setFavoriteCarColors(new ArrayList<>(Arrays.asList("Pink", "Purple")));
      member3.setPhones(new HashMap<>(){
        {
          put("Mobil", "90807040");
          put("Arbejde", "45454545");
        }
      });
      createMember(member3);
    }


    public void createMember(Member member){
      memberRepo.save(member);
    }

    // Inject the repository into the DeveloperDataSetup class (implemented in 1-c)
    // and create a few cars
    public void createCar(Car car){
      carRepository.save(car);
    }


  }


