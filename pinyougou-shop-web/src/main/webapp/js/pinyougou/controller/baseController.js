app.controller("baseController",function($scope){

    /*重新加载*/
    $scope.reloadList=function(){
        $scope.findPage($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
    }

    /*分页配置*/
    $scope.paginationConf={
        currentPage:1,//当前页
        totalItems:10,//总条数
        itemsPerPage:10,//每页的数量
        perPageOptions:[10,20,30,50],
        onChange:function(){
            $scope.reloadList();
        }
    };

    /*定义要删除的数组*/
    $scope.selectIds=[];
    /*添加元素到要删除的数组中*/
    $scope.addToIds=function($event,id){
        if ($event.target.checked){
            //选中：向数组中添加元素
            $scope.selectIds.push(id);
        }else{
            //查找当前元素所在的位置
            var index=$scope.selectIds.indexOf(id);
            //移除
            $scope.selectIds.splice(index,1);
        }
    };


    /*将JSON字符串数据中的某个属性，将其拼接成字符串
    * json:要转换的JSON字符串，key:要转换的属性
    * */
    $scope.jsonToString=function(json,key){
        //将JSON字符串转换为数组
        var array=JSON.parse(json);
        var value="";
        for (var i=0;i<array.length;i++){
            if (i>0){
                value+=",";
            }
            value+=array[i][key];
        }
        return value;
    }

});