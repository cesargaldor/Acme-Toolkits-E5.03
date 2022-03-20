package acme.features.anonymous.patronageReport;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.patronage.Patronage;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousPatronageReportRepository extends AbstractRepository{
	@Query("select p from Patronage p")
	Collection<Patronage> findMany();
}
