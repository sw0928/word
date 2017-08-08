package tts.moudle.api.bean;

/**
 * Created by sjb on 2016/2/23.
 */
public class MenuItemBean {
    private int id;//菜单Id
    private String title;//菜单名称
    private int icon;//菜单图标
    private int textSise;//名称大小
    private int textColor;//名称颜色
    private int width;//图标宽度
    private int height;//图标高度

    private String type;//菜单类型 1：文本 2：图标

    /**
     * 默认是1
     *
     * @return
     */
    public String getType() {
        if (type == null || !type.equals("2")) {
            type = "1";
        }
        return type;
    }

    public MenuItemBean setType(String type) {
        this.type = type;
        return this;
    }

    public int getId() {
        return id;
    }

    public MenuItemBean setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public MenuItemBean setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getIcon() {
        return icon;
    }

    public MenuItemBean setIcon(String type, int icon) {
        this.type = type;
        this.icon = icon;
        return this;
    }

    public MenuItemBean setIcon(int icon) {
        this.icon = icon;
        return this;
    }

    public int getTextSise() {
        return textSise;
    }

    public MenuItemBean setTextSise(int textSise) {
        this.textSise = textSise;
        return this;
    }

    public int getTextColor() {
        return textColor;
    }

    public MenuItemBean setTextColor(int textColor) {
        this.textColor = textColor;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public MenuItemBean setWidth(int width) {
        this.width = width;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public MenuItemBean setHeight(int height) {
        this.height = height;
        return this;
    }
}
