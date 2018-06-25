package com.kazma.sevice.impl;

import com.kazma.dao.TestDao;
import com.kazma.entity.InvokeResult;
import com.kazma.entity.Operator;
import com.kazma.sevice.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
