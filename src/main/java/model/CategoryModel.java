package model;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class CategoryModel {
    private int idBookCategory;
    private String categoryName;

    public CategoryModel(int idBookCategory, String categoryName) {
        this.idBookCategory = idBookCategory;
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "CategoryModel{" +
                "idBookCategory=" + idBookCategory +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
