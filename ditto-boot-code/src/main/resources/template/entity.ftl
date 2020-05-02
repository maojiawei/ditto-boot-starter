package ${packageName}.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.jovi.ditto.core.domain.entity.AbstractVersionDO;

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
@Getter
@Setter
@ToString
@NoArgsConstructor
@TableName("${tableName}")
public class ${className}DO extends AbstractVersionDO  {

    <#list fieldList as field>
    /**
     * 字段名
     */
    @TableField(value = "${field.dbName}")
    private ${field.type} ${field.name};
    </#list>


}
