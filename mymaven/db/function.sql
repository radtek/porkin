delimiter $$ 
CREATE FUNCTION mymaven_url (input_string VARCHAR(1024), find_number INT) RETURNS VARCHAR(1024)
BEGIN
	DECLARE new_string VARCHAR(1024);
	DECLARE new_pos INT;
	
	SET new_pos = LOCATE('/',input_string,find_number);
	IF (new_pos>0) THEN
		SET new_string=SUBSTRING(input_string,0,new_pos);
	ELSE 
		SET new_string = input_string;  
	END IF;
	RETURN(new_string);    
END$$  

