package HospitalApp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRePository extends JpaRepository<Hospital,Long> {
    @Query(value = "select * from Hospital WHERE Number=?1 ", nativeQuery = true)

    public List <Hospital> search(@Param("keyword")Long Number);

}
