# AI Robot Spring Boot 项目

智能AI机器人项目，基于Spring Boot和Spring AI构建，集成多种大模型API，提供丰富的AI能力接口。

## 项目概述

本项目是一个基于 Spring Boot 和 Spring AI 构建的智能 AI 机器人系统，支持多种大模型接入（如 Deepseek、Ollama、OpenAI、智谱AI、阿里百炼等），提供丰富的 AI 能力接口，包括文本生成、工具调用、多模态处理（图文音视频）、结构化输出、提示词模板管理等功能。

### 核心功能

- **多模型支持**: 集成 DeepSeek、Ollama、OpenAI、ZhipuAI、阿里百炼等多种 LLM
- **工具调用 (Tool Calling)**: 支持时间查询、天气查询等自定义工具
- **多模态生成**: 文生图、文生音频、文生视频接口封装
- **结构化输出**: 利用 JSON Schema 实现 AI 输出标准化
- **Prompt 模板管理**: 外部化存储 `.st` 模板文件，支持动态加载
- **对话记忆管理**: 支持对话历史的持久化存储
- **跨域支持**: 支持前端跨域请求

## 技术栈

- **后端框架**: Spring Boot 3.5.3, Spring AI 1.0.0
- **编程语言**: Java 21
- **AI集成**: 阿里云百炼平台 (通过OpenAI兼容接口)
- **数据库**: PostgreSQL
- **ORM框架**: MyBatis-Plus 3.5.12
- **其他依赖**: Lombok 1.18.30, Apache Commons Lang3 3.12.0
- **构建工具**: Maven

## 项目结构

```
ai-robot-springboot/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/jacob/ai/robot/
│   │   │       ├── config/          # 配置类
│   │   │       ├── domain/          # 数据库实体和映射
│   │   │       ├── model/           # 数据模型
│   │   │       └── AiRobotSpringbootApplication.java  # 启动类
│   │   └── resources/
│   │       ├── application.yml      # 主配置文件
│   │       ├── application-dev.yml  # 开发环境配置
│   │       └── application-prod.yml # 生产环境配置
│   └── test/
│       └── java/
│           └── com/jacob/ai/robot/  # 测试类
├── pom.xml                         # Maven配置文件
└── README.md                       # 项目说明文档
```

## 核心组件

### 配置类

1. **ChatClientConfig**: 配置AI聊天客户端
2. **CorsConfig**: 跨域配置，允许所有域名访问
3. **MybatisPlusConfig**: MyBatis-Plus配置，扫描Mapper接口

### 数据库实体

- **ChatDO**: 对话实体类，对应数据库表`t_chat`
- **ChatMapper**: 对话实体的数据库操作接口

### 数据模型

- **AIResponse**: AI响应数据模型

## 配置说明

### 环境配置

项目支持多环境配置，默认激活开发环境(`dev`):

```yaml
# application.yml
spring:
  profiles:
    active: dev
```

### 开发环境配置

```yaml
# application-dev.yml
spring:
  ai:
    openai:
      base-url: https://dashscope.aliyuncs.com/compatible-mode
      api-key: your_api_key_here

  datasource:
    driver-class-name: org.postgresql.Driver
    url: jdbc:postgresql://localhost:5432/robot
    username: postgres
    password: postgres
```

### 数据库表结构

对话记录表 `t_chat`：

| 字段名 | 类型 | 描述 |
|--------|------|------|
| id | BIGINT | 主键 |
| uuid | VARCHAR | 对话唯一标识 |
| summary | VARCHAR | 对话摘要 |
| create_time | TIMESTAMP | 创建时间 |
| update_time | TIMESTAMP | 更新时间 |

## 快速开始

### 环境要求

- JDK 21
- Maven 3.6+
- PostgreSQL数据库

### 安装步骤

1. 克隆项目
   ```bash
   git clone <项目地址>
   ```

2. 修改配置文件
   在 [application-dev.yml](file://E:\IDEAWorkplace\ai-robot\project\ai-robot-springboot\src\main\resources\application-dev.yml) 中配置数据库连接和API密钥

3. 创建数据库
   ```sql
   CREATE DATABASE robot;
   ```

4. 构建项目
   ```bash
   mvn clean package
   ```

5. 运行项目
   ```bash
   mvn spring-boot:run
   ```
   
   或者
   ```bash
   java -jar target/ai-robot-0.0.1-SNAPSHOT.jar
   ```

## API端点

项目启动后，默认端口为 `8080`。

## 测试

项目包含基本的单元测试:

```bash
mvn test
```

## 注意事项

1. 需要有效的阿里云百炼API Key
2. 确保PostgreSQL数据库服务运行正常
3. 生产环境应修改跨域配置，指定具体的允许域名
4. 当前项目使用了Spring Snapshots仓库，可能存在不稳定性风险

## 项目特点

- 基于 Spring Boot 3 + Java 21 的现代化技术栈
- 使用 Lombok 减少样板代码
- 支持跨域配置，便于前端联调
- 可通过配置灵活切换不同 AI 模型后端
- 配置驱动模式，所有模型和行为通过配置文件控制