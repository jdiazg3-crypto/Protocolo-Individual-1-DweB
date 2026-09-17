# Usar la imagen oficial de Tomcat 9 con Java 8 (Acorde a los requerimientos)
FROM tomcat:9.0-jdk8-corretto

# Eliminar las aplicaciones por defecto de Tomcat para evitar conflictos
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copiar el archivo compilado (WAR) a la carpeta de despliegue de Tomcat como aplicación principal (ROOT)
COPY target/gestion_futbol.war /usr/local/tomcat/webapps/ROOT.war

# Exponer el puerto
EXPOSE 8080

# Iniciar Tomcat
CMD ["catalina.sh", "run"]
