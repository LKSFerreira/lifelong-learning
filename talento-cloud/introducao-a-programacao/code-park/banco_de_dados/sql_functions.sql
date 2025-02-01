CREATE OR REPLACE FUNCTION soma_clientes_cadastrados(data_consulta DATE)
RETURN NUMBER
IS
  total_clientes NUMBER;
BEGIN
  SELECT COUNT(*)
  INTO total_clientes
  FROM clientes
  WHERE TRUNC(data_cadastro) = TRUNC(data_consulta);

  RETURN total_clientes;
END soma_clientes_cadastrados;
/
