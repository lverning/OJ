package com.lv.oj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lv.oj.model.entity.Post;
import com.lv.oj.model.entity.Question;


/**
* @author 吕
* @description 针对表【post(帖子)】的数据库操作Service
* @createDate 2025-01-10 20:38:32
*/
public interface PostService extends IService<Post> {

    /**
     * 校验
     *
     * @param post
     * @param add
     */
    void validPost(Post post, boolean add);

}
