package de.particity.model.repository;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.FirstResult;
import org.apache.deltaspike.data.api.MaxResults;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.SingleResultType;
import org.apache.deltaspike.data.api.mapping.MappingConfig;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.particity.model.I_OrganizationModel;
import de.particity.model.impl.Organization;
import de.particity.model.map.OrganizationMapper;

@Repository
@Transactional
@MappingConfig(OrganizationMapper.class)
public interface OrganizationRepository extends EntityRepository<I_OrganizationModel, Long> {

	
	//@Query("select count(p) from Person p where p.age > ?1")
    //Long countAllOlderThan(int minAge);
    

    //@Query("select p from Person p where p.age between ?1 and ?2")
    //QueryResult<Person> findAllByAge(int minAge, int maxAge);
	
	//    List<Person> findByLastNameLikeOrderByAgeAscLastNameDesc(String lastName);
	
	//    List<Person> findAllOrderByAgeAsc();
	
	//    List<Person> findByNameLike(String name, @FirstResult int start, @MaxResults int pageSize);
	
	//List<Person> findByNameLike(String name, @FirstResult int start, @MaxResults int pageSize);
	
	//@Query(named = Person.BY_MIN_AGE)
    //Long countAllOlderThan(int minAge);
	
	void removeById(long id);

	List<I_OrganizationModel> findAll(@FirstResult int start, @MaxResults int pageSize);

	List<I_OrganizationModel> findByOwner(String owner);

	@Query(singleResult=SingleResultType.ANY)
	I_OrganizationModel findTop1ByOwner(String owner);

	@Query(named=Organization.getByUserListEntry, isNative=true, singleResult=SingleResultType.ANY)
	I_OrganizationModel findByUser(String user);
}