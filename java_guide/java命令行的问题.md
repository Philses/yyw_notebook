# java命令行的问题

### Windows解决 java ClassName 发生 “错误: 找不到或无法加载主类 APPEnter”的问题

##### 首先检查jdk的环境变量是否设置合适

* 要将 jdk安装目录\bin 添加到系统变量path中

##### 其次要注意写全包名

* 比如要启动的类的包名为 learn.test
* 那么命令应该为 java learn.test.ClassName，并且执行命令的路径应该在包含learn的文件夹下