package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class SampleController implements Initializable{
	LoginModel loginModel =new LoginModel();

    @FXML
    private Label L1;
    
    @FXML
    private ImageView myimg;
    @FXML
    private Button btn;

    @FXML
    private TextField username;
    
    @FXML
    private PasswordField password;
    
    @Override
public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	/* if(loginModel.isDbconnected())
		 	L1.setText("DB connected...");
		else
		    L1.setText("DB Connection Failed");*/
    	Image image = new Image("file:src/Resource/sample.png");
		myimg.setImage(image);
    }
	    
	 public void logInCheck(ActionEvent event)
		{
			try {
				String u=username.getText();
				String p=password.getText();
				System.out.println(u);
				System.out.println(p);
				
				if(loginModel.isValidLogin(username.getText(), password.getText()))
				{
					
					L1.setText("Valid username and password");
					Stage stage=(Stage)this.password.getScene().getWindow();
					stage.close();
					openPage(event);
				}else 
				{
					L1.setText("InValid username and password");
				}
				}catch(Exception e) 
			{
					e.printStackTrace();
					L1.setText("InValid username and password");
				}
		}
			public void openPage(ActionEvent event) throws IOException {
				Stage primaryStage=new Stage();
				Parent root = FXMLLoader.load(getClass().getResource("Item.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
}
}


