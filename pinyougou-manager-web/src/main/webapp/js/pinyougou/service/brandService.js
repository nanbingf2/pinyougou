app.service("brandService",function($http){

    this.findAll=function(){
        return $http.get("../brand/findAll.do");
    }

    this.findPage=function(page,rows,brand){
        return $http.post("../brand/findPage.do?page="+page+"&rows="+rows,brand);
    };

    this.save=function(brand){
        return $http.post("../brand/save.do",brand);
    };

    this.findOne=function(id){
        return $http.get("../brand/findOne.do?id="+id);
    };

    this.deleteBatch=function(ids){
        return $http.get("../brand/delete.do?ids="+ids);
    }
});