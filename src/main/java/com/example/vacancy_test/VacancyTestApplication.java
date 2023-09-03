package com.example.vacancy_test;

import com.example.vacancy_test.model.Client;
import com.example.vacancy_test.model.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * Created by Ukrainsky Alex.
 **/

@SpringBootApplication
public class VacancyTestApplication {

    public static void main(String[] args) {

        SpringApplication.run(VacancyTestApplication.class, args);
        Configuration configuration = new Configuration().addAnnotatedClass(Client.class).addAnnotatedClass(Contact.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Client client = session.get(Client.class, 2);
            List<Contact> contactList = (List<Contact>) client.getContactList();

            System.out.println(contactList);


            session.getTransaction().commit();


        } finally {
            sessionFactory.close();
        }


    }

}
