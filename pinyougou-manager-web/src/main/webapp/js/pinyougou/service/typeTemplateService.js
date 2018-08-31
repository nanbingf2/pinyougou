app.service("typeTemplateService",function($http){

    this.findAll=function(){
        return $http.get("../typeTemplate/findAll.do");
    }

    this.findPage=function(page,rows,typeTemplate){
        return $http.post("../typeTemplate/findPage.do?page="+page+"&rows="+rows,typeTemplate);
    };

    this.save=function(typeTemplate){
        return $http.post("../typeTemplate/save.do",typeTemplate);
    };

    this.findOne=function(id){
        return $http.get("../typeTemplate/findOne.do?id="+id);
    };

    this.deleteBatch=function(ids){
        return $http.get("../typeTemplate/delete.do?ids="+ids);
    }
});