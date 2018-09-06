package net.togogo.mapper;

import net.togogo.bean.Company;
import net.togogo.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyMapper {

    //注册公司用户
    int createCompany(Company company);

    //判断邮箱是否存在
    Company checkExist(String email);
}
