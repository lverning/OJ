package com.lv.oj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.lv.oj.mapper.PostMapper;
import com.lv.oj.model.entity.Post;
import com.lv.oj.service.PostService;
import org.springframework.stereotype.Service;

/**
 * @author 吕
 * @description 针对表【post(帖子)】的数据库操作Service实现
 * @createDate 2025-01-10 20:38:32
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post>
        implements PostService {

}




