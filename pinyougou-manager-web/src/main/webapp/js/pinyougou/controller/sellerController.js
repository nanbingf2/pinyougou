app.controller("sellerController",function($scope,$controller,sellerService){

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
    $scope.findOne=function(id){
        sellerService.findOne(id).success(function(responseData){
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

    /*更新商家状态*/
    $scope.updateStatus=function(sellerId,status){
        sellerService.updateStatus(sellerId,status).success(function(responseData){
            if (responseData.success){
                alert(responseData.message);
                $scope.reloadList();
            }else{
                alert(responseData.message);
            }
        });
    };

    /*定义一个数组来存储商家状态*/
    $scope.status=['未审核','审核通过','审核未通过','关闭'];

});