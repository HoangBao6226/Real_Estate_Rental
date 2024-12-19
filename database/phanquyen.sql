create role 'manager';
create role 'sales';
create role 'lessor';
create role 'lessee';

SELECT user, host, authentication_string, plugin FROM mysql.user;

GRANT SELECT ON real_estate.accommodation TO 'lessee';

CREATE USER 'john'@'%' IDENTIFIED BY '123456' default role 'lessee';

-- DROP USER 'john'@'%';

FLUSH PRIVILEGES;

SHOW GRANTS FOR 'root'@'localhost';

SELECT USER(), CURRENT_USER();



SHOW GRANTS FOR CURRENT_USER();