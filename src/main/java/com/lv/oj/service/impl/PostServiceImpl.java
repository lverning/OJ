package com.lv.oj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.lv.oj.common.ErrorCode;
import com.lv.oj.exception.BusinessException;
import com.lv.oj.exception.ThrowUtils;
import com.lv.oj.mapper.PostMapper;
import com.lv.oj.model.entity.Post;
import com.lv.oj.service.PostService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author 吕
 * @description 针对表【post(帖子)】的数据库操作Service实现
 * @createDate 2025-01-10 20:38:32
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post>
        implements PostService {

    @Override
    public void validPost(Post post, boolean add) {
        if (post == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String title = post.getTitle();
        String content = post.getContent();
        String tags = post.getTags();
        // 创建时参数不能为空
        if (add){
            ThrowUtils.throwIf(StringUtils.isAllBlank(title,content,tags),ErrorCode.PARAMS_ERROR);
        }
        // 有参数则校验
        if (StringUtils.isNotBlank(title) && title.length() > 80) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "标题过长");
        }
        if (StringUtils.isNotBlank(content) && content.length() > 8192) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "内容过长");
        }
    }
}




