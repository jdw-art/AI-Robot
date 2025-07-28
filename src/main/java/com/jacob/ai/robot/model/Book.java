package com.jacob.ai.robot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: Jacob
 * @Description: 书籍信息
 * @Date: 2025/7/24 22:04
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    /**
     * 书名
     */
    private String title;

    /**
     * 作者
     */
    private String author;

    /**
     * 发布年份
     */
    private Integer publishYear;

    /**
     * 类型
     */
    private List<String> genres;

    /**
     * 简介
     */
    private String description;
}