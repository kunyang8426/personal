package com.kazma.sevice.impl;

import com.kazma.dao.MaterialDao;
import com.kazma.entity.Material;
import com.kazma.sevice.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialServiceImpl implements MaterialService{
    @Autowired
    private MaterialDao materialDao;


}
