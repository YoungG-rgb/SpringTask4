package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user, Car car) {
      user.setCar(car);
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public User getUserByCarSeriesAndModel(String model, int series) {
      String HQL = "from User us where us.car.model = :cModel and us.car.series = :cSeries";
      User user = (User)sessionFactory.getCurrentSession().createQuery(HQL)
              .setParameter("cModel", model)
              .setParameter("cSeries", series)
              .uniqueResult();
      return user;
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

}
