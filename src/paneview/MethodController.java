package paneview;

import javafx.event.ActionEvent;

import java.util.List;

public interface MethodController<T> {

    void add (ActionEvent event) throws Exception;
    void update (ActionEvent event) throws Exception;
    void delete (ActionEvent event);
    void select(ActionEvent event);
    void save() throws Exception;
    void reset(ActionEvent event);

    void edit(ActionEvent event);

    T findById(int id);
    List<T> findByProductName (String name);
    List<T> findAll();

}
