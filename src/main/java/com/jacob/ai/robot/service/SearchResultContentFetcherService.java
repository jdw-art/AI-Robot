package com.jacob.ai.robot.service;

import com.jacob.ai.robot.model.dto.SearchResultDTO;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Jacob
 * @Description: TODO
 * @Date: 2025/12/21 16:14
 * @Version: 1.0
 */
public interface SearchResultContentFetcherService {

    /**
     * 并发批量获取搜索页面的内容
     * @param searchResults
     * @param timeout
     * @param unit
     * @return
     */
    CompletableFuture<List<SearchResultDTO>> batchFetch(List<SearchResultDTO> searchResults,
                                                        long timeout,
                                                        TimeUnit unit);

}
