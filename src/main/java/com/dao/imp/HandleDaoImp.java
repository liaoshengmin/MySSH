package com.dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dao.HandleDao;
import com.model.Address;
import com.model.Customer;
import com.model.Store;

public class HandleDaoImp implements HandleDao {

	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	//登录
	public boolean login(String fname,String password) {
		Session session = sessionFactory.openSession();
		String hql = "from Customer where firstName=:fname and lastName=:lname";
		Transaction tx = null; 
		try{
			tx = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("fname", fname);
			query.setParameter("lname", password);
			List result = query.list();
			tx.commit();
			if(result.size()!=0){
				return true;
			}
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {

			session.close(); 
		}
		return false;
	}


	//查询所有信息，返回一个列表
	public String customer() {
		Session session = sessionFactory.openSession();
		String hql = "from Customer";
		Transaction tx = null; 
		try{
			tx = session.beginTransaction();
			Query query = session.createQuery(hql);
			List customer = query.list();
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			for (Iterator iterator = customer.iterator(); iterator.hasNext();){
				Customer cus = (Customer) iterator.next(); 
				sb.append("{\"first_name\" : \" " + cus.getFirstName() + "\",");
				sb.append("\"last_name\" : \"" + cus.getLastName() + "\",");
				sb.append("\"address\":\"" + cus.getAddress().getAddress() + "\",");
				sb.append("\"email\":\"" + cus.getEmail() + "\",");
				sb.append("\"customer_id\":\"" + cus.getCustomerId() + "\",");
				sb.append("\"last_update\":\"" + cus.getLastUpdate() + "\"},");
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("]");
			return sb.toString();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {

			session.close(); 
		}
		return null;
	}
	
	
	public List addressname() {
		Session session = sessionFactory.openSession();
		String hql = "select address from Address";
		Transaction tx = null; 
		try{
			tx = session.beginTransaction();
			Query query = session.createQuery(hql);
			List result = query.list();
			tx.commit();
			return result;			
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {

			session.close(); 
		}
		return null;
	}

	public Address address(String name) {
		short id=addressid(name);
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Address address = null;
		try{
			tx = session.beginTransaction();
			address = (Address)session.get(Address.class,id);
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return address;
	}
	
	public Store store(){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Store st = null;
		try{
			tx = session.beginTransaction();
			st = (Store)session.get(Store.class,(short)1);
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return st;
	}
	
	
	public short addressid(String name){
		Session session = sessionFactory.openSession();
		Transaction tx = null; 
		String hql="select addressId from Address where address=:name";
		try{
			tx = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("name", name);
			List result = query.list();
			tx.commit();
			return (Short) result.get(0);		
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {

			session.close(); 
		}
		return 0;
	}

	public void add(Customer cus) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		short cus_id = 0;
		try{
			tx = session.beginTransaction();
			cus_id = (Short)session.save(cus);
			tx.commit();
			System.out.println("---------add success-------");
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}

	}

	public void delete(short id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null; 
		try{
			tx = session.beginTransaction();
			Customer cus = (Customer)session.get(Customer.class, id);
			session.delete(cus); 
			tx.commit();
			System.out.println("---------delete success-------");
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}

	}

	public void update(Customer cu) {
		Session session = sessionFactory.openSession();
		String hql = "UPDATE Customer set firstName=:fname,lastName=:lname,email=:email,address=:address"
				+ " WHERE customerId=:customerid";
		Transaction tx = null; 
		try{
			Query query = session.createQuery(hql);
			query.setParameter("fname", cu.getFirstName());
			query.setParameter("lname", cu.getLastName());
			query.setParameter("email", cu.getEmail());
			query.setParameter("address", cu.getAddress());
			query.setParameter("customerid", cu.getCustomerId());
			int result = query.executeUpdate();
			System.out.println("---------update success-------");
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}

	}

	

}
