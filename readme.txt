git add
git commit -m "hi"
git status
git remote add myTest git@github.com:winkey4986/myTest.git
git push -u myTest master  第一次
git push myTest master
git rm -rf "G:\\myGitWorkspace\\myTest" 删除完了还要commit


先在本地建立仓库，再在github上建立远程仓库，将本地仓库的文件同步到远程仓库
 删除本地仓库。在intelij中 VCS——Checkout from Version Contrl——Git中 粘贴仓库url地址
 会从github仓库中拷贝一份项目   然后就可以在本地直接进行git操作， 并且可以push到github
 仓库中 （会提示你输入github的仓库和密码）

****************************************************
1、在github上创建项目
2、使用git clone https://github.com/xxxxxxx/xxxxx.git克隆到本地
3、编辑项目
4、git add . （将改动添加到暂存区）
5、git commit -m "提交说明"
6、git push origin master 将本地更改推送到远程master分支。
文／继续海阔天空（简书作者）
原文链接：http://www.jianshu.com/p/8d26730386f3
著作权归作者所有，转载请联系作者获得授权，并标注“简书作者”。
