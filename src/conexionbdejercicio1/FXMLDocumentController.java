/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author daw
 */
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
    private void ActionButtonPrimero(ActionEvent event) {
    }

    @FXML
    private void ActionButtonAnterior(ActionEvent event) {
    }

    @FXML
    private void ActionButtonSiguiente(ActionEvent event) {
    }

    @FXML
    private void ActionButtonÚltimo(ActionEvent event) throws SQLException {
         while(rs.last()){
             id = rs.getInt("id");
         nombre = rs.getString("nombre");
        }
        this.TextFliedID.setText(""+id);
        this.TextFieldComunidad.setText(nombre);
    }
    }
    

