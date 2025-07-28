package com.jacob.ai.robot.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

/**
 * @Author: Jacob
 * @Description: 演员 - 电影集合
 * @Date: 2025/7/24 21:55
 * @Version: 1.0
 */
@JsonPropertyOrder({"actor", "movies"})
public record ActorFilmography(String actor, List<String> movies) {
}
