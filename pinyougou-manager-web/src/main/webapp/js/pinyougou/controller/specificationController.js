app.controller("specificationController",function($scope,$controller,specificationService){

    /*继承父模块*/
    $controller("baseController",{$scope:$scope});

    $scope.findAll=function(){
        specificationService.findAll().success(function (responseData) {
            $scope.specificationList=responseData;
        });
    }

    $scope.searchEntity={};
    /*分页查询*/
    $scope.findPage=function(page,rows){
        specificationService.findPage(page,rows,$scope.searchEntity).success(function(responseData){
            $scope.specificationList=responseData.rows;
            //更新总记录数
            $scope.paginationConf.totalItems=responseData.total;
        });
    }

    /*保存*/
    $scope.save=function(){
        specificationService.save($scope.specificationCustom).success(function(responseData){
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
        specificationService.findOne(id).success(function(responseData){
            $scope.specificationCustom=responseData;
        });
    };

    /*批量删除*/
    $scope.deleteBatch=function(){
        specificationService.deleteBatch($scope.selectIds).success(function(responseData){
            if (responseData.success){
                alert(responseData.message);
                $scope.reloadList();
                $scope.selectIds=[];
            }else{
                alert(responseData.message);
            }
        });
    };


    /*添加规格选项*/
    $scope.addOption=function(){
        $scope.specificationCustom.specificationOptionList.push({});
    }

    /*删除规格选项*/
    $scope.deleteOption=function(index){
        $scope.specificationCustom.specificationOptionList.splice(index,1);
    }
});