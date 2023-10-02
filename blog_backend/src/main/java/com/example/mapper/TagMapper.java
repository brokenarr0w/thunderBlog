package com.example.mapper;

import com.example.entity.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Thunder
 * @since 2023-09-08
 */
@Mapper
public interface TagMapper extends BaseMapper<Tag> {
    /**
     * @param id 文章id
     * @return 文章对应的所有tag
     * 根据文章id查询所有的对应tag
     */
    @Select("select tag.* from tag,blog_tag where blog_tag.blog_id = #{blog_id} and tag.id = blog_tag.tag_id")
    List<Tag> getTags(@Param("blog_id")String id);

}
