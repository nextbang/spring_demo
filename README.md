# spring_demo

该项目为maven+spring+mybatis的基础架构，包含的具体框架版本为：


### 项目版本
maven：3.3

spring：4.3.3.RELEASE

mybatis：3.2.6


### 自动生成orm映射
1. 修改配置文件：/src/main/resources/generatorConfig.xml
	> 修改classPathEntry

	> 修改jdbcConnection
	> 
	> 修改targetProject
	> 
2. 运行mvn命令

	> mvn mybatis-generator:generate
	
### 拦截器说明

1. TimeInteceptor统计每个action的运行时长(单位:ms)
2. LoginInteceptor检查用户是否为登录状态