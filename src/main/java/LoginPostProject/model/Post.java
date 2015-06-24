/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPostProject.model;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Benjamin
 */
public class Post {
    private String user;
    private String title;
    private String content;
    private String date;



    public Post(String user, String title, String content, Calendar theDate) {
        this.user = user;
        this.title = title;
        this.content = content;
        DateFormat df = new SimpleDateFormat("yyyy/mm/dd");
        this.date = df.format(theDate.getTime());
    }
    
    public Post(String user, String title, String content, String theDate) {
        this.user = user;
        this.title = title;
        this.content = content;
        this.date = theDate;
    }

    
    public Post() {
        user = "";
        title = "";
        content = "";
        date = "2000/01/01";
    }
    
    public String getDate() {

        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    @Override
    public String toString() {
        
        return user + "\n" + title + "\n" + content;
    }
    
}
