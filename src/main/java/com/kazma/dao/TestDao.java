package com.kazma.dao;

import com.kazma.entity.Operator;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by 80002526 on 2018/6/25.
 */
@Repository
public interface TestDao {

    void insertOpt(Operator operator);
}
