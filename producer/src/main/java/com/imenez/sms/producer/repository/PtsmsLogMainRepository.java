package com.imenez.sms.producer.repository;


import com.imenez.sms.producer.model.PtsmslogMainModel;
import com.imenez.sms.producer.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PtsmsLogMainRepository extends JpaRepository<PtsmslogMainModel, Long> {

    @Query(value = "SELECT * FROM ptsmslog_main where msg_id = :msg_id order by log_date desc", nativeQuery = true)
    Optional<List<PtsmslogMainModel>> getAllSMS(@Param("msg_id") String msgId);

    @Modifying
    @Query(value = "UPDATE ptsmslog_main SET statudesc = :status where msg_id = :msg_id", nativeQuery = true)
    void updateSMSStatus(@Param("status") Integer status, @Param("msg_id") String msg_id);
}
