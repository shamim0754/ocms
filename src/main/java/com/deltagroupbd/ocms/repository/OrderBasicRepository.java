package com.deltagroupbd.ocms.repository;

import com.deltagroupbd.ocms.model.OrderBasic;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface OrderBasicRepository extends CrudRepository<OrderBasic, Long> {

    List<OrderBasic> findByBuyerName(String buyerName);
}