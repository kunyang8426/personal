package com.kazma.dao;

import com.kazma.entity.Material;
import com.kazma.entity.Operator;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 80002526 on 2018/6/25.
 */
@Repository
public interface TestDao {

    void insertOpt(Operator operator);

    void insertMaterial(Material material);

    List<Material> getMaterials();
}
