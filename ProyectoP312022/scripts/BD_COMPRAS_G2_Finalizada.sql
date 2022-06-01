CREATE SCHEMA IF NOT EXISTS `1245` DEFAULT CHARACTER SET utf8 ;

USE `1245` ;

CREATE TABLE IF NOT EXISTS tbl_proveedor(
    provid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    provnombre VARCHAR(45) NOT NULL,
    provsaldo INT (10) NOT NULL,
    provestado BOOLEAN  NOT NULL,
    provtelefono VARCHAR(10) NOT NULL,
    provdireccion VARCHAR(16) NOT NULL   
    )ENGINE = InnoDB CHARACTER SET = latin1;
    
CREATE TABLE IF NOT EXISTS tbl_bitacora (
  id_bitacora int(40) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  fecha varchar(40) DEFAULT NULL,
  area varchar(40) DEFAULT NULL,
  accion varchar(40) DEFAULT NULL,
  id_usuario int(40) DEFAULT NULL,
  ip varchar(40) DEFAULT NULL,
  nombrepc varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

    
CREATE TABLE IF NOT EXISTS tbl_producto(
    prodid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    provid INT NOT NULL,
    prodnombre VARCHAR(16) NOT NULL,
    prodmarca VARCHAR(16) NOT NULL,
    prodprecio INT (11) NOT NULL,
    Prodlinea VARCHAR(16) NOT NULL,
    prodexistencia INT(11) NOT NULL,
    FOREIGN KEY (provid) REFERENCES tbl_proveedor(provid)
    
	)ENGINE = INNODB CHARACTER SET = latin1;
      
   CREATE TABLE IF NOT EXISTS tbl_ordecompraencabezado(
       ordid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
       ordfecha VARCHAR(15) NOT NULL,
       provid INT NOT NULL
       
 
     
       
    )ENGINE = InnoDB CHARACTER SET = latin1;
    
    
    CREATE TABLE IF NOT EXISTS tbl_ordecompradetalle(
    ordcdetalleid INT(11) AUTO_INCREMENT PRIMARY KEY ,
    ordcantidad INT (11) NOT NULL,    
    ordcosto INT(11) NOT NULL,
    prodid INT NOT NULL,
     
      
    FOREIGN KEY (prodid) REFERENCES tbl_producto(prodid)   
    )ENGINE = InnoDB CHARACTER SET = latin1;
    
      CREATE TABLE IF NOT EXISTS tbl_compraencabezado(
         comid INT NOT NULL  PRIMARY KEY,
         provid INT NOT NULL,
         comserie INT(11) NOT NULL,
         ordid INT NOT NULL,
         comfechaemi DATE NOT NULL,
         comfechavenci DATE NOT NULL, 
      

      FOREIGN KEY (ordid) REFERENCES tbl_ordecompraencabezado(ordid)
  )ENGINE = InnoDB CHARACTER SET = latin1; 
 
  
      CREATE TABLE IF NOT EXISTS tbl_compradetalle(
          
         comid INt(11) NOT NULL PRIMARY KEY,
         prodid INT NOT NULL,
         ordcantidad INT NOT NULL,
         ordcosto INT NOT NULL,
 
       FOREIGN KEY (comid) REFERENCES tbl_compraencabezado(comid)
           
  )ENGINE = InnoDB CHARACTER SET = latin1;
    

 
    CREATE TABLE IF NOT EXISTS  tbl_concepto(
 	conid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    connombre VARCHAR(16) NOT NULL,
    conefecto VARCHAR(10) NOT NULL,
    conestatus BOOLEAN NOT NULL
    
        
	)ENGINE = INNODB CHARACTER SET = latin1;
    
 CREATE TABLE IF NOT EXISTS tbl_cuentasporpagar(
     cuentapagarid INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
     conid INT NOT NULL,
     cuentasaldo INT(11) NOT NULL,
     cuentavalor INT(11) NOT NULL,
     cuentareferencia INT (11) NOT NULL,
     comid INT NOT NULL,
     provid INT NOT NULL,
     cuentafechaemi DATE NOT NULL,
     cuentafechavenci DATE NOT NULL,
     

     
     FOREIGN KEY (conid) REFERENCES tbl_concepto(conid),
     FOREIGN KEY (comid) REFERENCES tbl_compraencabezado(comid)
    )ENGINE = InnoDB CHARACTER SET = latin1;
    