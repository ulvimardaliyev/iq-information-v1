package az.iq.information.v1.dao.repository;

import az.iq.information.v1.dao.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
}
