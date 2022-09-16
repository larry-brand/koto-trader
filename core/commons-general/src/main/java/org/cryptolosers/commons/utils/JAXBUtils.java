package org.cryptolosers.commons.utils;

import javax.xml.bind.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Utils class for simple usage JAXB: to xml and from xml
 */
@SuppressWarnings("unchecked")
public class JAXBUtils {

    private static ConcurrentMap<Class, JAXBContext> jaxbContextMap = new ConcurrentHashMap<>();

    public static String marshall(Object source) throws JAXBException {
        StringWriter sw = new StringWriter();
        JAXBContext jaxbContext;
        if (jaxbContextMap.get(source.getClass()) == null) {
            jaxbContext = JAXBContext.newInstance(source.getClass());
            jaxbContextMap.put(source.getClass(), jaxbContext);
        } else {
            jaxbContext = jaxbContextMap.get(source.getClass());
        }
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(source, sw);
        return sw.toString();
    }

    public static <T> T unmarshall(String xml, Class<T> sourceClass) throws JAXBException {
        try {
            JAXBContext jaxbContext;
            if (jaxbContextMap.get(sourceClass) == null) {
                jaxbContext = JAXBContext.newInstance(sourceClass);
                jaxbContextMap.put(sourceClass, jaxbContext);
            } else {
                jaxbContext = jaxbContextMap.get(sourceClass);
            }
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StringReader sr = new StringReader(xml);
            T retVal = (T) jaxbUnmarshaller.unmarshal(sr);
            return retVal;
        } catch (UnmarshalException e) {
            return null;
        }
    }

    public static Object unmarshall(String xml, JAXBContext jaxbContext) throws JAXBException {
        try {
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StringReader sr = new StringReader(xml);
            Object retVal = jaxbUnmarshaller.unmarshal(sr);
            return retVal;
        } catch (UnmarshalException e) {
            return null;
        }
    }

}
