package rpassets.core.model;

public abstract class AssetEntity {
    private String nameEn;
    private String nameRu;


    protected AssetEntity(String nameEn, String nameRu) {
        this.nameEn = nameEn;
        this.nameRu = nameRu;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }
}
