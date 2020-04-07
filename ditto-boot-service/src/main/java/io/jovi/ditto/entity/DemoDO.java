package io.jovi.ditto.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.jovi.ditto.core.domain.entity.AbstractVersionDO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
@Getter
@Setter
@ToString
@NoArgsConstructor
@TableName("ditto_demo")
public class DemoDO extends AbstractVersionDO {
    /**
     * 姓名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 年龄
     */
    @TableField(value = "age")
    private Integer age;
}
