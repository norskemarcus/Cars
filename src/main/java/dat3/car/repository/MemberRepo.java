package dat3.car.repository;

import dat3.car.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepo extends JpaRepository<Member, String> {


}
