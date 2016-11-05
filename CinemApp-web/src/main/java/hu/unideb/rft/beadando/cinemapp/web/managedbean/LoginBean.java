package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import hu.unideb.rft.beadando.cinemapp.ejb.api.LoginService;
import hu.unideb.rft.beadando.cinemapp.web.filter.LoginFilter;

@ManagedBean(name = "login")
@SessionScoped
public class LoginBean{
	
	@EJB
	private LoginService loginService;

	private String username;
	private String password;
	private String message;
	
	private Boolean loggedIn;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@PostConstruct
	public void init() {
		this.loggedIn = false;		
	}

	public String loginUser() throws IOException{
		boolean valid = loginService.validate(username, password);
		
		if (valid) {
			FacesContext context = FacesContext.getCurrentInstance();
	        ExternalContext externalContext = context.getExternalContext();
			
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			session.setAttribute("username", username);
			System.out.println("Login Success");
			loggedIn = true;
			
			externalContext.redirect(externalContext.getApplicationContextPath() + "/secured/adminpage.xhtml");
			
			return "";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Passowrd",
							"Please enter correct username and Password"));
			
			loggedIn = false;
			FacesContext fCtx = FacesContext.getCurrentInstance();
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Incorrect username or password!", "Your login skills are bad so you should feel bad..");
			fCtx.addMessage("password", fm);
			return "login";
		}
	}

	//logout event, invalidate session
	public String logout() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
		System.out.println("logout successful");
		loggedIn = false;
		return "index";
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
}
