package dmit2015.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the Expense database table.
 * 
 */
@Entity
public class Expense implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	

	@NotNull
	private BigDecimal amount;

	
	private Date date=java.util.Calendar.getInstance().getTime();
	
	
	@Column(length = 50)
	@NotNull
	private String description;
	
	
	private String email;   

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Expense() {
	}


	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	


}