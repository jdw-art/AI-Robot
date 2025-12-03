package com.jacob.ai.robot;

import com.jacob.ai.robot.domain.dos.ChatDO;
import com.jacob.ai.robot.domain.mapper.ChatMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @Author: Jacob
 * @Description: TODO
 * @Date: 2025/9/23 21:23
 * @Version: 1.0
 */
@SpringBootTest
public class MybatisPlusTests {

    @Resource
    private ChatMapper chatMapper;

    /**
     * 添加数据
     */
    @Test
    void testInsert() {
        chatMapper.insert(ChatDO.builder()
                .uuid(UUID.randomUUID().toString())
                .summary("新对话")
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build());
    }
}
