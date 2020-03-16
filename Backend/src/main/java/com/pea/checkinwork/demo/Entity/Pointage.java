package com.pea.checkinwork.demo.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
//import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@ToString
@EqualsAndHashCode
@Data
public class Pointage {
	@SequenceGenerator(name="pointage_seq",sequenceName="pointage_seq")
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="pointage_seq")
	@Id
    private Long id;

    @NotNull
    private String firstname;

    @NotNull
	private String lastname;
	
	@NotNull
	private Date date;



	public Pointage(){}

    public Pointage(String firstname, String lastname, Date date) {
		this.date = date;
		this.firstname = firstname;
		this.lastname = lastname;
	}

}