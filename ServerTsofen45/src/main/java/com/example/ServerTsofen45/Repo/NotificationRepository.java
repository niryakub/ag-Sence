package com.example.ServerTsofen45.Repo;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.ServerTsofen45.Beans.Notification;
import com.example.ServerTsofen45.Beans.NotificationDTO;

import Enums.Severity;


public interface NotificationRepository extends CrudRepository<Notification, Integer> {
	
	
	@Query(nativeQuery = true, value ="SELECT n.id , n.date_time , n.readed, n.severity, n.user_id, "
			  + "n.device_id, n.device_imei, n.error_code, n.message"
			  + " FROM notifications AS n "
			  + "ORDER BY n.date_time DESC;")
	public List<NotificationDTO> getAll();
	@Query(nativeQuery = true, value ="SELECT n.id , n.date_time , n.readed, n.severity, n.user_id, "
			+ "n.device_id, n.device_imei, n.error_code, n.message"
			  + " FROM notifications AS n "
			  + "WHERE n.device_id = ?1 " + 
			  "ORDER BY n.date_time DESC;")
	public List<NotificationDTO> findByDeviceId(int deviceId);
	@Query(nativeQuery = true, value ="SELECT n.id , n.date_time , n.readed, n.severity, n.user_id, "
			+ "n.device_id, n.device_imei, n.error_code, n.message"
			  + " FROM notifications AS n "
			  + "WHERE n.user_id = ?1 " + 
			  "ORDER BY n.date_time DESC;")
	public List<NotificationDTO> findByUserId(int UserId);
	public Notification findById(int id);
	public List<Notification> findBySeverity(Severity severity);
	public List<Notification> findByDeviceImei(long deviceImei);
	public List<Notification> findByDeviceImeiAndDeviceId(long deviceImei, int deviceId);

	
	@Query(nativeQuery = true, value =
			"select count(distinct id) " + 
			"from notifications " + 
			"where readed = FALSE AND user_id = ?1 ;" )
	public String getUnreadNotificationsNumber(int id);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value =
			"     UPDATE public.notifications SET readed = TRUE WHERE id = ?1 AND user_id = ?2 " )
	public int setNotificationsReaded(int notificationId, int accountId);
}