package hiber;

import hiber.config.AppConfig;
import hiber.dao.UserDaoImp;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      /*userService.add(new User("Zhalaldin", "Toichubaev", "tzhalal@mail.ru"), new Car("BMW", 1));
      userService.add(new User("Ema", "Krusov", "ema@mail.ru"), new Car("Lexus", 2));
      userService.add(new User("Elena", "Pavlovna", "elena@mail.ru"), new Car("Tesla", 3));
      userService.add(new User("Anton", "Bogdan", "anton@mail.ru"), new Car("Tesla", 4));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }*/
      System.out.println(userService.getUserByCarSeriesAndModel("BMW", 1));
      context.close();
   }
}
