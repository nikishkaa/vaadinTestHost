package org.example.vaadindeploytestproject.login;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.Collections;

@Route("Login")
@PageTitle("Login")
public class LoginView extends VerticalLayout implements BeforeEnterObserver {
    LoginForm loginForm = new LoginForm();

    public LoginView() {
        addClassName("login-view");
        setSizeFull();

        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);
        loginForm.setAction("login");
        add(
                new H1("Vaadin Login Screen"), loginForm
        );
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if (!beforeEnterEvent.getLocation().getQueryParameters()
                .getParameters().getOrDefault("error", Collections.emptyList()).isEmpty()) {
            loginForm.setError(true);
        }
    }
}
