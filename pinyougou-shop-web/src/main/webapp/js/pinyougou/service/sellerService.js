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

    this.findOne=function(){
        return $http.get("../seller/findOne.do");
    };

    this.deleteBatch=function(ids){
        return $http.get("../seller/delete.do?ids="+ids);
    }

    this.register=function(seller){
        return $http.post("seller/register.do",seller)
    }

    this.updatePassword=function(password,newPassword){
        return $http.get("../seller/updatePassword.do?password="+password+"&newPassword="+newPassword);
    }
});