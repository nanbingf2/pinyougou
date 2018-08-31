package com.rogercw.pinyougou.service;

import com.rogercw.pinyougou.pojo.Seller;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: rogercw
 * @Date: 2018/8/31 19:52
 * @Version 1.0
 */
public class UserDetailServiceImpl implements UserDetailsService {

    private SellerService sellerService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据商家id查询密码
        Seller seller = sellerService.findOne(username);
        System.out.println("经过了认证类");
        if (seller!=null){
            if (seller.getStatus().equals("1")){
                //认证通过的商家
                List<GrantedAuthority> authorities=new ArrayList<>();
                //添加商家的角色
                authorities.add(new SimpleGrantedAuthority("ROLE_SELLER"));
                return new User(username,seller.getPassword(),authorities);
            }
            return null;
        }else{
            return null;
        }
    }

    public void setSellerService(SellerService sellerService) {
        this.sellerService = sellerService;
    }
}
