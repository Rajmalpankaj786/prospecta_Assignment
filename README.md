# prospecta_Assignment
## 1. coding Assignment : <br> 
# database files : 
mysql> use prospecta;
Database changed
mysql> show tables;
+---------------------+
| Tables_in_prospecta |
+---------------------+
| category            |
| entity_class        |
+---------------------+
2 rows in set (0.00 sec)

mysql> desc category;
+-------+--------------+------+-----+---------+----------------+
| Field | Type         | Null | Key | Default | Extra          |
+-------+--------------+------+-----+---------+----------------+
| id    | int          | NO   | PRI | NULL    | auto_increment |
| name  | varchar(255) | YES  |     | NULL    |                |
+-------+--------------+------+-----+---------+----------------+
2 rows in set (0.00 sec)

mysql> desc entity_class;
+-------------+--------------+------+-----+---------+-------+
| Field       | Type         | Null | Key | Default | Extra |
+-------------+--------------+------+-----+---------+-------+
| auth        | varchar(255) | NO   | PRI | NULL    |       |
| category_id | int          | YES  |     | NULL    |       |
| cors        | varchar(255) | YES  |     | NULL    |       |
| description | varchar(255) | YES  |     | NULL    |       |
| https       | bit(1)       | NO   |     | NULL    |       |
| title       | varchar(255) | YES  |     | NULL    |       |
+-------------+--------------+------+-----+---------+-------+
6 rows in set (0.00 sec)

mysql> select * from category;
+----+-----------------------+
| id | name                  |
+----+-----------------------+
|  1 | Science & Mathematics |
|  2 | Arts                  |
|  3 | commerces             |
|  4 | computer programming  |
+----+-----------------------+
4 rows in set (0.00 sec)

mysql> select * from entity_class;
+--------------------------------------+-------------+------+---------------------------------------------------------------+--------------+--------------------+
| auth                                 | category_id | cors | description                                                   | https        | title              |
+--------------------------------------+-------------+------+---------------------------------------------------------------+--------------+--------------------+
| 215a8021-908d-4b8a-8687-3a1ddeb13af1 |           4 | yes  | Preform a English operations                                  | 0x01         | java               |
| 327fc48a-53bf-4d07-90f6-75abc688e39b |           4 | yes  | Preform a frontend and backend operations                     | 0x01         | Node               |
| 4125ccdf-8952-4873-a600-fe358cbf3574 |           2 | yes  | Preform a English operations                                  | 0x01         | English compulsary |
| 707d9c6b-c562-4019-85a4-7c610594138e |           1 | yes  | Preform a Logical operations like add , multilply and divide  | 0x01         | Mathematics        |
| 7d6596ed-ec29-400f-9be5-21038e01303e |           4 | yes  | Preform a AI operations                                       | 0x01         | Machine learning   |
| 82481cee-174a-40df-b72c-e77dcee62798 |           1 | No   | Preform a physical operations                                 | 0x01         | Science            |
| b6156f73-00c9-48d3-b23e-899efa11dcb3 |           4 | yes  | Preform a frontend operations                                 | 0x01         | React              |
| c8ee20e7-d14c-4114-9baf-03dbed163cf6 |           2 | No   | Preform a arts operations                                     | 0x00         | Hindi compulsary   |
+--------------------------------------+-------------+------+---------------------------------------------------------------+--------------+--------------------+
8 rows in set (0.00 sec)
