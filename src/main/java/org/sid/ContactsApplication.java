package org.sid;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@SpringBootApplication
public class ContactsApplication implements CommandLineRunner {
    @Autowired
    private ContactRepository contactRepository;

    public static void main(String[] args) {
        SpringApplication.run(ContactsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        contactRepository.save(new Contact("BOUZIDI","Mehdi",df.parse("08/06/1992"),
                "mehdi@bouzidi.net", "0551896895",""));
        contactRepository.save(new Contact("IDIRENE","Youcef",df.parse("22/07/1993"),
                "youcef@idirene.net", "0554586879",""));
        contactRepository.findAll().forEach(contact -> {
            System.out.println("CONTACT:"+contact.getNom());
        });
    }
}
