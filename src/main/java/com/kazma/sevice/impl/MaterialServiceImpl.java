package com.kazma.sevice.impl;

import com.kazma.dao.MaterialDao;
import com.kazma.entity.InvokeResult;
import com.kazma.entity.Material;
import com.kazma.entity.MaterialBase;
import com.kazma.sevice.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService{
    @Autowired
    private MaterialDao materialDao;


    @Override
    public void insertMaterialBase(InvokeResult iv, MaterialBase materialBase) {
        materialDao.insertMaterialBase(materialBase);
    }

    @Override
    public void selectMaterialBase(InvokeResult iv) {
        List<MaterialBase> materialBases = materialDao.selectMaterialBase();
        iv.putValueAndReturn("materialBases", materialBases);
    }
}
