CREATE TABLE dispositivos (
nombre VARCHAR (50),
precio NUMERIC (10),
tipo VARCHAR (30)
)
INSERT INTO dispositivos values ('Celulares',3000,'Iphones');
INSERT INTO dispositivos values ('Power Bank',200,'Bateria');
INSERT INTO dispositivos values ('Wireless Headphone',150,'Audifonos');
INSERT INTO dispositivos values ('Tablet',1500,'IPads');
INSERT INTO dispositivos values ('Smart Watch',500,'Tecnologia');
INSERT INTO dispositivos values ('Cables',120,'Accesorios');
---------------- REGISTRAR
CREATE PROCEDURE registrar(

IN _p_nombre VARCHAR(30),
IN _p_precio NUMERIC (6,2),
OUT _p_tipo INT
)
BEGIN
    DECLARE _dispositivos INT;
    SET _p_nombre= UPPER (_p_nombre);
    SET _P_precio=_p_precio*3.5;
    
   SELECT FLOOR (1+ RAND()*60) INTO _v_id_prod;

 INSERT INTO dispositivo 
        (nombre, precio, tipo)
        VALUES
        (_dispositivo , _p_nombre , _p_precio,_p_tipo);
 IF ROW_COUNT ()> 0 THEN
    SET _p_tipo = 1;
ELSE
    SET _p_tipo = 0;
END IF;
END$$
DELIMITER ;

-----------ACTUALIZAR
CREATE PROCEDURE actualizar 

BEGIN
UPDATE dispositivos SET nombre = nombre,
precio = precio(),
tipo = tipo

WHERE dispositivos = dispositivos;
END
------- BORRAR

CREATE PROCEDURE borrar 
IF nombre ('cusp_CustomerDelete') IS NOT NULL
BEGIN 
DROP PROC cusp_CustomerDelete
END 
GO
CREATE PROC cusp_CustomerDelete 
    @CustomerID int
AS 
BEGIN 
DELETE
FROM   Customer
WHERE  CustomerID = @CustomerID
 
END
GO


