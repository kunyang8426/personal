package com.kazma.service.impl;

import com.kazma.dao.TestDao;
import com.kazma.entity.InvokeResult;
import com.kazma.entity.Material;
import com.kazma.entity.Operator;
import com.kazma.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 80002526 on 2018/6/25.
 */
@Service("mainService")
public class MainServiceImpl implements MainService{
    @Autowired
    private TestDao testDao;

    @Override
    public void insertOperator(InvokeResult iv, Operator operator) {
        testDao.insertOpt(operator);
    }

    @Override
    public void insertMaterial(InvokeResult iv, Material material) {
        testDao.insertMaterial(material);
    }

    @Override
    public void getMaterials(InvokeResult iv) {
        List<Material> materials = testDao.getMaterials();
        iv.putValueAndReturn("materials", materials);

    }
}
