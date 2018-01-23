# 使用 Spring4.3集成mybatisplus的非web项目,可以运行时指定数据配置

## 技术点

```
Spring + mybatisplus 非 WEB项目

使用JVM参数实现数据库配置文件db.properties的运行时指定

扩展PropertyPlaceholderConfigurer实现读取并解密,DES加密后配置的文件db.properties


```

## 运行方式

### 打包

```
mvn clean package
```

### 运行

```
修改com.springmybatis.test.TestSecure中的name和pwd值,并运行该类得到DES加密后的值,替换db.properties中的jdbc_username以及jdbc_password

java -DCONFIG_PATH=/opt/dev/resources/db.properties  -jar target/data-0.0.1-SNAPSHOT.jar 

```

### 过程中的坑


#### 如何在运行jar是指定外部的db.properties

```
使用PropertyPlaceholderConfigurer指定location值时,定义自己的变量CONFIG_PATH,这样就可以在运行jar时,指定参数-DCONFIG_PATH 来指定外部的db.properties
```

```xml
<!-- 如果配置不是加密的可以用默认的PropertyPlaceholderConfigurer -->
<bean id="propertyConfigurer"
		class="com.springmybatis.noweb.EncryptPropertyPlaceholderConfigurer">

		<property name="systemPropertiesModeName" value="SYSTEM_PROPERTIES_MODE_OVERRIDE" />
		<property name="location">
			<value>file://${CONFIG_PATH}</value>
		</property>
	</bean>

```

#### 打包运行后出现Unable to locate Spring NamespaceHandler for XML schema namespace

```
这个是因为没有把spring-schema打到包里面去
```

```xml
		<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-shade-plugin</artifactId>
				<version>2.4.2</version>
				<executions>
					<execution>
						<phase>package</phase>
						<goals>
							<goal>shade</goal>
						</goals>
						<configuration>
							<descriptorRefs>
							
								<descriptorRef>jar-with-dependencies</descriptorRef>
							</descriptorRefs>
							<transformers>
								<transformer
									implementation="org.apache.maven.plugins.shade.resource.AppendingTransformer">
									<resource>META-INF/spring.handlers</resource>
								</transformer>
								<transformer
									implementation="org.apache.maven.plugins.shade.resource.AppendingTransformer">
									<resource>META-INF/spring.schemas</resource>
								</transformer>
								<transformer
									implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
									<mainClass>com.springmybatis.noweb.App</mainClass>
								</transformer>
							</transformers>
						</configuration>
					</execution>
				</executions>
			</plugin>
```



