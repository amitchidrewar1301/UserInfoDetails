package info.repository;

import info.entity.UserContactInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserContactInfoRepository extends CrudRepository<UserContactInfo, Long> {


}
