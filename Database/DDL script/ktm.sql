create database ktm;
use ktm;
create table cust (name varchar(50),address varchar(50),number varchar(50),email varchar(50),registeredto varchar(50),custid varchar(50) not null auto_increment, PRIMARY KEY (custid));
create table products (name varchar(50),price varchar(10),prodid varchar(10) Primary key ,description varchar(100),size varchar(10) );
create table offers (offerid varchar(50) Primary key not null,prodid varchar(50),discount varchar(10) ,finalprice varchar(10) , foreign key(prodid) references products(prodid));
create table orders (custid int,oid int auto_increment primary key not null ,productsord varchar(100),bill varchar(50),placedto varchar(50),foreign key(custid) references cust(custid));