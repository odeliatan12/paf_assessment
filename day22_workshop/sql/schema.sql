create database acme_bank;

create table accounts (
    account_id varchar(128) not null,
    name varchar(128) not null,
    balance decimal(5,2) not null
)

insert into accounts(account_id, name, balance) values ("V9L3Jd1BBI", "fred", 100.00);
insert into accounts(account_id, name, balance) values ("fhRq46Y6vB", " barney", 300.00);
insert into accounts(account_id, name, balance) values ("uFSFRqUpJy", "wilma", 1000.00);
insert into accounts(account_id, name, balance) values ("ckTV56axff", "betty", 1000.00);
insert into accounts(account_id, name, balance) values ("Qgcnwbshbh", " pebbles", 50.00);
insert into accounts(account_id, name, balance) values ("if9l185l18", "bambam", 50.00);

create table transferAccount(
	id varchar(128) not null,
    from_account varchar(128),
    to_account varchar(128),
    ammount_transferred decimal(7,2),
    transfer_date datetime
)
