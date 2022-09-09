# java_demo

### #安装Java和Maven
1. https://www.oracle.com/java/technologies/downloads/
2. http://maven.apache.org/download.cgi

> 安装完成之后需要配置环境变量

### #使用Maven创建项目
```bash
# -DgroupId: 组织名，公司网址的反写 + 项目名称
# -DartifactId: 项目名-模块名
# -DarchetypeArtifactId: 指定 ArchetypeId，maven-archetype-quickstart，创建一个简单的 Java 应用
# -DinteractiveMode: 是否使用交互模式
mvn archetype:generate "-DgroupId=com.companyname.bank" "-DartifactId=consumerBanking" "-DarchetypeArtifactId=maven-archetype-quickstart" "-DinteractiveMode=false"
```

### #使用第三方依赖
```xml
<!-- 在pom.xml文件中配置dependency -->
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  
  <!-- 项目描述 -->
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.companyname.bank</groupId>
  <artifactId>consumerBanking</artifactId>
  <packaging>jar</packaging>
  <version>1.0-SNAPSHOT</version>
  <name>consumerBanking</name>
  <url>http://maven.apache.org</url>

  <dependencies>
    <!-- 下面是项目第三方依赖 -->

    <!-- 测试用例依赖 -->
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>

    <!-- 开发依赖 -->
    <dependency>
      <groupId>cn.hutool</groupId>
      <artifactId>hutool-all</artifactId>
      <version>5.8.6</version>
    </dependency>

    <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>fastjson</artifactId>
      <version>1.2.76</version>
    </dependency>
    
  </dependencies>
  
  <!-- 项目编码 -->
  <properties>
    <!-- <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding> -->
    <!-- <maven.compiler.encoding>UTF-8</maven.compiler.encoding> -->
    <java.version>11</java.version>
    
    <!-- 打包报错 -->
    <maven.compiler.source>11</maven.compiler.source>
    <maven.compiler.target>11</maven.compiler.target>
  </properties>

  <!-- 打包配置 -->
  <build>
    <finalName>my-project-name</finalName>
    <plugins>

        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.6.1</version>
            <configuration>
                <source>1.8</source>
                <target>1.8</target>
            </configuration>
        </plugin>

        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-assembly-plugin</artifactId>
            <version>3.1.1</version>

            <configuration>
                <descriptorRefs>
                    <descriptorRef>jar-with-dependencies</descriptorRef>
                </descriptorRefs>
            </configuration>

            <executions>
                <execution>
                    <id>make-assembly</id>
                    <phase>package</phase>
                    <goals>
                        <goal>single</goal>
                    </goals>
                </execution>
            </executions>

        </plugin>

        <plugin>
          <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-maven-plugin</artifactId>
         
         <!-- 解决运行时找不到依赖 -->
         <executions>
              <execution>
                <goals>
                  <goal>repackage</goal>
                </goals>
              </execution>
            </executions>
        </plugin>

    </plugins>
</build>
</project>

```

### #编译打包
```bash
# 使用Maven

# 清除目标目录中的生成结果
mvn clean

# 编译
mvn compile

# 打包
mvn package

# 在本地Repository中安装jar
mvn install

# 运行编译后的jar包
java -jar morin.jar

```
