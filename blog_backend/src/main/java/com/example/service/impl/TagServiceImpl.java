package com.example.service.impl;

import com.example.entity.Tag;
import com.example.mapper.TagMapper;
import com.example.service.ITagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Thunder
 * @since 2023-09-08
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {

}
