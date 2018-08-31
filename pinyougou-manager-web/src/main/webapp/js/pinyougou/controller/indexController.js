app.controller("indexController",function($scope,loginService){

    /*获取登录用户名*/
    $scope.getLoginName=function(){
        loginService.getLoginName().success(function(responseData){
            $scope.loginName=responseData.loginName;
        })
    }
})