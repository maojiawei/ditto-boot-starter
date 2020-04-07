package io.jovi.ditto.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.jovi.ditto.entity.DemoDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
@Mapper
public interface DemoRepository extends BaseMapper<DemoDO> {

}
