//package com.cg.service.impl;
//
//import com.cg.model.Customer;
//import com.cg.service.HibernateCustomerService;
//import org.hibernate.HibernateException;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//import org.springframework.stereotype.Service;
//
//import javax.persistence.EntityManager;
//import javax.persistence.TypedQuery;
//import java.util.List;
//import java.util.Optional;
//
//
//@Service
//public class HibernateCustomerServiceImpl implements HibernateCustomerService {
//
//    private static SessionFactory sessionFactory;
//    private static EntityManager entityManager;
//
//    static {
//        try {
//            sessionFactory = new Configuration()
//                    .configure("hibernate.conf.xml")
//                    .buildSessionFactory();
//            entityManager = sessionFactory.createEntityManager();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public boolean existsById(Long id) {
//        return false;
//    }
//
//    @Override
//    public List<Customer> findAll() {
//        String queryStr = "SELECT c FROM Customer AS c";
//        TypedQuery<Customer> query = entityManager.createQuery(queryStr, Customer.class);
//        return query.getResultList();
//    }
//
//    @Override
//    public Optional<Customer> findById(Long id) {
//        return null;
//    }
//
//    @Override
//    public Customer getById(Long id) {
//        String queryStr = "SELECT c FROM Customer AS c WHERE c.id = :id";
//        TypedQuery<Customer> query = entityManager.createQuery(queryStr, Customer.class);
//        query.setParameter("id", id);
//        return query.getSingleResult();
//    }
//
//    @Override
//    public Customer save(Customer customer) {
//        Session session = null;
//        Transaction transaction = null;
//        try {
//            session = sessionFactory.openSession();
//            transaction = session.beginTransaction();
//
//            Customer origin = new Customer();
//
//            if (customer.getId() != null) {
//                origin = getById(customer.getId());
//            }
//
//            origin.setFullName(customer.getFullName());
//            origin.setEmail(customer.getEmail());
//            origin.setPhone(customer.getPhone());
//            origin.setAddress(customer.getAddress());
//
//            session.saveOrUpdate(origin);
//            transaction.commit();
//            return origin;
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void delete(Long id) {
//
//    }
//
//    @Override
//    public void delete(Customer customer) {
//
//    }
//}
