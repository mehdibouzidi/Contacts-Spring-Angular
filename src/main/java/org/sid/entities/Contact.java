package org.sid.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Contact {

    @Id
    @GeneratedValue
    private Integer id;

    private String nom;

    private String prenom;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    private String email;

    private String telephone;

    private String photo;

    public Contact() {
    }

    public Contact(String nom, String prenom, Date dateNaissance, String email, String telephone, String photo) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.email = email;
        this.telephone = telephone;
        this.photo = photo;
    }

}
