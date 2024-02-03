# Sistema de Inventario para una Tienda de Ropa Deportiva (InventarioXport)

## Introduccion

El proyecto InventarioXport se centra en el desarrollo de un Sistema de Inventario para una Tienda de Ropa Deportiva, que busca optimizar la gestión de inventario en un entorno minorista dinámico y altamente competitivo. La tienda, ubicada en un entorno urbano con alta demanda de productos deportivos, ha identificado problemas en su gestión de inventario, como falta de visibilidad de stock, exceso de inventario y pérdida de ventas por falta de disponibilidad de productos populares.

En respuesta a estos desafíos, el proyecto se propone diseñar e implementar un sistema automatizado y robusto, utilizando tecnologías modernas como Java 17, spring, Hibernate, MySQL y JavaFX.

## Objetivos
#### General

El objetivo general de este proyecto de investigación es diseñar, implementar y evaluar un Sistema de Inventario para una Tienda de Ropa Deportiva que permita una gestión eficiente y precisa de los productos, optimizando los procesos internos y mejorando la experiencia tanto para el personal de la tienda como para los clientes.

#### Específicos (POR MEJORAR)

1. Analizar las necesidades y requisitos específicos de gestión de inventario de una tienda de ropa deportiva, considerando aspectos como la variedad de productos, la estacionalidad de la demanda y los patrones de compra de los clientes.
2. Diseñar la arquitectura del Sistema de Inventario, definiendo la estructura de la base de datos, los modelos de datos y las relaciones entre ellos, así como los módulos y funcionalidades que integrarán la aplicación.
3. Implementar el Sistema de Inventario utilizando tecnologías modernas y herramientas de desarrollo, como Java 17, JPA-Hibernate para la capa de persistencia, MySQL como sistema de gestión de base de datos, y JavaFX para el desarrollo de la interfaz gráfica de usuario (GUI).
4. Evaluar el rendimiento, la usabilidad y la eficacia del Sistema de Inventario a través de pruebas rigurosas y la retroalimentación de usuarios y expertos en el campo de la gestión de inventario y el comercio minorista.
5. Proponer mejoras y ajustes al Sistema de Inventario en base a los resultados obtenidos durante la fase de evaluación, con el fin de optimizar su funcionamiento y adaptarlo a las necesidades cambiantes del mercado y de la tienda de ropa deportiva.
## Marco teórico / Base tecnológica  (POR MEJORAR)
- Revisión de tecnologías, sistemas o enfoques ya existentes que se adoptarán
- Descripción de la solución que se tomará como base
- Eventuales diferencias en el nuevo contexto de aplicación

Para el desarrollo del Sistema de Inventario InventarioXport, se ha llevado a cabo una revisión exhaustiva de tecnologías, sistemas y enfoques existentes en el ámbito de la gestión de inventario y el desarrollo de aplicaciones empresariales. Se han identificado diversas herramientas y metodologías que han sido adoptadas como base para la implementación de este proyecto.

La solución adoptada como base para InventarioXport se fundamenta en el uso de tecnologías modernas y eficientes, tales como Java 17, JPA-Hibernate, MySQL y JavaFX. Java 17 proporciona un entorno de desarrollo robusto y escalable, permitiendo la implementación de aplicaciones empresariales complejas. JPA-Hibernate se utiliza para la capa de persistencia, facilitando la interacción con la base de datos MySQL y proporcionando un mapeo objeto-relacional flexible y eficiente. JavaFX, por otro lado, se emplea para el diseño de la interfaz gráfica de usuario (GUI), ofreciendo una experiencia visual atractiva y fácil de usar para los usuarios finales.

Las eventuales diferencias en el nuevo contexto de aplicación se centran principalmente en la adaptación de estas tecnologías y enfoques a las necesidades específicas de una tienda de ropa deportiva. Esto incluye la gestión de un inventario altamente diversificado, la consideración de la estacionalidad de la demanda y la integración con sistemas existentes de la tienda, como los sistemas de punto de venta y de gestión de clientes. La personalización y configuración del sistema para cumplir con los requisitos y procesos específicos de la tienda son aspectos clave que se abordarán durante el desarrollo e implementación de InventarioXport.
## Desarrollo y ejecución del proyecto
- Descripción del proceso de implementación
- Herramientas y lenguajes utilizados
- Esquema o diagrama de solución propuesta
- Interfaz de usuario
- Pruebas realizadas
## Resultados esperados
- Mejoras con la solución implementada
- Beneficios para la organización
## Riesgos y Mitigaciones

