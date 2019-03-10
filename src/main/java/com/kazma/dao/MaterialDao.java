package com.kazma.dao;

import com.kazma.entity.MaterialBase;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialDao {
    void insertMaterialBase(MaterialBase materialBase);

    List<MaterialBase> selectMaterialBase();
}
