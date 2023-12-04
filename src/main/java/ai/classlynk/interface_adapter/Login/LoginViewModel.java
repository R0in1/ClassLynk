package ai.classlynk.interface_adapter.Login;

import ai.classlynk.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LoginViewModel extends ViewModel {

    public final String TITLE_LABEL = "Log In";
    public final String USERNAME_LABEL = "Enter username";
    public final String PASSWORD_LABEL = "Enter password";

    public static final String Login_BUTTON_LABEL = "Log in";
    public static final String GoRegister_BUTTON_LABEL = "Go to register";

    private LoginState state = new LoginState();

    public LoginViewModel() {
        super("log in");
    }

    public void setState(LoginState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Signup Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public LoginState getState() {
        return state;
    }
}
