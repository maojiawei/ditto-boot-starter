package ${packageName}.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ${packageName}.entity.${className}DO;
import ${packageName}.repository.${className}Repository;
import ${packageName}.service.${className}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import io.jovi.ditto.core.domain.page.PageBO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


/**
  * <p>
  * Title:
  * </p>
  * <p>
  * Description:
  * </p>
  * <p>
  * Copyright: Copyright (c) 2020
  * </p>
  *
  * @author ditto
  * @version 1.0
  */
@Service
public class ${className}ServiceImpl extends ServiceImpl<${className}Repository,${className}DO> implements ${className}Service {
    @Autowired
    private  ${className}Repository repository;

    /**
     * 分页查询
     *
     * @param pageBO
     * @return
     */
    @Override
    public Page<${className}DO> page(PageBO pageBO) {
        QueryWrapper<${className}DO> wrapper = new QueryWrapper();
        
        Page<${className}DO> page = pageBO.startPage()
                .doSelectPage(()-> repository.selectList(wrapper));
        return page;
    }
}
