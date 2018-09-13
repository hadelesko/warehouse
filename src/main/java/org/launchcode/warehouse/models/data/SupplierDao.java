package org.launchcode.warehouse.models.data;

import org.launchcode.warehouse.models.MMaterial;
import org.launchcode.warehouse.models.Msupplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public interface SupplierDao extends CrudRepository<Msupplier,Integer> {
/*    List<Msupplier>getAllsupplier();
    void saveSupplier(Msupplier msupplier);
    List<MMaterial> getMateiallistByMsupplierId(int supplierId);*/

}
