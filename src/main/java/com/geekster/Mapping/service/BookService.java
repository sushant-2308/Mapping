package com.geekster.Mapping.service;

import com.geekster.Mapping.model.Book;
import com.geekster.Mapping.model.Student;
import com.geekster.Mapping.repository.IBookRepository;
import com.geekster.Mapping.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    IBookRepository iBookRepository;

    @Autowired
    IStudentRepository iStudentRepository;

    public String addBook(Book book) {
        if(book!=null){
            Integer studentId = book.getStudent().getStudentId();
            Optional<Student> student = iStudentRepository.findById(studentId);
            if(student.isPresent()){
                book.setStudent(student.get());
                iBookRepository.save(book);
                return "Book added sucessfully";
            }
            return "Enter valid details";

        }
        return "Book not added sucessfully";

    }

    public List<Book> getAllBook(Integer bookId) {
        if(bookId==null){
            return iBookRepository.findAll();
        }else{
            List<Book> bookList = new ArrayList<>();
            bookList.add(iBookRepository.findById(bookId).get());
            return bookList;
        }
    }

    public String deleteBookById(Integer bookId) {
        Optional<Book> optionalbook = iBookRepository.findById(bookId);
        if(optionalbook.isEmpty()){
            return "Book with id "+bookId + " is not present";
        }else{
            iBookRepository.deleteById(bookId);
            return "Book with id "+bookId + " deleted successfully";
        }
    }

    public String updateBook(Integer bookId, Book book) {
        Optional<Book> optionalbook = iBookRepository.findById(bookId);
        Student student = book.getStudent();
        if(optionalbook.isEmpty()){
            return "Book with id "+bookId + " is not present";
        }else{
            Optional<Student> student1 = iStudentRepository.findById(student.getStudentId());
            book.setStudent(student1.get());

            book.setBookId(bookId);
            iBookRepository.save(book);
            return "Book with id "+bookId + " updated successfully";
        }
    }
}