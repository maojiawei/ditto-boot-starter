package ${packageName}.service;

import com.baomidou.mybatisplus.extension.service.IService;
import ${packageName}.entity.${className}DO;
import com.github.pagehelper.Page;
import io.jovi.ditto.core.domain.page.PageBO;


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
public interface ${className}Service extends IService<${className}DO> {
    /**
      * 分页查询
      * @param pageBO
      * @return
      */
    Page<${className}DO> page(PageBO pageBO);
}
