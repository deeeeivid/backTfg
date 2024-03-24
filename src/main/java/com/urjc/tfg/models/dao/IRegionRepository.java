package com.urjc.tfg.models.dao;

import com.urjc.tfg.models.entity.Region;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRegionRepository extends CrudRepository<Region, Long> {
    List<Region> findAllRegiones();
}
