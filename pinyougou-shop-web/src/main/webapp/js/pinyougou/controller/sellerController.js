app.controller("sellerController",function($scope,$controller,
                                           sellerService,loginService){

    /*继承父模块*/
    $controller("baseController",{$scope:$scope});

    $scope.findAll=function(){
        sellerService.findAll().success(function (responseData) {
            $scope.sellerList=responseData;
        });
    }

    $scope.searchEntity={};
    /*分页查询*/
    $scope.findPage=function(page,rows){
        sellerService.findPage(page,rows,$scope.searchEntity).success(function(responseData){
            $scope.sellerList=responseData.rows;
            //更新总记录数
            $scope.paginationConf.totalItems=responseData.total;
        });
    }

    /*保存*/
    $scope.save=function(){
        sellerService.save($scope.seller).success(function(responseData){
            if (responseData.success){
                alert(responseData.message);
                $scope.reloadList();
            }else{
                alert(responseData.message);
            }
        });
    };

    /*查询单个品牌信息*/
    $scope.findOne=function(){
        sellerService.findOne().success(function(responseData){
            $scope.seller=responseData;
        });
    };

    /*批量删除*/
    $scope.deleteBatch=function(){
        sellerService.deleteBatch($scope.selectIds).success(function(responseData){
            if (responseData.success){
                alert(responseData.message);
                $scope.reloadList();
                $scope.selectIds=[];
            }else{
                alert(responseData.message);
            }
        });
    };

    /*商家注册*/
    $scope.register=function(){
        sellerService.register($scope.seller).success(function(responseData){
            if (responseData.success){
                alert(responseData.message);
                //跳转到登录页面,等待审核
                location.href="shoplogin.html";
            }else{
                alert(responseData.message);
            }
        });
    };

    /*获取登录用户名*/
    $scope.getLoginName=function(){
        loginService.getLoginName().success(function(responseData){
            $scope.loginName=responseData.loginName;
        })
    };

    /*更新用户密码*/
    $scope.updatePassword=function(){
        if ($scope.newPassword!=$scope.rePassword){
            alert("两次密码不一致");
        } else{
            sellerService.updatePassword($scope.password,$scope.newPassword).success(
                function(responseData){
                    if (responseData.success){
                        //修改密码成功
                        alert(responseData.message);
                        $scope.password="";
                        $scope.newPassword="";
                        $scope.rePassword="";
                    }else{
                        alert(responseData.message);
                    }
                });
        }
    }
});