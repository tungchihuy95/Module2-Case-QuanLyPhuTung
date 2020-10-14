package paneview;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.io.*;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
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

    @FXML
    private Button addButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button editButton;

    @FXML
    private Button resetButton;

    @FXML
    private Button searchButton;

    @FXML
    private Button updateButton;

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

    private final NumberFormat numberFormat = new DecimalFormat("#,###");


    private ObservableList<Products> productsList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            productsList = FXCollections.observableArrayList(

                    readFile()

            );
        } catch (Exception e) {
            e.printStackTrace();
        }


        idColumn.setCellValueFactory(new PropertyValueFactory<Products, String>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Products, String>("name"));
        brandColumn.setCellValueFactory(new PropertyValueFactory<Products, String>("brand"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Products, Integer>("quantity"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Products, Integer>("price"));
        priceColumn.setCellFactory(tc -> new TableCell<Products, Integer>() {
            @Override
            protected void updateItem(Integer price, boolean empty) {
                super.updateItem(price, empty);
                if (price == null || empty) {
                    setText(null);
                } else {
                    setText(numberFormat.format(price));
                }
            }
        });
//        editButton.setDisable(true);
        table.setItems(productsList);
        this.search();

    }


    //Write files
    public void writeFile() throws Exception {
        FileOutputStream file;
        ObjectOutputStream object;
        try {
            file = new FileOutputStream("tung.txt");
            object = new ObjectOutputStream(file);
            for (Products products : productsList) {
                object.writeObject(products);
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Read file
    public List<Products> readFile() {
        List<Products> list = new ArrayList<>();
        FileInputStream file;
        ObjectInputStream object;
        try {
            file = new FileInputStream("tung.txt");
            object = new ObjectInputStream(file);
            while (true) {
                list.add((Products) object.readObject());
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (EOFException exception) {
            exception.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    //load
    public void loadProducts() {
//        table.getItems().clear();
        for (Products products : productsList) {
            table.getItems().add(products);
        }
        table.getItems().clear();
    }


    //Add
    @Override
    public void add(ActionEvent event) throws Exception {
        Products newProduct = new Products();
        newProduct.setId(idText.getText());
        newProduct.setName(nameText.getText());
        newProduct.setBrand(brandText.getText());
        newProduct.setQuantity(Integer.parseInt(quantityText.getText()));
        newProduct.setPrice(Integer.parseInt(priceText.getText()));

        for (Products product : productsList) {
            if (product.getId().equals(idText.getText()) || idText.getText().equals("")) {
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

    }


    //Save
    @Override
    public void save() {
        try {
            FileOutputStream fos = new FileOutputStream("src/file_manager/tung.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Products product : productsList) {
                oos.writeObject(product);
            }
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Edit
    @Override
    public void edit(ActionEvent e) {
        Products products = table.getSelectionModel().getSelectedItem();
        if (products == null) {
            editButton.setDisable(true);
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
            updateButton.setDisable(false);
            editButton.setDisable(true);
        }
    }

    //Delete
    @Override
    public void delete(ActionEvent event) {
        Products selectedProduct = table.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("System information");
        alert.setContentText("Do you really want to delete ?");
        alert.showAndWait();
        productsList.remove(selectedProduct);
        save();
        loadProducts();

    }

    public void TableSelectionChanged() {
        Products products = table.getSelectionModel().getSelectedItem();
        editButton.setDisable(products == null);
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
//            editButton.setDisable(true);
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
    public void update(ActionEvent event) throws Exception {
        Products products = table.getSelectionModel().getSelectedItem();
        if (products == null) {
            updateButton.setDisable(false);
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

            updateButton.setDisable(true);
            editButton.setDisable(false);
            loadProducts();
            writeFile();
            loadProducts();

        }
    }


    public void search() {
        FilteredList<Products> searchList = new FilteredList<>(productsList, b -> true);
        searchText.textProperty().addListener(((observable, oldValue, newValue) -> {
            searchList.setPredicate(products -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowercaseValue = newValue.toLowerCase();
                if (products.getId().indexOf(lowercaseValue) != -1) return true;
                else if (products.getName().toLowerCase().indexOf(lowercaseValue) != -1) return true;
                else if (products.getBrand().toLowerCase().indexOf(lowercaseValue) != -1) return true;
                else if (String.valueOf(products.getQuantity()).indexOf(lowercaseValue) != -1) return true;
                else if (String.valueOf(products.getPrice()).indexOf(lowercaseValue) != -1) return true;
                else return false;
            });
        }));
        table.setItems(searchList);
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
