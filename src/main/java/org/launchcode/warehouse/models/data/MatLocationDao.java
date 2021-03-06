package org.launchcode.warehouse.models.data;

import org.launchcode.warehouse.models.MatLocation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface MatLocationDao extends CrudRepository<MatLocation,Integer> {
}
