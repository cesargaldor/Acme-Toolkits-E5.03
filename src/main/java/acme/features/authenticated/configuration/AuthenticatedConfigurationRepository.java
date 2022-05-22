package acme.features.authenticated.configuration;
import java.util.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.configuration.Configuration;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedConfigurationRepository extends AbstractRepository {
	
	@Query("select c from Configuration c")
    Collection<Configuration> findConfiguration();
}
