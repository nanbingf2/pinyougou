app.controller("typeTemplateController",function($scope,$controller,typeTemplateService,
                                                 brandService,specificationService){

    /*继承父模块*/
    $controller("baseController",{$scope:$scope});

    $scope.findAll=function(){
        typeTemplateService.findAll().success(function (responseData) {
            $scope.typeTemplateList=responseData;
        });
    }

    $scope.searchEntity={};
    /*分页查询*/
    $scope.findPage=function(page,rows){
        typeTemplateService.findPage(page,rows,$scope.searchEntity).success(function(responseData){
            $scope.typeTemplateList=responseData.rows;
            //更新总记录数
            $scope.paginationConf.totalItems=responseData.total;
        });
    }

    /*保存*/
    $scope.save=function(){
        typeTemplateService.save($scope.typeTemplate).success(function(responseData){
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
        typeTemplateService.findOne(id).success(function(responseData){
            $scope.typeTemplate=responseData;
            $scope.typeTemplate.brandIds=JSON.parse($scope.typeTemplate.brandIds);//转换品牌为对象
            $scope.typeTemplate.specIds=JSON.parse($scope.typeTemplate.specIds);//转换规格为对象
            $scope.typeTemplate.customAttributeItems=JSON.parse($scope.typeTemplate.customAttributeItems);//转换扩展属性为对象
        });
    };

    /*批量删除*/
    $scope.deleteBatch=function(){
        typeTemplateService.deleteBatch($scope.selectIds).success(function(responseData){
            if (responseData.success){
                alert(responseData.message);
                $scope.reloadList();
                $scope.selectIds=[];
            }else{
                alert(responseData.message);
            }
        });
    };

    /*查询品牌列表*/
    $scope.findBrandList=function(){
        brandService.selectOptionList().success(function(responseData){
            $scope.brandList={data:responseData};
        });
    };

    /*查询规格列表*/
    $scope.findSpecList=function(){
        specificationService.selectOptionList().success(function(responseData){
            $scope.specList={data:responseData};
        });
    };

    /*新增扩展属性*/
    $scope.addOption=function(){
        $scope.typeTemplate.customAttributeItems.push({});
    }

    /*删除扩展属性*/
    $scope.deleteOption=function(index){
        $scope.typeTemplate.customAttributeItems.splice(index,1);
    }
});