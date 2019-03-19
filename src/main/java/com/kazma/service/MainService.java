package com.kazma.service;

import com.kazma.entity.InvokeResult;
import com.kazma.entity.Material;
import com.kazma.entity.Operator;

/**
 * Created by 80002526 on 2018/6/25.
 */
public interface MainService {
    public void insertOperator(InvokeResult iv, Operator paramMap);

    void insertMaterial(InvokeResult iv, Material material);

    void getMaterials(InvokeResult iv);
}
