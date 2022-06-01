
package acme.features.any.userAccount;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnyUserAccountRepository extends AbstractRepository {

	@Query("SELECT DISTINCT acc FROM UserAccount acc join FETCH"
		+ " acc.roles r where acc.enabled = 1 and Administrator not in"
		+ " (select type(r) from UserAccount acc2 join acc2.roles r2 where"
		+ " acc2.id = acc.id) and Anonymous not in (select type(r)"
		+ " from UserAccount acc3 join acc3.roles r3 where acc3.id = acc.id)")
	Collection<UserAccount> findManyUserAccountsByAvailability();

	@Query("select acc from UserAccount acc where acc.id = :id")
	UserAccount findUserAccountById(int id);

}
