package practice.query;

import static practice.entity.country.QCity.city;
import static practice.entity.country.QCountry.country;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import practice.entity.country.Country;

@Repository
public class CountryQuery {
    @PersistenceContext
    private EntityManager em;

    public void test() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        
        List<Country> fetch = queryFactory
            .select(country)
            .from(country)
            .join(country.cities, city)
            .fetch();
        
        System.out.println("hello test");
    }
}