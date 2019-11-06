package com.gctchina.demo.dao.repository.sec;

import com.gctchina.demo.dao.entity.Etl_cron;
import com.gctchina.demo.dao.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface Etl_cronRepositoryB extends JpaRepository<Etl_cron,String> {

//    @Query("select o from Employee o where o.name=?1 and o.age=?2")
//    public List<Employee> queryParams1(String name,Integer age);
//    @Query("select o from Employee o where o.name=:name and o.age=:age")
//    public List<Employee> queryParams2(@Param("name") String name, @Param("age") Integer age);

//    https://www.cnblogs.com/suizhikuo/p/9400727.html
}
