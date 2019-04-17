package dmit2015.web;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import dmit2015.entities.Expense;
import dmit2015.service.ExpenseService;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class ExpenseCRUDController implements Serializable {
	private static Logger log = Logger.getLogger(ExpenseCRUDController.class.getName());
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ExpenseService expenseService;
	
	private List<Expense> expenses;		
	
	@Getter @Setter
	private Expense expenseDetail;	// The current Artist to create, edit, update or delete// +getter
	@Getter @Setter 
	private boolean editMode = false;
	
	@Getter @Setter 
	private Integer editId = null;
	@PostConstruct
	void init() {
		
		expenseDetail=new Expense();
		try {
			expenses = expenseService.findAllExpense();
		} catch(Exception e) {
			Messages.addGlobalError("Error retreiving shippers");
			log.fine(e.getMessage());			
		}
		
		
	
	}
	public String update() {
		String outcome = null;
		try {
			expenseService.updateExpense(expenseDetail);
			expenseDetail = new Expense();
			editMode = false;
			editId = null;
			Messages.addFlashGlobalInfo("Update was succesful");
			outcome = "list?faces-redirect=true";
		} catch(Exception e) {
			Messages.addGlobalError("Update was not successful");
			log.fine(e.getMessage());
		}
		
		return outcome;
	}
	
	public String create() {
		String outcome = null;
		
		try {
			expenseService.createExpense(expenseDetail);;
			init();
			Messages.addFlashGlobalInfo("Add successful");
			outcome = "list?faces-redirect=true";
		} catch(Exception e) {
			Messages.addGlobalError("Add unsuccessful");
			Messages.addGlobalError("Exception: " + e.getMessage());			
		}
		
		return outcome;
	}
	

	public void delete(Expense existingOffice) {
		
		try {			
			expenseService.deleteExpense(existingOffice);
			expenses.remove(existingOffice);
			Messages.addGlobalInfo("Delete successful");
		} catch(Exception e) {
			Messages.addGlobalError("Delete unsuccessful");
			Messages.addGlobalError("Exception: " + e.getMessage());			
		}
		
	}
	
	public void edit() {
		if (!Faces.isPostback() && !Faces.isValidationFailed() ) {
			if (editId != null) {
				try {
					expenseDetail = expenseService.findOneExpense(editId);
					if (expenseDetail != null) {
						editMode = true;
					} else {
						Messages.addFlashGlobalError("{0} is not a valid id value", editId);
						Faces.navigate("list?faces-redirect=true");						
					}
				} catch (Exception e) {
					Messages.addGlobalError("Query unsucessful");
					log.fine(e.getMessage());	
				}	
			} else {
				Faces.navigate("list?faces-redirect=true");	
			}
		} 
	}
	
	public String cancel() {
		expenseDetail = null;
		editMode = false;
		return "list?faces-redirect=true";
	}

	
	public List<Expense> getExpenses() {
		return expenses;
	}
}
