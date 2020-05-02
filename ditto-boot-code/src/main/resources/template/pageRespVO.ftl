package ${packageName}.controller.vo;

import ${packageName}.entity.${className}DO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;


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
public class ${className}PageRespVO  {
	/**
	  * 构造方法
	  * @param entity
	  */
	public ${className}PageRespVO( ${className}DO entity){
		BeanUtils.copyProperties(entity,this);
	}

	 /**
     * 物理主键
     */
    private Long id;

	<#list fieldList as field>
    /**
     * 字段名
     */
    private ${field.type} ${field.name};
    </#list>
}
