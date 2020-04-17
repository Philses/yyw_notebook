# 在IDEA中生成Maven项目的jar文件

### 首先需要配置pom文件：

```html
<build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-jar-plugin</artifactId>
                <configuration>
                    <archive>
                        <manifest>
                            <addClasspath>true</addClasspath>
                            <useUniqueVersions>false</useUniqueVersions>
                            <classpathPrefix>lib/</classpathPrefix>
                            <mainClass>window.APPEnter</mainClass>
                        </manifest>
                    </archive>
                </configuration>
            </plugin>
        </plugins>
    </build>
```

* 注意`<mainClass>window.APPEnter</mainClass>`tag中间的内容是程序入口类的完全类名（包+类）

### 然后直接找到IDEA的Maven命令：

![IDEA中maven打包jar.png](https://github.com/ustcyyw/nootbook/blob/master/Tool_use_guide/IDEA%E4%B8%ADmaven%E6%89%93%E5%8C%85jar.png?raw=true)

* 点击package，运行完成后，就会在target文件夹下面找到一个jar。
* 在该文件夹下面使用命令 java -jar [文件名.jar] 即可运行。