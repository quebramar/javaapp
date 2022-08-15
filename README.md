# javaapp

Database for the application:

mysql> CREATE DATABASE demo;
Query OK, 1 row affected (0.02 sec)

mysql> use demo;
Database changed

mysql> CREATE TABLE insects ( InsectID TINYINT NOT NULL , InsectName VARCHAR(255), Species TINYINT, PRIMARY KEY (InsectID));
Query OK, 0 rows affected (0.04 sec)

mysql> INSERT INTO insects (InsectID, InsectName, Species) VALUES (1, 'Butterfly', 25), (2, 'Lady Bug', 5), (3, 'Praying Mantis', 122), (4, 'Mosquito', 99), (5, 'Honey bee', 4);
Query OK, 5 rows affected (0.02 sec)
Records: 5  Duplicates: 0  Warnings: 0

mysql> CREATE TABLE flying ( FlyingID TINYINT NOT NULL , InsectsID TINYINT, FlyingName VARCHAR(16), Wings TINYINT, PRIMARY KEY (FlyingID));
Query OK, 0 rows affected (0.05 sec)

mysql> INSERT INTO flying (FlyingID, InsectsID, FlyingName, Wings) VALUES (1, 1, 'Schmetterling', 4), (2, NULL, 'Adler', 2), (3, 4, 'Stechmücke', 4), (4, NULL, 'Fledermaus', 2);
Query OK, 4 rows affected (0.01 sec)
Records: 4  Duplicates: 0  Warnings: 0

mysql> SELECT * FROM insects
    -> LEFT OUTER JOIN flying
    -> ON insects.InsectID = flying.InsectsID
    -> UNION
    -> SELECT * FROM insects
    -> RIGHT OUTER JOIN flying
    -> ON insects.InsectID = flying.InsectsID
    -> WHERE insects.InsectID IS NULL;
+----------+----------------+---------+----------+-----------+---------------+-------+
| InsectID | InsectName     | Species | FlyingID | InsectsID | FlyingName    | Wings |
+----------+----------------+---------+----------+-----------+---------------+-------+
|        1 | Butterfly      |      25 |        1 |         1 | Schmetterling |     4 |
|        2 | Lady Bug       |       5 |     NULL |      NULL | NULL          |  NULL |
|        3 | Praying Mantis |     122 |     NULL |      NULL | NULL          |  NULL |
|        4 | Mosquito       |      99 |        3 |         4 | Stechmücke    |     4 |
|        5 | Honey bee      |       4 |     NULL |      NULL | NULL          |  NULL |
|     NULL | NULL           |    NULL |        2 |      NULL | Adler         |     2 |
|     NULL | NULL           |    NULL |        4 |      NULL | Fledermaus    |     2 |
+----------+----------------+---------+----------+-----------+---------------+-------+
7 rows in set (0.01 sec)

mysql>
