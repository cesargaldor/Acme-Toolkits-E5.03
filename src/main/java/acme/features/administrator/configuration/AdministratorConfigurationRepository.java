package acme.features.administrator.configuration;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import acme.entities.configuration.Configuration;
import acme.framework.repositories.AbstractRepository;

public interface AdministratorConfigurationRepository extends AbstractRepository {

	@Query("select c from Configuration c")
	List<Configuration> findManySpamWord();

}
