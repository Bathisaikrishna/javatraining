package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;
@Repository
public class BookingDaoJpaImpl implements BookingDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Hotel> findHotels(String criteria) {
		String jpql = "select h from Hotel h where h.name = :name or h.city = :city";
		
		TypedQuery<Hotel> qu = em.createQuery(jpql, Hotel.class);
		qu.setParameter("name", criteria);
		qu.setParameter("city", criteria);
		
		
		return qu.getResultList();
	}

	@Override
	public Hotel findHotelById(long id) {
		return em.find(Hotel.class, id);
	}

	@Override
	public User getUser(String email, String password) {
		String jpql = "select u from User u where u.email = :mail and u.password = :pwd";
		
		TypedQuery<User> qu = em.createQuery(jpql, User.class);
		qu.setParameter("mail", email);
		qu.setParameter("pwd", password); //setting parameters in jpql query
		
		return qu.getSingleResult();
	}

	@Override
	public long createBooking(Booking booking) {
		return 0;
	}

	@Override
	public List<Booking> getAllBookingsOfUser(User user) {
		String jpql = "select b from Booking b where b.user = :u";
		
		TypedQuery<Booking> qu = em.createQuery(jpql, Booking.class);
		
		qu.setParameter("u", user.getUsername()); //setting parameters in jpql query
		
		return qu.getResultList();
	}

}
