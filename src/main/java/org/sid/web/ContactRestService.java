package org.sid.web;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ContactRestService {

    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public List<Contact> getContacts(){
        return contactRepository.findAll();
    }

    @RequestMapping(value = "/contact/{id}", method = RequestMethod.GET)
    public Contact getContact(@PathVariable Integer id){
        return contactRepository.findById(id).orElse(null);
    }


    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Page<Contact> search(
            @RequestParam(name="nom",  defaultValue = "") String nom,
            @RequestParam(name="page", defaultValue = "0") int page,
            @RequestParam(name="size", defaultValue = "5") int size
    ){
        return contactRepository.findByName("%"+nom+"%", PageRequest.of(page, size));
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.POST)
    public Contact saveContact(@RequestBody Contact contact){
        return contactRepository.save(contact);
    }

    @RequestMapping(value = "/contact/{id}", method = RequestMethod.DELETE)
    public void deleteContact(@PathVariable Integer id){
        contactRepository.deleteById(id);
    }


    @RequestMapping(value = "/contacts", method = RequestMethod.PUT)
    public Contact saveContact(@PathVariable Integer id, @RequestBody Contact contact){
        contact.setId(id);
        return contactRepository.save(contact);
    }

}
