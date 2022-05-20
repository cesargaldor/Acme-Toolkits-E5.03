package acme.features.inventor.patronageReport;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.patronage.Patronage;
import acme.entities.patronageReport.PatronageReport;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;

@Repository
public interface InventorPatronageReportRepository extends AbstractRepository{

	//Consulta para buscar patroage reports por username de inventor
	@Query("select pr from PatronageReport pr where pr.patronage.inventor.userAccount.username = :username")
	Collection<PatronageReport> findPatronagesReports(String username);

	//Consulta para buscar patronage report por id
	@Query("select pr from PatronageReport pr where pr.id = :id")
	PatronageReport findOnePatronageReport(int id);
	
	@Query("select p from Patronage p where p.id = :id")
	Patronage findPatronageById(int id);

	//Consulta para buscar inventor por id
	@Query("select i from Inventor i where i.id = ?1")
	Inventor findInventorById(Integer id);

	//Consulta para buscar coleccion de patronage reports por id de patronage
	@Query("select pr from PatronageReport pr where pr.patronage.id = :id")
	Collection<PatronageReport> findPatronageReportsByPatronageId(int id);

	//Consulta para buscar patronage dado un code
	@Query("select p from Patronage p where p.code = :code")
	Patronage findPatronageByCode(String code);

	//Consulta que devuelve los patronage reports dado un code de patronage
	@Query("select pr from PatronageReport pr where pr.patronage.code = :code")
	Collection<PatronageReport> findPatronagesReportsByPatronages(String code);
	
	
}
