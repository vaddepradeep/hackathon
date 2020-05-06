package com.example.demo.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.aspectj.weaver.patterns.ConcreteCflowPointcut.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.SlotEntity;

public interface SlotRepo extends JpaRepository<SlotEntity, Integer> {
	@Query("SELECT CASE WHEN count(s) > 0 THEN true ELSE false END FROM SlotEntity s where s.type = ?1 and s.status=?2")
	// @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Company c WHERE c.name = :companyName")
	boolean checkSlotAvilabulity(String type, String status);
	
@Query("select e.slotid from SlotEntity e where e.type=?1 and e.status=?2")
	List<Integer> findAvilableSlots(String type, String status);

//@Query("update slot set status=")
//void updateStatus( int id,String status);
@Transactional
@Modifying	
@Query("UPDATE SlotEntity s SET s.status=?2 WHERE s.slotid =?1")
void updateStatus( Integer id,String status);
}