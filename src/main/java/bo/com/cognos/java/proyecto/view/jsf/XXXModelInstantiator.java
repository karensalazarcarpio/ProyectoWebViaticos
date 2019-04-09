package bo.com.cognos.java.proyecto.view.jsf;

import org.apache.log4j.Logger;

import bo.com.cognos.java.proyecto.model.XXXModel;

public class XXXModelInstantiator {
static Logger log = Logger.getLogger(XXXModelInstantiator.class);
public static<T extends XXXModel> T instantiate(Class<T> clazz){
  try {
    return clazz.newInstance();
  } catch (Exception e) {
   log.error("Error al instanciar objeto del tipo " + clazz.getName(), e);
     return null;
   }
  }
}

