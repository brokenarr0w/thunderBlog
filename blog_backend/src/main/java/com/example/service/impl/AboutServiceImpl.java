package com.example.service.impl;

import com.example.entity.About;
import com.example.mapper.AboutMapper;
import com.example.service.IAboutService;
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
public class AboutServiceImpl extends ServiceImpl<AboutMapper, About> implements IAboutService {

}
