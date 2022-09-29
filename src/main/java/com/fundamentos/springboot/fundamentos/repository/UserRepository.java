package com.fundamentos.springboot.fundamentos.repository;

import com.fundamentos.springboot.fundamentos.dto.UserDto;
import com.fundamentos.springboot.fundamentos.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Query("Select u from User u WHERE u.email=?1")
    Optional<User> findByUserEmail(String email);

    //Uso de Querys nativas consulta directa en la BD
    @Query(value = "SELECT * FROM users WHERE email = ?1", nativeQuery = true)
    Optional<User> findMyUserByEmailNative(String email);

    @Query("select u from User u where u.name like ?1%")
    List<User> findByAndSort(String name, Sort sort);

    //QueryMethods
    List<User> findByNameOrderById(String name);

    List<User> findByNameContaining(String name);

    //… where x.firstname like ?1
    List<User> findByNameLike(String name);

    //… where x.name = ?1 and x.email = ?2
    Optional<User> findUsersByNameAndAndEmail(String name, String email);

    //… where x.name = ?1 or x.email = ?2
    Optional<User> findUsersByNameOrAndEmail(String name, String email);

    //… where x.birthDate between ?1 and ?2
    List<User> findByBirthDateBetween(LocalDate begin, LocalDate end);

    //… where x.age = ?1 order by x.lastname desc
    List<User> findByNameLikeOrderByIdDesc(String name);

    //… where x.age = ?1 order by x.lastname desc
    List<User> findByNameContainingOrderByIdDesc(String name);

    //Uso de JPQL con named parameters
    @Query("SELECT new com.fundamentos.springboot.fundamentos.dto.UserDto(u.id, u.name, u.birthDate)" +
            "FROM User u " +
            "WHERE u.birthDate=:parametroFecha " +
            "AND u.email=:parametroEmail")
    Optional<UserDto> getAllByBirthDateAndEmail(@Param("parametroFecha") LocalDate date, @Param("parametroEmail") String email);

}
