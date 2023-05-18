package me.unvstore.utils;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import me.unvstore.entity.CategoryEntity;
import me.unvstore.entity.ImageEntity;
import me.unvstore.entity.InformationEntity;
import me.unvstore.entity.OrderDetailEntity;
import me.unvstore.entity.OrderEntity;
import me.unvstore.entity.ProductEntity;
import me.unvstore.entity.RoleEntity;
import me.unvstore.entity.UserEntity;

public class DBUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
//				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/phoneweb?useSSL=false");
//				settings.put(Environment.USER, "root");
//				settings.put(Environment.PASS, "123456");
				settings.put(Environment.URL, "jdbc:mysql://practicaleducation.mysql.database.azure.com:3306/pe?useSSL=false");
				settings.put(Environment.USER, "educationDB");
				settings.put(Environment.PASS, "Ngocthien2306.com");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLInnoDBDialect");

				settings.put(Environment.SHOW_SQL, "true");

				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				settings.put(Environment.HBM2DDL_AUTO, "update");

				configuration.setProperties(settings);
				configuration.addAnnotatedClass(UserEntity.class);
				configuration.addAnnotatedClass(RoleEntity.class);
				configuration.addAnnotatedClass(CategoryEntity.class);
				configuration.addAnnotatedClass(ImageEntity.class);
				configuration.addAnnotatedClass(InformationEntity.class);
				configuration.addAnnotatedClass(ProductEntity.class);
				configuration.addAnnotatedClass(OrderDetailEntity.class);
				configuration.addAnnotatedClass(OrderEntity.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				System.out.println("Hibernate Java Config serviceRegistry created");
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				return sessionFactory;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
