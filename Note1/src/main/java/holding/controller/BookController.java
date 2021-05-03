package holding.controller;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {
    @Autowired
    BookService service;
    @Autowired
    ResponseBook responseBook;

    @GetMapping(value = "/{category_id}")
    public ResponseBook get(@PathVariable (name="category_id") int idCategory,
                            @RequestParam (name="orderBy",required = false) String type,
                            @RequestParam (name="order",required = false) String order){
        //ResponseBook responseBook = ResponseBook.getInstance();
        if(!service.checkValid_IdCategory(idCategory)){
            responseBook.setCode(-1);
            responseBook.setMessage("fail to connect, check value id");
        }else{
            responseBook.setCode(200);
            responseBook.setMessage("Success");
            if (type==null){
                type="nameBook";
            }
            if(order==null){
                order="ASC";
            }
            responseBook.setListBook(service.getListBook_byCategory_order(idCategory,type, order));
        }
        return responseBook;
    }

}

@Getter @Setter
class Book{
    private int idBook;
    private String nameBook;
    private int yearEdition;
    private String descript;
    private String linkImg;
    private String author;
    private float price;
    private String category;           // bằng 1 nếu bằng toán, bằng 2 nếu bằng văn

}

@Getter @Setter @Service
class ResponseBook{
    private int code;
    private String message;
    private List<Book> listBook ;
/////////// Eager Initialization
//    private static final ResponseBook response = new ResponseBook();
//    private ResponseBook(){
//
//    }
//    public static ResponseBook getInstance(){
//        return response;
//    }
}


@Service ///// singleton
class BookService{
    @Autowired
    Connection connectDB;

    public boolean checkValid_IdCategory(int id){
        if (id>2||id<1){
            return false;
        }else {
            return true;
        }
    }
    public List<Book> getListBook_byCategory_order(int id,String type, String order){
        List<Book> list= new ArrayList<>();
        String category =(id==1)? "Toán học":"Văn học";
        String sql = "SELECT * FROM books WHERE category = '"+category+"' ORDER BY "+type+" "+order;
        try {
            Statement stmt = connectDB.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                Book book =new Book();// hoặc khởi tạo bằng contructor
                book.setIdBook(rs.getInt(1));
                book.setNameBook(rs.getString(2));
                book.setYearEdition(rs.getInt(3));
                book.setDescript(rs.getString(4));
                book.setAuthor(rs.getString(6));
                book.setPrice(rs.getFloat(7));
                book.setCategory(category);
                list.add(book);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }


}


