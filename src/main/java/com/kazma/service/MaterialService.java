package com.kazma.service;

import com.kazma.entity.InvokeResult;
import com.kazma.entity.MaterialBase;

public interface MaterialService {
    void insertMaterialBase(InvokeResult iv, MaterialBase materialBase);

    void selectMaterialBase(InvokeResult iv);
}
