package Main;

public class Template {
    private String name;
    private int xName;
    private int yName;
    private int xCategory;
    private int yCategory;
    private int xTeacher;
    private int yTeacher;
    private int fontSizeName;
    private int fontSizeCategory;
    private int fontSizeTeacher;
    private float spacing;
    private int yChange;

    public Template(String name, int xName, int yName, int xCategory, int yCategory, int xTeacher, int yTeacher, int fontSizeName
            , int fontSizeCategory, int fontSizeTeacher, float spacing, int yChange) {
        this.name = name;
        this.xName = xName;
        this.yName = yName;
        this.xCategory = xCategory;
        this.yCategory = yCategory;
        this.xTeacher = xTeacher;
        this.yTeacher = yTeacher;
        this.fontSizeName = fontSizeName;
        this.fontSizeCategory = fontSizeCategory;
        this.fontSizeTeacher = fontSizeTeacher;
        this.spacing = spacing;
        this.yChange = yChange;
    }

    public String getName() {
        return name;
    }

    public int getxName() {
        return xName;
    }

    public int getyName() {
        return yName;
    }

    public int getxCategory() {
        return xCategory;
    }

    public int getyCategory() {
        return yCategory;
    }

    public int getxTeacher() {
        return xTeacher;
    }

    public int getyTeacher() {
        return yTeacher;
    }

    public int getFontSizeName() {
        return fontSizeName;
    }

    public int getFontSizeCategory() {
        return fontSizeCategory;
    }

    public int getFontSizeTeacher() {
        return fontSizeTeacher;
    }

    public float getSpacing() {
        return spacing;
    }

    public int getyChange() {
        return yChange;
    }
}
