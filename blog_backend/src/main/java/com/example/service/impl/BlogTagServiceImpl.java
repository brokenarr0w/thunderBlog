package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.BlogTags;
import com.example.mapper.BlogTagMapper;
import com.example.service.IBlogTagService;
import com.github.jeffreyning.mybatisplus.service.MppServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BlogTagServiceImpl extends MppServiceImpl<BlogTagMapper, BlogTags> implements IBlogTagService {
}
