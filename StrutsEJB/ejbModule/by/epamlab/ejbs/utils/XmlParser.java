package by.epamlab.ejbs.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;

import by.epamlab.beans.reservation.ObjectElement;
import by.epamlab.ejbs.constants.Constants;

public class XmlParser {
	private Element rootNode;
	private Namespace namespace;
	private HashMap<String, List<String>> elementsParam = new HashMap<>();

	public List<ObjectElement> getElement(String nameElement, String params) {
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(Constants.FILE_XML);
		try {
			Document document = builder.build(xmlFile);
			rootNode = document.getRootElement();
			namespace = rootNode.getNamespace("");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}

		String[] arrayParams = params.split(";");
		getParams(nameElement, arrayParams);
		List<ObjectElement> elements = new ArrayList<>();
		List<Element> listElements = new ArrayList<>();
		if(rootNode == null) {
			return elements;
		}
		namespace = rootNode.getNamespace("");
		if(rootNode.getName().equals(nameElement)) {
			listElements.add(rootNode);
		}else {
			listElements = rootNode.getChildren(nameElement, namespace);
		}

		if(listElements != null) {
			for(Element element : listElements) {
				elements.add(getElement(element));
			}
		}
		return  elements;
	}

	private void getParams(String name, String[] arrayParams) {
		elementsParam = new HashMap<>();
		List<String> listElemenParams = new ArrayList<>();
		elementsParam.put(name, listElemenParams);

		if(arrayParams != null) {
			for (String attribute : arrayParams) {
				if(attribute != null && !attribute.equals("") && attribute.indexOf("(") == -1) {
					listElemenParams = elementsParam.get(name);
					if(listElemenParams != null) {
						listElemenParams.add(attribute);
					}
				}else {
					listElemenParams = new ArrayList<>();
					int startIndex = attribute.indexOf("(");
					String nameElement = attribute.substring(0, startIndex);
					startIndex++;
					int endIndex = attribute.indexOf(")");
					String[] arrayElentParams = attribute.substring(startIndex, endIndex).split(",");
					if(arrayElentParams != null) {
						for(String nameElementParam : arrayElentParams) {
							if(nameElementParam != null && !nameElementParam.equals("")) {
								listElemenParams.add(nameElementParam);
							}
						}
					}
					elementsParam.put(nameElement, listElemenParams);
				}
			}
		}
	}

	private ObjectElement getElement(Element element) {
		namespace = element.getNamespace("");
		String nameElement = element.getName();

		ObjectElement objectElement = new ObjectElement();
		objectElement.setNameElement(element.getName());

		List<Element> listElements = element.getChildren();
		if(listElements != null) {
			for (int indexListElement =listElements.size() - 1; indexListElement >= 0; indexListElement--) {
				Element elementElement = listElements.get(indexListElement);
				if (listElements.get(indexListElement) != null && !elementsParam.containsKey(elementElement.getName())) {
					listElements.remove(elementElement);
				}
			}
		}
		List<Attribute> listAttributes = element.getAttributes();

		if(listAttributes != null) {
			HashMap<String, String> attributes = new HashMap<>();
			for (Attribute attribute : listAttributes) {
				if(elementsParam.containsKey(nameElement)) {
					List<String> listParams = elementsParam.get(nameElement);
					if (listParams == null || listParams.size() == 0) {
						attributes.put(attribute.getName(), attribute.getValue());
					} else {
						for (String nameParam : listParams) {
							if (nameParam != null && nameParam.equals(attribute.getName())) {
								attributes.put(attribute.getName(), attribute.getValue());
							}
						}
					}
				}
			}
			objectElement.setAttributes(attributes);
		}

		if(listElements != null) {
			HashMap<String, List<ObjectElement>> contents = new HashMap<>();
			List<ObjectElement> elements = new ArrayList<>();
			for(Element content : listElements) {
				elements.add(getElement(content));
			}
			if(elementsParam.containsKey(nameElement)) {
				contents.put("", elements);
				objectElement.setContent(contents);
			}
		}
		return  objectElement;
	}
}
