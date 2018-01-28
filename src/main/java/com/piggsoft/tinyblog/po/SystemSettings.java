package com.piggsoft.tinyblog.po;

/**
 * @author piggsoft
 * @version 1.0
 * @create 2018/1/28
 * @since 1.0
 */
public class SystemSettings {

    private Long id;
    private String key;
    private String value;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
