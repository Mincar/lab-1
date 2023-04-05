package com.github.rsoi.repository;

import com.github.rsoi.domain.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PhonesRepository extends JpaRepository<Phone, Long> {


    @Modifying
    @Query("UPDATE Phone p set p.counterForCompare = p.counterForCompare + 1 WHERE p.RAM = :ram")
    void increaseCounterForCompareWhereRam(@Param("ram") int ram);

    @Modifying
    @Query("UPDATE Phone p set p.counterForCompare = p.counterForCompare + 1 WHERE p.size = :size")
    void increaseCounterForCompareWhereSize(@Param("size") double size);

    @Modifying
    @Query("UPDATE Phone p set p.counterForCompare = p.counterForCompare + 1 WHERE p.SDCard = :sdcard")
    void increaseCounterForCompareWhereSDCard(@Param("sdcard") boolean sdcard);


    @Modifying
    @Query("UPDATE Phone p set p.counterForCompare = 0")
    void setCounterForCompareZero();



    @Query(value = "SELECT * FROM phonelist p WHERE p.counter_for_compare = (SELECT MAX(counter_for_compare) FROM phonelist) AND " +
            "((p.min_price >= :min AND p.min_price <= :max) OR (p.max_price >= :max AND p.max_price <= :min));", nativeQuery = true)
    List<Phone> findPhonesByParams(@Param("min") int min, @Param("max") int max);

}
