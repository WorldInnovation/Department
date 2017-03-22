package com.aimprosoft.model;

import net.sf.oval.constraint.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "Employee")
public class Employee implements Serializable {

    public Employee() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //  @Column(name = "firstName")
//    @NotNull
//    @NotEmpty
    @MinLength(value = 3, message = " is shorter 3")
    @MaxLength(value = 21, message = " is bigger 21")
    private String firstName;

    //  @Column(name = "secondName")
//    @NotNull
//    @NotEmpty
    @MinLength(value = 3, message = " is shorter 3")
    @MaxLength(value = 21, message = " is bigger 21")
    private String secondName;

    //   @Column(name = "grade")
//    @NotNull(message = " is smaller 1")
//    @NotEmpty(message = " is smaller 1")
    @Min(value = 1, message = " is smaller 1")
    @Max(value = 10, message = " is bigger 10")
    private Integer grade;

    //  @Column(name = "birthday")
    @Temporal(value = TemporalType.DATE)
    //  @Min(value = 9, message = " select format yyyy-MM-dd")
    //   @Max(value = 12, message = " select format yyyy-MM-dd")
    @NotNull(message = "select format yyyy-MM-dd")
//    @NotEmpty(message = "select format yyyy-MM-dd")
    @DateRange(format = "yyyy-mm-dd", message = "select format yyyy-MM-dd")
    private Date birthday;

    //   @Column(name = "eMail")
//    @NotNull
//    @NotEmpty
    @MinLength(value = 7, message = "set@rightMail.format")
    @MaxLength(value = 21, message = "mail is to long")
    @Email(message = "set@rightMail.format")
    private String eMail;


    //  @Column(name = "depID")
    @NotNull
    private Long depId;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getDepID() {
        return depId;
    }

    public void setDepID(Long depId) {
        this.depId = depId;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        return getId() == employee.getId();
    }

    @Override
    public int hashCode() {
        return (int) (getId() ^ (getId() >>> 32));
    }
}