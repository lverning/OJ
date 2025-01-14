package com.lv.oj.controller;


import cn.hutool.json.JSONUtil;
import com.lv.oj.common.BaseResponse;
import com.lv.oj.common.DeleteRequest;
import com.lv.oj.common.ErrorCode;
import com.lv.oj.common.ResultUtils;
import com.lv.oj.constant.UserConstant;
import com.lv.oj.exception.BusinessException;
import com.lv.oj.exception.ThrowUtils;
import com.lv.oj.model.dto.post.PostAddRequest;
import com.lv.oj.model.entity.Post;
import com.lv.oj.model.entity.User;
import com.lv.oj.service.PostService;
import com.lv.oj.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;
    /**
     * 创建
     *
     * @param postAddRequest
     * @param request
     * @return
     */
    @PostMapping("/add")
    public BaseResponse<Long> addPost(@RequestBody PostAddRequest postAddRequest, HttpServletRequest request) {
        if (postAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Post post = new Post();
        BeanUtils.copyProperties(postAddRequest, post);
        List<String> tags = postAddRequest.getTags();
        if (tags != null) {
            post.setTags(JSONUtil.toJsonStr(tags));
        }
        postService.validPost(post, true);
        User loginUser = userService.getLoginUser(request);
        post.setUserId(loginUser.getId());
        post.setFavourNum(0);
        post.setThumbNum(0);
        boolean result = postService.save(post);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        long newPostId = post.getId();
        return ResultUtils.success(newPostId);
    }

    /**
     * 删除
     *
     * @param deleteRequest
     * @param request
     * @return
     */
    @PostMapping("/delete")
    public BaseResponse<Boolean> deletePost(@RequestBody DeleteRequest deleteRequest,HttpServletRequest request){
        if (deleteRequest == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        long id = deleteRequest.getId();
        User user = userService.getLoginUser(request);
        Post post = postService.getById(id);
        // 判断是否存在
        if (post == null){
            throw new BusinessException(ErrorCode.OPERATION_ERROR,"数据不存在");
        }
        // 只有本人和管理员可删除
        if (!post.getUserId().equals(user.getId()) && !user.getUserRole().equals(UserConstant.ADMIN_ROLE)){
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        boolean result = postService.removeById(id);
        if (!result){
            throw new BusinessException(ErrorCode.OPERATION_ERROR);
        }
        return ResultUtils.success(result);
    }



}
