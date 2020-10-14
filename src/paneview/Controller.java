package paneview;

import file_manager.FileManager;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.*;



import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;




public class Controller implements Initializable, MethodController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TableView<Products> table;

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




//    //List thay đổi nên cái hiển thị của TableView cũng thay đổi theo, nên cần dùng ObservableList
//    private ObservableList<paneview.Products> obsProdList;

    @FXML
    private Button addButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button deleteButton;
    //
    @FXML
    private Button updateButton;

    @FXML
    private Button resetButton;

    @FXML
    private Button searchButton;
//
//
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

    @FXML
    private TextField searchText;


    List<Products> productsList = new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            readFile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //vì ObservableList là thuộc ITF, nên phải có một thư viện để khởi tạo nó


        idColumn.setCellValueFactory(new PropertyValueFactory<Products, String>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Products, String>("name"));
        brandColumn.setCellValueFactory(new PropertyValueFactory<Products, String>("brand"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Products, Integer>("quantity"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Products, Integer>("price"));
        table.getItems().addAll(productsList);

    }


    //Ghi
    public void writeFile() throws Exception {
        FileManager<Products> fileManager = new FileManager<>();
        fileManager.writeFile("src/file_manager/tung.txt", productsList);
    }
    //đọc file
    public void readFile() throws Exception {
        FileManager<Products> fileManager = new FileManager<>();
                productsList.clear();
                productsList.addAll(fileManager.readFile("src/file_manager/tung.txt"));
    }




    public void loadProducts() {
        table.getItems().clear();
        for (Products products : productsList) {
            table.getItems().add(products);
        }
    }

    @Override
    public void add(ActionEvent event) throws Exception {
        Products newProduct = new Products();
        newProduct.setId(idText.getText());
        newProduct.setName(nameText.getText());
        newProduct.setBrand(brandText.getText());
        newProduct.setQuantity(Integer.parseInt(quantityText.getText()));
        newProduct.setPrice(Integer.parseInt(priceText.getText()));

        for (Products products : productsList) {
            if (products.getId().equals(idText.getText()) || idText.getText().equals("")) {
//                Alert.AlertType alertAlertType;
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Alert Information!");
                alert.setContentText("Existed or missing info!");
                alert.showAndWait();
                return;

            }

        }
        productsList.add(newProduct);
        idText.clear();
        nameText.clear();
        brandText.clear();
        quantityText.clear();
        priceText.clear();
        loadProducts();
        writeFile();


//                if (flag)
//                Products newProduct = new Products();
//                newProduct.setId(idText.getText());
//                newProduct.setName(nameText.getText());
//                newProduct.setBrand(brandText.getText());
//                newProduct.setQuantity(Integer.parseInt(quantityText.getText()));
//                newProduct.setPrice(Integer.parseInt(priceText.getText()));
//                    productList
//                    productList.add(newProduct);


    }

    @Override
    public void update(ActionEvent e) {
        Products products = table.getSelectionModel().getSelectedItem();
        if (products == null) {
            updateButton.setDisable(true);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("System information");
            alert.setContentText("No product selected. Please try again!");
            alert.showAndWait();
        } else {
            idText.setText(products.getId());
            nameText.setText(products.getName());
            brandText.setText(products.getBrand());
            quantityText.setText(String.valueOf(products.getQuantity()));
            priceText.setText(String.valueOf(products.getPrice()));
            saveButton.setDisable(false);
            updateButton.setDisable(true);
        }
    }

    @Override
    public void delete(ActionEvent event) {
        Products selectedProduct = table.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("System information");
        alert.setContentText("Do you really want to delete ?");
        alert.showAndWait();
        productsList.remove(selectedProduct);
        loadProducts();

    }

    public void TableSelectionChanged() {
        Products products = table.getSelectionModel().getSelectedItem();
        updateButton.setDisable(products == null);
    }


    @Override
    public void select(ActionEvent event) {
        Products selectedProduct = table.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            idText.setText(String.valueOf(selectedProduct.getId()));
            nameText.setText(String.valueOf(selectedProduct.getName()));
            brandText.setText(String.valueOf(selectedProduct.getBrand()));
            quantityText.setText(String.valueOf(selectedProduct.getQuantity()));
            priceText.setText(String.valueOf(selectedProduct.getPrice()));
        } else {
            Alert.AlertType alertAlertType;
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Not found!");
            alert.setHeaderText(null);
            alert.setContentText("Product is not selected!");
            alert.showAndWait();
        }
    }

    @Override
    public void save(ActionEvent event) throws Exception{
        Products products = table.getSelectionModel().getSelectedItem();
        if (products == null) {
            saveButton.setDisable(false);
            Alert.AlertType alertAlertType;
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("System Information!");
            alert.setContentText("No selected yet. Please try again:");
            alert.showAndWait();
        } else {
            products.setId(idText.getText());
            products.setName(nameText.getText());
            products.setBrand(brandText.getText());
            products.setQuantity(Integer.parseInt(quantityText.getText()));
            products.setPrice(Integer.parseInt(priceText.getText()));

            saveButton.setDisable(true);
            updateButton.setDisable(false);

//            productsList.add(products);
            loadProducts();
            writeFile();
        }
    }

    @Override
    public void search(ActionEvent event) {
//        String input = n.toLowerCase();
//        boolean check = false;
//        String string;
//        int i;
//        for (i = 0; i < listBooks.size(); i++) {
//            string = (listBooks.get(i).getNameBook()).toLowerCase();
//            for (int j = 0; j < (listBooks.get(i).getNameBook()).length(); j++) {
//                if (listBooks.get(j).getNameBook().contains(input)) {
//                    check = true;
//                    break;
//                }
//                if (check)
//                    tableView.getItems().add(listBooks.get(i));
//            }
//        }
    }

    @Override
    public void reset(ActionEvent event) {
        idText.clear();
        nameText.clear();
        brandText.clear();
        quantityText.clear();
        priceText.clear();


    }


    @Override
    public Object findById(int id) {
        return null;
    }

    @Override
    public List findByProductName(String name) {

        return null;
    }

    @Override
    public List findAll() {
        return null;
    }



}
