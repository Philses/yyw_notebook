# git 使用部分说明

[toc]

### 提交人信息查看与修改

- 从本地commit代码到github如果不修改提交人信息一致，是无法计算contribution的。所以一定要修改一致。
- 查看提交人信息的git bash命令行为
    - git config user.name
    - git config user.email
- 修改提交人信息的git bash命令行为：
    - git config --global user.name "ustcyyw"
    - git config --global user.email yang0@mail.ustc.edu.cn

### 版本回退

* git命令使用错误导致文件修改添加删除出现错误，可以通过git来进行版本回退。
* 第一步，在该目录下输入`git log`得到所有的commit记录，再找到自己想要回退到的版本对应的commit ID复制下来。退出`git log`命令只需要输入`q`即可。
* 第二步，使用命令`git reset --hard <commit ID>`即可

### 文件名修改

* 首先通过命令行`git mv <old filename> <new filename>`。注意这里文件名要写全相对路径及文件后缀。
* 然后需要进行 commit 和 push