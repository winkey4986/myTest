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