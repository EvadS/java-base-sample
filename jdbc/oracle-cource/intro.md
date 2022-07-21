

```
CREATE TABLE customers
( customer_id number(10) NOT NULL,
  customer_name varchar2(50) NOT NULL,
  city varchar2(50),
  CONSTRAINT customers_pk PRIMARY KEY (customer_id)
);

```


The CREATE TABLE AS statement is used to create a table from an existing table by copying the columns of existing table.


CREATE TABLE new_table
AS (SELECT * FROM old_table);