## Conclusiones
- Resumen global
- Proyecciones futuras y trabajo pendiente

## Referencias
- [Spring MVC Hibernate MySQL Integration CRUD Example Tutorial | DigitalOcean](https://www.digitalocean.com/community/tutorials/spring-mvc-hibernate-mysql-integration-crud-example-tutorial)

- [hibernate - Cómo configurar la fuente de datos usando @Bean en la clase Java - Stack Overflow](https://stackoverflow.com/questions/52075287/how-to-configure-datasource-using-bean-in-java-class)
[Claude](https://claude.ai/chat/d0581f1e-da94-4545-92e9-9986ceba134a)

- [Three Tier (Three Layer) Architecture in Spring MVC Web Application (javaguides.net)](https://www.javaguides.net/2020/07/three-tier-three-layer-architecture-in-spring-mvc-web-application.html)


```mysql
CREATE TABLE categories ( ✅
    category_id INT PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(50) UNIQUE NOT NULL,
);

CREATE TABLE available_sizes ( ✅
    size_id INT PRIMARY KEY AUTO_INCREMENT,
    size_name VARCHAR(10) NOT NULL
);

CREATE TABLE products ( ✅
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_code VARCHAR(50) NOT NULL,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    colors VARCHAR(100),
    price DECIMAL(10, 2) NOT NULL,
    cost DECIMAL(10, 2) NOT NULL,
    supplier_id INT NOT NULL,
    category_id INT NOT NULL,
    FOREIGN KEY (supplier_id) REFERENCES suppliers(supplier_id),
    FOREIGN KEY (category_id) REFERENCES categories(category_id)
);

CREATE TABLE product_sizes (✅
    product_id INT,
    size_id INT,
    PRIMARY KEY (product_id, size_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id),
    FOREIGN KEY (size_id) REFERENCES available_sizes(size_id)
);

CREATE TABLE suppliers (✅
    supplier_id INT PRIMARY KEY AUTO_INCREMENT,
    company_name VARCHAR(75) NOT NULL,
    address TEXT NOT NULL,
    contact_numbers VARCHAR(255) NOT NULL,
    contact_person VARCHAR(255) NOT NULL
);

CREATE TABLE merchandise_purchases ( ✅
    purchase_id INT PRIMARY KEY AUTO_INCREMENT,
    purchase_date DATE NOT NULL,
    quantity INT NOT NULL,
    product_id INT NOT NULL,
    price_paid DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);


CREATE TABLE sales ( ✅
    sale_id INT PRIMARY KEY AUTO_INCREMENT,
    sale_date DATE NOT NULL,
    quantity INT NOT NULL,
    product_id INT NOT NULL,
    sale_price DECIMAL(10, 2) NOT NULL,
    client_id INT NOT NULL,
    employee_id INT NOT NULL,
    FOREIGN KEY (product_id) REFERENCES products(product_id),
    FOREIGN KEY (client_id) REFERENCES clients(client_id),
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);

CREATE TABLE clients ( ✅
    client_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(25) NOT NULL,
    last_name VARCHAR(25) NOT NULL,
    address TEXT NOT NULL,
    last_purchase_id INT,
    FOREIGN KEY (last_purchase_id) REFERENCES purchase_history(history_id)
);


CREATE TABLE purchase_history ( ✅
    history_id INT PRIMARY KEY,
    client_id INT NOT NULL,
    purchase_date DATE NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    price_paid DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (client_id) REFERENCES clients(client_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);


CREATE TABLE employees ( ✅
    employee_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(25) NOT NULL,
    last_name VARCHAR(25) NOT NULL,
    role VARCHAR(25) NOT NULL
);

CREATE TABLE warehouse ( ✅
    warehouse_id INT PRIMARY KEY AUTO_INCREMENT,
    product_id INT NOT NULL,
    in_stock_quantity INT NOT NULL,
    location_rack VARCHAR(50) NOT NULL,
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

CREATE TABLE exchanges ( ✅
    return_id INT PRIMARY KEY AUTO_INCREMENT,
    return_date DATE NOT NULL,
    quantity INT NOT NULL,
    product_id INT NOT NULL,
    reason TEXT NOT NULL,
    client_id INT NOT NULL,
    FOREIGN KEY (product_id) REFERENCES products(product_id),
    FOREIGN KEY (client_id) REFERENCES clients(client_id)
);

```

