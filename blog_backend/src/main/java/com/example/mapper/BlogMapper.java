package com.example.mapper;

import com.example.entity.Blog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

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
public interface BlogMapper extends BaseMapper<Blog> {
    /**
     * @param id 文章id
     * @return 文章实体类
     * 根据文章id查询文章
     */
    @Select("select * from blog where id = #{id}")
    @Results({
            @Result(
                    property = "tags",column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.example.mapper.TagMapper.getTags")
            ),
            @Result(
                    property = "categoryName",column = "category_id",
                    javaType = String.class,
                    one = @One(select = "com.example.mapper.CategoryMapper.getCategoryById")
            ),
})
    Blog selectBlog(@Param("id") String id);

    @Select("select * from blog")
    @Results({
            @Result(
                    property = "tags", column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.example.mapper.TagMapper.getTags")
            ),
            @Result(
                    property = "categoryName",column = "category_id",
                    javaType = String.class,
                    one = @One(select = "com.example.mapper.CategoryMapper.getCategoryById")
            ),
            @Result(
                    property = "categoryId",column = "category_id"
            ),
            @Result(
                    property = "id", column = "id"
            )
    }
    )
    List<Blog> selectAllBlogs();
    @Select("select * from blog limit #{pageNum},#{toNum}")
    @Results({
            @Result(
                    property = "tags", column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.example.mapper.TagMapper.getTags")
            ),
            @Result(
                    property = "categoryName",column = "category_id",
                    javaType = String.class,
                    one = @One(select = "com.example.mapper.CategoryMapper.getCategoryById")
            ),
            @Result(
                    property = "categoryId",column = "category_id"
            ),
            @Result(
                    property = "id", column = "id"
            )
    }
    )
    List<Blog> selectblogsByPageNum(int pageNum,int toNum);
    @Select("select * from blog where category_id = #{id} limit #{pageNum}, #{toNum}")
    @Results({
            @Result(
                    property = "tags", column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.example.mapper.TagMapper.getTags")
            ),
            @Result(
                    property = "categoryName", column = "category_id",
                    javaType = String.class,
                    one = @One(select = "com.example.mapper.CategoryMapper.getCategoryById")
            ),
            @Result(
                    property = "id", column = "id"
            )
    })
    List<Blog> getBlogListByCategoryId(Long id, int pageNum, int toNum);
    @Select("select * from blog join blog_tag on blog_id = id where tag_id = #{id} limit #{pageNum},5")
    @Results({
            @Result(
                    property = "tags", column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.example.mapper.TagMapper.getTags")
            ),
            @Result(
                    property = "categoryName", column = "category_id",
                    javaType = String.class,
                    one = @One(select = "com.example.mapper.CategoryMapper.getCategoryById")
            ),
            @Result(
                    property = "id", column = "id"
            )
    })
    List<Blog> selectBlogByTag(@Param("id") Long id,@Param("pageNum") int pageNum);
    @Select("select * from blog limit 0,3")
    List<Blog> selectNewBlogs();
    @Select("select * from blog where is_top = 1 limit 0,3")
    List<Blog> selectTopBlogs();
    }
