/*package com.aimprosoft.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Exception ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }



}*/
/*    public static void executeDAO (Object object, String execute){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        if (execute == "delete"){session.delete(object);}
        if (execute == "update"){session.saveOrUpdate(object);}
        session.getTransaction().commit();
       // session.close();
    }
    {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")// configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry )
                    .addAnnotatedClass(Department.class)
                    .addAnnotatedClassName("com.aimprosoft.model.Department")
                    .addResource("Department.hbn.xml")
                    .buildMetadata()
                    .buildSessionFactory();
        }
        catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }*/


            /*        Metadata metadata = new MetadataSources(registry)
            .addAnnotatedClass( Department.class )
            .addAnnotatedClassName("com.aimprosoft.model.Department")
            .addResource("Department.hbn.xml")
            .getMetadataBuilder()
            .applyImplicitNamingStrategy( ImplicitNamingStrategyJpaCompliantImpl.INSTANCE )
            .build();

       sessionFactory = metadata.getSessionFactoryBuilder()
                    .build();

          sessionFactory = new MetadataSources( registry )
                    .addAnnotatedClass(Department.class)
                    .addAnnotatedClassName("com.aimprosoft.model.Department")
                    .addResource("Department.hbn.xml")
                    .buildMetadata()
                    .buildSessionFactory();

SessionFactory


            metadata = new MetadataSources( standardRegistry )
    .getMetadataBuilder()
    .applyImplicitNamingStrategy( ImplicitNamingStrategyJpaCompliantImpl.INSTANCE )
    .build();
*/
/*
* import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {

			SessionFactory sessionFactory = new Configuration()
					.configure("/com/mkyong/persistence/hibernate.cfg.xml")
					.addResource("com/mkyong/common/Stock.hbm.xml")
					.buildSessionFactory();

			return sessionFactory;

		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}

}
* */
/*public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static ServiceRegistry serviceRegistry;

    private static SessionFactory buildSessionFactory() {
        try {
            // Создает сессию с hibernate.cfg.xml
            Configuration configuration = new Configuration();
            configuration.configure();
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();

            return configuration.buildSessionFactory(serviceRegistry);
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Чистит кеш и закрывает соединение с БД
        getSessionFactory().close();
    }


}*/
/*

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {

                // Create registry builder
                StandardServiceRegistryBuilder registryBuilder =
                        new StandardServiceRegistryBuilder();
                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Map<String, String> settings = new HashMap<String, String>();
                settings.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
                settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/mydb");
                settings.put("hibernate.connection.username", "root");
                settings.put("hibernate.connection.password", "1");
                settings.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
                settings.put("hibernate.current_session_context_class", "thread");
                // Apply settings
                registryBuilder.applySettings(settings);

                // Create registry
                registry = registryBuilder.build();

                // Create MetadataSources
                MetadataSources sources = new MetadataSources(registry);

                // Create Metadata
                Metadata metadata = sources.getMetadataBuilder().build();

                // Create SessionFactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();

            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
*/


/*

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.HashMap;
import java.util.Map;

public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {

                // Create registry builder
                StandardServiceRegistryBuilder registryBuilder =
                        new StandardServiceRegistryBuilder();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Map<String, String> settings = new HashMap<String, String>();
                */
/*    <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
    <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/mydb</property>

    <property name="hibernate.connection.username">root</property>
     <property name="hibernate.connection.password">1</property>
    <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>*//*


                settings.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
                settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/mydb");

                settings.put("hibernate.connection.username", "root");
                settings.put("hibernate.connection.password", "1");
                settings.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

                // Apply settings
                registryBuilder.applySettings(settings);

                // Create registry
                registry = registryBuilder.build();

                // Create MetadataSources
                MetadataSources sources = new MetadataSources(registry);

                // Create Metadata
                Metadata metadata = sources.getMetadataBuilder().build();

                // Create SessionFactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();

            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
*/

/*



package com.aimprosoft.util;

        import org.hibernate.SessionFactory;
        import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

        import org.hibernate.cfg.Configuration;
        import org.hibernate.service.ServiceRegistry;


public class HibernateUtile {



    private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        Configuration conf = new Configuration();
        conf.configure();
        serviceRegistry = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
        try {
            sessionFactory = conf.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
*//*    private static SessionFactory sessionFactory = buildSessionFactory();
    private static SessionFactory buildSessionFactory(){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()//configure from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }catch (Exception e){
            StandardServiceRegistryBuilder.destroy(registry);
            throw new ExceptionInInitializerError("Initial SessionFactory failed " + e);
        }
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public  static void shutdown(){
        getSessionFactory().close();
    }*//*
}*/