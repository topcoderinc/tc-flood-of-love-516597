package com.javaprocess;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.javabean.Values;

@ManagedBean(name="processor")
@SessionScoped
public class Processor {
	
	public String createFinalSentence() {
		Values values = (Values) FacesContext.getCurrentInstance().getELContext()
				.getELResolver().getValue(FacesContext.getCurrentInstance().getELContext(),null,"values");
		formSentence(values);
		return "finalResult?faces-redirect=true";
	}
	
	private void formSentence(Values values) {
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		if(session== null)
			FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.setAttribute("valueBean", values);
	}
}