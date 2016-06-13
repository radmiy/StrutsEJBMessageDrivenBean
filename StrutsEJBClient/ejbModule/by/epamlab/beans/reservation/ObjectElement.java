package by.epamlab.beans.reservation;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * Created by rdv on 03-Jun-16.
 */
public class ObjectElement implements Serializable {
	private static final long serialVersionUID = -4641415111946881410L;
    private String nameElement;
    private HashMap<String, String> attributes;
    private HashMap<String, List<ObjectElement>> content;

    public String getNameElement() {
        return nameElement;
    }

    public HashMap<String, String> getAttributes() {
        return attributes;
    }

    public HashMap<String, List<ObjectElement>> getContent() {
        return content;
    }

    public void setNameElement(String nameElement) {
        this.nameElement = nameElement;
    }

    public void setAttributes(HashMap<String, String> attributes) {
        this.attributes = attributes;
    }

    public void setContent(HashMap<String, List<ObjectElement>> content) {
        this.content = content;
    }
}
