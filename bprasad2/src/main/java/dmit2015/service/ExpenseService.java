package dmit2015.service;
import java.util.List;
import java.util.Locale.Category;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dmit2015.entities.Expense;



@Stateless
public class ExpenseService {

	@Inject
	private dmit2015.repository.ExpenseRepository ExpenseRepository;

	
	public void createExpense(Expense newExpense) {
		 ExpenseRepository.create(newExpense);
	}

	public void updateExpense(Expense existingExpense) {
		ExpenseRepository.edit(existingExpense);
	}
	
	public void deleteExpense(Expense existingExpense){
		ExpenseRepository.remove(existingExpense);
		}
	public Expense findOneExpense(int ExpenseID) {
		return ExpenseRepository.find(ExpenseID);
	}
	
	
	public List<Expense> findAllExpense() {
		return ExpenseRepository.findAll();
	}
}
