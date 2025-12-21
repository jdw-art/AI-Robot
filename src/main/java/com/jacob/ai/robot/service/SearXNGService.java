package com.jacob.ai.robot.service;

import com.jacob.ai.robot.model.dto.SearchResultDTO;

import java.util.List;

/**
 * @Author: Jacob
 * @Description: TODO
 * @Date: 2025/12/21 16:13
 * @Version: 1.0
 */
public interface SearXNGService {

    /**
     * 调用 SearXNG Api，获取搜索结果
     * @param query
     * @return
     */
    List<SearchResultDTO> search(String query);

}
