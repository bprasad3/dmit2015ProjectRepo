package dmit2015.repository;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import dmit2015.entities.Expense;


public class ExpenseRepository extends AbstractJPARepository<Expense> {
	public ExpenseRepository() {
		super(Expense.class);
	}
	
	
	

//	public List<Expense> findAll() {
//		return getEntityManager().createQuery(
//			"FROM Expense c ORDER BY c.id",
//			Expense.class)
//			.getResultList();
//	}
//	
	
	


	


}
