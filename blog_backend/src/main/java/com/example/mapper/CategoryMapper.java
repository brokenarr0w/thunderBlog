package com.example.mapper;

import com.example.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Thunder
 * @since 2023-09-08
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
    @Select("select category_name from category where id = #{id}")
    String getCategoryById(@Param("id") String id);
}
