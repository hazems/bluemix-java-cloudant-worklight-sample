package com.test.todos.service;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;

@Path("/todo")
public class TodoService {
    protected static CouchDbInstance _db;      
    
    static {
        try {
            _db = (CouchDbInstance) new InitialContext().lookup("couchdb/todos-cloudant");
        } catch (Exception e) {
            e.printStackTrace();
            
            //Handle error nicely here ...
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Todo> getAllTodos() {
        List<Todo> todos = new ArrayList<>();

        try {            
            CouchDbConnector dbc = _db.createConnector("todos_db", false);

            List<String> ids = dbc.getAllDocIds();

            for (String id : ids) {
                Todo todo = dbc.get(Todo.class, id);

                todos.add(todo);
            }
        } catch (Exception e) {
            todos = new ArrayList<>();
            e.printStackTrace();
            //Handle error nicely here ...
        }

        return todos;
    }
    
    static class Todo {
        String _id;
        String _rev;
        String title;
        String description;
        
        public Todo() {
        }        
        
        public Todo(String id, String title, String description) {
            super();
            
            this._id = id;
            this.title = title;
            this.description = description;
        }
        
        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String get_rev() {
            return _rev;
        }
        public void set_rev(String _rev) {
            this._rev = _rev;
        }

        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }
    }
}
