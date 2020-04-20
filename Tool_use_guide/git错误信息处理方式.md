# git错误信息处理方式

### 修改文件后无法commit：提示Your branch is up-to-date with 'origin/master'

* 原因是版本分支的问题。
* `git branch <newBranch_name>`：新建一个分支，指定分支名字。（`git branch`）查看现有的所有分支。
* `git checkout newBranch_name`，切换到刚才新建的分支。
* 将改动添加到新的分支上，`git add .`，`git commit -m "[msg]"`
* 再切换回管理员分支`git checkout master`
* 将新分支提交的改动合并到主分支上`git merge newBranch_name`
* 然后在master分支上push。最后将临时新建的分支删除`git branch -D newBranch_name`。

