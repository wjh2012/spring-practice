package practice.jpa.repository.country;

import org.springframework.data.repository.CrudRepository;
import practice.jpa.entity.country.District;

public interface DistrictRepository extends CrudRepository<District, Long> {

}