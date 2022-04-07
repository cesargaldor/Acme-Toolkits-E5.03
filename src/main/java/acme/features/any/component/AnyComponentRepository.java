/*
 * AnonymousShoutRepository.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.any.component;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.components.Component;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnyComponentRepository extends AbstractRepository {

	@Query("select c from Component c")
	Collection<Component> findMany();

	@Query("select c from Component c where c.id = :id")
	Component findOneComponentById(Integer id);

}
