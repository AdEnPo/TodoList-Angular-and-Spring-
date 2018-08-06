package com.example.angulardeneme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PATCH, RequestMethod.PUT})
@RestController
public class WebRestController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //tablo oluşturmak
    @RequestMapping(value = "/createTable", method = RequestMethod.GET)
    public void createTable() {
        try {
            jdbcTemplate.execute("CREATE TABLE NOTLAR "
                    + "(id int identity (1,1) primary key ," +
                    " text VARCHAR(250) NOT NULL ," +
                    "checked INT )");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //veri koymak
        }
    @RequestMapping("/putData")
    public void putData(@RequestBody Todo todo) {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS NOTLAR (id int identity (1,1) primary key ," +
                " text VARCHAR(250) NOT NULL ," +
                "checked INT )");
        jdbcTemplate.execute("INSERT INTO NOTLAR(text,checked) VALUES ('" + todo.getText() + "'" +
                "," + booleanToInt(todo.getChecked()) + ")");
    }

    //veri çekmek
    @RequestMapping("/getData")
    public List<Todo> getData() {
        List<Todo> query = jdbcTemplate.query("SELECT * FROM NOTLAR WHERE CHECKED=0", new RowMapper<Todo>() {
            @Override
            public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
                Todo todo = new Todo();
                todo.setId(rs.getInt("id"));
                todo.setText(rs.getString("text"));
                //todo.setChecked(rs.getInt("checked"));
                if (rs.getInt("checked") == 1) {
                    todo.setChecked(true);
                } else {
                    todo.setChecked(false);
                }
                return todo;
            }
        });
        return query;
    }

    //veri silmek
    @RequestMapping("/deleteData/{id}")
    public void deleteData(@PathVariable("id") int id) {
        jdbcTemplate.execute("DELETE FROM NOTLAR WHERE id=" + id);
    }

    //veri güncellemek
    @RequestMapping("/updateData/{id}/{checked}")
    public void updateData(@PathVariable("id") int id, @PathVariable("checked") boolean checked) {
        jdbcTemplate.execute("UPDATE NOTLAR SET CHECKED=" + booleanToInt(checked) + " WHERE id=" + id);
    }

    @RequestMapping("/getChecked")
    public List<Todo> getChecked(){
        List<Todo> query = jdbcTemplate.query("SELECT * FROM NOTLAR WHERE CHECKED=1", new RowMapper<Todo>() {
            @Override
            public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
                Todo todo = new Todo();
                todo.setId(rs.getInt("id"));
                todo.setText(rs.getString("text"));
                //todo.setChecked(rs.getInt("checked"));
                if (rs.getInt("checked") == 1) {
                    todo.setChecked(true);
                } else {
                    todo.setChecked(false);
                }
                return todo;
            }
        });
        return query;
    }

    //Elle veri ekleme
    /*@RequestMapping(value = "/putDatas", method = RequestMethod.GET)
    public void putDatas() {
        jdbcTemplate.execute("INSERT INTO NOTLAR(text,checked) VALUES ('xcvbxcbvxcb',1)");
    }
    List<Todo> liste = new ArrayList<Todo>();
    Todo todo1 = new Todo("sdfasfd", false);
    Todo todo2 = new Todo( "zxczxczx", false);
    Todo todo3 = new Todo("gel", false);
    Todo todo4 = new Todo("jkjiiikj", false);
    Todo todo5 = new Todo(".çöjscv", false);
    Todo todo6;

    public void something() {

        liste = new ArrayList<Todo>();
        liste.add(todo1);
        liste.add(todo2);
        liste.add(todo1);
        liste.add(todo1);
        liste.add(3, todo2);
        liste.add(2, todo3);
        liste.set(1, todo4);
        todo1.setText("mehmet");
        liste.add(todo5);
        liste.add(todo5);
    }

    @RequestMapping("/liste")
    public List<Todo> list() {
        something();
        return liste;
    }

    @PostMapping("/post")
    public Todo posting(@RequestBody String text, boolean checked) {
        todo6 = new Todo(text, checked);
        liste.add(todo6);
        return todo6;
    }*/

    public static int booleanToInt(boolean veri) {
        return veri ? 1 : 0;
    }

}
