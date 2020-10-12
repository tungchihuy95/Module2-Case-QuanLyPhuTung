package paneview;

import javafx.collections.FXCollections;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;


public class Controller implements Initializable {

    @FXML
    private TableView<Products> table;

    @FXML
    private TableColumn<Products, String > idColumn;

    @FXML
    private TableColumn<Products, String> nameColumn;

    @FXML
    private TableColumn<Products, String> brandColumn;

    @FXML
    private TableColumn<Products, Integer> quantityColumn;

    @FXML
    private TableColumn<Products, Integer> priceColumn;

    private ObservableList<Products> observableList;


//    //List thay đổi nên cái hiển thị của TableView cũng thay đổi theo, nên cần dùng ObservableList
//    private ObservableList<Products> obsProdList;

//    @FXML
//    private Button addButton;
//
//    @FXML
//    private Button deleteButton;
//
//    @FXML
//    private Button updateButton;
//
//    @FXML
//    private Button resetButton;
//
//    @FXML
//    private Button searchButton;
//
//
//    @FXML
//    private TextField idText;
//
//    @FXML
//    private TextField nameText;
//
//    @FXML
//    private TextField brandText;
//
//    @FXML
//    private TextField quantityText;
//
//    @FXML
//    private TextField priceText;

//    @FXML
//    private TextField searchText;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //vì ObservableList là thuộc ITF, nên phải có một thư viện để khởi tạo nó
        observableList = FXCollections.observableArrayList(
                new Products("BAXS2202", " LOP TRUOC SPORTY ", "SUZUKI", 3,  320000 ),
                new Products("BULH1236", " BU LONG CHAN NHIET ", "HONDA", 3,  5000),
                new Products("BAXS2202", " LOP TRUOC SPORTY ", "SUZUKI", 3,  320000 )
        );

        idColumn.setCellValueFactory(new PropertyValueFactory<Products, String>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Products, String>("name"));
        brandColumn.setCellValueFactory(new PropertyValueFactory<Products, String>("brand"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Products, Integer>("quantity"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Products, Integer>("price"));
        table.setItems(observableList);

    }

    //Dùng ID tự sinh (thêm cột STT)
}