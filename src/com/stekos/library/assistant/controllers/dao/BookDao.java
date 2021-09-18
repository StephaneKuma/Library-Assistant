/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stekos.library.assistant.controllers.dao;

import com.stekos.library.assistant.controllers.jpa.BookJpaController;
import com.stekos.library.assistant.controllers.jpa.exceptions.NonexistentEntityException;
import com.stekos.library.assistant.models.Book;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Stekos
 */
public class BookDao implements Dao<Book> {
    private final BookJpaController controller;
    private final EntityManagerFactory emf;
    
    public BookDao() {
        emf = Persistence.createEntityManagerFactory("LibraryAssistantPU");
        controller = new BookJpaController(emf);
    }

    @Override
    public void add(Book entity) throws Exception {
        controller.create(entity);
    }

    @Override
    public void edit(Book entity) throws Exception {
        controller.edit(entity);
    }

    @Override
    public void remove(int id) throws NonexistentEntityException {
        controller.destroy(id);
    }

    @Override
    public List<Book> getAll() {
        return controller.findBookEntities();
    }

    @Override
    public Book getById(int id) {
        return controller.findBook(id);
    }

    @Override
    public int countEntities() {
        return getAll().size();
    }
    
}
