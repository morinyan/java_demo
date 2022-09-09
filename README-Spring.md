# Java项目集成Spring框架

### #创建基本Java启动项目

具体操作可以参考README.md文件

### #在pom.xml中添加依赖
```xml
<!-- 添加spring-boot-starter-web -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
  <version>2.7.3</version>
</dependency>

```

### #入口函数代码
```java
package com.morin.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }

    @GetMapping("/hello")
        public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("->>>> ->>>Hello %s!", name);
	}
}

```

### #编译打包
```bash
# 1
mvn clean

# 2
mvn package

# 3
java -jar target/demo.jar
```

### #链接
1. [https://start.spring.io/](https://start.spring.io/)
2. [https://springref.com/quickstart](https://springref.com/quickstart)
3. [https://mvnrepository.com/](https://mvnrepository.com/)
