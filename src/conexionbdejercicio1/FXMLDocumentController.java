package conexionbdejercicio1;

import com.mysql.jdbc.Connection;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/* @author Álvaro García Fernández*/
public class FXMLDocumentController implements Initializable {
        private Connection conn;
    private Label label;
    int id;
    String nombre;
    PreparedStatement ps;
     ResultSet rs;
    @FXML
    private Label LabelID;
    @FXML
    private TextField TextFliedID;
    @FXML
    private Label LabelTotalID;
    @FXML
    private Label LabelConectado;
    @FXML
    private Label LabelComunidad;
    @FXML
    private TextField TextFieldComunidad;
    @FXML
    private Button ButtonPrimero;
    @FXML
    private Button ButtonAnterior;
    @FXML
    private Button ButtonSiguiente;
    @FXML
    private Button ButtonÚltimo;
    @FXML
    private Label LabeDesconectado;
    
    private void handleButtonAction(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try  {
             conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/parques", "root", "root");
            if (conn != null) {
                this.LabeDesconectado.setText("");

            }
            
          ps = conn.prepareStatement("Select * from comunidad");
         rs= ps.executeQuery();

            rs.first();
         id = rs.getInt("id");
         nombre = rs.getString("nombre");
      
        this.TextFliedID.setText(""+id);
        this.TextFieldComunidad.setText(nombre);
        } catch (SQLException ex) {
            this.LabelConectado.setText("");
            System.out.println(ex.getMessage());
            
        } catch (Exception e) {
          this.LabelConectado.setText("");
          System.out.println(e.getMessage());
        }
    }
        

    @FXML
    private void ActionButtonPrimero(ActionEvent event) throws SQLException {
          rs.first();
         id = rs.getInt("id");
         nombre = rs.getString("nombre");
      
        this.TextFliedID.setText(""+id);
        this.TextFieldComunidad.setText(nombre);
    }

   @FXML
    private void ActionButtonAnterior(ActionEvent event){
        try {
            if (rs.isFirst()) {
                rs.last();
                id = rs.getInt("id");
                nombre = rs.getString("nombre");
                this.TextFliedID.setText("" + id);
                this.TextFieldComunidad.setText(nombre);
            } else {
                rs.previous();
                id = rs.getInt("id");
                nombre = rs.getString("nombre");
                this.TextFliedID.setText("" + id);
                this.TextFieldComunidad.setText(nombre);
            }

        } catch (SQLException ex) {

        }
    }

    @FXML
    private void ActionButtonSiguiente(ActionEvent event) {
        try {
            if (rs.isLast()) {
                rs.first();
                id = rs.getInt("id");
                nombre = rs.getString("nombre");
                this.TextFliedID.setText("" + id);
                this.TextFieldComunidad.setText(nombre);
            } else {
                rs.next();
                id = rs.getInt("id");
                nombre = rs.getString("nombre");
                this.TextFliedID.setText("" + id);
                this.TextFieldComunidad.setText(nombre);
            }
        } catch (SQLException ex) {

        }
    }

    @FXML
    private void ActionButtonÚltimo(ActionEvent event) throws SQLException {
         rs.last();
             id = rs.getInt("id");
         nombre = rs.getString("nombre");
           this.TextFliedID.setText(""+id);
        this.TextFieldComunidad.setText(nombre);
        
      
    }
    }
    

