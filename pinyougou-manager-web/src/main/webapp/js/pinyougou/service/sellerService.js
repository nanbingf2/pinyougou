app.service("sellerService",function($http){

    this.findAll=function(){
        return $http.get("../seller/findAll.do");
    }

    this.findPage=function(page,rows,seller){
        return $http.post("../seller/findPage.do?page="+page+"&rows="+rows,seller);
    };

    this.save=function(seller){
        return $http.post("../seller/save.do",seller);
    };

    this.findOne=function(id){
        return $http.get("../seller/findOne.do?id="+id);
    };

    this.deleteBatch=function(ids){
        return $http.get("../seller/delete.do?ids="+ids);
    }

    this.updateStatus=function (sellerId, status) {
        return $http.get("../seller/updateStatus.do?sellerId="+sellerId+"&status="+status);
    }
});