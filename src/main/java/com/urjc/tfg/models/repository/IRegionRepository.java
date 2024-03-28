package com.urjc.tfg.models.repository;

import com.urjc.tfg.models.entity.Region;
import org.springframework.data.repository.CrudRepository;

public interface IRegionRepository extends CrudRepository<Region, Long> {
}
