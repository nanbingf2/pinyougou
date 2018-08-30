app.controller("brandController",function($scope,$controller,brandService){

    /*继承父模块*/
    $controller("baseController",{$scope:$scope});

    $scope.findAll=function(){
        brandService.findAll().success(function (responseData) {
            $scope.brandList=responseData;
        });
    }

    $scope.searchEntity={};
    /*分页查询*/
    $scope.findPage=function(page,rows){
        brandService.findPage(page,rows,$scope.searchEntity).success(function(responseData){
            $scope.brandList=responseData.rows;
            //更新总记录数
            $scope.paginationConf.totalItems=responseData.total;
        });
    }

    /*保存*/
    $scope.save=function(){
        brandService.save($scope.brand).success(function(responseData){
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
        brandService.findOne(id).success(function(responseData){
            $scope.brand=responseData;
        });
    };

    /*批量删除*/
    $scope.deleteBatch=function(){
        brandService.deleteBatch($scope.selectIds).success(function(responseData){
            if (responseData.success){
                alert(responseData.message);
                $scope.reloadList();
                $scope.selectIds=[];
            }else{
                alert(responseData.message);
            }
        });
    };
});