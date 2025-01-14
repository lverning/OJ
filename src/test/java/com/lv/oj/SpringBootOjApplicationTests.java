package com.lv.oj;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lv.oj.common.ErrorCode;
import com.lv.oj.exception.ThrowUtils;
import com.lv.oj.model.entity.Question;
import com.lv.oj.model.vo.QuestionVO;
import com.lv.oj.service.QuestionService;
import com.lv.oj.service.impl.QuestionServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootOjApplicationTests {

    @Autowired
    private QuestionServiceImpl questionService;
    @Test
    void contextLoads() {
        QueryWrapper<Question> queryWrapper = new QueryWrapper<>();
        Page<Question> page = questionService.page(new Page<>(1, 10), queryWrapper);
        Page<QuestionVO> questionVOPage = questionService.getQuestionVOPage(page, null);
        List<QuestionVO> records = questionVOPage.getRecords();
        for (int i = 0; i <records.size(); i++) {
            System.out.println(records.get(i));
        }
    }

}
