package com.demo.demo.repository;

import com.demo.demo.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo  extends JpaRepository<UserEntity, Long> {
    /* NAMED METHOD */
     boolean existsByUsername(String username);
     Optional<UserEntity> findByUsername(String username);
     List<UserEntity> findByEmailAndAdressStartingWith(String email, String adress);
     UserEntity findByEmail(String email);
    /* JPQL METHOD */
    @Query("SELECT u  from UserEntity u WHERE u.username=?1")
    UserEntity findUserByUsernameJPQL(String username);
    @Query("SELECT CASE WHEN COUNT(u)>0 THEN true ELSE false  end  from UserEntity u WHERE u.username=:username")
    boolean existsByUsernameJPQL(@Param("username") String username);
    /* SQL METHOD */
    @Query(value="SELECT * FROM users where username=?1", nativeQuery = true)
    UserEntity findByUsernameSQL(String username);
    @Query(value="SELECT count(*) FROM users WHERE username=:u",nativeQuery = true)
    boolean existsbyUsernameSQL(@Param("u") String username);
    @Query(value="select * from users where username like :cle%",nativeQuery = true)
    List<UserEntity> findbycle(@Param("cle") String cle );
    @Query(value="select * from users where email like %:domain%", nativeQuery = true)
   List< UserEntity>  findbydomaine(@Param("domain") String un);
}
