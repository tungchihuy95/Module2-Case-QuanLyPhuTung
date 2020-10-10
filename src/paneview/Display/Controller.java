package paneview.Display;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
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
import paneview.Model.Products;



//
public class Controller implements Initializable {

    @FXML
    private TableView<Products> table;

    @FXML
    private ImageView image;

    @FXML
    private TableColumn<Products, String> idColumn;

    @FXML
    private TableColumn<Products, String> nameColumn;

    @FXML
    private TableColumn<Products, String> brandColumn;

    @FXML
    private TableColumn<Products, Integer> quantityColumn;

    @FXML
    private TableColumn<Products, Integer> priceColumn;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button resetButton;


    //List thay đổi nên cái hiển thị của TableView cũng thay đổi theo, nên cần dùng ObservableList
    private ObservableList<Products> obsProdList;

    @FXML
    private TextField idText;

    @FXML
    private TextField nameText;

    @FXML
    private TextField brandText;

    @FXML
    private TextField quantityText;

    @FXML
    private TextField priceText;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        //vì ObservableList là thuộc ITF, nên phải có một thư viện để khởi tạo nó
        obsProdList = FXCollections.observableArrayList(
                new Products("BULH1189", "BU LONG LOC", "HONDA", 7, 6500),
                new Products("BULH1236", "BU LONG CHAN NHIET", "HONDA", 8, 5000),
                new Products("BULH1873", "BU LONG LOC", "HONDA", 6, 7000)
        );
        //cho ID, name,... vào đúng các cột ID, name...
        idColumn.setCellValueFactory(new PropertyValueFactory<Products, String>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Products, String>("name"));
        brandColumn.setCellValueFactory(new PropertyValueFactory<Products, String>("brand"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Products, Integer>("quantity"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Products, Integer>("price"));
        table.setItems(obsProdList);//đưa obsProdList vào trong table(khai báo bên trên)
    }


//public class Controller implements Initializable {
//
//    @FXML
//    private TableView<Products> table;
//
//    @FXML
//    private ImageView image;
//
//    @FXML
//    private TableColumn<Products, String> idColumn;
//
//    @FXML
//    private TableColumn<Products, String> nameColumn;
//
//    @FXML
//    private TableColumn<Products, String> brandColumn;
//
//    @FXML
//    private TableColumn<Products, Integer> quantityColumn;
//
//    @FXML
//    private TableColumn<Products, Integer> priceColumn;
//
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
//
//    //List thay đổi nên cái hiển thị của TableView cũng thay đổi theo, nên cần dùng ObservableList
//    private ObservableList<Products> obsProdList;
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
//
//
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        //vì ObservableList là thuộc ITF, nên phải có một thư viện để khởi tạo nó
//        obsProdList = FXCollections.observableArrayList (
//                new Products("BULH1189", "BU LONG LOC", "HONDA", 7, 6500),
//                new Products("BULH1236", "BU LONG CHAN NHIET", "HONDA", 8, 5000),
//                new Products("BULH1873", "BU LONG LOC", "HONDA", 6, 7000)
//
//        );
//

    //
//
//
    public void add(ActionEvent event) {
        Products newProduct = new Products();
        //lấy id từ trong idText
        newProduct.setId(idText.getText());//nếu id là int thì phải là Integer.parseInt nhưng id là String r nên k cần
        newProduct.setName(nameText.getText());
        newProduct.setBrand(brandText.getText());
        newProduct.setQuantity(Integer.parseInt(quantityText.getText()));
        newProduct.setPrice(Integer.parseInt(priceText.getText()));
        //sau đó cho đối tượng vừa tạo vào trong list obsProdList (dòng 79)
        obsProdList.add(newProduct);


    }
}
//}
//
