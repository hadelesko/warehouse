package org.launchcode.warehouse.models.data;

import org.launchcode.warehouse.models.MMaterial;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public interface SupplierDao {
    List<MMaterial> getMateiallistByMsupplierId(int supplierId);
}
