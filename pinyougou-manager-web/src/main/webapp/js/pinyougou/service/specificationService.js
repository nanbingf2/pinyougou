app.service("specificationService",function($http){

    this.findAll=function(){
        return $http.get("../specification/findAll.do");
    }

    this.findPage=function(page,rows,specification){
        return $http.post("../specification/findPage.do?page="+page+"&rows="+rows,specification);
    };

    this.save=function(specificationCustom){
        return $http.post("../specification/save.do",specificationCustom);
    };

    this.findOne=function(id){
        return $http.get("../specification/findOne.do?id="+id);
    };

    this.deleteBatch=function(ids){
        return $http.get("../specification/delete.do?ids="+ids);
    }
});