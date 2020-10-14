package paneview;

import javafx.event.ActionEvent;

import java.util.List;

public interface MethodController<T> {

    void add (ActionEvent event) throws Exception;
    void update (ActionEvent event);
    void delete (ActionEvent event);
    void select(ActionEvent event);
    void save(ActionEvent event) throws Exception;
    void reset(ActionEvent event);
    void search(ActionEvent event);

    T findById(int id);
    List<T> findByProductName (String name);
    List<T> findAll();

}
