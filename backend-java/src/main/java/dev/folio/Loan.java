package dev.folio;
import jakarta.persistence.*;import java.time.LocalDate;
@Entity public class Loan {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; private Long bookId; private String studentId; private LocalDate borrowedOn,dueOn,returnedOn;
protected Loan(){} public Loan(Long b,String s,LocalDate from,LocalDate due){bookId=b;studentId=s;borrowedOn=from;dueOn=due;}
public Long getId(){return id;} public Long getBookId(){return bookId;} public String getStudentId(){return studentId;} public LocalDate getBorrowedOn(){return borrowedOn;} public LocalDate getDueOn(){return dueOn;} public LocalDate getReturnedOn(){return returnedOn;} public void setReturnedOn(LocalDate d){returnedOn=d;}
}