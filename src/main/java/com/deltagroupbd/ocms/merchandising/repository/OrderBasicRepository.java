package com.deltagroupbd.ocms.merchandising.repository;

import com.deltagroupbd.ocms.merchandising.model.OrderBasic;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface OrderBasicRepository extends CrudRepository<OrderBasic, Long> {

    List<OrderBasic> findByBuyerName(String buyerName);
}