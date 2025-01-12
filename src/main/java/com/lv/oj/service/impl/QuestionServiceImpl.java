package com.lv.oj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lv.oj.mapper.QuestionMapper;
import com.lv.oj.model.entity.Question;

import com.lv.oj.service.QuestionService;
import org.springframework.stereotype.Service;

/**
* @author 吕
* @description 针对表【question(题目)】的数据库操作Service实现
* @createDate 2025-01-11 21:15:09
*/
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question>
    implements QuestionService {

}




